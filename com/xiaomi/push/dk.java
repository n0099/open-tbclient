package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class dk extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f225a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f225a.f213a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f225a.f213a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo224c() {
        if (this.a != null) {
            this.a.mo224c();
        }
    }
}
