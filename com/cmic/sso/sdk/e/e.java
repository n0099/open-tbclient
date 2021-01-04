package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f8022a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f8022a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f8022a.put(str, bVar);
    }

    public static void b(String str) {
        f8022a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b Zf(String str) {
        return f8022a.get(str);
    }

    public static boolean a() {
        return f8022a.isEmpty();
    }
}
