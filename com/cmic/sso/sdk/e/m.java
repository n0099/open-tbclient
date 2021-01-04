package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class m {
    public static boolean a() {
        String[] strArr;
        try {
            int length = new String[]{"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/"}.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i] + "su";
                if (new File(str).exists()) {
                    String a2 = a(new String[]{"ls", "-l", str});
                    c.b("cyb", "isRooted=" + a2);
                    if (!TextUtils.isEmpty(a2)) {
                        if (a2.indexOf("root") != a2.lastIndexOf("root")) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        try {
            Process start = new ProcessBuilder(strArr).start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            start.getInputStream().close();
            start.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
