package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29646a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f29647b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f29648c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f29649d;

    /* renamed from: e  reason: collision with root package name */
    public final w f29650e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f29651f = new a();

    /* renamed from: g  reason: collision with root package name */
    public v<T> f29652g;

    /* loaded from: classes5.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public a() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f29654a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29655b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f29656c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f29657d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f29658e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f29657d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f29658e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f29657d == null && kVar == null) ? false : true);
            this.f29654a = aVar;
            this.f29655b = z;
            this.f29656c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f29654a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f29655b && this.f29654a.b() == aVar.a());
            } else {
                isAssignableFrom = this.f29656c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.f29657d, this.f29658e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.f29647b = sVar;
        this.f29648c = kVar;
        this.f29646a = fVar;
        this.f29649d = aVar;
        this.f29650e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        s<T> sVar = this.f29647b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f29649d.b(), this.f29651f), cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.f29648c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.f29648c.a(a2, this.f29649d.b(), this.f29651f);
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private v<T> b() {
        v<T> vVar = this.f29652g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f29646a.a(this.f29650e, this.f29649d);
        this.f29652g = a2;
        return a2;
    }
}
