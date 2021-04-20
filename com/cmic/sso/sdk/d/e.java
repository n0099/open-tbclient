package com.cmic.sso.sdk.d;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, TokenListener> f30369a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f30369a.containsKey(str);
    }

    public static void b(String str) {
        f30369a.remove(str);
    }

    public static TokenListener c(String str) {
        return f30369a.get(str);
    }

    public static void a(String str, TokenListener tokenListener) {
        f30369a.put(str, tokenListener);
    }

    public static boolean a() {
        return f30369a.isEmpty();
    }
}
