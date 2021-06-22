package d.a.o0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.o0.b1.h.j.b, CardViewHolder<d.a.o0.z.i>> {
    public TbPageContext<?> m;
    public d.a.o0.z.i n;
    public BdUniqueId o;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), d.a.o0.b1.h.j.d.j);
        this.m = tbPageContext;
        d.a.o0.z.i iVar = new d.a.o0.z.i(tbPageContext);
        this.n = iVar;
        iVar.N("c10714", "c10739", "c10712", "c10738");
        this.n.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
    }

    public void e0(int i2) {
        d.a.o0.z.i iVar = this.n;
        if (iVar != null) {
            iVar.o(this.m, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardViewHolder Q(ViewGroup viewGroup) {
        if (this.n == null) {
            d.a.o0.z.i iVar = new d.a.o0.z.i(this.m);
            this.n = iVar;
            iVar.M(this.o);
            this.n.N("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.b1.h.j.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        d.a.o0.z.t.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, d.a.o0.z.m.e()));
        return cardViewHolder.a();
    }

    public void i0(BdUniqueId bdUniqueId) {
        this.o = bdUniqueId;
        d.a.o0.z.i iVar = this.n;
        if (iVar != null) {
            iVar.M(bdUniqueId);
        }
    }
}
