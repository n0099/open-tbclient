package com.tencent.turingfd.sdk.ams.au;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class ab {
    public static String a(String str, int i) {
        return str + i;
    }

    public static StringBuilder a(String str) {
        return new StringBuilder().append(str);
    }

    public static void a(StringBuilder sb, int i, HashMap hashMap, Object obj) {
        hashMap.put(obj, sb.append(i).toString());
    }

    public static void a(HashMap hashMap, Object obj, Object obj2, long j, int i) {
        hashMap.put(obj, obj2);
        i.a(i, System.currentTimeMillis() - j);
    }
}
