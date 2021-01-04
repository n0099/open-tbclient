package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes5.dex */
public final class b implements a.InterfaceC1092a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10607a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10608b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10607a = eVar;
        this.f10608b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    @NonNull
    public Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f10607a.b(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    public void a(@NonNull Bitmap bitmap) {
        this.f10607a.a(bitmap);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    public void a(@NonNull byte[] bArr) {
        if (this.f10608b == null) {
            return;
        }
        this.f10608b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    public void a(@NonNull int[] iArr) {
        if (this.f10608b == null) {
            return;
        }
        this.f10608b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    @NonNull
    public byte[] a(int i) {
        return this.f10608b == null ? new byte[i] : (byte[]) this.f10608b.a(i, byte[].class);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1092a
    @NonNull
    public int[] b(int i) {
        return this.f10608b == null ? new int[i] : (int[]) this.f10608b.a(i, int[].class);
    }
}
