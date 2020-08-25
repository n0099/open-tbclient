package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class e {
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        a.put(str, bVar);
    }

    public static void b(String str) {
        a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b Uh(String str) {
        return a.get(str);
    }

    public static boolean a() {
        return a.isEmpty();
    }
}
