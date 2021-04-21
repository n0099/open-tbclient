package d.b.j0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.j0.t.h.b.a, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.b.j0.t.c n;
    public String o;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder R(ViewGroup viewGroup) {
        AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.m);
        alaGameFrsGameLiveDoubleView.w(this.o);
        return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.h.b.a aVar, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        alaGameFrsGameLiveDoubleViewHolder.f14665a.n(aVar);
        alaGameFrsGameLiveDoubleViewHolder.f14665a.x(this.n);
        d.b.j0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f62758e.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f62758e.q1().appId) ? aVar.f62758e.q1().appId : ""));
        a2 a2Var = aVar.f62759f;
        if (a2Var != null) {
            d.b.j0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f62759f.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.q1().appId) ? "" : aVar.f62759f.q1().appId));
        }
        return alaGameFrsGameLiveDoubleViewHolder.a();
    }

    public void j0(d.b.j0.t.c cVar) {
        this.n = cVar;
    }
}
