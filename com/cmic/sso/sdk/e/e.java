package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f8023a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f8023a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f8023a.put(str, bVar);
    }

    public static void b(String str) {
        f8023a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b Ze(String str) {
        return f8023a.get(str);
    }

    public static boolean a() {
        return f8023a.isEmpty();
    }
}
