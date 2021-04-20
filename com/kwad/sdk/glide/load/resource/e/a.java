package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.CompressFormat f36034a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36035b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.f36034a = compressFormat;
        this.f36035b = i;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Bitmap> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.e().compress(this.f36034a, this.f36035b, byteArrayOutputStream);
        sVar.d_();
        return new com.kwad.sdk.glide.load.resource.a.b(byteArrayOutputStream.toByteArray());
    }
}
