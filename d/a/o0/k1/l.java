package d.a.o0.k1;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
/* loaded from: classes4.dex */
public class l implements d.a.o0.k1.r.a {
    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.p.a a(d.a.o0.k1.p.e eVar) {
        return new d.a.o0.k1.p.c(eVar);
    }

    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        return new LegoDelegateAdapter(tbPageContext, bdUniqueId, i2);
    }

    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        return new d.a.o0.k1.s.c(tbPageContext, bdUniqueId);
    }
}
