package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29797a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f29798b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f29799c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f29800d;

    /* renamed from: e  reason: collision with root package name */
    public final w f29801e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f29802f = new a();

    /* renamed from: g  reason: collision with root package name */
    public v<T> f29803g;

    /* loaded from: classes6.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public a() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f29805a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29806b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f29807c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f29808d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f29809e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f29808d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f29809e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f29808d == null && kVar == null) ? false : true);
            this.f29805a = aVar;
            this.f29806b = z;
            this.f29807c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f29805a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f29806b && this.f29805a.b() == aVar.a());
            } else {
                isAssignableFrom = this.f29807c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.f29808d, this.f29809e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.f29798b = sVar;
        this.f29799c = kVar;
        this.f29797a = fVar;
        this.f29800d = aVar;
        this.f29801e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        s<T> sVar = this.f29798b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f29800d.b(), this.f29802f), cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.f29799c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.f29799c.a(a2, this.f29800d.b(), this.f29802f);
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private v<T> b() {
        v<T> vVar = this.f29803g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f29797a.a(this.f29801e, this.f29800d);
        this.f29803g = a2;
        return a2;
    }
}
