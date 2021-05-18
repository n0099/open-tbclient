package d.a.k0.a1.b.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class r extends c {
    public BdUniqueId u;
    public BdUniqueId v;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.u = bdUniqueId2;
        this.v = bdUniqueId3;
    }

    @Override // d.a.k0.a1.b.e.c, d.a.c.j.e.a
    public BdUniqueId v() {
        BdUniqueId bdUniqueId = this.v;
        return bdUniqueId == null ? super.v() : bdUniqueId;
    }

    @Override // d.a.k0.a1.b.e.c, d.a.c.j.e.a
    public BdUniqueId x() {
        BdUniqueId bdUniqueId = this.u;
        return bdUniqueId == null ? super.x() : bdUniqueId;
    }
}
