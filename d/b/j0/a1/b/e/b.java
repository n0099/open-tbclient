package d.b.j0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.b0;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.j0.x.e0.j, CardViewHolder<d.b.j0.x.k>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.j0.x.k o;
    public String p;
    public b0 q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.j0.x.e0.j> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.j jVar) {
            if (view == null || b.this.o == null || b.this.o.m() == null || jVar == null || jVar.n() == null || StringUtils.isNull(jVar.n().w1())) {
                return;
            }
            d.b.j0.a1.b.c.b(view, jVar, view == b.this.o.O() ? 1 : 2);
            if (view == b.this.o.p.getCommentContainer() || view == b.this.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.n().w1());
                statisticItem.param("nid", jVar.n().L0());
                d.b.i0.i0.c f2 = TbPageExtraHelper.f(view);
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
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.j0.x.k> R(ViewGroup viewGroup) {
        d.b.j0.x.k kVar = new d.b.j0.x.k(this.n, this.m);
        this.o = kVar;
        kVar.X(true);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.W(bdUniqueId);
        }
        return new CardViewHolder<>(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.j jVar, CardViewHolder<d.b.j0.x.k> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        jVar.U(i + 1);
        d.b.j0.x.t.b().a(jVar.l0("c12351"));
        if (cardViewHolder.b() instanceof d.b.j0.m.e) {
            cardViewHolder.b().setPage(this.p);
        }
        cardViewHolder.b().n(jVar);
        cardViewHolder.b().q(this.q);
        return cardViewHolder.a();
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.p = str;
    }
}
