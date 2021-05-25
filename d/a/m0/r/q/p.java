package d.a.m0.r.q;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class p extends a2 {
    public static final BdUniqueId K3 = BdUniqueId.gen();
    public boolean G3 = false;
    public boolean H3 = false;
    public boolean I3 = false;
    public int J3;

    public int C4() {
        return this.J3;
    }

    public boolean D4() {
        return this.G3;
    }

    public boolean E4() {
        return this.I3;
    }

    public boolean F4() {
        return this.H3;
    }

    public void G4(int i2) {
        this.J3 = i2;
    }

    public void H4(boolean z) {
        this.G3 = z;
    }

    public void I4(boolean z) {
        this.I3 = z;
    }

    public void J4(boolean z) {
        this.H3 = z;
    }

    @Override // d.a.m0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return K3;
    }
}
