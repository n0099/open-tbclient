package com.kwad.sdk.core.config;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f39337b;
    public Map<String, String> a = new HashMap();

    public static c a() {
        if (f39337b == null) {
            synchronized (c.class) {
                if (f39337b == null) {
                    f39337b = new c();
                }
            }
        }
        return f39337b;
    }

    public synchronized void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
