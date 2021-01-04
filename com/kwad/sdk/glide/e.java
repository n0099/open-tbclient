package com.kwad.sdk.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.request.a.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final h<?, ?> f10260a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10261b;
    private final Registry c;
    private final com.kwad.sdk.glide.request.a.f d;
    private final com.kwad.sdk.glide.request.f e;
    private final List<com.kwad.sdk.glide.request.e<Object>> f;
    private final Map<Class<?>, h<?, ?>> g;
    private final i h;
    private final boolean i;
    private final int j;

    public e(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull com.kwad.sdk.glide.request.a.f fVar, @NonNull com.kwad.sdk.glide.request.f fVar2, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, @NonNull i iVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.f10261b = bVar;
        this.c = registry;
        this.d = fVar;
        this.e = fVar2;
        this.f = list;
        this.g = map;
        this.h = iVar;
        this.i = z;
        this.j = i;
    }

    @NonNull
    public <T> h<?, T> a(@NonNull Class<T> cls) {
        h<?, T> hVar;
        h<?, T> hVar2 = (h<?, T>) this.g.get(cls);
        if (hVar2 == null) {
            Iterator<Map.Entry<Class<?>, h<?, ?>>> it = this.g.entrySet().iterator();
            while (true) {
                hVar = hVar2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, h<?, ?>> next = it.next();
                hVar2 = next.getKey().isAssignableFrom(cls) ? (h<?, T>) next.getValue() : hVar;
            }
            hVar2 = hVar;
        }
        return hVar2 == null ? (h<?, T>) f10260a : hVar2;
    }

    @NonNull
    public <X> k<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.d.a(imageView, cls);
    }

    public List<com.kwad.sdk.glide.request.e<Object>> a() {
        return this.f;
    }

    public com.kwad.sdk.glide.request.f b() {
        return this.e;
    }

    @NonNull
    public i c() {
        return this.h;
    }

    @NonNull
    public Registry d() {
        return this.c;
    }

    public int e() {
        return this.j;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f() {
        return this.f10261b;
    }

    public boolean g() {
        return this.i;
    }
}
