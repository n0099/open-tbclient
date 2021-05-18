package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f29751a;

    /* loaded from: classes6.dex */
    public static final class a<E> extends v<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        public final v<E> f29752a;

        /* renamed from: b  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> f29753b;

        public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<E> vVar, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> iVar) {
            this.f29752a = new m(fVar, vVar, type);
            this.f29753b = iVar;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Collection) ((Collection) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Collection<E> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a2 = this.f29753b.a();
            aVar.a();
            while (aVar.e()) {
                a2.add(this.f29752a.b(aVar));
            }
            aVar.b();
            return a2;
        }

        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (E e2 : collection) {
                this.f29752a.a(cVar, e2);
            }
            cVar.c();
        }
    }

    public b(com.bytedance.sdk.openadsdk.preload.a.b.c cVar) {
        this.f29751a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b2 = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (Collection.class.isAssignableFrom(a2)) {
            Type a3 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(b2, (Class<?>) a2);
            return new a(fVar, a3, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a3)), this.f29751a.a(aVar));
        }
        return null;
    }
}
