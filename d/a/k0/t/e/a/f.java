package d.a.k0.t.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import d.a.j0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends d.a.c.j.e.a<d.a.k0.t.h.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.k0.t.c n;
    public String o;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder P(ViewGroup viewGroup) {
        AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.m);
        alaGameFrsLiveDoubleView.u(this.o);
        return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.h.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        alaGameFrsLiveDoubleViewHolder.f14059a.m(aVar);
        alaGameFrsLiveDoubleViewHolder.f14059a.v(this.n);
        d.a.k0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f61678e.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f61678e.q1().appId) ? aVar.f61678e.q1().appId : ""));
        a2 a2Var = aVar.f61679f;
        if (a2Var != null) {
            d.a.k0.t.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f61679f.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.q1().appId) ? "" : aVar.f61679f.q1().appId));
        }
        return alaGameFrsLiveDoubleViewHolder.a();
    }

    public void g0(d.a.k0.t.c cVar) {
        this.n = cVar;
    }
}
