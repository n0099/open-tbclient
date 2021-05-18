package d.a.k0.j2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.c.e.p.k;
import d.a.j0.r.q.a2;
import d.a.k0.j2.h;
import d.a.k0.j2.o;
import d.a.k0.t1.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f56732c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f56733d;

    /* renamed from: e  reason: collision with root package name */
    public o f56734e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56736g;

    /* renamed from: a  reason: collision with root package name */
    public long f56730a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56731b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f56735f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f56737h = new j();

    public void a() {
        if (this.f56731b > 0) {
            this.f56730a += System.currentTimeMillis() - this.f56731b;
            this.f56731b = 0L;
        }
    }

    public void b() {
        if (this.f56731b > 0) {
            this.f56730a += System.currentTimeMillis() - this.f56731b;
            this.f56731b = 0L;
        }
        this.f56736g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f56737h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f56732c = j;
        this.f56737h.c();
    }

    public void e() {
        this.f56737h.e();
    }

    public void f() {
        if (this.f56731b != 0) {
            this.f56730a += System.currentTimeMillis() - this.f56731b;
        }
        this.f56731b = System.currentTimeMillis();
        this.f56736g = true;
        this.f56737h.b();
    }

    public void g() {
        if (this.f56731b > 0) {
            this.f56730a += System.currentTimeMillis() - this.f56731b;
            this.f56731b = 0L;
        }
        h();
        this.f56730a = 0L;
        this.f56731b = 0L;
        this.f56736g = false;
        this.f56737h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f56730a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f56730a);
            statisticItem.param("obj_type", this.f56735f);
            statisticItem.param("playduration", this.f56732c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f56734e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f56733d) != null) {
                if (a2Var.V() != null) {
                    if (this.f56733d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f56733d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f56733d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.F2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f56730a, this.f56735f, this.f56734e, "", this.f56732c);
        } else if (this.f56736g) {
            h.d(j, this.f56735f, this.f56734e, "", this.f56732c);
        }
    }

    public void i(String str) {
        this.f56735f = str;
    }

    public void j(a2 a2Var) {
        this.f56733d = a2Var;
    }

    public void k(o oVar) {
        this.f56734e = oVar;
    }
}
