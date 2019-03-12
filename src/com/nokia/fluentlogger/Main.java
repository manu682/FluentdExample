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
                String str = "time=\"2018-12-20T08:53:53Z\" level=info " +
                        "event_status=\"SUCCESS\" " +
                        "msg=\"AUDIT_LOG SUCCESS A hardware with id: " + counter++ + " was successfully created by user: test@test.com\"\n";
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
