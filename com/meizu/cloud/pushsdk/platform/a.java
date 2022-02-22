package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class a {
    public static Map<String, String> a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f59025b = new ArrayList(a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (a.containsKey(substring)) {
                    String str3 = a.get(substring);
                    str2 = str.substring(3, str.length());
                    try {
                        char[] cArr = new char[str2.length() / 2];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < str2.length() / 2) {
                            if (i3 == str3.length()) {
                                i3 = 0;
                            }
                            int i4 = i2 * 2;
                            cArr[i2] = (char) (((char) Integer.valueOf(str2.substring(i4, i4 + 2), 16).intValue()) ^ str3.charAt(i3));
                            i2++;
                            i3++;
                        }
                        return new String(String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
                    } catch (Exception unused) {
                        c.k.a.a.a.b("PushIdEncryptUtils", "invalid pushId encryption " + str2);
                        return str;
                    }
                }
                return str;
            }
            return str;
        } catch (Exception unused2) {
            str2 = str;
        }
    }

    public static Map<String, String> a() {
        if (a(a)) {
            synchronized (a.class) {
                if (a(a)) {
                    TreeMap treeMap = new TreeMap();
                    a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    a.put("G3G", "XAsFqhhaf4gKpmAi");
                    a.put("V5R", "cOqH18NXwBtZVkvz");
                    a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    a.put("EIM", "K11Rs9HAKRXeNwq8");
                    a.put("SO7", "T8LquL1DvwVcogiU");
                    a.put("DDI", "d02F6ttOtV05MYCQ");
                    a.put("ULY", "ToZZIhAywnUfHShN");
                    a.put("0EV", "r5D5RRwQhfV0AYLb");
                    a.put("N6A", "QAtSBFcXnQoUgHO2");
                    a.put("S5Q", "sDWLrZINnum227am");
                    a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    a.put("J04", "N5hViUTdLCpN59H0");
                    a.put("B68", "EY3sH1KKtalg5ZaT");
                    a.put("9IW", "q1u0MiuFyim4pCYY");
                    a.put("UU3", "syLnkkd8AqNykVV7");
                    a.put("Z49", "V00FiWu124yE91sH");
                    a.put("BNA", "rPP7AK1VWpKEry3p");
                    a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
