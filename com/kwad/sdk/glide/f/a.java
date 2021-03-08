package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class a implements c {
    private static final a b = new a();

    private a() {
    }

    @NonNull
    public static a a() {
        return b;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
