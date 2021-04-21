package com.bytedance.sdk.openadsdk.preload.b;

import java.util.List;
/* loaded from: classes5.dex */
public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public e f29859a;

    /* renamed from: b  reason: collision with root package name */
    public int f29860b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f29861c;

    /* renamed from: d  reason: collision with root package name */
    public d f29862d;

    /* loaded from: classes5.dex */
    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public i(List<h> list, int i, e eVar, d dVar) {
        this.f29861c = list;
        this.f29860b = i;
        this.f29859a = eVar;
        this.f29862d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f29862d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f29840a;
        }
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        d dVar = this.f29862d;
        if (dVar != null) {
            dVar.f29842c = obj;
            dVar.f();
        }
        if (this.f29860b >= this.f29861c.size()) {
            return obj;
        }
        h hVar = this.f29861c.get(this.f29860b);
        Class<? extends d> a2 = hVar.a();
        d dVar2 = (d) this.f29859a.a(a2);
        if (dVar2 != null) {
            com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
            i iVar = new i(this.f29861c, this.f29860b + 1, this.f29859a, dVar2);
            dVar2.a(iVar, this.f29862d, obj, b2, hVar.c());
            dVar2.d();
            try {
                Object a_ = dVar2.a_(iVar, obj);
                dVar2.e();
                return a_;
            } catch (a e2) {
                dVar2.c(e2.getCause());
                throw e2;
            } catch (Throwable th) {
                dVar2.b(th);
                throw new a(th);
            }
        }
        throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + a2);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object b(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.f29842c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.f29841b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }
}
