package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
/* loaded from: classes4.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f10324a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10325b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.f10324a = compressFormat;
        this.f10325b = i;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Bitmap> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.e().compress(this.f10324a, this.f10325b, byteArrayOutputStream);
        sVar.d_();
        return new com.kwad.sdk.glide.load.resource.a.b(byteArrayOutputStream.toByteArray());
    }
}
