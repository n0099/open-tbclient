package com.kwad.sdk.glide.load.resource.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public class b implements s<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35630a;

    public b(byte[] bArr) {
        this.f35630a = (byte[]) j.a(bArr);
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
        return this.f35630a;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35630a.length;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
