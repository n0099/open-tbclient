package com.kwad.sdk.core.config;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f55852b;
    public Map<String, String> a = new HashMap();

    public static c a() {
        if (f55852b == null) {
            synchronized (c.class) {
                if (f55852b == null) {
                    f55852b = new c();
                }
            }
        }
        return f55852b;
    }

    public synchronized void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
