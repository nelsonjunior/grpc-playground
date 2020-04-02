package main

import (
	"context"
	"log"
	"net"
	"google.golang.org/grpc"
	"hello-with-go/pb"
)

type server struct {

}

func (*server) SayHello(ctx context.Context, request *api.HelloRequest) (*api.HelloReply, error){
	result := "Hello " + request.GetName()

	res := &api.HelloReply{
		Message: result,
	}

	return res, nil
}

func main() {
	lis, err := net.Listen("tcp", "0.0.0.0:50051")
	if err != nil {
		log.Fatalf("Failed to list %v", err)
	}

	grpcServer := grpc.NewServer()
	api.RegisterHelloServiceServer(grpcServer, &server{})

	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("Failed to serve %v", err)
	}

}
