package com.kwad.sdk.glide.webp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.c.h;
import com.kwad.sdk.glide.c.l;
import com.kwad.sdk.glide.g;
import com.kwad.sdk.glide.request.f;
/* loaded from: classes6.dex */
public class c extends g {
    public c(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
        super(cVar, hVar, lVar, context);
    }

    @Override // com.kwad.sdk.glide.g
    public void a(@NonNull f fVar) {
        if (!(fVar instanceof a)) {
            fVar = new a().b(fVar);
        }
        super.a(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<Drawable> a(@Nullable String str) {
        return (b) super.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: c */
    public <ResourceType> b<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new b<>(this.f35191a, this, cls, this.f35192b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: j */
    public b<Bitmap> f() {
        return (b) super.f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: k */
    public b<Drawable> g() {
        return (b) super.g();
    }
}
