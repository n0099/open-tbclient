package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.kwad.sdk.glide.g.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<i> f35828a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<i, List<Class<?>>> f35829b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f35828a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f35829b) {
            list = this.f35829b.get(andSet);
        }
        this.f35828a.set(andSet);
        return list;
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f35829b) {
            this.f35829b.put(new i(cls, cls2, cls3), list);
        }
    }
}
