package com.bytedance.sdk.openadsdk.preload.b;

import java.util.List;
/* loaded from: classes5.dex */
public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public e f30772a;

    /* renamed from: b  reason: collision with root package name */
    public int f30773b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f30774c;

    /* renamed from: d  reason: collision with root package name */
    public d f30775d;

    /* loaded from: classes5.dex */
    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public i(List<h> list, int i2, e eVar, d dVar) {
        this.f30774c = list;
        this.f30773b = i2;
        this.f30772a = eVar;
        this.f30775d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f30775d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f30753a;
        }
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        d dVar = this.f30775d;
        if (dVar != null) {
            dVar.f30755c = obj;
            dVar.f();
        }
        if (this.f30773b >= this.f30774c.size()) {
            return obj;
        }
        h hVar = this.f30774c.get(this.f30773b);
        Class<? extends d> a2 = hVar.a();
        d dVar2 = (d) this.f30772a.a(a2);
        if (dVar2 != null) {
            com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
            i iVar = new i(this.f30774c, this.f30773b + 1, this.f30772a, dVar2);
            dVar2.a(iVar, this.f30775d, obj, b2, hVar.c());
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
            return c2.f30755c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.f30754b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }
}
