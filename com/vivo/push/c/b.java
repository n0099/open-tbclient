package com.vivo.push.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b extends com.vivo.push.v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        boolean b;
        com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.f4712a);
        try {
            if (((com.vivo.push.b.d) yVar).d()) {
                b = f.a(this.f4712a);
            } else {
                b = f.b(this.f4712a);
            }
            if (b) {
                com.vivo.push.model.b a3 = com.vivo.push.util.s.a(this.f4712a);
                if (a2 == null || a3 == null || a3.a() == null || !a3.a().equals(a2.a())) {
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.f4712a, a2.a(), new com.vivo.push.b.ac(a2.a()));
                    }
                    if (a3 != null && a3.a() != null) {
                        com.vivo.push.a.a.a(this.f4712a, a3.a(), new com.vivo.push.b.f());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
