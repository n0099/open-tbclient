package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.CompressFormat f36441a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36442b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i2) {
        this.f36441a = compressFormat;
        this.f36442b = i2;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Bitmap> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.e().compress(this.f36441a, this.f36442b, byteArrayOutputStream);
        sVar.d_();
        return new com.kwad.sdk.glide.load.resource.a.b(byteArrayOutputStream.toByteArray());
    }
}
