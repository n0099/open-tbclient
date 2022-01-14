package com.kwad.sdk.core.config;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f55640b;
    public Map<String, String> a = new HashMap();

    public static c a() {
        if (f55640b == null) {
            synchronized (c.class) {
                if (f55640b == null) {
                    f55640b = new c();
                }
            }
        }
        return f55640b;
    }

    public synchronized void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
