package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes6.dex */
public final class b implements a.InterfaceC0406a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35713a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35714b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f35713a = eVar;
        this.f35714b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    @NonNull
    public Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f35713a.b(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    public void a(@NonNull Bitmap bitmap) {
        this.f35713a.a(bitmap);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    public void a(@NonNull byte[] bArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f35714b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    public void a(@NonNull int[] iArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f35714b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    @NonNull
    public byte[] a(int i) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f35714b;
        return bVar == null ? new byte[i] : (byte[]) bVar.a(i, byte[].class);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0406a
    @NonNull
    public int[] b(int i) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f35714b;
        return bVar == null ? new int[i] : (int[]) bVar.a(i, int[].class);
    }
}
