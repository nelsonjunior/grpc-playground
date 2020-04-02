package main

import (
	"context"
	"google.golang.org/grpc"
	api "hello-with-go/pb"
	"log"
)

func main() {

	connection, err := grpc.Dial("localhost:50051", grpc.WithInsecure())

	if err != nil {
		log.Fatalf("Could not connect: %v", err)
	}
	defer connection.Close()

	client := api.NewHelloServiceClient(connection)

	request := &api.HelloRequest{
		Name: "Nelson Rodrigues",
	}

	res, err := client.SayHello(context.Background(), request)
	if err != nil {
		log.Fatalf("Error during the execution: %v", err)
	}

	log.Println(res.Message)
}
