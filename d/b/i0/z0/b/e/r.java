package d.b.i0.z0.b.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class r extends c {
    public BdUniqueId u;
    public BdUniqueId v;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, BdUniqueId bdUniqueId3) {
        super(tbPageContext, bdUniqueId);
        this.u = bdUniqueId2;
        this.v = bdUniqueId3;
    }

    @Override // d.b.i0.z0.b.e.c, d.b.b.j.e.a
    public BdUniqueId w() {
        BdUniqueId bdUniqueId = this.v;
        return bdUniqueId == null ? super.w() : bdUniqueId;
    }

    @Override // d.b.i0.z0.b.e.c, d.b.b.j.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.u;
        return bdUniqueId == null ? super.y() : bdUniqueId;
    }
}
