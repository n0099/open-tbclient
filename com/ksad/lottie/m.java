package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f32077a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32078b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f32078b && this.f32077a.containsKey(str)) {
            return this.f32077a.get(str);
        }
        String b2 = b(str);
        if (this.f32078b) {
            this.f32077a.put(str, b2);
        }
        return b2;
    }
}
