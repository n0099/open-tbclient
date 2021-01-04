package com.meizu.cloud.pushsdk.platform;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f11646a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f11647b = new ArrayList(f11646a.keySet());

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 3) {
                String substring = str.substring(0, 3);
                if (f11646a.containsKey(substring)) {
                    String str3 = f11646a.get(substring);
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
        if (a(f11646a)) {
            synchronized (a.class) {
                if (a(f11646a)) {
                    f11646a = new TreeMap();
                    f11646a.put("UCI", "v9tC0Myz1MGwXRFy");
                    f11646a.put("G3G", "XAsFqhhaf4gKpmAi");
                    f11646a.put("V5R", "cOqH18NXwBtZVkvz");
                    f11646a.put("0XC", "IgSEKZ3Ea6Pm4woS");
                    f11646a.put("Z9K", "pH6J9DMPNgqQp8m8");
                    f11646a.put("EIM", "K11Rs9HAKRXeNwq8");
                    f11646a.put("SO7", "T8LquL1DvwVcogiU");
                    f11646a.put("DDI", "d02F6ttOtV05MYCQ");
                    f11646a.put("ULY", "ToZZIhAywnUfHShN");
                    f11646a.put("0EV", "r5D5RRwQhfV0AYLb");
                    f11646a.put("N6A", "QAtSBFcXnQoUgHO2");
                    f11646a.put("S5Q", "sDWLrZINnum227am");
                    f11646a.put("RA5", "4Uq3Ruxo1FTBdHQE");
                    f11646a.put("J04", "N5hViUTdLCpN59H0");
                    f11646a.put("B68", "EY3sH1KKtalg5ZaT");
                    f11646a.put("9IW", "q1u0MiuFyim4pCYY");
                    f11646a.put("UU3", "syLnkkd8AqNykVV7");
                    f11646a.put("Z49", "V00FiWu124yE91sH");
                    f11646a.put("BNA", "rPP7AK1VWpKEry3p");
                    f11646a.put("WXG", "om8w5ahkJJgpAH9v");
                }
            }
        }
        return f11646a;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.isEmpty();
    }
}
