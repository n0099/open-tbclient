package com.kwad.sdk.glide.e;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.glide.load.engine.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final q<?, ?, ?> f35433a = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.kwad.sdk.glide.load.resource.e.g(), null)), null);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<i, q<?, ?, ?>> f35434b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<i> f35435c = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.f35435c.getAndSet(null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        i b2 = b(cls, cls2, cls3);
        synchronized (this.f35434b) {
            qVar = (q<Data, TResource, Transcode>) this.f35434b.get(b2);
        }
        this.f35435c.set(b2);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        synchronized (this.f35434b) {
            ArrayMap<i, q<?, ?, ?>> arrayMap = this.f35434b;
            i iVar = new i(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f35433a;
            }
            arrayMap.put(iVar, qVar);
        }
    }

    public boolean a(@Nullable q<?, ?, ?> qVar) {
        return f35433a.equals(qVar);
    }
}
