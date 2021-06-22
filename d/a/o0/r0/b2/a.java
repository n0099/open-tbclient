package d.a.o0.r0.b2;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.lego.LegoItemHolder;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.o0.k1.o.b;
import d.a.o0.k1.o.l.e;
import d.a.o0.r0.k;
/* loaded from: classes4.dex */
public class a extends k<ICardInfo, LegoItemHolder> {
    public ICardInfo w;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public View I(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.w = iCardInfo;
        return super.I(i2, view, viewGroup, iCardInfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: t0 */
    public LegoItemHolder Q(ViewGroup viewGroup) {
        e a2 = b.h().a(this.o, this.w, 1);
        if (a2 == null) {
            return null;
        }
        a2.c(this.f43016i);
        return new LegoItemHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.r0.k, d.a.c.k.e.a
    /* renamed from: v0 */
    public View X(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoItemHolder legoItemHolder) {
        super.X(i2, view, viewGroup, iCardInfo, legoItemHolder);
        View a2 = legoItemHolder.a();
        if (a2 != null && iCardInfo != null) {
            ((e) a2).i(iCardInfo);
        }
        return a2;
    }
}
