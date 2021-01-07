package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f8337a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8338b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f8338b && this.f8337a.containsKey(str)) {
            return this.f8337a.get(str);
        }
        String b2 = b(str);
        if (this.f8338b) {
            this.f8337a.put(str, b2);
            return b2;
        }
        return b2;
    }
}
