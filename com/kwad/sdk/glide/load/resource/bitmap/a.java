package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class a<DataType> implements com.kwad.sdk.glide.load.f<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<DataType, Bitmap> f36343a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f36344b;

    public a(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.f<DataType, Bitmap> fVar) {
        this.f36344b = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.f36343a = (com.kwad.sdk.glide.load.f) com.kwad.sdk.glide.g.j.a(fVar);
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(@NonNull DataType datatype, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return q.a(this.f36344b, this.f36343a.a(datatype, i2, i3, eVar));
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull DataType datatype, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36343a.a(datatype, eVar);
    }
}
