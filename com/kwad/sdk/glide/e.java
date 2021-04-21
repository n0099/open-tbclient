package com.kwad.sdk.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.request.a.k;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static final h<?, ?> f35516a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35517b;

    /* renamed from: c  reason: collision with root package name */
    public final Registry f35518c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.a.f f35519d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.f f35520e;

    /* renamed from: f  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.e<Object>> f35521f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f35522g;

    /* renamed from: h  reason: collision with root package name */
    public final i f35523h;
    public final boolean i;
    public final int j;

    public e(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull com.kwad.sdk.glide.request.a.f fVar, @NonNull com.kwad.sdk.glide.request.f fVar2, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, @NonNull i iVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.f35517b = bVar;
        this.f35518c = registry;
        this.f35519d = fVar;
        this.f35520e = fVar2;
        this.f35521f = list;
        this.f35522g = map;
        this.f35523h = iVar;
        this.i = z;
        this.j = i;
    }

    @NonNull
    public <T> h<?, T> a(@NonNull Class<T> cls) {
        h<?, T> hVar = (h<?, T>) this.f35522g.get(cls);
        if (hVar == null) {
            for (Map.Entry<Class<?>, h<?, ?>> entry : this.f35522g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    hVar = (h<?, T>) entry.getValue();
                }
            }
        }
        return hVar == null ? (h<?, T>) f35516a : hVar;
    }

    @NonNull
    public <X> k<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f35519d.a(imageView, cls);
    }

    public List<com.kwad.sdk.glide.request.e<Object>> a() {
        return this.f35521f;
    }

    public com.kwad.sdk.glide.request.f b() {
        return this.f35520e;
    }

    @NonNull
    public i c() {
        return this.f35523h;
    }

    @NonNull
    public Registry d() {
        return this.f35518c;
    }

    public int e() {
        return this.j;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f() {
        return this.f35517b;
    }

    public boolean g() {
        return this.i;
    }
}
