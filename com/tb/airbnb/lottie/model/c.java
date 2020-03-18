package com.tb.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private final float hA;
    private final String hz;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.hz = str;
        this.name = str2;
        this.style = str3;
        this.hA = f;
    }

    public String ch() {
        return this.hz;
    }

    public String getName() {
        return this.name;
    }

    public String ci() {
        return this.style;
    }
}
