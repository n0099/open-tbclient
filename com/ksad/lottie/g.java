package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f32054a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32055b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32056c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32057d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32058e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f32059f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i2, int i3, String str, String str2, String str3) {
        this.f32054a = i2;
        this.f32055b = i3;
        this.f32056c = str;
        this.f32057d = str2;
        this.f32058e = str3;
    }

    public String a() {
        return this.f32056c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f32059f = bitmap;
    }

    public String b() {
        return this.f32057d;
    }

    @Nullable
    public Bitmap c() {
        return this.f32059f;
    }
}
