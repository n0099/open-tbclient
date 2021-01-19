package com.cmic.sso.sdk.e;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.b.b> f7723a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f7723a.containsKey(str);
    }

    public static void a(String str, com.cmic.sso.sdk.b.b bVar) {
        f7723a.put(str, bVar);
    }

    public static void b(String str) {
        f7723a.remove(str);
    }

    public static com.cmic.sso.sdk.b.b XX(String str) {
        return f7723a.get(str);
    }

    public static boolean a() {
        return f7723a.isEmpty();
    }
}
