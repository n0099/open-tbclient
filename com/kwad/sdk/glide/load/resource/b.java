package com.kwad.sdk.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.h;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class b<T> implements h<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final h<?> f36423b = new b();

    @NonNull
    public static <T> b<T> a() {
        return (b) f36423b;
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<T> a(@NonNull Context context, @NonNull s<T> sVar, int i2, int i3) {
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
