package com.vivo.push.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        boolean b;
        com.vivo.push.model.b a = com.vivo.push.util.p.a(this.a);
        try {
            if (((com.vivo.push.b.d) vVar).d()) {
                b = f.a(this.a);
            } else {
                b = f.b(this.a);
            }
            if (b) {
                com.vivo.push.model.b a2 = com.vivo.push.util.p.a(this.a);
                if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                    if (a != null && a.a() != null) {
                        com.vivo.push.a.a.a(this.a, a.a(), new com.vivo.push.b.z(a.a()));
                    }
                    if (a2 != null && a2.a() != null) {
                        com.vivo.push.a.a.a(this.a, a2.a(), new com.vivo.push.b.f());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
