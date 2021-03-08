package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class dk extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f8323a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f220a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f220a.f208a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f220a.f208a.remove(bVar)) {
            this.f8323a = bVar;
        }
        if (this.f8323a != null) {
            this.f8323a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo233c() {
        if (this.f8323a != null) {
            this.f8323a.mo233c();
        }
    }
}
