package com.will.netty.netty2;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;
import java.util.Date;

/**
 * Created by pengweiqiang on 2017/12/12.
 */
public class NettyTelnetHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send greeting for a new connection.
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
//
//        String response;
//        boolean close = false;
//        if (request==null || "".equals(request)) {
//            response = "Please type something.\r\n";
//        } else if ("bye".equals(request.toLowerCase())) {
//            response = "Have a good day!\r\n";
//            close = true;
//        } else {
//            response = "Did you say '" + request + "'?\r\n";
//        }
//
//        ChannelFuture future = ctx.write(response);
//        ctx.flush();
//        if (close) {
//            future.addListener(ChannelFutureListener.CLOSE);
//        }
//    }

    protected void messageReceived(ChannelHandlerContext ctx, String request) throws Exception {
        String response;
        boolean close = false;
        if (request==null || "".equals(request)) {
            response = "Please type something.\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Have a good day!\r\n";
            close = true;
        } else {
            response = "Did you say '" + request + "'?\r\n";
        }
        System.out.println(request);
        ChannelFuture future = ctx.write(response);
        ctx.flush();
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}