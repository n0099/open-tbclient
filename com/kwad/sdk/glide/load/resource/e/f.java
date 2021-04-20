package com.kwad.sdk.glide.load.resource.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?, ?>> f36040a = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        public final e<Z, R> f36041a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<Z> f36042b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<R> f36043c;

        public a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f36042b = cls;
            this.f36043c = cls2;
            this.f36041a = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f36042b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f36043c);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.f36040a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f36041a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f36040a.add(new a<>(cls, cls2, eVar));
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f36040a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
