package d.b.i0.a1.d.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import d.b.i0.q0.l;
import d.b.i0.x.e0.b;
import d.b.i0.x.m;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(a2 a2Var) {
        if (a2Var == null || a2Var.s1) {
            return false;
        }
        int i = a2Var.Z;
        return i == 0 || i == 11 || i == 40 || a2Var.y2();
    }

    public static void b(d.b.h0.r.q.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar == null || aVar.n() == null || context == null) {
            return;
        }
        a2 n = aVar.n();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(n, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(n.c0()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
        createFromThreadCfg.setForumName(n.i0());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.j() != null) {
            createFromThreadCfg.addLocateParam(aVar.j());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(n)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(n);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(n.w1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i) {
        if (bVar == null) {
            return;
        }
        int i2 = 1;
        StatisticItem I = bVar.I("c13488", true);
        if (I != null) {
            if (bVar.n() != null) {
                a2 n = bVar.n();
                if (n.z1() == null || (n.z1().K() == null && n.z1().V() == null)) {
                    i2 = 0;
                }
                I.param("obj_name", i2);
                if (n.T() != null) {
                    I.param(TiebaStatic.Params.AB_TYPE, n.T().hadConcerned() ? 1 : 0);
                }
            }
            I.param("obj_type", i);
            TiebaStatic.log(I);
        }
    }

    public static void d(b bVar, int i) {
        StatisticItem I;
        if (bVar == null || bVar.n() == null || !d.b.i0.x.e0.l.d0(bVar.f63772e) || (I = bVar.I("c13494", true)) == null) {
            return;
        }
        I.param("obj_type", i);
        TiebaStatic.log(I);
    }

    public static void e(b bVar, int i) {
        StatisticItem I;
        if (bVar == null || !d.b.i0.x.e0.l.d0(bVar.f63772e) || (I = bVar.I("c13495", true)) == null) {
            return;
        }
        I.param("obj_type", i);
        TiebaStatic.log(I);
    }

    public static void f(b bVar, int i) {
        StatisticItem I;
        if (bVar == null || bVar.n() == null || (I = bVar.I("c13496", true)) == null) {
            return;
        }
        I.param("obj_type", i);
        TiebaStatic.log(I);
    }
}
