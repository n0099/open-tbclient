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
    public long f60601c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f60602d;

    /* renamed from: e  reason: collision with root package name */
    public o f60603e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60605g;

    /* renamed from: a  reason: collision with root package name */
    public long f60599a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f60600b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f60604f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f60606h = new j();

    public void a() {
        if (this.f60600b > 0) {
            this.f60599a += System.currentTimeMillis() - this.f60600b;
            this.f60600b = 0L;
        }
    }

    public void b() {
        if (this.f60600b > 0) {
            this.f60599a += System.currentTimeMillis() - this.f60600b;
            this.f60600b = 0L;
        }
        this.f60605g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f60606h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f60601c = j;
        this.f60606h.c();
    }

    public void e() {
        this.f60606h.e();
    }

    public void f() {
        if (this.f60600b != 0) {
            this.f60599a += System.currentTimeMillis() - this.f60600b;
        }
        this.f60600b = System.currentTimeMillis();
        this.f60605g = true;
        this.f60606h.b();
    }

    public void g() {
        if (this.f60600b > 0) {
            this.f60599a += System.currentTimeMillis() - this.f60600b;
            this.f60600b = 0L;
        }
        h();
        this.f60599a = 0L;
        this.f60600b = 0L;
        this.f60605g = false;
        this.f60606h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f60599a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f60599a);
            statisticItem.param("obj_type", this.f60604f);
            statisticItem.param("playduration", this.f60601c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f60603e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f60602d) != null) {
                if (a2Var.V() != null) {
                    if (this.f60602d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f60602d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f60602d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.H2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f60599a, this.f60604f, this.f60603e, "", this.f60601c);
        } else if (this.f60605g) {
            h.d(j, this.f60604f, this.f60603e, "", this.f60601c);
        }
    }

    public void i(String str) {
        this.f60604f = str;
    }

    public void j(a2 a2Var) {
        this.f60602d = a2Var;
    }

    public void k(o oVar) {
        this.f60603e = oVar;
    }
}
