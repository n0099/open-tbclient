package d.a.j0.j1;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
/* loaded from: classes4.dex */
public class l implements d.a.j0.j1.r.a {
    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.p.a a(d.a.j0.j1.p.e eVar) {
        return new d.a.j0.j1.p.c(eVar);
    }

    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        return new LegoDelegateAdapter(tbPageContext, bdUniqueId, i2);
    }

    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        return new d.a.j0.j1.s.c(tbPageContext, bdUniqueId);
    }
}
