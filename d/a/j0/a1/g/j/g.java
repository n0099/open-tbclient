package d.a.j0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import d.a.j0.x.e0.p;
import tbclient.ActiveCenter;
/* loaded from: classes4.dex */
public class g extends d.a.j0.x.e0.b implements p {
    public static final BdUniqueId U = BdUniqueId.gen();
    public int S;
    public ActiveCenterData T;

    public void Z(ActiveCenter activeCenter) {
        if (activeCenter != null) {
            ActiveCenterData activeCenterData = new ActiveCenterData();
            this.T = activeCenterData;
            activeCenterData.parseProto(activeCenter);
        }
    }

    @Override // d.a.j0.x.e0.p
    public void a(boolean z) {
    }

    @Override // d.a.j0.x.e0.p
    public boolean g() {
        return false;
    }

    @Override // d.a.j0.x.e0.p
    public int getPosition() {
        return this.S;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return U;
    }

    @Override // d.a.j0.x.e0.p
    public void n(boolean z) {
    }
}
