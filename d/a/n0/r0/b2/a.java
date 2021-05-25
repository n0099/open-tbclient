package d.a.n0.r0.b2;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.lego.LegoItemHolder;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.n0.k1.o.b;
import d.a.n0.k1.o.l.e;
import d.a.n0.r0.k;
/* loaded from: classes4.dex */
public class a extends k<ICardInfo, LegoItemHolder> {
    public ICardInfo w;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: s0 */
    public View H(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.w = iCardInfo;
        return super.H(i2, view, viewGroup, iCardInfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: t0 */
    public LegoItemHolder P(ViewGroup viewGroup) {
        e a2 = b.h().a(this.o, this.w, 1);
        if (a2 == null) {
            return null;
        }
        a2.k(this.f39232i);
        return new LegoItemHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    /* renamed from: u0 */
    public View W(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoItemHolder legoItemHolder) {
        super.W(i2, view, viewGroup, iCardInfo, legoItemHolder);
        View a2 = legoItemHolder.a();
        if (a2 != null && iCardInfo != null) {
            ((e) a2).g(iCardInfo);
        }
        return a2;
    }
}
