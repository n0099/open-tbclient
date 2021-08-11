package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f74577a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f74578b = new ArrayList(f74577a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f74577a.containsKey(substring)) {
                    String str3 = f74577a.get(substring);
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
                        c.l.a.a.a.b("PushIdEncryptUtils", "invalid pushId encryption " + str2);
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
        if (a(f74577a)) {
            synchronized (a.class) {
                if (a(f74577a)) {
                    TreeMap treeMap = new TreeMap();
                    f74577a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    f74577a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f74577a.put("V5R", "cOqH18NXwBtZVkvz");
                    f74577a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f74577a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f74577a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f74577a.put("SO7", "T8LquL1DvwVcogiU");
                    f74577a.put("DDI", "d02F6ttOtV05MYCQ");
                    f74577a.put("ULY", "ToZZIhAywnUfHShN");
                    f74577a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f74577a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f74577a.put("S5Q", "sDWLrZINnum227am");
                    f74577a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f74577a.put("J04", "N5hViUTdLCpN59H0");
                    f74577a.put("B68", "EY3sH1KKtalg5ZaT");
                    f74577a.put("9IW", "q1u0MiuFyim4pCYY");
                    f74577a.put("UU3", "syLnkkd8AqNykVV7");
                    f74577a.put("Z49", "V00FiWu124yE91sH");
                    f74577a.put("BNA", "rPP7AK1VWpKEry3p");
                    f74577a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f74577a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
