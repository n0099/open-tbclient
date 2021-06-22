package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes7.dex */
public final class b implements a.InterfaceC0410a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36506a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36507b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36506a = eVar;
        this.f36507b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    @NonNull
    public Bitmap a(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.f36506a.b(i2, i3, config);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    public void a(@NonNull Bitmap bitmap) {
        this.f36506a.a(bitmap);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    public void a(@NonNull byte[] bArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f36507b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    public void a(@NonNull int[] iArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f36507b;
        if (bVar == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    @NonNull
    public byte[] a(int i2) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f36507b;
        return bVar == null ? new byte[i2] : (byte[]) bVar.a(i2, byte[].class);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0410a
    @NonNull
    public int[] b(int i2) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f36507b;
        return bVar == null ? new int[i2] : (int[]) bVar.a(i2, int[].class);
    }
}
