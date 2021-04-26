package d.a.j0.j2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.j0.j2.h;
import d.a.j0.j2.o;
import d.a.j0.t1.j;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f56025c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f56026d;

    /* renamed from: e  reason: collision with root package name */
    public o f56027e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56029g;

    /* renamed from: a  reason: collision with root package name */
    public long f56023a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56024b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f56028f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f56030h = new j();

    public void a() {
        if (this.f56024b > 0) {
            this.f56023a += System.currentTimeMillis() - this.f56024b;
            this.f56024b = 0L;
        }
    }

    public void b() {
        if (this.f56024b > 0) {
            this.f56023a += System.currentTimeMillis() - this.f56024b;
            this.f56024b = 0L;
        }
        this.f56029g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f56030h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f56025c = j;
        this.f56030h.c();
    }

    public void e() {
        this.f56030h.e();
    }

    public void f() {
        if (this.f56024b != 0) {
            this.f56023a += System.currentTimeMillis() - this.f56024b;
        }
        this.f56024b = System.currentTimeMillis();
        this.f56029g = true;
        this.f56030h.b();
    }

    public void g() {
        if (this.f56024b > 0) {
            this.f56023a += System.currentTimeMillis() - this.f56024b;
            this.f56024b = 0L;
        }
        h();
        this.f56023a = 0L;
        this.f56024b = 0L;
        this.f56029g = false;
        this.f56030h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f56023a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f56023a);
            statisticItem.param("obj_type", this.f56028f);
            statisticItem.param("playduration", this.f56025c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f56027e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f56026d) != null) {
                if (a2Var.V() != null) {
                    if (this.f56026d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f56026d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f56026d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.D2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f56023a, this.f56028f, this.f56027e, "", this.f56025c);
        } else if (this.f56029g) {
            h.d(j, this.f56028f, this.f56027e, "", this.f56025c);
        }
    }

    public void i(String str) {
        this.f56028f = str;
    }

    public void j(a2 a2Var) {
        this.f56026d = a2Var;
    }

    public void k(o oVar) {
        this.f56027e = oVar;
    }
}
