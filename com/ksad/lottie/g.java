package com.ksad.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f31956a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31957b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31958c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31959d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31960e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f31961f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i2, int i3, String str, String str2, String str3) {
        this.f31956a = i2;
        this.f31957b = i3;
        this.f31958c = str;
        this.f31959d = str2;
        this.f31960e = str3;
    }

    public String a() {
        return this.f31958c;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f31961f = bitmap;
    }

    public String b() {
        return this.f31959d;
    }

    @Nullable
    public Bitmap c() {
        return this.f31961f;
    }
}
