package d.a.o0.k2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.c.e.p.k;
import d.a.n0.r.q.a2;
import d.a.o0.k2.h;
import d.a.o0.k2.o;
import d.a.o0.u1.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f60726c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f60727d;

    /* renamed from: e  reason: collision with root package name */
    public o f60728e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60730g;

    /* renamed from: a  reason: collision with root package name */
    public long f60724a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f60725b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f60729f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f60731h = new j();

    public void a() {
        if (this.f60725b > 0) {
            this.f60724a += System.currentTimeMillis() - this.f60725b;
            this.f60725b = 0L;
        }
    }

    public void b() {
        if (this.f60725b > 0) {
            this.f60724a += System.currentTimeMillis() - this.f60725b;
            this.f60725b = 0L;
        }
        this.f60730g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f60731h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f60726c = j;
        this.f60731h.c();
    }

    public void e() {
        this.f60731h.e();
    }

    public void f() {
        if (this.f60725b != 0) {
            this.f60724a += System.currentTimeMillis() - this.f60725b;
        }
        this.f60725b = System.currentTimeMillis();
        this.f60730g = true;
        this.f60731h.b();
    }

    public void g() {
        if (this.f60725b > 0) {
            this.f60724a += System.currentTimeMillis() - this.f60725b;
            this.f60725b = 0L;
        }
        h();
        this.f60724a = 0L;
        this.f60725b = 0L;
        this.f60730g = false;
        this.f60731h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f60724a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f60724a);
            statisticItem.param("obj_type", this.f60729f);
            statisticItem.param("playduration", this.f60726c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f60728e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f60727d) != null) {
                if (a2Var.V() != null) {
                    if (this.f60727d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f60727d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f60727d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.H2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f60724a, this.f60729f, this.f60728e, "", this.f60726c);
        } else if (this.f60730g) {
            h.d(j, this.f60729f, this.f60728e, "", this.f60726c);
        }
    }

    public void i(String str) {
        this.f60729f = str;
    }

    public void j(a2 a2Var) {
        this.f60727d = a2Var;
    }

    public void k(o oVar) {
        this.f60728e = oVar;
    }
}
