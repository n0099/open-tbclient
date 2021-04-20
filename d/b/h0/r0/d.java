package d.b.h0.r0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes3.dex */
public class d extends d.b.c.c.f.e {
    public d(int i) {
        super(i);
    }

    @Override // d.b.c.c.f.e
    public void a(int i, BdUniqueId bdUniqueId) {
        ReloginManager.g().m(i, bdUniqueId);
    }

    @Override // d.b.c.c.f.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.g().n(bdUniqueId);
    }
}
