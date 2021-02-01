package com.kwad.sdk.glide.load.resource.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f10331a = new ArrayList();

    /* loaded from: classes3.dex */
    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final e<Z, R> f10332a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<Z> f10333b;
        private final Class<R> c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f10333b = cls;
            this.c = cls2;
            this.f10332a = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f10333b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.c);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        e<Z, R> eVar;
        if (!cls2.isAssignableFrom(cls)) {
            for (a<?, ?> aVar : this.f10331a) {
                if (aVar.a(cls, cls2)) {
                    eVar = (e<Z, R>) aVar.f10332a;
                }
            }
            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
        }
        eVar = g.a();
        return eVar;
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f10331a.add(new a<>(cls, cls2, eVar));
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList2.add(cls2);
            arrayList = arrayList2;
        } else {
            for (a<?, ?> aVar : this.f10331a) {
                if (aVar.a(cls, cls2)) {
                    arrayList2.add(cls2);
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }
}
