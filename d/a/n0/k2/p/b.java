package d.a.n0.k2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
import d.a.n0.k2.h;
import d.a.n0.k2.o;
import d.a.n0.u1.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f56912c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f56913d;

    /* renamed from: e  reason: collision with root package name */
    public o f56914e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56916g;

    /* renamed from: a  reason: collision with root package name */
    public long f56910a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56911b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f56915f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f56917h = new j();

    public void a() {
        if (this.f56911b > 0) {
            this.f56910a += System.currentTimeMillis() - this.f56911b;
            this.f56911b = 0L;
        }
    }

    public void b() {
        if (this.f56911b > 0) {
            this.f56910a += System.currentTimeMillis() - this.f56911b;
            this.f56911b = 0L;
        }
        this.f56916g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f56917h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f56912c = j;
        this.f56917h.c();
    }

    public void e() {
        this.f56917h.e();
    }

    public void f() {
        if (this.f56911b != 0) {
            this.f56910a += System.currentTimeMillis() - this.f56911b;
        }
        this.f56911b = System.currentTimeMillis();
        this.f56916g = true;
        this.f56917h.b();
    }

    public void g() {
        if (this.f56911b > 0) {
            this.f56910a += System.currentTimeMillis() - this.f56911b;
            this.f56911b = 0L;
        }
        h();
        this.f56910a = 0L;
        this.f56911b = 0L;
        this.f56916g = false;
        this.f56917h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f56910a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f56910a);
            statisticItem.param("obj_type", this.f56915f);
            statisticItem.param("playduration", this.f56912c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f56914e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f56913d) != null) {
                if (a2Var.V() != null) {
                    if (this.f56913d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f56913d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f56913d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.G2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f56910a, this.f56915f, this.f56914e, "", this.f56912c);
        } else if (this.f56916g) {
            h.d(j, this.f56915f, this.f56914e, "", this.f56912c);
        }
    }

    public void i(String str) {
        this.f56915f = str;
    }

    public void j(a2 a2Var) {
        this.f56913d = a2Var;
    }

    public void k(o oVar) {
        this.f56914e = oVar;
    }
}
