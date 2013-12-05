package com.google.zxing.client.result;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f2855a = {new f(), new c(), new j(), new b(), new ae(), new e(), new af(), new i(), new x(), new z(), new u(), new w(), new n(), new ah(), new ad(), new ac(), new p(), new s(), new l()};
    private static final Pattern b = Pattern.compile("\\d*");
    private static final Pattern c = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern d = Pattern.compile("&");
    private static final Pattern e = Pattern.compile("=");

    public abstract q b(com.google.zxing.h hVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public static String c(com.google.zxing.h hVar) {
        String a2 = hVar.a();
        if (a2.startsWith("\ufeff")) {
            return a2.substring(1);
        }
        return a2;
    }

    public static q d(com.google.zxing.h hVar) {
        for (t tVar : f2855a) {
            q b2 = tVar.b(hVar);
            if (b2 != null) {
                return b2;
            }
        }
        return new aa(hVar.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] b(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf >= 0) {
            int length = str.length();
            StringBuilder sb = new StringBuilder(length - 1);
            sb.append(str.toCharArray(), 0, indexOf);
            boolean z = false;
            for (int i = indexOf; i < length; i++) {
                char charAt = str.charAt(i);
                if (z || charAt != '\\') {
                    sb.append(charAt);
                    z = false;
                } else {
                    z = true;
                }
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return (c2 - 'A') + 10;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i == charSequence.length() && b.matcher(charSequence).matches();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> d(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        String[] split = d.split(str.substring(indexOf + 1));
        for (String str2 : split) {
            a(str2, hashMap);
        }
        return hashMap;
    }

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = e.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], e(split[1]));
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] a(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        int i = 0;
        ArrayList arrayList = null;
        while (i < length) {
            int indexOf = str2.indexOf(str, i);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            ArrayList arrayList2 = arrayList;
            int i2 = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i2);
                if (indexOf2 < 0) {
                    i2 = str2.length();
                    z2 = false;
                } else if (str2.charAt(indexOf2 - 1) == '\\') {
                    i2 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String c3 = c(str2.substring(length2, indexOf2));
                    if (z) {
                        c3 = c3.trim();
                    }
                    if (c3.length() > 0) {
                        arrayList2.add(c3);
                    }
                    i2 = indexOf2 + 1;
                    z2 = false;
                }
            }
            int i3 = i2;
            arrayList = arrayList2;
            i = i3;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str, String str2, char c2, boolean z) {
        String[] a2 = a(str, str2, c2, z);
        if (a2 == null) {
            return null;
        }
        return a2[0];
    }
}
