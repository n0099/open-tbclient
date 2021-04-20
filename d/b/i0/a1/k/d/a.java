package d.b.i0.a1.k.d;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.r.q.a2;
import d.b.i0.q0.l;
import d.b.i0.x.e0.b;
import d.b.i0.x.m;
/* loaded from: classes4.dex */
public class a {
    public static void a(b bVar, StatisticItem statisticItem) {
        if (bVar == null || bVar.n() == null || statisticItem == null) {
            return;
        }
        if (bVar.n().V() != null) {
            BaijiahaoData V = bVar.n().V();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, V.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, V.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(a2 a2Var) {
        if (a2Var == null || a2Var.s1) {
            return false;
        }
        int i = a2Var.Z;
        return i == 0 || i == 11 || i == 40 || a2Var.y2();
    }

    public static void c(d.b.h0.r.q.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar == null || aVar.n() == null || context == null) {
            return;
        }
        a2 n = aVar.n();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(n, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(n.c0()));
        createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
        createFromThreadCfg.setForumName(n.i0());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (aVar.j() != null) {
            createFromThreadCfg.addLocateParam(aVar.j());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(n)) {
            createFromThreadCfg.setNeedPreLoad(true);
            l.c(n);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        m.a(n.w1());
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
