package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f8037a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8038b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f8038b && this.f8037a.containsKey(str)) {
            return this.f8037a.get(str);
        }
        String b2 = b(str);
        if (this.f8038b) {
            this.f8037a.put(str, b2);
            return b2;
        }
        return b2;
    }
}
