package com.qq.e.comm.plugin.util;

import android.annotation.SuppressLint;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import java.util.Random;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f12848a = new Random(System.currentTimeMillis());

    private static int a(String str, int i) {
        return GDTADManager.getInstance().getSM().getInteger(str, i);
    }

    public static String a(String str, String str2, String str3) {
        String format = String.format("%s@%s#%d#%s", str2, str, Long.valueOf(System.currentTimeMillis()), str3);
        int nextDouble = (int) (f12848a.nextDouble() * 100.0d);
        StringBuilder sb = new StringBuilder();
        sb.append(nextDouble < a(Constants.KEYS.SDKServerGetADReportSamplingRate, 1) ? "1" : "0");
        sb.append(nextDouble < a(Constants.KEYS.SDKServerExpReportSamplingRate, 1) ? "1" : "0");
        sb.append(nextDouble < a(Constants.KEYS.SDKServerClickReportSamplingRate, 100) ? "1" : "0");
        sb.append(format);
        return sb.toString();
    }

    public static boolean a(String str) {
        return str != null && str.length() > 3 && str.charAt(0) == '1';
    }

    public static boolean b(String str) {
        return str != null && str.length() > 3 && str.charAt(1) == '1';
    }

    public static boolean c(String str) {
        return str != null && str.length() > 3 && str.charAt(2) == '1';
    }
}
