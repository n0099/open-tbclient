package com.xiaomi.push;

import com.xiaomi.push.am;
import com.xiaomi.push.de;
/* loaded from: classes10.dex */
public class dg extends am.b {
    public am.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ de f222a;

    public dg(de deVar) {
        this.f222a = deVar;
    }

    @Override // com.xiaomi.push.am.b
    public void b() {
        de.b bVar = (de.b) this.f222a.f210a.peek();
        if (bVar == null || !bVar.a()) {
            return;
        }
        if (this.f222a.f210a.remove(bVar)) {
            this.a = bVar;
        }
        am.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo362c() {
        am.b bVar = this.a;
        if (bVar != null) {
            bVar.mo362c();
        }
    }
}
