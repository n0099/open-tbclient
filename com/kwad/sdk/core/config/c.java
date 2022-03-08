package com.kwad.sdk.core.config;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f54202b;
    public Map<String, String> a = new HashMap();

    public static c a() {
        if (f54202b == null) {
            synchronized (c.class) {
                if (f54202b == null) {
                    f54202b = new c();
                }
            }
        }
        return f54202b;
    }

    public synchronized void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
