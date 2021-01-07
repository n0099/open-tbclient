package com.qq.e.comm.plugin.rewardvideo;

import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.w.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.c.a.c f12693a;

    public f(com.qq.e.comm.plugin.c.a.c cVar) {
        this.f12693a = cVar;
    }

    private void a(d dVar, String str, View view, int i, boolean z) {
        int integerForPlacement = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, dVar.B(), 0);
        int i2 = (!z || com.qq.e.comm.plugin.util.b.g(dVar.E())) ? 0 : 1;
        d.a a2 = com.qq.e.comm.plugin.w.i.a(dVar);
        d.e eVar = new d.e(dVar.D(), com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD, dVar.B());
        d.b a3 = new d.b(i2, d.c.InnerBrowser).a(az.b(com.qq.e.comm.plugin.util.b.e(a2.f12939a)) ? 5 : 1).a(str).b(integerForPlacement).c(5).a(true);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(view);
        a3.k = false;
        com.qq.e.comm.plugin.w.a.d.a(view, a2, eVar, a3);
    }

    private void b(d dVar, int i, View view, String str) {
        int integerForPlacement = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, dVar.B(), 0);
        d.a a2 = com.qq.e.comm.plugin.w.i.a(dVar);
        d.e eVar = new d.e(dVar.D(), com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD, dVar.B());
        d.b c = new d.b(com.qq.e.comm.plugin.util.d.a(dVar) ? 1 : 0, d.c.InnerBrowser).a(str).b(integerForPlacement).c(i);
        if (com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(i)) {
            com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(dVar, com.qq.e.comm.plugin.ad.a.a().b(view), i, str, eVar, c, dVar.y());
        } else {
            com.qq.e.comm.plugin.w.a.d.a(view, a2, eVar, c);
        }
    }

    void a(d dVar, int i, View view, String str) {
        if (com.qq.e.comm.plugin.c.e.a(dVar)) {
            com.qq.e.comm.plugin.c.e.a(new f.a(dVar, view).a(str).a(i).d(com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(i)).b(false).e(true).a(), this.f12693a);
        } else {
            b(dVar, i, view, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar, String str, View view) {
        boolean a2 = com.qq.e.comm.plugin.util.d.a(dVar);
        if (com.qq.e.comm.plugin.c.e.a(dVar)) {
            com.qq.e.comm.plugin.c.e.a(new f.a(dVar, view).a(str).a(5).b(false).e(true).a(), this.f12693a);
        } else {
            a(dVar, str, view, 5, a2);
        }
    }
}
