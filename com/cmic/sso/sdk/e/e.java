package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f4023a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f4023a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f4023a.put(str, bVar);
    }

    public static void b(String str) {
        f4023a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b YU(String str) {
        return f4023a.get(str);
    }

    public static boolean a() {
        return f4023a.isEmpty();
    }
}
