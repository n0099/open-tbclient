package d.b.i0.z0.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class a extends d.b.b.j.e.a<d.b.i0.x.e0.j, CardViewHolder<d.b.i0.x.j>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.b.i0.x.j o;
    public String p;
    public b0 q;

    /* renamed from: d.b.i0.z0.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1682a extends b0<d.b.i0.x.e0.j> {
        public C1682a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.j jVar) {
            if (view == null || a.this.o == null || a.this.o.m() == null || jVar == null || jVar.n() == null || StringUtils.isNull(jVar.n().w1())) {
                return;
            }
            d.b.i0.z0.b.c.b(view, jVar, view == a.this.o.O() ? 1 : 2);
            if (view == a.this.o.p.getCommentContainer() || view == a.this.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.n().w1());
                statisticItem.param("nid", jVar.n().L0());
                d.b.h0.i0.c f2 = TbPageExtraHelper.f(view);
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

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new C1682a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.i0.x.j> R(ViewGroup viewGroup) {
        d.b.i0.x.j jVar = new d.b.i0.x.j(this.n, this.m);
        this.o = jVar;
        jVar.W(true);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.V(bdUniqueId);
        }
        return new CardViewHolder<>(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.j jVar, CardViewHolder<d.b.i0.x.j> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        jVar.U(i + 1);
        d.b.i0.x.t.b().a(jVar.l0("c12351"));
        if (cardViewHolder.b() instanceof d.b.i0.m.e) {
            cardViewHolder.b().setPage(this.p);
        }
        cardViewHolder.b().n(jVar);
        cardViewHolder.b().q(this.q);
        if (jVar.n() != null && jVar.n().q1() != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_param1", jVar.n().q1().live_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
        return cardViewHolder.a();
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.p = str;
    }
}
