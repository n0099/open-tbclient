package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f9971a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f9972b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f9973a;

        /* renamed from: b  reason: collision with root package name */
        final com.kwad.sdk.glide.load.f<T, R> f9974b;
        private final Class<T> c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, com.kwad.sdk.glide.load.f<T, R> fVar) {
            this.c = cls;
            this.f9973a = cls2;
            this.f9974b = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f9973a);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f9971a.contains(str)) {
            this.f9971a.add(str);
        }
        list = this.f9972b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f9972b.put(str, list);
        }
        return list;
    }

    @NonNull
    public synchronized <T, R> List<com.kwad.sdk.glide.load.f<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f9971a) {
            List<a<?, ?>> list = this.f9972b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f9974b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull com.kwad.sdk.glide.load.f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, fVar));
    }

    public synchronized void a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f9971a);
        this.f9971a.clear();
        this.f9971a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f9971a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f9971a) {
            List<a<?, ?>> list = this.f9972b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f9973a)) {
                        arrayList.add(aVar.f9973a);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void b(@NonNull String str, @NonNull com.kwad.sdk.glide.load.f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(0, new a<>(cls, cls2, fVar));
    }
}
