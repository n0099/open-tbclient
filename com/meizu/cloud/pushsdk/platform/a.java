package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f38253a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f38254b = new ArrayList(f38253a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f38253a.containsKey(substring)) {
                    String str3 = f38253a.get(substring);
                    str2 = str.substring(3, str.length());
                    try {
                        char[] cArr = new char[str2.length() / 2];
                        int i = 0;
                        int i2 = 0;
                        while (i < str2.length() / 2) {
                            if (i2 == str3.length()) {
                                i2 = 0;
                            }
                            int i3 = i * 2;
                            cArr[i] = (char) (((char) Integer.valueOf(str2.substring(i3, i3 + 2), 16).intValue()) ^ str3.charAt(i2));
                            i++;
                            i2++;
                        }
                        return new String(String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
                    } catch (Exception unused) {
                        d.k.a.a.a.b("PushIdEncryptUtils", "invalid pushId encryption " + str2);
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
        if (a(f38253a)) {
            synchronized (a.class) {
                if (a(f38253a)) {
                    TreeMap treeMap = new TreeMap();
                    f38253a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    f38253a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f38253a.put("V5R", "cOqH18NXwBtZVkvz");
                    f38253a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f38253a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f38253a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f38253a.put("SO7", "T8LquL1DvwVcogiU");
                    f38253a.put("DDI", "d02F6ttOtV05MYCQ");
                    f38253a.put("ULY", "ToZZIhAywnUfHShN");
                    f38253a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f38253a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f38253a.put("S5Q", "sDWLrZINnum227am");
                    f38253a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f38253a.put("J04", "N5hViUTdLCpN59H0");
                    f38253a.put("B68", "EY3sH1KKtalg5ZaT");
                    f38253a.put("9IW", "q1u0MiuFyim4pCYY");
                    f38253a.put("UU3", "syLnkkd8AqNykVV7");
                    f38253a.put("Z49", "V00FiWu124yE91sH");
                    f38253a.put("BNA", "rPP7AK1VWpKEry3p");
                    f38253a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f38253a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
