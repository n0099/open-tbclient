package com.kwad.sdk.core.config;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    public static volatile c b;
    public Map<String, String> a = new HashMap();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public synchronized void a(String str, String str2) {
        this.a.put(str, str2);
    }
}
