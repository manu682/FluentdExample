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
                String str = "{\"log\": \"time=2018-12-20T08:53:53Z level=info tag=AUDIT_LOG msg=HWIM: Entered gRPC FetchENodeBBasedOnSerialNumber() SerialNumber=120200002517CSP0007\"}\n";
                String str1 = "{\"log\": \"time=2018-12-20T08:53:53Z level=info msg=HWIM: Entered gRPC FetchENodeBBasedOnSerialNumber() SerialNumber=120200002517CSP0007\"}\n";
                //String str = "{\"log\": \"time=2018-12-20T08:53:53Z level=info msg=HWIM: Entered gRPC FetchENodeBBasedOnSerialNumber() SerialNumber=120200002517CSP0007\"}\n";
                //String str = "time=2018-12-20T08:53:53Z level=info event_status=SUCCESS tag=AUDIT_LOG msg=A hardware with id: " + counter++ + " was successfully created by user: test@test.com\n";
                writer.append(str);
                writer.append(str1);
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
