package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    final com.bytedance.sdk.openadsdk.preload.a.f f4970a;
    private final s<T> b;
    private final com.bytedance.sdk.openadsdk.preload.a.k<T> c;
    private final com.bytedance.sdk.openadsdk.preload.a.c.a<T> d;
    private final w e;
    private final l<T>.a f = new a();
    private v<T> g;

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.b = sVar;
        this.c = kVar;
        this.f4970a = fVar;
        this.d = aVar;
        this.e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.c.a(a2, this.d.b(), this.f);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        if (this.b == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(this.b.a(t, this.d.b(), this.f), cVar);
        }
    }

    private v<T> b() {
        v<T> vVar = this.g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f4970a.a(this.e, this.d);
        this.g = a2;
        return a2;
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f4972a;
        private final boolean b;
        private final Class<?> c;
        private final s<?> d;
        private final com.bytedance.sdk.openadsdk.preload.a.k<?> e;

        b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.d = obj instanceof s ? (s) obj : null;
            this.e = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.d == null && this.e == null) ? false : true);
            this.f4972a = aVar;
            this.b = z;
            this.c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.f4972a != null) {
                isAssignableFrom = this.f4972a.equals(aVar) || (this.b && this.f4972a.b() == aVar.a());
            } else {
                isAssignableFrom = this.c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.d, this.e, fVar, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    private final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        private a() {
        }
    }
}
