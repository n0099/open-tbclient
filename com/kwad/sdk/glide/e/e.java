package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f35438a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f35439b = new HashMap();

    /* loaded from: classes6.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<R> f35440a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.f<T, R> f35441b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<T> f35442c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, com.kwad.sdk.glide.load.f<T, R> fVar) {
            this.f35442c = cls;
            this.f35440a = cls2;
            this.f35441b = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f35442c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f35440a);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f35438a.contains(str)) {
            this.f35438a.add(str);
        }
        list = this.f35439b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f35439b.put(str, list);
        }
        return list;
    }

    @NonNull
    public synchronized <T, R> List<com.kwad.sdk.glide.load.f<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f35438a) {
            List<a<?, ?>> list = this.f35439b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f35441b);
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
        ArrayList<String> arrayList = new ArrayList(this.f35438a);
        this.f35438a.clear();
        this.f35438a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f35438a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f35438a) {
            List<a<?, ?>> list = this.f35439b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f35440a)) {
                        arrayList.add(aVar.f35440a);
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
