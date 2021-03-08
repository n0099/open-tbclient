package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f7450a = a();
    private static final List<String> b = new ArrayList(f7450a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f7450a.containsKey(substring)) {
                    String str3 = f7450a.get(substring);
                    String substring2 = str.substring(3, str.length());
                    try {
                        char[] cArr = new char[substring2.length() / 2];
                        int i = 0;
                        int i2 = 0;
                        while (i2 < substring2.length() / 2) {
                            if (i == str3.length()) {
                                i = 0;
                            }
                            cArr[i2] = (char) (((char) Integer.valueOf(substring2.substring(i2 * 2, (i2 * 2) + 2), 16).intValue()) ^ str3.charAt(i));
                            i2++;
                            i++;
                        }
                        return new String(String.valueOf(cArr).getBytes("iso-8859-1"), "UTF-8");
                    } catch (Exception e) {
                        str2 = substring2;
                        com.meizu.cloud.a.a.e("PushIdEncryptUtils", "invalid pushId encryption " + str2);
                        return str;
                    }
                }
                return str;
            }
            return str;
        } catch (Exception e2) {
            str2 = str;
        }
    }

    private static Map<String, String> a() {
        if (a(f7450a)) {
            synchronized (a.class) {
                if (a(f7450a)) {
                    f7450a = new TreeMap();
                    f7450a.put("UCI", "v9tC0Myz1MGwXRFy");
                    f7450a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f7450a.put("V5R", "cOqH18NXwBtZVkvz");
                    f7450a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f7450a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f7450a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f7450a.put("SO7", "T8LquL1DvwVcogiU");
                    f7450a.put("DDI", "d02F6ttOtV05MYCQ");
                    f7450a.put("ULY", "ToZZIhAywnUfHShN");
                    f7450a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f7450a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f7450a.put("S5Q", "sDWLrZINnum227am");
                    f7450a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f7450a.put("J04", "N5hViUTdLCpN59H0");
                    f7450a.put("B68", "EY3sH1KKtalg5ZaT");
                    f7450a.put("9IW", "q1u0MiuFyim4pCYY");
                    f7450a.put("UU3", "syLnkkd8AqNykVV7");
                    f7450a.put("Z49", "V00FiWu124yE91sH");
                    f7450a.put("BNA", "rPP7AK1VWpKEry3p");
                    f7450a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f7450a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
