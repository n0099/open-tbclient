package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f5371a;
    private boolean b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.b && this.f5371a.containsKey(str)) {
            return this.f5371a.get(str);
        }
        String b = b(str);
        if (this.b) {
            this.f5371a.put(str, b);
            return b;
        }
        return b;
    }
}
