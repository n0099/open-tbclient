package d.a.n0.r0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public class b1 implements n0 {
    @Override // d.a.n0.r0.n0
    public d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new d.a.n0.r0.n1.d.b0(tbPageContext, a2.C3, bdUniqueId, z);
    }

    @Override // d.a.n0.r0.n0
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new d.a.n0.r0.b2.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // d.a.n0.r0.n0
    public d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == d.a.n0.e3.x.J3) {
            return new d.a.n0.r0.n1.d.d(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == a2.C3) {
            return new d.a.n0.r0.n1.d.c0(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // d.a.n0.r0.n0
    public d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == a2.D3) {
            return new d.a.n0.r0.n1.d.f(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }
}
