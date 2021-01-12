package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f9969a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<i, List<Class<?>>> f9970b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        i iVar;
        List<Class<?>> list;
        i andSet = this.f9969a.getAndSet(null);
        if (andSet == null) {
            iVar = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
            iVar = andSet;
        }
        synchronized (this.f9970b) {
            list = this.f9970b.get(iVar);
        }
        this.f9969a.set(iVar);
        return list;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f9970b) {
            this.f9970b.put(new i(cls, cls2, cls3), list);
        }
    }
}
