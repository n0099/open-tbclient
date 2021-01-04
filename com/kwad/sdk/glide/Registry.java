package com.kwad.sdk.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.p;
import com.kwad.sdk.glide.load.engine.q;
import com.kwad.sdk.glide.load.engine.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class Registry {
    private final com.kwad.sdk.glide.e.d h = new com.kwad.sdk.glide.e.d();
    private final com.kwad.sdk.glide.e.c i = new com.kwad.sdk.glide.e.c();
    private final Pools.Pool<List<Throwable>> j = com.kwad.sdk.glide.g.a.a.a();

    /* renamed from: a  reason: collision with root package name */
    private final p f10219a = new p(this.j);

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.e.a f10220b = new com.kwad.sdk.glide.e.a();
    private final com.kwad.sdk.glide.e.e c = new com.kwad.sdk.glide.e.e();
    private final com.kwad.sdk.glide.e.f d = new com.kwad.sdk.glide.e.f();
    private final com.kwad.sdk.glide.load.a.f e = new com.kwad.sdk.glide.load.a.f();
    private final com.kwad.sdk.glide.load.resource.e.f f = new com.kwad.sdk.glide.load.resource.e.f();
    private final com.kwad.sdk.glide.e.b g = new com.kwad.sdk.glide.e.b();

    /* loaded from: classes5.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes5.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }
    }

    /* loaded from: classes5.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes5.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        a(Arrays.asList(com.bumptech.glide.Registry.BUCKET_GIF, com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new com.kwad.sdk.glide.load.engine.g(cls, cls4, cls5, this.c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    @NonNull
    public Registry a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry a(@NonNull e.a<?> aVar) {
        this.e.a(aVar);
        return this;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.kwad.sdk.glide.load.a<Data> aVar) {
        this.f10220b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry a(@NonNull Class<TResource> cls, @NonNull com.kwad.sdk.glide.load.g<TResource> gVar) {
        this.d.a(cls, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f10219a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        a("legacy_append", cls, cls2, fVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.kwad.sdk.glide.load.resource.e.e<TResource, Transcode> eVar) {
        this.f.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        this.c.a(str, fVar, cls, cls2);
        return this;
    }

    @NonNull
    public final Registry a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.c.a(arrayList);
        return this;
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.a<X> a(@NonNull X x) {
        com.kwad.sdk.glide.load.a<X> a2 = this.f10220b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        q<Data, TResource, Transcode> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> c = c(cls, cls2, cls3);
            q<Data, TResource, Transcode> qVar = c.isEmpty() ? null : new q<>(cls, cls2, cls3, c, this.j);
            this.i.a(cls, cls2, cls3, qVar);
            return qVar;
        }
        return a2;
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.g.a();
        if (a2.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return a2;
    }

    public boolean a(@NonNull s<?> sVar) {
        return this.d.a(sVar.a()) != null;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.kwad.sdk.glide.load.g<TResource> gVar) {
        this.d.b(cls, gVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        b("legacy_prepend_all", cls, cls2, fVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        this.c.b(str, fVar, cls, cls2);
        return this;
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.a.e<X> b(@NonNull X x) {
        return this.e.a((com.kwad.sdk.glide.load.a.f) x);
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.g<X> b(@NonNull s<X> sVar) {
        com.kwad.sdk.glide.load.g<X> a2 = this.d.a(sVar.a());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(sVar.a());
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2, cls3);
        if (a2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls4 : this.f10219a.a((Class<?>) cls)) {
                for (Class cls5 : this.c.b(cls4, cls2)) {
                    if (!this.f.b(cls5, cls3).isEmpty() && !arrayList.contains(cls5)) {
                        arrayList.add(cls5);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            return arrayList;
        }
        return a2;
    }

    @NonNull
    public <Model> List<n<Model, ?>> c(@NonNull Model model) {
        List<n<Model, ?>> a2 = this.f10219a.a((p) model);
        if (a2.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return a2;
    }
}
