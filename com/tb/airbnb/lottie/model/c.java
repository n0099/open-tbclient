package com.tb.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private final String Df;
    private final float Dg;
    private final String name;
    private final String style;

    public c(String str, String str2, String str3, float f) {
        this.Df = str;
        this.name = str2;
        this.style = str3;
        this.Dg = f;
    }

    public String hE() {
        return this.Df;
    }

    public String getName() {
        return this.name;
    }

    public String hF() {
        return this.style;
    }
}
