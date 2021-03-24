package d.b.i0.c2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.h0.r.q.c1;
/* loaded from: classes4.dex */
public class g0 extends PostData {
    public static final BdUniqueId z0 = BdUniqueId.gen();
    public c1 w0;
    public c1 x0;
    public c1 y0;

    public boolean A0() {
        c1 c1Var = this.w0;
        if (c1Var == null || StringUtils.isNull(c1Var.f50735b)) {
            c1 c1Var2 = this.x0;
            if (c1Var2 == null || StringUtils.isNull(c1Var2.f50735b)) {
                c1 c1Var3 = this.y0;
                return (c1Var3 == null || StringUtils.isNull(c1Var3.f50735b)) ? false : true;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.b.b.j.e.n
    public BdUniqueId getType() {
        return z0;
    }
}
