package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f31424a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31425b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31426c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31427d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31428e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f31429f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.f31424a = i;
        this.f31425b = i2;
        this.f31426c = str;
        this.f31427d = str2;
        this.f31428e = str3;
    }

    public String a() {
        return this.f31426c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f31429f = bitmap;
    }

    public String b() {
        return this.f31427d;
    }

    @Nullable
    public Bitmap c() {
        return this.f31429f;
    }
}
