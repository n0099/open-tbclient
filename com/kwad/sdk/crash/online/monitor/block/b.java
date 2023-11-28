package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    public static int aFA = 5;
    public static List<String> aFy;
    public static List<String> aFz;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aFy = new ArrayList();
        List<String> list = aVar.aFL;
        if (list != null && !list.isEmpty()) {
            aFy.addAll(aVar.aFL);
        } else {
            aFy.add("com.kwad");
            aFy.add("com.kwai");
            aFy.add("com.ksad");
            aFy.add("tkruntime");
            aFy.add("tachikoma");
            aFy.add("kuaishou");
        }
        aFA = aVar.aFQ;
        aFz = new ArrayList();
        List<String> list2 = aVar.aFK;
        if (list2 != null && !list2.isEmpty()) {
            aFz.addAll(aVar.aFK);
            return;
        }
        aFz.add("android.");
        aFz.add("androidx.");
        aFz.add("org.");
        aFz.add("java.");
    }

    public static boolean eW(String str) {
        List<String> list = aFz;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean eX(String str) {
        List<String> list = aFy;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String eY(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.e.c.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z = false;
        int i = 0;
        for (String str2 : split) {
            if (z || !eW(str2)) {
                if (i >= aFA) {
                    return "";
                }
                if (eX(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
