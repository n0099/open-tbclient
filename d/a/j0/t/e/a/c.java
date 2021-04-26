package d.a.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.j0.t.h.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.j0.t.c n;
    public String o;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder P(ViewGroup viewGroup) {
        AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.m);
        alaGameFrsGameLiveDoubleView.u(this.o);
        return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.t.h.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        alaGameFrsGameLiveDoubleViewHolder.f14743a.m(aVar);
        alaGameFrsGameLiveDoubleViewHolder.f14743a.v(this.n);
        d.a.j0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f60954e.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f60954e.q1().appId) ? aVar.f60954e.q1().appId : ""));
        a2 a2Var = aVar.f60955f;
        if (a2Var != null) {
            d.a.j0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f60955f.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.q1().appId) ? "" : aVar.f60955f.q1().appId));
        }
        return alaGameFrsGameLiveDoubleViewHolder.a();
    }

    public void g0(d.a.j0.t.c cVar) {
        this.n = cVar;
    }
}
