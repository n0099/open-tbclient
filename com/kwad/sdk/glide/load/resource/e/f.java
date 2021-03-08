package com.kwad.sdk.glide.load.resource.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f6818a = new ArrayList();

    /* loaded from: classes3.dex */
    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final e<Z, R> f6819a;
        private final Class<Z> b;
        private final Class<R> c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.b = cls;
            this.c = cls2;
            this.f6819a = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.c);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        e<Z, R> eVar;
        if (!cls2.isAssignableFrom(cls)) {
            for (a<?, ?> aVar : this.f6818a) {
                if (aVar.a(cls, cls2)) {
                    eVar = (e<Z, R>) aVar.f6819a;
                }
            }
            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
        }
        eVar = g.a();
        return eVar;
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f6818a.add(new a<>(cls, cls2, eVar));
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList2.add(cls2);
            arrayList = arrayList2;
        } else {
            for (a<?, ?> aVar : this.f6818a) {
                if (aVar.a(cls, cls2)) {
                    arrayList2.add(cls2);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }
}
