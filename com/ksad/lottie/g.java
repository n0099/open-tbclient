package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f31423a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31424b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31425c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31426d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31427e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f31428f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f31423a = i;
        this.f31424b = i2;
        this.f31425c = str;
        this.f31426d = str2;
        this.f31427e = str3;
    }

    public String a() {
        return this.f31425c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f31428f = bitmap;
    }

    public String b() {
        return this.f31426d;
    }

    @Nullable
    public Bitmap c() {
        return this.f31428f;
    }
}
