package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class m {
    public static boolean a() {
        String[] strArr = {"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/"};
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                String str = strArr[i2];
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("su");
                String sb2 = sb.toString();
                if (new File(sb2).exists()) {
                    String[] strArr2 = new String[3];
                    strArr2[0] = "ls";
                    strArr2[1] = "-l";
                    strArr2[2] = sb2;
                    String a2 = a(strArr2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("isRooted=");
                    sb3.append(a2);
                    c.b("cyb", sb3.toString());
                    if (TextUtils.isEmpty(a2)) {
                        return false;
                    }
                    return a2.indexOf(PrefetchEvent.EVENT_DATA_ROOT_PATH) != a2.lastIndexOf(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String a(String[] strArr) {
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }
}
