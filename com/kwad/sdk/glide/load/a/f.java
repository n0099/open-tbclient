package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final e.a<?> f36034b = new e.a<Object>() { // from class: com.kwad.sdk.glide.load.a.f.1
        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public e<Object> a(@NonNull Object obj) {
            return new a(obj);
        }

        @Override // com.kwad.sdk.glide.load.a.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, e.a<?>> f36035a = new HashMap();

    /* loaded from: classes7.dex */
    public static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f36036a;

        public a(@NonNull Object obj) {
            this.f36036a = obj;
        }

        @Override // com.kwad.sdk.glide.load.a.e
        @NonNull
        public Object a() {
            return this.f36036a;
        }

        @Override // com.kwad.sdk.glide.load.a.e
        public void b() {
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        com.kwad.sdk.glide.g.j.a(t);
        aVar = this.f36035a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f36035a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f36034b;
        }
        return (e<T>) aVar.a(t);
    }

    public synchronized void a(@NonNull e.a<?> aVar) {
        this.f36035a.put(aVar.a(), aVar);
    }
}
