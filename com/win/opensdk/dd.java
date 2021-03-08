package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class dd implements bh {

    /* renamed from: a  reason: collision with root package name */
    public long f8151a = 0;
    public final /* synthetic */ dq qlI;

    public dd(dq dqVar) {
        this.qlI = dqVar;
    }

    @Override // com.win.opensdk.bh
    public void a(int i, String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f8151a;
        bx iT = ca.iT(this.qlI.f8157a);
        cd cdVar = new cd(null);
        cdVar.f8141a = this.qlI.b;
        iT.a(cdVar, currentTimeMillis, i, 0).a();
        this.qlI.j.removeMessages(100101);
        this.qlI.d = false;
        this.qlI.a(this.qlI.Si(i));
    }

    @Override // com.win.opensdk.bh
    public void a() {
        this.f8151a = System.currentTimeMillis();
        dq dqVar = this.qlI;
        dqVar.j.sendEmptyMessageDelayed(100101, dqVar.f * 1000);
    }

    @Override // com.win.opensdk.bh
    public void a(Object obj) {
        n nVar = (n) obj;
        this.qlI.j.removeMessages(100101);
        this.qlI.d = false;
        int size = nVar.f8169a.size();
        long currentTimeMillis = System.currentTimeMillis() - this.f8151a;
        Info info = size > 0 ? (Info) nVar.f8169a.get(0) : null;
        bx iT = ca.iT(this.qlI.f8157a);
        cd cdVar = new cd(info);
        cdVar.f8141a = this.qlI.b;
        iT.a(cdVar, currentTimeMillis, 200, size).a();
        this.qlI.a(nVar);
        cx cxVar = this.qlI.qlR;
        if (cxVar != null && !cxVar.c()) {
            dq dqVar = this.qlI;
            if (!dqVar.h) {
                Info eJj = dqVar.qlR.eJj();
                if (eJj != null) {
                    this.qlI.d(eJj);
                    return;
                }
            } else {
                return;
            }
        }
        this.qlI.a(PBError.NO_FILL);
    }
}
