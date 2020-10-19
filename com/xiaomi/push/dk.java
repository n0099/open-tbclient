package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class dk extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f4860a;

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
            this.f4860a = bVar;
        }
        if (this.f4860a != null) {
            this.f4860a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo230c() {
        if (this.f4860a != null) {
            this.f4860a.mo230c();
        }
    }
}
