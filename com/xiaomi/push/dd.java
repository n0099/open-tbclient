package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.db;
/* loaded from: classes7.dex */
public class dd extends al.b {

    /* renamed from: a  reason: collision with root package name */
    public al.b f40355a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ db f227a;

    public dd(db dbVar) {
        this.f227a = dbVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        db.b bVar = (db.b) this.f227a.f215a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f227a.f215a.remove(bVar)) {
            this.f40355a = bVar;
        }
        al.b bVar2 = this.f40355a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo223c() {
        al.b bVar = this.f40355a;
        if (bVar != null) {
            bVar.mo223c();
        }
    }
}
