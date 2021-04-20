package d.b.i0.j2.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.c.e.p.k;
import d.b.h0.r.q.a2;
import d.b.i0.j2.h;
import d.b.i0.j2.o;
import d.b.i0.t1.j;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public long f57624c;

    /* renamed from: d  reason: collision with root package name */
    public a2 f57625d;

    /* renamed from: e  reason: collision with root package name */
    public o f57626e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57628g;

    /* renamed from: a  reason: collision with root package name */
    public long f57622a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f57623b = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f57627f = "1";

    /* renamed from: h  reason: collision with root package name */
    public j f57629h = new j();

    public void a() {
        if (this.f57623b > 0) {
            this.f57622a += System.currentTimeMillis() - this.f57623b;
            this.f57623b = 0L;
        }
    }

    public void b() {
        if (this.f57623b > 0) {
            this.f57622a += System.currentTimeMillis() - this.f57623b;
            this.f57623b = 0L;
        }
        this.f57628g = false;
    }

    public void c(TbCyberVideoView tbCyberVideoView) {
        this.f57629h.d(tbCyberVideoView);
    }

    public void d(long j) {
        this.f57624c = j;
        this.f57629h.c();
    }

    public void e() {
        this.f57629h.e();
    }

    public void f() {
        if (this.f57623b != 0) {
            this.f57622a += System.currentTimeMillis() - this.f57623b;
        }
        this.f57623b = System.currentTimeMillis();
        this.f57628g = true;
        this.f57629h.b();
    }

    public void g() {
        if (this.f57623b > 0) {
            this.f57622a += System.currentTimeMillis() - this.f57623b;
            this.f57623b = 0L;
        }
        h();
        this.f57622a = 0L;
        this.f57623b = 0L;
        this.f57628g = false;
        this.f57629h.a();
    }

    public final void h() {
        a2 a2Var;
        long j = this.f57622a;
        if (j < 0 || j >= 86400000) {
            return;
        }
        if (j > 0) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.f57622a);
            statisticItem.param("obj_type", this.f57627f);
            statisticItem.param("playduration", this.f57624c);
            statisticItem.param("player_type", 1);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
            }
            o oVar = this.f57626e;
            if (oVar != null) {
                oVar.a(statisticItem);
            }
            if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (a2Var = this.f57625d) != null) {
                if (a2Var.V() != null) {
                    if (this.f57625d.V().oriUgcType == 2) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    } else if (this.f57625d.V().oriUgcType == 4) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    }
                } else {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            }
            a2 a2Var2 = this.f57625d;
            if (a2Var2 != null) {
                statisticItem.param(TiebaStatic.Params.IS_ZP, a2Var2.D2() ? 1 : 0);
            }
            TiebaStatic.log(statisticItem);
            h.d(this.f57622a, this.f57627f, this.f57626e, "", this.f57624c);
        } else if (this.f57628g) {
            h.d(j, this.f57627f, this.f57626e, "", this.f57624c);
        }
    }

    public void i(String str) {
        this.f57627f = str;
    }

    public void j(a2 a2Var) {
        this.f57625d = a2Var;
    }

    public void k(o oVar) {
        this.f57626e = oVar;
    }
}
