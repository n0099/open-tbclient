package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dk extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f14245a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f300a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f300a.f288a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f300a.f288a.remove(bVar)) {
            this.f14245a = bVar;
        }
        if (this.f14245a != null) {
            this.f14245a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo259c() {
        if (this.f14245a != null) {
            this.f14245a.mo259c();
        }
    }
}
