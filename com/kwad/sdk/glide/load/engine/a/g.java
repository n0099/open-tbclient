package com.kwad.sdk.glide.load.engine.a;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, s<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    public h.a f35816a;

    public g(long j) {
        super(j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g.g
    public int a(@Nullable s<?> sVar) {
        return sVar == null ? super.a((g) null) : sVar.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @Nullable
    public /* synthetic */ s a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        return (s) super.c(cVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g.g
    public void a(@NonNull com.kwad.sdk.glide.load.c cVar, @Nullable s<?> sVar) {
        h.a aVar = this.f35816a;
        if (aVar == null || sVar == null) {
            return;
        }
        aVar.b(sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public void a(@NonNull h.a aVar) {
        this.f35816a = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @Nullable
    public /* bridge */ /* synthetic */ s b(@NonNull com.kwad.sdk.glide.load.c cVar, @Nullable s sVar) {
        return (s) super.b((g) cVar, (com.kwad.sdk.glide.load.c) sVar);
    }
}
