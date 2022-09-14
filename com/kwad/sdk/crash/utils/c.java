package com.kwad.sdk.crash.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0071 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(String[] strArr, int i) {
        Process process;
        OutputStream outputStream;
        InputStream inputStream;
        OutputStream outputStream2;
        ?? r5;
        OutputStream outputStream3;
        OutputStream outputStream4;
        Process process2;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream2 = null;
        try {
            Process process3 = f(strArr);
            try {
                inputStream = process3.getInputStream();
                try {
                    outputStream = process3.getOutputStream();
                } catch (InterruptedException e) {
                    e = e;
                    outputStream = null;
                    outputStream2 = outputStream;
                    r5 = outputStream2;
                    inputStream2 = process3;
                    r5 = r5;
                    try {
                        throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                    } catch (Throwable th) {
                        th = th;
                        process3 = inputStream2;
                        inputStream2 = inputStream;
                        process2 = process3;
                        outputStream4 = outputStream2;
                        outputStream3 = r5;
                        b.closeQuietly(inputStream2);
                        b.closeQuietly(outputStream);
                        b.closeQuietly(outputStream4);
                        b.closeQuietly(outputStream3);
                        if (process2 != null) {
                            process2.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    outputStream2 = null;
                }
                try {
                    outputStream2 = process3.getErrorStream();
                    try {
                        r5 = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = r5.readLine();
                                if (readLine == null || arrayList.size() >= 0) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (InterruptedException e2) {
                                e = e2;
                                inputStream2 = process3;
                                r5 = r5;
                                throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream2 = inputStream;
                                process2 = process3;
                                outputStream4 = outputStream2;
                                outputStream3 = r5;
                                b.closeQuietly(inputStream2);
                                b.closeQuietly(outputStream);
                                b.closeQuietly(outputStream4);
                                b.closeQuietly(outputStream3);
                                if (process2 != null) {
                                }
                                throw th;
                            }
                        }
                        process3.waitFor();
                        if (process3.exitValue() != 0) {
                            throw new IOException("Command line returned OS error code '" + process3.exitValue() + "' for command " + Arrays.asList(strArr));
                        }
                        b.closeQuietly(inputStream);
                        b.closeQuietly(outputStream);
                        b.closeQuietly(outputStream2);
                        b.closeQuietly((Closeable) r5);
                        if (process3 != 0) {
                            process3.destroy();
                        }
                        return arrayList;
                    } catch (InterruptedException e3) {
                        e = e3;
                        r5 = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        r5 = 0;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    outputStream2 = null;
                    r5 = outputStream2;
                    inputStream2 = process3;
                    r5 = r5;
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream2 = null;
                    r5 = outputStream2;
                    inputStream2 = inputStream;
                    process2 = process3;
                    outputStream4 = outputStream2;
                    outputStream3 = r5;
                    b.closeQuietly(inputStream2);
                    b.closeQuietly(outputStream);
                    b.closeQuietly(outputStream4);
                    b.closeQuietly(outputStream3);
                    if (process2 != null) {
                    }
                    throw th;
                }
            } catch (InterruptedException e5) {
                e = e5;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                process = process3;
                OutputStream outputStream5 = outputStream;
                outputStream3 = outputStream5;
                process2 = process;
                outputStream4 = outputStream5;
                b.closeQuietly(inputStream2);
                b.closeQuietly(outputStream);
                b.closeQuietly(outputStream4);
                b.closeQuietly(outputStream3);
                if (process2 != null) {
                }
                throw th;
            }
        } catch (InterruptedException e6) {
            e = e6;
            inputStream = null;
            outputStream = null;
            outputStream2 = null;
            r5 = 0;
        } catch (Throwable th7) {
            th = th7;
            process = null;
            outputStream = null;
        }
    }

    public static Process f(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }
}
