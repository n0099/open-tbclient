package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class p extends a2 {
    public static final BdUniqueId N3 = BdUniqueId.gen();
    public boolean J3 = false;
    public boolean K3 = false;
    public boolean L3 = false;
    public int M3;

    public int D4() {
        return this.M3;
    }

    public boolean E4() {
        return this.J3;
    }

    public boolean F4() {
        return this.L3;
    }

    public boolean G4() {
        return this.K3;
    }

    public void H4(int i2) {
        this.M3 = i2;
    }

    public void I4(boolean z) {
        this.J3 = z;
    }

    public void J4(boolean z) {
        this.L3 = z;
    }

    public void K4(boolean z) {
        this.K3 = z;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return N3;
    }
}
