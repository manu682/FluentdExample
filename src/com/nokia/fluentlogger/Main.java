package com.nokia.fluentlogger;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        String fileName = "\\Users\\m1mathew\\IdeaProjects\\SampleFluentLogger\\fluentd\\logs\\output.txt";
        BufferedWriter writer = null;
        try {
            for (;;) {
                writer = new BufferedWriter(new FileWriter(fileName, true));
                //String str = "2017-07-27 06:44:54 +0900 [info]: AUDIT_LOG My content is added through this iteration : " + ++counter + ".\n";
                //String str = "2017-07-27 06:44:54 +0900 [info]: AUDIT_LOG My content is added through this iteration : " + ++counter + ".\n";
                String str = "time=\"2018-12-20T08:53:53Z\" level=info msg=\"HWIM: Entered gRPC FetchENodeBBasedOnSerialNumber()\" SerialNumber=120200002517CSP0007\n";
                writer.append(str);
                writer.flush();
                System.out.println("Str : " + str);
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }
}
