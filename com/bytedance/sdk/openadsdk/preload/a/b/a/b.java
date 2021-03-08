package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.preload.a.b.c f4956a;

    public b(com.bytedance.sdk.openadsdk.preload.a.b.c cVar) {
        this.f4956a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(b, (Class<?>) a2);
        return new a(fVar, a3, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a3)), this.f4956a.a(aVar));
    }

    /* loaded from: classes6.dex */
    private static final class a<E> extends v<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final v<E> f4957a;
        private final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> b;

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Collection) ((Collection) obj));
        }

        public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<E> vVar, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Collection<E>> iVar) {
            this.f4957a = new m(fVar, vVar, type);
            this.b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Collection<E> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a2 = this.b.a();
            aVar.a();
            while (aVar.e()) {
                a2.add(this.f4957a.b(aVar));
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
            for (E e : collection) {
                this.f4957a.a(cVar, e);
            }
            cVar.c();
        }
    }
}
