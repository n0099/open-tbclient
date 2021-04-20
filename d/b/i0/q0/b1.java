package d.b.i0.q0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
/* loaded from: classes4.dex */
public class b1 implements n0 {
    @Override // d.b.i0.q0.n0
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        return new d.b.i0.q0.b2.a(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // d.b.i0.q0.n0
    public d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        if (bdUniqueId == d.b.i0.d3.x.H3) {
            return new d.b.i0.q0.n1.d.d(tbPageContext, bdUniqueId, z);
        }
        if (bdUniqueId == a2.A3) {
            return new d.b.i0.q0.n1.d.c0(tbPageContext, bdUniqueId, bdUniqueId2, z);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // d.b.i0.q0.n0
    public d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        if (bdUniqueId == a2.B3) {
            return new d.b.i0.q0.n1.d.f(tbPageContext, bdUniqueId, bdUniqueId2);
        }
        throw new IllegalArgumentException("Unsupported adapter type.");
    }

    @Override // d.b.i0.q0.n0
    public d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        return new d.b.i0.q0.n1.d.b0(tbPageContext, a2.A3, bdUniqueId, z);
    }
}
