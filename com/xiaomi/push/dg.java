package com.xiaomi.push;

import com.xiaomi.push.am;
import com.xiaomi.push.de;
/* loaded from: classes10.dex */
public class dg extends am.b {
    public am.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ de f223a;

    public dg(de deVar) {
        this.f223a = deVar;
    }

    @Override // com.xiaomi.push.am.b
    public void b() {
        de.b bVar = (de.b) this.f223a.f211a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f223a.f211a.remove(bVar)) {
            this.a = bVar;
        }
        am.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo359c() {
        am.b bVar = this.a;
        if (bVar != null) {
            bVar.mo359c();
        }
    }
}
