package com.kwad.sdk.glide.load.resource.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.resource.bitmap.q;
/* loaded from: classes5.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f10626a;

    public b(@NonNull Resources resources) {
        this.f10626a = (Resources) j.a(resources);
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<BitmapDrawable> a(@NonNull s<Bitmap> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return q.a(this.f10626a, sVar);
    }
}
