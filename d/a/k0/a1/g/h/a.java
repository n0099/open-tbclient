package d.a.k0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.k0.a1.g.j.b, CardViewHolder<d.a.k0.x.i>> {
    public TbPageContext<?> m;
    public d.a.k0.x.i n;
    public BdUniqueId o;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), d.a.k0.a1.g.j.d.j);
        this.m = tbPageContext;
        d.a.k0.x.i iVar = new d.a.k0.x.i(tbPageContext);
        this.n = iVar;
        iVar.M("c10714", "c10739", "c10712", "c10738");
        this.n.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
    }

    public void e0(int i2) {
        d.a.k0.x.i iVar = this.n;
        if (iVar != null) {
            iVar.n(this.m, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder P(ViewGroup viewGroup) {
        if (this.n == null) {
            d.a.k0.x.i iVar = new d.a.k0.x.i(this.m);
            this.n = iVar;
            iVar.L(this.o);
            this.n.M("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.a1.g.j.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().m(bVar);
        d.a.k0.x.t.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, d.a.k0.x.m.e()));
        return cardViewHolder.a();
    }

    public void h0(BdUniqueId bdUniqueId) {
        this.o = bdUniqueId;
        d.a.k0.x.i iVar = this.n;
        if (iVar != null) {
            iVar.L(bdUniqueId);
        }
    }
}
