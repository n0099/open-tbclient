package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f31447a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31448b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f31448b && this.f31447a.containsKey(str)) {
            return this.f31447a.get(str);
        }
        String b2 = b(str);
        if (this.f31448b) {
            this.f31447a.put(str, b2);
        }
        return b2;
    }
}
