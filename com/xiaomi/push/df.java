package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class df extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f238a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f238a.f226a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f238a.f226a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo215c() {
        if (this.a != null) {
            this.a.mo215c();
        }
    }
}
