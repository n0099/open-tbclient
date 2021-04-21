package d.b.j0.j1;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
/* loaded from: classes4.dex */
public class l implements d.b.j0.j1.r.a {
    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.s.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        return new d.b.j0.j1.s.c(tbPageContext, bdUniqueId);
    }

    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.p.a b(d.b.j0.j1.p.e eVar) {
        return new d.b.j0.j1.p.c(eVar);
    }

    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.o.g.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        return new LegoDelegateAdapter(tbPageContext, bdUniqueId, i);
    }
}
