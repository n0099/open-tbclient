package d.b.i0.q0.c2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.b.h0.r.q.a2;
import d.b.i0.x.t;
import d.b.i0.x.z;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<a2>, z {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q0.j2.b f59079e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f59080f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f59081g;

    /* renamed from: h  reason: collision with root package name */
    public int f59082h;

    public b(d.b.i0.q0.j2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.f59079e = null;
        this.f59080f = null;
        this.f59079e = bVar;
        this.f59080f = tbPageTag;
        this.f59081g = bdUniqueId;
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
    }

    public final void b(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        long j = a2Var.q1().user_info != null ? a2Var.q1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", a2Var.T().getUserId());
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param("ab_tag", a2Var.T0);
        statisticItem.param("obj_type", a2Var.q1().isChushou ? 2 : 1);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2Var.q1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", a2Var.U0);
        statisticItem.param("source_from", a2Var.R0);
        int i = this.f59082h;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        long j = a2Var.q1().user_info != null ? a2Var.q1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", a2Var.T().getUserId());
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param("ab_tag", a2Var.T0);
        statisticItem.param("obj_type", a2Var.q1().isChushou ? 2 : 1);
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2Var.q1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", a2Var.U0);
        statisticItem.param("source_from", a2Var.R0);
        int i = this.f59082h;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        t.b().a(statisticItem);
    }

    public void d(int i) {
        this.f59082h = i;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<a2> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof a2)) {
            a2 data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                b(data);
                d.b.i0.q0.j2.c.j().g(this.f59079e, data, 1);
                d.b.i0.q0.j2.a.b(data, 1, this.f59081g, this.f59079e, this.f59080f);
            } else if (customMessage.getCmd() == 2921016) {
                b(data);
                d.b.i0.q0.j2.c.j().g(this.f59079e, data, 2);
                d.b.i0.q0.j2.a.b(data, 2, this.f59081g, this.f59079e, this.f59080f);
            } else if (customMessage.getCmd() == 2921019) {
                b(data);
                d.b.i0.q0.j2.c.j().g(this.f59079e, data, 4);
                d.b.i0.q0.j2.a.b(data, 1, this.f59081g, this.f59079e, this.f59080f);
            } else if (customMessage.getCmd() == 2921017) {
                c(data);
                d.b.i0.q0.j2.c.j().c(this.f59079e, data);
                d.b.i0.q0.j2.a.i(data, this.f59081g, this.f59079e, this.f59080f);
            }
        }
        return null;
    }
}
