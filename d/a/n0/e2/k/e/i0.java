package d.a.n0.e2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.m0.r.q.c1;
/* loaded from: classes5.dex */
public class i0 extends PostData {
    public static final BdUniqueId A0 = BdUniqueId.gen();
    public c1 x0;
    public c1 y0;
    public c1 z0;

    public boolean C0() {
        c1 c1Var = this.x0;
        if (c1Var == null || StringUtils.isNull(c1Var.f53642b)) {
            c1 c1Var2 = this.y0;
            if (c1Var2 == null || StringUtils.isNull(c1Var2.f53642b)) {
                c1 c1Var3 = this.z0;
                return (c1Var3 == null || StringUtils.isNull(c1Var3.f53642b)) ? false : true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return A0;
    }
}
