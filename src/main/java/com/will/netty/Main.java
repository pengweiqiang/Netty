package com.will.netty;

/**
 * Created by pengweiqiang on 2017/12/12.
 */
public class Main {
    public static void main(String []args) throws Exception{
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();
        System.out.println("server:run()");
    }
}
