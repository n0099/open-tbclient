package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f7725a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f7725a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f7725a.put(str, bVar);
    }

    public static void b(String str) {
        f7725a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b YY(String str) {
        return f7725a.get(str);
    }

    public static boolean a() {
        return f7725a.isEmpty();
    }
}
