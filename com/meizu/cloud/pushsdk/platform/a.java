package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f34986a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f34987b = new ArrayList(f34986a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f34986a.containsKey(substring)) {
                    String str3 = f34986a.get(substring);
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
                        d.j.a.a.a.b("PushIdEncryptUtils", "invalid pushId encryption " + str2);
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
        if (a(f34986a)) {
            synchronized (a.class) {
                if (a(f34986a)) {
                    TreeMap treeMap = new TreeMap();
                    f34986a = treeMap;
                    treeMap.put("UCI", "v9tC0Myz1MGwXRFy");
                    f34986a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f34986a.put("V5R", "cOqH18NXwBtZVkvz");
                    f34986a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f34986a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f34986a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f34986a.put("SO7", "T8LquL1DvwVcogiU");
                    f34986a.put("DDI", "d02F6ttOtV05MYCQ");
                    f34986a.put("ULY", "ToZZIhAywnUfHShN");
                    f34986a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f34986a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f34986a.put("S5Q", "sDWLrZINnum227am");
                    f34986a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f34986a.put("J04", "N5hViUTdLCpN59H0");
                    f34986a.put("B68", "EY3sH1KKtalg5ZaT");
                    f34986a.put("9IW", "q1u0MiuFyim4pCYY");
                    f34986a.put("UU3", "syLnkkd8AqNykVV7");
                    f34986a.put("Z49", "V00FiWu124yE91sH");
                    f34986a.put("BNA", "rPP7AK1VWpKEry3p");
                    f34986a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f34986a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
