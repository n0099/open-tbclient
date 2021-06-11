package com.yy.gslbsdk.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class RuntimeTools {
    public static final String TAG = "RuntimeTools";

    public static String execCmd(String str) {
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine;
            }
            bufferedReader.close();
        } catch (Exception e2) {
            LogTools.printWarning(TAG, e2);
        }
        return str2;
    }
}
