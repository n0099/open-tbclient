package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f8324a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8325b;
    private final String c;
    private final String d;
    private final String e;
    @Nullable
    private Bitmap f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f8324a = i;
        this.f8325b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public String a() {
        return this.c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f = bitmap;
    }

    public String b() {
        return this.d;
    }

    @Nullable
    public Bitmap c() {
        return this.f;
    }
}
