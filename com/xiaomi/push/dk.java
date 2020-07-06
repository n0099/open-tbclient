package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class dk extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f226a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f226a.f214a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f226a.f214a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo223c() {
        if (this.a != null) {
            this.a.mo223c();
        }
    }
}
