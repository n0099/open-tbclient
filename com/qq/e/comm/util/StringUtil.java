package com.qq.e.comm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (str != null && i2 != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i2]);
            }
        }
        return stringBuffer.toString();
    }

    public static int parseInteger(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readAll(File file) throws IOException {
        Throwable th;
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        GDTLogger.e("Exception while close bufferreader", e2);
                    }
                    return sb2;
                } catch (IOException e3) {
                    throw e3;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        GDTLogger.e("Exception while close bufferreader", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader = null;
            throw e5;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(str);
        fileWriter.close();
    }
}
