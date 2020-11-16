package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class dk extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f4860a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f223a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f223a.f211a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f223a.f211a.remove(bVar)) {
            this.f4860a = bVar;
        }
        if (this.f4860a != null) {
            this.f4860a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo232c() {
        if (this.f4860a != null) {
            this.f4860a.mo232c();
        }
    }
}
