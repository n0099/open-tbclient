package com.kwad.sdk.glide.e;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import com.kwad.sdk.glide.load.engine.g;
import com.kwad.sdk.glide.load.engine.q;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final q<?, ?, ?> f35923a = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new com.kwad.sdk.glide.load.resource.e.g(), null)), null);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<i, q<?, ?, ?>> f35924b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<i> f35925c = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.f35925c.getAndSet(null);
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
        synchronized (this.f35924b) {
            qVar = (q<Data, TResource, Transcode>) this.f35924b.get(b2);
        }
        this.f35925c.set(b2);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        synchronized (this.f35924b) {
            ArrayMap<i, q<?, ?, ?>> arrayMap = this.f35924b;
            i iVar = new i(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f35923a;
            }
            arrayMap.put(iVar, qVar);
        }
    }

    public boolean a(@Nullable q<?, ?, ?> qVar) {
        return f35923a.equals(qVar);
    }
}
