package d.b.i0.i1;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
/* loaded from: classes3.dex */
public class l implements d.b.i0.i1.r.a {
    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.s.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        return new d.b.i0.i1.s.c(tbPageContext, bdUniqueId);
    }

    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.p.a b(d.b.i0.i1.p.e eVar) {
        return new d.b.i0.i1.p.c(eVar);
    }

    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.o.g.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        return new LegoDelegateAdapter(tbPageContext, bdUniqueId, i);
    }
}
