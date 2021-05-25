package d.a.n0.b1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import d.a.n0.z.e0.p;
import tbclient.ActiveCenter;
/* loaded from: classes4.dex */
public class g extends d.a.n0.z.e0.b implements p {
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

    @Override // d.a.n0.z.e0.p
    public void a(boolean z) {
    }

    @Override // d.a.n0.z.e0.p
    public boolean g() {
        return false;
    }

    @Override // d.a.n0.z.e0.p
    public int getPosition() {
        return this.T;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return V;
    }

    @Override // d.a.n0.z.e0.p
    public void n(boolean z) {
    }
}
