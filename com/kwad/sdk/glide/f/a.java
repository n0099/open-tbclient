package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final a f9982b = new a();

    private a() {
    }

    @NonNull
    public static a a() {
        return f9982b;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }
}
