package d.a.n0.b1.l.d;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.r.q.a2;
import d.a.n0.r0.l;
import d.a.n0.z.e0.b;
import d.a.n0.z.m;
/* loaded from: classes4.dex */
public class a {
    public static void a(b bVar, StatisticItem statisticItem) {
        if (bVar == null || bVar.i() == null || statisticItem == null) {
            return;
        }
        if (bVar.i().V() != null) {
            BaijiahaoData V = bVar.i().V();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, V.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, V.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(a2 a2Var) {
        if (a2Var == null || a2Var.u1) {
            return false;
        }
        int i2 = a2Var.Z;
        return i2 == 0 || i2 == 11 || i2 == 40 || a2Var.C2();
    }

    public static void c(d.a.m0.r.q.a aVar, Context context, int i2, boolean z, Rect rect) {
        if (aVar == null || aVar.i() == null || context == null) {
            return;
        }
        a2 i3 = aVar.i();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(i3, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(i3.c0()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
        createFromThreadCfg.setForumName(i3.i0());
        createFromThreadCfg.setStartFrom(i2);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.g() != null) {
            createFromThreadCfg.addLocateParam(aVar.g());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(i3)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(i3);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        m.a(i3.z1());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(b bVar) {
        StatisticItem I;
        if (bVar == null || (I = bVar.I("c13583", true)) == null) {
            return;
        }
        a(bVar, I);
        TiebaStatic.log(I);
    }

    public static void e(b bVar) {
        StatisticItem I;
        if (bVar == null || (I = bVar.I("c13584", true)) == null) {
            return;
        }
        a(bVar, I);
        I.param(TiebaStatic.Params.OBJ_FLOOR, bVar.position + 1);
        TiebaStatic.log(I);
    }

    public static void f(b bVar) {
        StatisticItem I;
        if (bVar == null || (I = bVar.I("c13585", true)) == null) {
            return;
        }
        a(bVar, I);
        TiebaStatic.log(I);
    }

    public static void g(b bVar) {
        StatisticItem I;
        if (bVar == null || (I = bVar.I("c13586", true)) == null) {
            return;
        }
        a(bVar, I);
        TiebaStatic.log(I);
    }

    public static void h(b bVar) {
        StatisticItem I;
        if (bVar == null || (I = bVar.I("c13587", true)) == null) {
            return;
        }
        a(bVar, I);
        TiebaStatic.log(I);
    }
}
