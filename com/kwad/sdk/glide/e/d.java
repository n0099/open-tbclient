package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f6600a = new AtomicReference<>();
    private final ArrayMap<i, List<Class<?>>> b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        i iVar;
        List<Class<?>> list;
        i andSet = this.f6600a.getAndSet(null);
        if (andSet == null) {
            iVar = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
            iVar = andSet;
        }
        synchronized (this.b) {
            list = this.b.get(iVar);
        }
        this.f6600a.set(iVar);
        return list;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new i(cls, cls2, cls3), list);
        }
    }
}
