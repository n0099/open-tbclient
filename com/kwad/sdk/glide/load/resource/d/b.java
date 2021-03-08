package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes3.dex */
public final class b implements a.InterfaceC1139a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f6806a;
    @Nullable
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f6806a = eVar;
        this.b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    @NonNull
    public Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f6806a.b(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    public void a(@NonNull Bitmap bitmap) {
        this.f6806a.a(bitmap);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    public void a(@NonNull byte[] bArr) {
        if (this.b == null) {
            return;
        }
        this.b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    public void a(@NonNull int[] iArr) {
        if (this.b == null) {
            return;
        }
        this.b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    @NonNull
    public byte[] a(int i) {
        return this.b == null ? new byte[i] : (byte[]) this.b.a(i, byte[].class);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1139a
    @NonNull
    public int[] b(int i) {
        return this.b == null ? new int[i] : (int[]) this.b.a(i, int[].class);
    }
}
