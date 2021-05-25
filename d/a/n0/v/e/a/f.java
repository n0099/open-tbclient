package d.a.n0.v.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class f extends d.a.c.j.e.a<d.a.n0.v.h.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.a.n0.v.c n;
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
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.h.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        alaGameFrsLiveDoubleViewHolder.f13962a.m(aVar);
        alaGameFrsLiveDoubleViewHolder.f13962a.v(this.n);
        d.a.n0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f61966e.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f61966e.r1().appId) ? aVar.f61966e.r1().appId : ""));
        a2 a2Var = aVar.f61967f;
        if (a2Var != null) {
            d.a.n0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f61967f.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(a2Var.r1().appId) ? "" : aVar.f61967f.r1().appId));
        }
        return alaGameFrsLiveDoubleViewHolder.a();
    }

    public void g0(d.a.n0.v.c cVar) {
        this.n = cVar;
    }
}
