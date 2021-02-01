package com.kwad.sdk.glide.load.resource.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes3.dex */
public class b implements s<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10259a;

    public b(byte[] bArr) {
        this.f10259a = (byte[]) j.a(bArr);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<byte[]> a() {
        return byte[].class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: b */
    public byte[] e() {
        return this.f10259a;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f10259a.length;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
