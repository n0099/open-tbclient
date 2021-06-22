package d.a.o0.r0.c2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import d.a.n0.r.q.a2;
import d.a.o0.z.t;
import d.a.o0.z.z;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<a2>, z {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r0.j2.b f62242e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f62243f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f62244g;

    /* renamed from: h  reason: collision with root package name */
    public int f62245h;

    public b(d.a.o0.r0.j2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.f62242e = null;
        this.f62243f = null;
        this.f62242e = bVar;
        this.f62243f = tbPageTag;
        this.f62244g = bdUniqueId;
    }

    @Override // d.a.o0.z.z
    public void a(String str) {
    }

    public final void b(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        long j = a2Var.s1().user_info != null ? a2Var.s1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", a2Var.T().getUserId());
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param("ab_tag", a2Var.V0);
        statisticItem.param("obj_type", a2Var.s1().isChushou ? 2 : 1);
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2Var.s1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", a2Var.W0);
        statisticItem.param("source_from", a2Var.T0);
        int i2 = this.f62245h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        long j = a2Var.s1().user_info != null ? a2Var.s1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", a2Var.T().getUserId());
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param("ab_tag", a2Var.V0);
        statisticItem.param("obj_type", a2Var.s1().isChushou ? 2 : 1);
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, a2Var.s1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", a2Var.W0);
        statisticItem.param("source_from", a2Var.T0);
        int i2 = this.f62245h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        t.b().a(statisticItem);
    }

    public void d(int i2) {
        this.f62245h = i2;
    }

    @Override // d.a.o0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<a2> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof a2)) {
            a2 data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                b(data);
                d.a.o0.r0.j2.c.j().g(this.f62242e, data, 1);
                d.a.o0.r0.j2.a.c(data, 1, this.f62244g, this.f62242e, this.f62243f);
            } else if (customMessage.getCmd() == 2921016) {
                b(data);
                d.a.o0.r0.j2.c.j().g(this.f62242e, data, 2);
                d.a.o0.r0.j2.a.c(data, 2, this.f62244g, this.f62242e, this.f62243f);
            } else if (customMessage.getCmd() == 2921019) {
                b(data);
                d.a.o0.r0.j2.c.j().g(this.f62242e, data, 4);
                d.a.o0.r0.j2.a.c(data, 1, this.f62244g, this.f62242e, this.f62243f);
            } else if (customMessage.getCmd() == 2921017) {
                c(data);
                d.a.o0.r0.j2.c.j().c(this.f62242e, data);
                d.a.o0.r0.j2.a.j(data, this.f62244g, this.f62242e, this.f62243f);
            }
        }
        return null;
    }
}
