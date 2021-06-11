package d.a.n0.b1.e.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.r.q.a2;
import d.a.n0.r0.l;
import d.a.n0.z.e0.b;
import d.a.n0.z.m;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(a2 a2Var) {
        if (a2Var == null || a2Var.u1) {
            return false;
        }
        int i2 = a2Var.Z;
        return i2 == 0 || i2 == 11 || i2 == 40 || a2Var.C2();
    }

    public static void b(d.a.m0.r.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        if (aVar == null || aVar.i() == null || context == null) {
            return;
        }
        a2 i3 = aVar.i();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(i3, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(i3.c0()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
        createFromThreadCfg.setForumName(i3.i0());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.g() != null) {
            createFromThreadCfg.addLocateParam(aVar.g());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(i3)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(i3);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        m.a(i3.z1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        int i3 = 1;
        StatisticItem I = bVar.I("c13488", true);
        if (I != null) {
            if (bVar.i() != null) {
                a2 i4 = bVar.i();
                if (i4.C1() == null || (i4.C1().K() == null && i4.C1().V() == null)) {
                    i3 = 0;
                }
                I.param("obj_name", i3);
                if (i4.T() != null) {
                    I.param(TiebaStatic.Params.AB_TYPE, i4.T().hadConcerned() ? 1 : 0);
                }
            }
            I.param("obj_type", i2);
            TiebaStatic.log(I);
        }
    }

    public static void d(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || bVar.i() == null || !d.a.n0.z.e0.l.d0(bVar.f67177e) || (I = bVar.I("c13494", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }

    public static void e(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || !d.a.n0.z.e0.l.d0(bVar.f67177e) || (I = bVar.I("c13495", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }

    public static void f(b bVar, int i2) {
        StatisticItem I;
        if (bVar == null || bVar.i() == null || (I = bVar.I("c13496", true)) == null) {
            return;
        }
        I.param("obj_type", i2);
        TiebaStatic.log(I);
    }
}
