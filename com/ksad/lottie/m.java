package com.ksad.lottie;

import java.util.Map;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f8039a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8040b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f8040b && this.f8039a.containsKey(str)) {
            return this.f8039a.get(str);
        }
        String b2 = b(str);
        if (this.f8040b) {
            this.f8039a.put(str, b2);
            return b2;
        }
        return b2;
    }
}
