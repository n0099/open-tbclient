package d.a.n0.v.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends d.a.c.k.e.a<d.a.n0.v.h.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.n0.v.c n;
    public String o;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder Q(ViewGroup viewGroup) {
        AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.m);
        alaGameFrsGameLiveDoubleView.v(this.o);
        return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.v.h.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        alaGameFrsGameLiveDoubleViewHolder.f14018a.n(aVar);
        alaGameFrsGameLiveDoubleViewHolder.f14018a.w(this.n);
        d.a.n0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f65681e.s1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f65681e.s1().appId) ? aVar.f65681e.s1().appId : ""));
        a2 a2Var = aVar.f65682f;
        if (a2Var != null) {
            d.a.n0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f65682f.s1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.s1().appId) ? "" : aVar.f65682f.s1().appId));
        }
        return alaGameFrsGameLiveDoubleViewHolder.a();
    }

    public void h0(d.a.n0.v.c cVar) {
        this.n = cVar;
    }
}
