package d.a.o0.e2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.n0.r.q.c1;
/* loaded from: classes5.dex */
public class i0 extends PostData {
    public static final BdUniqueId F0 = BdUniqueId.gen();
    public c1 C0;
    public c1 D0;
    public c1 E0;

    public boolean C0() {
        c1 c1Var = this.C0;
        if (c1Var == null || StringUtils.isNull(c1Var.f53749b)) {
            c1 c1Var2 = this.D0;
            if (c1Var2 == null || StringUtils.isNull(c1Var2.f53749b)) {
                c1 c1Var3 = this.E0;
                return (c1Var3 == null || StringUtils.isNull(c1Var3.f53749b)) ? false : true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return F0;
    }
}
