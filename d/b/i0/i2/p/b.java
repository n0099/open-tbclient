package d.b.i0.i2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import d.b.i0.i2.h;
import d.b.i0.i2.o;
import d.b.i0.s1.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f56176c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f56177d;

    /* renamed from: e  reason: collision with root package name */
    public o f56178e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56180g;

    /* renamed from: a  reason: collision with root package name */
    public long f56174a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56175b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f56179f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f56181h = new j();

    public void a() {
        if (this.f56175b > 0) {
            this.f56174a += System.currentTimeMillis() - this.f56175b;
            this.f56175b = 0L;
        }
    }

    public void b() {
        if (this.f56175b > 0) {
            this.f56174a += System.currentTimeMillis() - this.f56175b;
            this.f56175b = 0L;
        }
        this.f56180g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f56181h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f56176c = j;
        this.f56181h.c();
    }

    public void e() {
        this.f56181h.e();
    }

    public void f() {
        if (this.f56175b != 0) {
            this.f56174a += System.currentTimeMillis() - this.f56175b;
        }
        this.f56175b = System.currentTimeMillis();
        this.f56180g = true;
        this.f56181h.b();
    }

    public void g() {
        if (this.f56175b > 0) {
            this.f56174a += System.currentTimeMillis() - this.f56175b;
            this.f56175b = 0L;
        }
        h();
        this.f56174a = 0L;
        this.f56175b = 0L;
        this.f56180g = false;
        this.f56181h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f56174a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f56174a);
            statisticItem.param("obj_type", this.f56179f);
            statisticItem.param("playduration", this.f56176c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f56178e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f56177d) != null) {
                if (a2Var.V() != null) {
                    if (this.f56177d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f56177d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f56177d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.C2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f56174a, this.f56179f, this.f56178e, "", this.f56176c);
        } else if (this.f56180g) {
            h.d(j, this.f56179f, this.f56178e, "", this.f56176c);
        }
    }

    public void i(String str) {
        this.f56179f = str;
    }

    public void j(a2 a2Var) {
        this.f56177d = a2Var;
    }

    public void k(o oVar) {
        this.f56178e = oVar;
    }
}
