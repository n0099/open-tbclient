package d.a.j0.a1.d.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.r.q.a2;
import d.a.j0.q0.l;
import d.a.j0.x.e0.b;
import d.a.j0.x.m;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(a2 a2Var) {
        if (a2Var == null || a2Var.s1) {
            return false;
        }
        int i2 = a2Var.Z;
        return i2 == 0 || i2 == 11 || i2 == 40 || a2Var.y2();
    }

    public static void b(d.a.i0.r.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        if (aVar == null || aVar.m() == null || context == null) {
            return;
        }
        a2 m = aVar.m();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(m, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(m.c0()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
        createFromThreadCfg.setForumName(m.i0());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.l() != null) {
            createFromThreadCfg.addLocateParam(aVar.l());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(m)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(m);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(m.w1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        int i3 = 1;
        StatisticItem I = bVar.I("c13488", true);
        if (I != null) {
            if (bVar.m() != null) {
                a2 m = bVar.m();
                if (m.z1() == null || (m.z1().K() == null && m.z1().V() == null)) {
                    i3 = 0;
                }
                I.param("obj_name", i3);
                if (m.T() != null) {
                    I.param(TiebaStatic.Params.AB_TYPE, m.T().hadConcerned() ? 1 : 0);
                }
            }
            I.param("obj_type", i2);
            TiebaStatic.log(I);
        }
    }

    public static void d(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || bVar.m() == null || !d.a.j0.x.e0.l.d0(bVar.f62455e) || (I = bVar.I("c13494", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }

    public static void e(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || !d.a.j0.x.e0.l.d0(bVar.f62455e) || (I = bVar.I("c13495", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }

    public static void f(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || bVar.m() == null || (I = bVar.I("c13496", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }
}
