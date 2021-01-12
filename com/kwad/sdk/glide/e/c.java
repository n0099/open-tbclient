package com.kwad.sdk.glide.e;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.glide.load.engine.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final q<?, ?, ?> f9967a = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.kwad.sdk.glide.load.resource.e.g(), null)), null);

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<i, q<?, ?, ?>> f9968b = new ArrayMap<>();
    private final AtomicReference<i> c = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.c.getAndSet(null);
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
        synchronized (this.f9968b) {
            qVar = (q<Data, TResource, Transcode>) this.f9968b.get(b2);
        }
        this.c.set(b2);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        synchronized (this.f9968b) {
            ArrayMap<i, q<?, ?, ?>> arrayMap = this.f9968b;
            i iVar = new i(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f9967a;
            }
            arrayMap.put(iVar, qVar);
        }
    }

    public boolean a(@Nullable q<?, ?, ?> qVar) {
        return f9967a.equals(qVar);
    }
}
