package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.di;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dk extends al.b {

    /* renamed from: a  reason: collision with root package name */
    al.b f13947a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f299a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(di diVar) {
        this.f299a = diVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        di.b bVar = (di.b) this.f299a.f287a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f299a.f287a.remove(bVar)) {
            this.f13947a = bVar;
        }
        if (this.f13947a != null) {
            this.f13947a.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo254c() {
        if (this.f13947a != null) {
            this.f13947a.mo254c();
        }
    }
}
