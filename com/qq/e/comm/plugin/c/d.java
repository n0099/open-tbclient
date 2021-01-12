package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes3.dex */
class d {

    /* loaded from: classes3.dex */
    private static class a extends com.qq.e.comm.plugin.c.a {
        private a() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(r.class);
            this.f11920a.add(n.class);
            this.f11920a.add(p.class);
            this.f11920a.add(i.class);
            this.f11920a.add(q.class);
            this.f11920a.add(com.qq.e.comm.plugin.c.b.class);
        }
    }

    /* loaded from: classes3.dex */
    private static class b extends com.qq.e.comm.plugin.c.a {
        private b() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(s.class);
            this.f11920a.add(h.class);
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends com.qq.e.comm.plugin.c.a {
        private c() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(m.class);
            this.f11920a.add(q.class);
            this.f11920a.add(com.qq.e.comm.plugin.c.b.class);
        }
    }

    /* renamed from: com.qq.e.comm.plugin.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C1190d extends com.qq.e.comm.plugin.c.a {
        private C1190d() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(r.class);
            this.f11920a.add(n.class);
            this.f11920a.add(j.class);
            this.f11920a.add(o.class);
            this.f11920a.add(i.class);
        }
    }

    /* loaded from: classes3.dex */
    private static class e extends com.qq.e.comm.plugin.c.a {
        private e() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(m.class);
            this.f11920a.add(n.class);
            this.f11920a.add(p.class);
        }
    }

    /* loaded from: classes3.dex */
    private static class f extends com.qq.e.comm.plugin.c.a {
        private f() {
        }

        @Override // com.qq.e.comm.plugin.c.l
        public void a() {
            this.f11920a.add(r.class);
            this.f11920a.add(j.class);
            this.f11920a.add(i.class);
        }
    }

    d() {
    }

    public static l a() {
        b bVar = new b();
        bVar.a();
        return bVar;
    }

    public static l a(com.qq.e.comm.plugin.c.f fVar) {
        l aVar = fVar.g ? new a() : (fVar.h == null || !fVar.h.booleanValue()) ? new C1190d() : new f();
        ai.a(d.class.getSimpleName(), "buildChain = " + aVar.getClass().getSimpleName());
        aVar.a();
        return aVar;
    }

    public static l b() {
        e eVar = new e();
        eVar.a();
        return eVar;
    }

    public static l c() {
        c cVar = new c();
        cVar.a();
        return cVar;
    }
}
