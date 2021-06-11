package d.a.n0.b1.c.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.n0.z.e0.j, CardViewHolder<d.a.n0.z.j>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.n0.z.j o;
    public String p;
    public b0 q;

    /* renamed from: d.a.n0.b1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1242a extends b0<d.a.n0.z.e0.j> {
        public C1242a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.j jVar) {
            if (view == null || a.this.o == null || a.this.o.m() == null || jVar == null || jVar.i() == null || StringUtils.isNull(jVar.i().z1())) {
                return;
            }
            d.a.n0.b1.c.c.b(view, jVar, view == a.this.o.M() ? 1 : 2);
            if (view == a.this.o.p.getCommentContainer() || view == a.this.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.i().z1());
                statisticItem.param("nid", jVar.i().M0());
                d.a.m0.i0.c f2 = TbPageExtraHelper.f(view);
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
        this.q = new C1242a();
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder<d.a.n0.z.j> Q(ViewGroup viewGroup) {
        d.a.n0.z.j jVar = new d.a.n0.z.j(this.n, this.m);
        this.o = jVar;
        jVar.U(true);
        BdUniqueId bdUniqueId = this.m;
        if (bdUniqueId != null) {
            this.o.T(bdUniqueId);
        }
        return new CardViewHolder<>(this.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.j jVar, CardViewHolder<d.a.n0.z.j> cardViewHolder) {
        if (jVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        jVar.U(i2 + 1);
        StatisticItem l0 = jVar.l0("c12351");
        if (jVar.i() != null && jVar.i().s1() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.i().s1());
            if (jVar.i().s1().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(l0, jVar.i().s1().mYyExtData);
            }
            l0.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        d.a.n0.z.t.b().a(l0);
        if (cardViewHolder.b() instanceof d.a.n0.o.e) {
            cardViewHolder.b().setPage(this.p);
        }
        cardViewHolder.b().n(jVar);
        cardViewHolder.b().p(this.q);
        if (jVar.i() != null && jVar.i().s1() != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_param1", jVar.i().s1().live_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
        return cardViewHolder.a();
    }
}
