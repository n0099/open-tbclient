package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f10270a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f10271b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f10272a;

        /* renamed from: b  reason: collision with root package name */
        final com.kwad.sdk.glide.load.f<T, R> f10273b;
        private final Class<T> c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, com.kwad.sdk.glide.load.f<T, R> fVar) {
            this.c = cls;
            this.f10272a = cls2;
            this.f10273b = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f10272a);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f10270a.contains(str)) {
            this.f10270a.add(str);
        }
        list = this.f10271b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f10271b.put(str, list);
        }
        return list;
    }

    @NonNull
    public synchronized <T, R> List<com.kwad.sdk.glide.load.f<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f10270a) {
            List<a<?, ?>> list = this.f10271b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f10273b);
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
        ArrayList<String> arrayList = new ArrayList(this.f10270a);
        this.f10270a.clear();
        this.f10270a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f10270a.add(str);
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f10270a) {
            List<a<?, ?>> list = this.f10271b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f10272a)) {
                        arrayList.add(aVar.f10272a);
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
