package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final e.a<?> f35637b = new e.a<Object>() { // from class: com.kwad.sdk.glide.load.a.f.1
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
    public final Map<Class<?>, e.a<?>> f35638a = new HashMap();

    /* loaded from: classes6.dex */
    public static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f35639a;

        public a(@NonNull Object obj) {
            this.f35639a = obj;
        }

        @Override // com.kwad.sdk.glide.load.a.e
        @NonNull
        public Object a() {
            return this.f35639a;
        }

        @Override // com.kwad.sdk.glide.load.a.e
        public void b() {
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        com.kwad.sdk.glide.g.j.a(t);
        aVar = this.f35638a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f35638a.values().iterator();
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
            aVar = f35637b;
        }
        return (e<T>) aVar.a(t);
    }

    public synchronized void a(@NonNull e.a<?> aVar) {
        this.f35638a.put(aVar.a(), aVar);
    }
}
