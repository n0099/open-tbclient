package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f31713a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31714b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31715c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31716d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31717e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f31718f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f31713a = i;
        this.f31714b = i2;
        this.f31715c = str;
        this.f31716d = str2;
        this.f31717e = str3;
    }

    public String a() {
        return this.f31715c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f31718f = bitmap;
    }

    public String b() {
        return this.f31716d;
    }

    @Nullable
    public Bitmap c() {
        return this.f31718f;
    }
}
