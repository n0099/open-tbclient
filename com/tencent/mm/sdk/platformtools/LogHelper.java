package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.text.format.DateFormat;
import com.tencent.mm.algorithm.c;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LogHelper {
    private static final byte[] au = {4, 0, 0, 0, -1, -1, -1, 0};

    private LogHelper() {
    }

    public static void initLogHeader(PrintStream printStream, String str, String str2, long j, int i) {
        if (printStream == null || Util.isNullOrNil(str2) || j == 0) {
            return;
        }
        printStream.println("1 " + str);
        printStream.println("2 " + str2);
        printStream.println("3 " + j);
        printStream.println("4 " + Integer.toHexString(i));
        printStream.println("5 " + Build.VERSION.RELEASE);
        printStream.println("6 " + Build.VERSION.CODENAME);
        printStream.println("7 " + Build.VERSION.INCREMENTAL);
        printStream.println("8 " + Build.BOARD);
        printStream.println("9 " + Build.DEVICE);
        printStream.println("10 " + Build.DISPLAY);
        printStream.println("11 " + Build.FINGERPRINT);
        printStream.println("12 " + Build.HOST);
        printStream.println("13 " + Build.MANUFACTURER);
        printStream.println("14 " + Build.MODEL);
        printStream.println("15 " + Build.PRODUCT);
        printStream.println("16 " + Build.TAGS);
        printStream.println("17 " + Build.TYPE);
        printStream.println("18 " + Build.USER);
        printStream.println();
        printStream.flush();
    }

    public static void writeToStream(PrintStream printStream, byte[] bArr, String str, String str2) {
        if (printStream == null || Util.isNullOrNil(bArr) || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            return;
        }
        synchronized (printStream) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DateFormat.format("MM-dd kk:mm:ss", System.currentTimeMillis()));
            stringBuffer.append(" ").append(str).append(" ").append(str2);
            String stringBuffer2 = stringBuffer.toString();
            try {
                SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr));
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(1, generateSecret);
                byte[] doFinal = cipher.doFinal(stringBuffer2.getBytes());
                printStream.write(c.a(doFinal.length));
                printStream.write(doFinal);
                printStream.write(au);
            } catch (Exception e) {
                e.printStackTrace();
            }
            printStream.flush();
        }
    }
}
