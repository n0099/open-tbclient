package d.b.i0.z0.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
/* loaded from: classes3.dex */
public class a extends d.b.b.j.e.a<d.b.i0.z0.g.j.b, CardViewHolder<d.b.i0.x.i>> {
    public TbPageContext<?> m;
    public d.b.i0.x.i n;
    public BdUniqueId o;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), d.b.i0.z0.g.j.d.j);
        this.m = tbPageContext;
        d.b.i0.x.i iVar = new d.b.i0.x.i(tbPageContext);
        this.n = iVar;
        iVar.P("c10714", "c10739", "c10712", "c10738");
        this.n.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
    }

    public void h0(int i) {
        d.b.i0.x.i iVar = this.n;
        if (iVar != null) {
            iVar.o(this.m, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardViewHolder R(ViewGroup viewGroup) {
        if (this.n == null) {
            d.b.i0.x.i iVar = new d.b.i0.x.i(this.m);
            this.n = iVar;
            iVar.O(this.o);
            this.n.P("c10714", "c10739", "c10712", "c10738");
        }
        return new CardViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.z0.g.j.b bVar, CardViewHolder cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        cardViewHolder.b().n(bVar);
        d.b.i0.x.t.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, d.b.i0.x.m.e()));
        return cardViewHolder.a();
    }

    public void l0(BdUniqueId bdUniqueId) {
        this.o = bdUniqueId;
        d.b.i0.x.i iVar = this.n;
        if (iVar != null) {
            iVar.O(bdUniqueId);
        }
    }
}
