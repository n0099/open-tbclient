package com.cmic.sso.sdk.d;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, TokenListener> f31394a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f31394a.containsKey(str);
    }

    public static void b(String str) {
        f31394a.remove(str);
    }

    public static TokenListener c(String str) {
        return f31394a.get(str);
    }

    public static void a(String str, TokenListener tokenListener) {
        f31394a.put(str, tokenListener);
    }

    public static boolean a() {
        return f31394a.isEmpty();
    }
}
