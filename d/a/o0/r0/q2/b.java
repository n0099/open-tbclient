package d.a.o0.r0.q2;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightCardView;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.a.c.e.p.k;
import d.a.n0.r.q.a2;
import d.a.o0.d3.c;
import d.a.o0.r0.i1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class b extends d.a.c.k.e.a<g, CardViewHolder<VideoMiddlePageLightCardView>> {
    public final List<VideoMiddlePageLightCardView> m;
    public final TbPageContext<?> n;
    public final VideoMiddlePageViewModel o;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
        this.o = videoMiddlePageViewModel;
        this.m = new ArrayList();
    }

    public final void e0(g gVar, int i2) {
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar != null ? gVar.f62506f : null);
        statisticItem.param("nid", gVar != null ? gVar.f62507g : null);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        if (gVar == null) {
            Intrinsics.throwNpe();
        }
        statisticItem.param("fid", gVar.f62505e);
        statisticItem.param("obj_param1", k.isEmpty(gVar.r) ? "0" : gVar.r);
        statisticItem.param("extra", k.isEmpty(gVar.s) ? "0" : gVar.s);
        statisticItem.param("obj_id", this.o.e());
        statisticItem.param("ab_tag", k.isEmpty(gVar.t) ? "0" : gVar.t);
        statisticItem.param("obj_type", this.o.d());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.k());
        statisticItem.param("obj_source", k.isEmpty(gVar.q) ? "0" : gVar.q);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, gVar.o() ? 1 : 0);
        BaijiahaoData baijiahaoData = gVar.A;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData != null ? baijiahaoData.oriUgcNid : null);
            BaijiahaoData baijiahaoData2 = gVar.A;
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void g0(g gVar, a2 a2Var, int i2) {
        if (gVar == null) {
            Intrinsics.throwNpe();
        }
        c.g().d(this.n.getUniqueId(), d.a.o0.d3.a.c(gVar.f62506f, "", "", gVar.A), d.a.o0.d3.a.f(a2Var, "a023", "common_exp", i2 + 1, false, null, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public CardViewHolder<VideoMiddlePageLightCardView> Q(ViewGroup viewGroup) {
        VideoMiddlePageLightCardView videoMiddlePageLightCardView = new VideoMiddlePageLightCardView(this.n, this.o);
        this.m.add(videoMiddlePageLightCardView);
        return new CardViewHolder<>(videoMiddlePageLightCardView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, g gVar, CardViewHolder<VideoMiddlePageLightCardView> cardViewHolder) {
        VideoMiddlePageLightCardView b2;
        AgreeData g2;
        a2 c2 = g.c(gVar);
        if (gVar != null && (g2 = gVar.g()) != null) {
            g2.keyFromHomePage = this.o.d();
        }
        if (cardViewHolder != null && (b2 = cardViewHolder.b()) != null) {
            b2.Y(gVar, i2);
        }
        g0(gVar, c2, i2);
        e0(gVar, i2);
        if (cardViewHolder != null) {
            return cardViewHolder.a();
        }
        return null;
    }

    public final void onDestroy() {
        for (VideoMiddlePageLightCardView videoMiddlePageLightCardView : this.m) {
            if (videoMiddlePageLightCardView != null) {
                videoMiddlePageLightCardView.onDestroy();
            }
        }
    }
}
