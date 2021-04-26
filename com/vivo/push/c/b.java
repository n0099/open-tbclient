package com.vivo.push.c;
/* loaded from: classes6.dex */
public final class b extends com.vivo.push.v {
    public b(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        boolean b2;
        com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.f37578a);
        try {
            if (((com.vivo.push.b.d) yVar).d()) {
                b2 = f.a(this.f37578a);
            } else {
                b2 = f.b(this.f37578a);
            }
            if (b2) {
                com.vivo.push.model.b a3 = com.vivo.push.util.s.a(this.f37578a);
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.f37578a, a2.a(), new com.vivo.push.b.ac(a2.a()));
                    }
                    if (a3 == null || a3.a() == null) {
                        return;
                    }
                    com.vivo.push.a.a.a(this.f37578a, a3.a(), new com.vivo.push.b.f());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
