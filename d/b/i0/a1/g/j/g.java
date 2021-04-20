package d.b.i0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import d.b.i0.x.e0.p;
import tbclient.ActiveCenter;
/* loaded from: classes4.dex */
public class g extends d.b.i0.x.e0.b implements p {
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

    @Override // d.b.i0.x.e0.p
    public void b(boolean z) {
    }

    @Override // d.b.i0.x.e0.p
    public int getPosition() {
        return this.S;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return U;
    }

    @Override // d.b.i0.x.e0.p
    public void h(boolean z) {
    }

    @Override // d.b.i0.x.e0.p
    public boolean m() {
        return false;
    }
}
