package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class e implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final a f36534a;

    public e(a aVar) {
        this.f36534a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36534a.a(inputStream, i2, i3, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36534a.a(inputStream, eVar);
    }
}
