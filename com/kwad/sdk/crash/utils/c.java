package com.kwad.sdk.crash.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static Process a(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }

    public static List<String> a(String[] strArr, int i) {
        Reader reader;
        InputStream inputStream;
        OutputStream outputStream;
        InputStream inputStream2;
        Process process;
        ArrayList arrayList = new ArrayList(20);
        try {
            try {
                process = a(strArr);
                try {
                    inputStream2 = process.getInputStream();
                    try {
                        outputStream = process.getOutputStream();
                        try {
                            inputStream = process.getErrorStream();
                        } catch (InterruptedException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                            reader = null;
                            inputStream = null;
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                        reader = null;
                        inputStream = null;
                        outputStream = null;
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null && arrayList.size() < i; readLine = bufferedReader.readLine()) {
                                arrayList.add(readLine);
                            }
                            process.waitFor();
                            if (process.exitValue() != 0) {
                                throw new IOException("Command line returned OS error code '" + process.exitValue() + "' for command " + Arrays.asList(strArr));
                            }
                            if (i <= 0 || !arrayList.isEmpty()) {
                                b.a(inputStream2);
                                b.a(outputStream);
                                b.a(inputStream);
                                b.a((Reader) bufferedReader);
                                if (process != null) {
                                    process.destroy();
                                }
                                return arrayList;
                            }
                            throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                        } catch (InterruptedException e3) {
                            e = e3;
                            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                        }
                    } catch (InterruptedException e4) {
                        e = e4;
                    } catch (Throwable th3) {
                        th = th3;
                        reader = null;
                        b.a(inputStream2);
                        b.a(outputStream);
                        b.a(inputStream);
                        b.a(reader);
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (InterruptedException e5) {
                    e = e5;
                } catch (Throwable th4) {
                    th = th4;
                    reader = null;
                    inputStream = null;
                    outputStream = null;
                    inputStream2 = null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (InterruptedException e6) {
            e = e6;
        } catch (Throwable th6) {
            th = th6;
            reader = null;
            inputStream = null;
            outputStream = null;
            inputStream2 = null;
            process = null;
        }
    }
}
