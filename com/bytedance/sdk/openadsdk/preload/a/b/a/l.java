package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29829a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f29830b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f29831c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f29832d;

    /* renamed from: e  reason: collision with root package name */
    public final w f29833e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f29834f = new a();

    /* renamed from: g  reason: collision with root package name */
    public v<T> f29835g;

    /* loaded from: classes6.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public a() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f29837a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29838b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f29839c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f29840d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f29841e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f29840d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f29841e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f29840d == null && kVar == null) ? false : true);
            this.f29837a = aVar;
            this.f29838b = z;
            this.f29839c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f29837a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f29838b && this.f29837a.b() == aVar.a());
            } else {
                isAssignableFrom = this.f29839c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.f29840d, this.f29841e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.f29830b = sVar;
        this.f29831c = kVar;
        this.f29829a = fVar;
        this.f29832d = aVar;
        this.f29833e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        s<T> sVar = this.f29830b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f29832d.b(), this.f29834f), cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.f29831c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.f29831c.a(a2, this.f29832d.b(), this.f29834f);
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private v<T> b() {
        v<T> vVar = this.f29835g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f29829a.a(this.f29833e, this.f29832d);
        this.f29835g = a2;
        return a2;
    }
}
