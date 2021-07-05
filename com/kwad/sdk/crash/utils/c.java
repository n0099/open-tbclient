package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Process a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, strArr)) == null) ? Runtime.getRuntime().exec(strArr) : (Process) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x009f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(String[] strArr, int i2) {
        InterceptResult invokeLI;
        Process process;
        OutputStream outputStream;
        InputStream inputStream;
        OutputStream outputStream2;
        ?? r6;
        ?? r5;
        Process process2;
        Process process3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65537, null, strArr, i2)) != null) {
            return (List) invokeLI.objValue;
        }
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream2 = null;
        try {
            process3 = a(strArr);
        } catch (InterruptedException e2) {
            e = e2;
            inputStream = null;
            outputStream = null;
            outputStream2 = 0;
            r6 = null;
        } catch (Throwable th) {
            th = th;
            process = null;
            outputStream = null;
        }
        try {
            inputStream = process3.getInputStream();
            try {
                outputStream = process3.getOutputStream();
                try {
                    outputStream2 = process3.getErrorStream();
                    try {
                        r6 = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = r6.readLine();
                                if (readLine == null || arrayList.size() >= i2) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (InterruptedException e3) {
                                e = e3;
                                inputStream2 = process3;
                                outputStream2 = outputStream2;
                                try {
                                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    process3 = inputStream2;
                                    inputStream2 = inputStream;
                                    process2 = process3;
                                    r5 = outputStream2;
                                    b.a(inputStream2);
                                    b.a(outputStream);
                                    b.a((InputStream) r5);
                                    b.a((Reader) r6);
                                    if (process2 != null) {
                                        process2.destroy();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream2 = inputStream;
                                process2 = process3;
                                r5 = outputStream2;
                                b.a(inputStream2);
                                b.a(outputStream);
                                b.a((InputStream) r5);
                                b.a((Reader) r6);
                                if (process2 != null) {
                                }
                                throw th;
                            }
                        }
                        process3.waitFor();
                        if (process3.exitValue() != 0) {
                            throw new IOException("Command line returned OS error code '" + process3.exitValue() + "' for command " + Arrays.asList(strArr));
                        }
                        if (i2 > 0 && arrayList.isEmpty()) {
                            throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                        }
                        b.a(inputStream);
                        b.a(outputStream);
                        b.a((InputStream) outputStream2);
                        b.a((Reader) r6);
                        if (process3 != 0) {
                            process3.destroy();
                        }
                        return arrayList;
                    } catch (InterruptedException e4) {
                        e = e4;
                        r6 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        r6 = null;
                    }
                } catch (InterruptedException e5) {
                    e = e5;
                    outputStream2 = 0;
                    r6 = outputStream2;
                    inputStream2 = process3;
                    outputStream2 = outputStream2;
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream2 = 0;
                    r6 = outputStream2;
                    inputStream2 = inputStream;
                    process2 = process3;
                    r5 = outputStream2;
                    b.a(inputStream2);
                    b.a(outputStream);
                    b.a((InputStream) r5);
                    b.a((Reader) r6);
                    if (process2 != null) {
                    }
                    throw th;
                }
            } catch (InterruptedException e6) {
                e = e6;
                outputStream = null;
                outputStream2 = outputStream;
                r6 = outputStream2;
                inputStream2 = process3;
                outputStream2 = outputStream2;
                throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                outputStream2 = 0;
            }
        } catch (InterruptedException e7) {
            e = e7;
            inputStream = null;
            outputStream = null;
        } catch (Throwable th7) {
            th = th7;
            outputStream = null;
            process = process3;
            OutputStream outputStream3 = outputStream;
            r6 = outputStream3;
            process2 = process;
            r5 = outputStream3;
            b.a(inputStream2);
            b.a(outputStream);
            b.a((InputStream) r5);
            b.a((Reader) r6);
            if (process2 != null) {
            }
            throw th;
        }
    }
}
