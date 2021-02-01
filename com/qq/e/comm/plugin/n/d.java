package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes15.dex */
public class d {
    public static h a(Context context, com.qq.e.comm.plugin.s.a aVar, com.qq.e.comm.plugin.ad.g gVar, String str, int i, com.qq.e.comm.plugin.y.c cVar) {
        if (!(aVar instanceof i)) {
            ai.a("EndCardFactory", "create EndCardView");
            return new f(context, str, i, aVar.Z(), cVar);
        }
        i iVar = (i) aVar;
        if (!a(iVar)) {
            ai.a("EndCardFactory", "create EndCardView");
            return new f(context, str, i, aVar.Z(), cVar);
        }
        ai.a("EndCardFactory", "create LandingPageView");
        j jVar = new j(context, gVar, cVar);
        b(iVar);
        return jVar;
    }

    private static boolean a(i iVar) {
        if (GDTADManager.getInstance().getSM().getInteger("rewardEndCardLandingPage", 1) == 0) {
            ai.a("EndCardFactory", "rewardEndCardLandingPage feature, switch off.");
            return false;
        }
        String a2 = iVar.a();
        int a_ = iVar.a_();
        String e = iVar.e();
        boolean z = !iVar.k_();
        boolean g = com.qq.e.comm.plugin.util.b.g(iVar.l_());
        ai.a("EndCardFactory", "showLandingPage ? landingPage : " + a2 + " ,productType : " + a_ + " ,dlUrl : " + e + " ,demoGame : " + z + " ,WXMiniProgram : " + g);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return (a_ == 12 || a_ == 1000 || a_ == 38) && TextUtils.isEmpty(e) && !z && !g;
    }

    private static void b(i iVar) {
        if (TextUtils.isEmpty(iVar.a())) {
            return;
        }
        ai.a("EndCardFactory", "show landing page, replace endCard url to landingPage url.");
        iVar.a(iVar.a());
    }
}
