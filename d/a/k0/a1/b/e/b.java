package d.a.k0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.k0.x.e0.j, CardViewHolder<d.a.k0.x.k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.k0.x.k o;
    public String p;
    public b0 q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.j jVar) {
            if (view == null || b.this.o == null || b.this.o.l() == null || jVar == null || jVar.m() == null || StringUtils.isNull(jVar.m().x1())) {
                return;
            }
            d.a.k0.a1.b.c.b(view, jVar, view == b.this.o.L() ? 1 : 2);
            if (view == b.this.o.p.getCommentContainer() || view == b.this.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.m().x1());
                statisticItem.param("nid", jVar.m().L0());
                d.a.j0.i0.c f2 = TbPageExtraHelper.f(view);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.k0.x.k> P(ViewGroup viewGroup) {
        d.a.k0.x.k kVar = new d.a.k0.x.k(this.n, this.m);
        this.o = kVar;
        kVar.W(true);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.V(bdUniqueId);
        }
        return new CardViewHolder<>(this.o);
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.j jVar, CardViewHolder<d.a.k0.x.k> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        jVar.U(i2 + 1);
        StatisticItem l0 = jVar.l0("c12351");
        if (jVar.m() != null && jVar.m().q1() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.m().q1());
            if (jVar.m().q1().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(l0, jVar.m().q1().mYyExtData);
            }
            l0.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        d.a.k0.x.t.b().a(l0);
        if (cardViewHolder.b() instanceof d.a.k0.m.e) {
            cardViewHolder.b().setPage(this.p);
        }
        cardViewHolder.b().m(jVar);
        cardViewHolder.b().o(this.q);
        return cardViewHolder.a();
    }
}
