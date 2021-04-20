package com.kwad.sdk.glide.load.resource;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public class a<T> implements s<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f35918a;

    public a(@NonNull T t) {
        this.f35918a = (T) j.a(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<T> a() {
        return (Class<T>) this.f35918a.getClass();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int c() {
        return 1;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public final T e() {
        return this.f35918a;
    }
}
