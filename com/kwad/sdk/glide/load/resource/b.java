package com.kwad.sdk.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.h;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class b<T> implements h<T> {
    private static final h<?> b = new b();

    private b() {
    }

    @NonNull
    public static <T> b<T> a() {
        return (b) b;
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<T> a(@NonNull Context context, @NonNull s<T> sVar, int i, int i2) {
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
