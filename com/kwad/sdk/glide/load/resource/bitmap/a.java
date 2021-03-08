package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class a<DataType> implements com.kwad.sdk.glide.load.f<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.f<DataType, Bitmap> f6783a;
    private final Resources b;

    public a(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.f<DataType, Bitmap> fVar) {
        this.b = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.f6783a = (com.kwad.sdk.glide.load.f) com.kwad.sdk.glide.g.j.a(fVar);
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(@NonNull DataType datatype, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return q.a(this.b, this.f6783a.a(datatype, i, i2, eVar));
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull DataType datatype, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f6783a.a(datatype, eVar);
    }
}
