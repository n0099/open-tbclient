package d.a.o0.b1.h.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import d.a.o0.z.e0.p;
import tbclient.ActiveCenter;
/* loaded from: classes4.dex */
public class g extends d.a.o0.z.e0.b implements p {
    public static final BdUniqueId V = BdUniqueId.gen();
    public int T;
    public ActiveCenterData U;

    public void Z(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.U = activeCenterData;
            activeCenterData.parseProto(activeCenter);
        }
    }

    @Override // d.a.o0.z.e0.p
    public void a(boolean z) {
    }

    @Override // d.a.o0.z.e0.p
    public int getPosition() {
        return this.T;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return V;
    }

    @Override // d.a.o0.z.e0.p
    public boolean j() {
        return false;
    }

    @Override // d.a.o0.z.e0.p
    public void r(boolean z) {
    }
}
