package com.bytedance.sdk.openadsdk.preload.b;

import java.util.List;
/* loaded from: classes6.dex */
public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public e f30131a;

    /* renamed from: b  reason: collision with root package name */
    public int f30132b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f30133c;

    /* renamed from: d  reason: collision with root package name */
    public d f30134d;

    /* loaded from: classes6.dex */
    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public i(List<h> list, int i2, e eVar, d dVar) {
        this.f30133c = list;
        this.f30132b = i2;
        this.f30131a = eVar;
        this.f30134d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f30134d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f30112a;
        }
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        d dVar = this.f30134d;
        if (dVar != null) {
            dVar.f30114c = obj;
            dVar.f();
        }
        if (this.f30132b >= this.f30133c.size()) {
            return obj;
        }
        h hVar = this.f30133c.get(this.f30132b);
        Class<? extends d> a2 = hVar.a();
        d dVar2 = (d) this.f30131a.a(a2);
        if (dVar2 != null) {
            com.bytedance.sdk.openadsdk.preload.b.b.a b2 = hVar.b();
            i iVar = new i(this.f30133c, this.f30132b + 1, this.f30131a, dVar2);
            dVar2.a(iVar, this.f30134d, obj, b2, hVar.c());
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
            return c2.f30114c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        d c2 = c(cls);
        if (c2 != null) {
            return c2.f30113b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
    }
}
