package d.a.j0.r0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes3.dex */
public class d extends d.a.c.c.f.e {
    public d(int i2) {
        super(i2);
    }

    @Override // d.a.c.c.f.e
    public void a(int i2, BdUniqueId bdUniqueId) {
        ReloginManager.g().m(i2, bdUniqueId);
    }

    @Override // d.a.c.c.f.e
    public void b(BdUniqueId bdUniqueId) {
        ReloginManager.g().n(bdUniqueId);
    }
}
