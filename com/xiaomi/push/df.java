package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class df extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f239a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f239a.f227a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f239a.f227a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo206c() {
        if (this.a != null) {
            this.a.mo206c();
        }
    }
}
