package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class df extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f235a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f235a.f223a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f235a.f223a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo220c() {
        if (this.a != null) {
            this.a.mo220c();
        }
    }
}
