package d.b.i0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends d.b.b.j.e.a<d.b.i0.t.h.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.b.i0.t.c n;
    public String o;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder R(ViewGroup viewGroup) {
        AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.m);
        alaGameFrsLiveDoubleView.w(this.o);
        return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.h.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        alaGameFrsLiveDoubleViewHolder.f14994a.n(aVar);
        alaGameFrsLiveDoubleViewHolder.f14994a.x(this.n);
        d.b.i0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f60772e.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f60772e.q1().appId) ? aVar.f60772e.q1().appId : ""));
        a2 a2Var = aVar.f60773f;
        if (a2Var != null) {
            d.b.i0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f60773f.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.q1().appId) ? "" : aVar.f60773f.q1().appId));
        }
        return alaGameFrsLiveDoubleViewHolder.a();
    }

    public void j0(d.b.i0.t.c cVar) {
        this.n = cVar;
    }
}
