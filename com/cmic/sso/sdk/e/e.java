package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f5218a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f5218a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f5218a.put(str, bVar);
    }

    public static void b(String str) {
        f5218a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b Zq(String str) {
        return f5218a.get(str);
    }

    public static boolean a() {
        return f5218a.isEmpty();
    }
}
