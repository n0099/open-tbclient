package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes3.dex */
public final class b implements a.InterfaceC1122a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10310a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10311b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10310a = eVar;
        this.f10311b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    @NonNull
    public Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f10310a.b(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    public void a(@NonNull Bitmap bitmap) {
        this.f10310a.a(bitmap);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    public void a(@NonNull byte[] bArr) {
        if (this.f10311b == null) {
            return;
        }
        this.f10311b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    public void a(@NonNull int[] iArr) {
        if (this.f10311b == null) {
            return;
        }
        this.f10311b.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    @NonNull
    public byte[] a(int i) {
        return this.f10311b == null ? new byte[i] : (byte[]) this.f10311b.a(i, byte[].class);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC1122a
    @NonNull
    public int[] b(int i) {
        return this.f10311b == null ? new int[i] : (int[]) this.f10311b.a(i, int[].class);
    }
}
