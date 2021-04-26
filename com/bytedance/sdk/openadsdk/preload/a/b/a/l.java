package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f30552a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f30553b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f30554c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f30555d;

    /* renamed from: e  reason: collision with root package name */
    public final w f30556e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f30557f = new a();

    /* renamed from: g  reason: collision with root package name */
    public v<T> f30558g;

    /* loaded from: classes5.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public a() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f30560a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f30561b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f30562c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f30563d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f30564e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f30563d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f30564e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f30563d == null && kVar == null) ? false : true);
            this.f30560a = aVar;
            this.f30561b = z;
            this.f30562c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            boolean isAssignableFrom;
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f30560a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f30561b && this.f30560a.b() == aVar.a());
            } else {
                isAssignableFrom = this.f30562c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.f30563d, this.f30564e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        this.f30553b = sVar;
        this.f30554c = kVar;
        this.f30552a = fVar;
        this.f30555d = aVar;
        this.f30556e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        s<T> sVar = this.f30553b;
        if (sVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f30555d.b(), this.f30557f), cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (this.f30554c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.f30554c.a(a2, this.f30555d.b(), this.f30557f);
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private v<T> b() {
        v<T> vVar = this.f30558g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f30552a.a(this.f30556e, this.f30555d);
        this.f30558g = a2;
        return a2;
    }
}
