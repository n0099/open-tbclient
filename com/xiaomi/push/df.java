package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.dd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class df extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f234a = ddVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        dd.b bVar = (dd.b) this.f234a.f222a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f234a.f222a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo218c() {
        if (this.a != null) {
            this.a.mo218c();
        }
    }
}
