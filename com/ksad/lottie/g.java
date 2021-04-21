package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f31808a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31809b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31810c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31811d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31812e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f31813f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f31808a = i;
        this.f31809b = i2;
        this.f31810c = str;
        this.f31811d = str2;
        this.f31812e = str3;
    }

    public String a() {
        return this.f31810c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f31813f = bitmap;
    }

    public String b() {
        return this.f31811d;
    }

    @Nullable
    public Bitmap c() {
        return this.f31813f;
    }
}
