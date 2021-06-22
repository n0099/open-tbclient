package com.kwad.sdk.glide.load.resource;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public class a<T> implements s<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f36420a;

    public a(@NonNull T t) {
        this.f36420a = (T) j.a(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<T> a() {
        return (Class<T>) this.f36420a.getClass();
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
        return this.f36420a;
    }
}
