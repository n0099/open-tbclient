package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dk extends al.b {
    al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f221a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f221a.f209a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f221a.f209a.remove(bVar)) {
            this.a = bVar;
        }
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo229c() {
        if (this.a != null) {
            this.a.mo229c();
        }
    }
}
