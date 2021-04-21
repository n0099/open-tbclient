package d.b.j0.j2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.c.e.p.k;
import d.b.i0.r.q.a2;
import d.b.j0.j2.h;
import d.b.j0.j2.o;
import d.b.j0.t1.j;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f58045c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f58046d;

    /* renamed from: e  reason: collision with root package name */
    public o f58047e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58049g;

    /* renamed from: a  reason: collision with root package name */
    public long f58043a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f58044b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f58048f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f58050h = new j();

    public void a() {
        if (this.f58044b > 0) {
            this.f58043a += System.currentTimeMillis() - this.f58044b;
            this.f58044b = 0L;
        }
    }

    public void b() {
        if (this.f58044b > 0) {
            this.f58043a += System.currentTimeMillis() - this.f58044b;
            this.f58044b = 0L;
        }
        this.f58049g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f58050h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f58045c = j;
        this.f58050h.c();
    }

    public void e() {
        this.f58050h.e();
    }

    public void f() {
        if (this.f58044b != 0) {
            this.f58043a += System.currentTimeMillis() - this.f58044b;
        }
        this.f58044b = System.currentTimeMillis();
        this.f58049g = true;
        this.f58050h.b();
    }

    public void g() {
        if (this.f58044b > 0) {
            this.f58043a += System.currentTimeMillis() - this.f58044b;
            this.f58044b = 0L;
        }
        h();
        this.f58043a = 0L;
        this.f58044b = 0L;
        this.f58049g = false;
        this.f58050h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f58043a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f58043a);
            statisticItem.param("obj_type", this.f58048f);
            statisticItem.param("playduration", this.f58045c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f58047e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f58046d) != null) {
                if (a2Var.V() != null) {
                    if (this.f58046d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f58046d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f58046d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.D2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f58043a, this.f58048f, this.f58047e, "", this.f58045c);
        } else if (this.f58049g) {
            h.d(j, this.f58048f, this.f58047e, "", this.f58045c);
        }
    }

    public void i(String str) {
        this.f58048f = str;
    }

    public void j(a2 a2Var) {
        this.f58046d = a2Var;
    }

    public void k(o oVar) {
        this.f58047e = oVar;
    }
}
