package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f68581a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f68582b = new ArrayList(f68581a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f68581a.containsKey(substring)) {
                    String str3 = f68581a.get(substring);
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
                        b.j.a.a.a.b("PushIdEncryptUtils", "invalid pushId encryption " + str2);
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
        if (a(f68581a)) {
            synchronized (a.class) {
                if (a(f68581a)) {
                    TreeMap treeMap = new TreeMap();
                    f68581a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    f68581a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f68581a.put("V5R", "cOqH18NXwBtZVkvz");
                    f68581a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f68581a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f68581a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f68581a.put("SO7", "T8LquL1DvwVcogiU");
                    f68581a.put("DDI", "d02F6ttOtV05MYCQ");
                    f68581a.put("ULY", "ToZZIhAywnUfHShN");
                    f68581a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f68581a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f68581a.put("S5Q", "sDWLrZINnum227am");
                    f68581a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f68581a.put("J04", "N5hViUTdLCpN59H0");
                    f68581a.put("B68", "EY3sH1KKtalg5ZaT");
                    f68581a.put("9IW", "q1u0MiuFyim4pCYY");
                    f68581a.put("UU3", "syLnkkd8AqNykVV7");
                    f68581a.put("Z49", "V00FiWu124yE91sH");
                    f68581a.put("BNA", "rPP7AK1VWpKEry3p");
                    f68581a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f68581a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
