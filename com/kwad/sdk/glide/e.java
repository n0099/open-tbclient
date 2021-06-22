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
/* loaded from: classes7.dex */
public class e extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public static final h<?, ?> f35910a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35911b;

    /* renamed from: c  reason: collision with root package name */
    public final Registry f35912c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.a.f f35913d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.request.f f35914e;

    /* renamed from: f  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.e<Object>> f35915f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Class<?>, h<?, ?>> f35916g;

    /* renamed from: h  reason: collision with root package name */
    public final i f35917h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f35918i;
    public final int j;

    public e(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull com.kwad.sdk.glide.request.a.f fVar, @NonNull com.kwad.sdk.glide.request.f fVar2, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, @NonNull i iVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f35911b = bVar;
        this.f35912c = registry;
        this.f35913d = fVar;
        this.f35914e = fVar2;
        this.f35915f = list;
        this.f35916g = map;
        this.f35917h = iVar;
        this.f35918i = z;
        this.j = i2;
    }

    @NonNull
    public <T> h<?, T> a(@NonNull Class<T> cls) {
        h<?, T> hVar = (h<?, T>) this.f35916g.get(cls);
        if (hVar == null) {
            for (Map.Entry<Class<?>, h<?, ?>> entry : this.f35916g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    hVar = (h<?, T>) entry.getValue();
                }
            }
        }
        return hVar == null ? (h<?, T>) f35910a : hVar;
    }

    @NonNull
    public <X> k<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f35913d.a(imageView, cls);
    }

    public List<com.kwad.sdk.glide.request.e<Object>> a() {
        return this.f35915f;
    }

    public com.kwad.sdk.glide.request.f b() {
        return this.f35914e;
    }

    @NonNull
    public i c() {
        return this.f35917h;
    }

    @NonNull
    public Registry d() {
        return this.f35912c;
    }

    public int e() {
        return this.j;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f() {
        return this.f35911b;
    }

    public boolean g() {
        return this.f35918i;
    }
}
