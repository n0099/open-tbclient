package com.bytedance.sdk.openadsdk.preload.b;

import java.util.List;
/* loaded from: classes6.dex */
final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    protected e f5045a;
    private int b;
    private List<h> c;
    private d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(List<h> list, int i, e eVar, d dVar) {
        this.c = list;
        this.b = i;
        this.f5045a = eVar;
        this.d = dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Object obj) throws Exception {
        if (this.d != null) {
            this.d.c = obj;
            this.d.f();
        }
        Object obj2 = obj;
        if (this.b < this.c.size()) {
            h hVar = this.c.get(this.b);
            Class<? extends d> a2 = hVar.a();
            d dVar = (d) this.f5045a.a(a2);
            if (dVar == null) {
                throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + a2);
            }
            com.bytedance.sdk.openadsdk.preload.b.b.a b = hVar.b();
            i iVar = new i(this.c, this.b + 1, this.f5045a, dVar);
            dVar.a(iVar, this.d, obj, b, hVar.c());
            dVar.d();
            try {
                Object a_ = dVar.a_(iVar, obj);
                dVar.e();
                obj2 = a_;
            } catch (a e) {
                dVar.c(e.getCause());
                throw e;
            } catch (Throwable th) {
                dVar.b(th);
                throw new a(th);
            }
        }
        return obj2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(Class cls) {
        d c = c(cls);
        if (c == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
        }
        return c.b;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object b(Class cls) {
        d c = c(cls);
        if (c == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:" + cls);
        }
        return c.c;
    }

    private d c(Class cls) {
        d dVar = this.d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f5041a;
        }
        return dVar;
    }

    /* loaded from: classes6.dex */
    static final class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
