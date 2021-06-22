package d.a.o0.b1.c.e;

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

    @Override // d.a.o0.b1.c.e.c, d.a.c.k.e.a
    public BdUniqueId w() {
        BdUniqueId bdUniqueId = this.v;
        return bdUniqueId == null ? super.w() : bdUniqueId;
    }

    @Override // d.a.o0.b1.c.e.c, d.a.c.k.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.u;
        return bdUniqueId == null ? super.y() : bdUniqueId;
    }
}
