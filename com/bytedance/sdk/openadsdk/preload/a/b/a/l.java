package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29952a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f29953b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f29954c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f29955d;

    /* renamed from: e  reason: collision with root package name */
    public final w f29956e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f29957f = new a();

    /* renamed from: g  reason: collision with root package name */
    public v<T> f29958g;

    /* loaded from: classes6.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public a() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f29960a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29961b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f29962c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f29963d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f29964e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f29963d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f29964e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f29963d == null && kVar == null) ? false : true);
            this.f29960a = aVar;
            this.f29961b = z;
            this.f29962c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f29960a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f29961b && this.f29960a.b() == aVar.a());
            } else {
                isAssignableFrom = this.f29962c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.f29963d, this.f29964e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.f29953b = sVar;
        this.f29954c = kVar;
        this.f29952a = fVar;
        this.f29955d = aVar;
        this.f29956e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        s<T> sVar = this.f29953b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f29955d.b(), this.f29957f), cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.f29954c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.f29954c.a(a2, this.f29955d.b(), this.f29957f);
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private v<T> b() {
        v<T> vVar = this.f29958g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f29952a.a(this.f29956e, this.f29955d);
        this.f29958g = a2;
        return a2;
    }
}
