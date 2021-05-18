package d.a.j0.r.q;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class p extends a2 {
    public static final BdUniqueId J3 = BdUniqueId.gen();
    public boolean F3 = false;
    public boolean G3 = false;
    public boolean H3 = false;
    public int I3;

    public int B4() {
        return this.I3;
    }

    public boolean C4() {
        return this.F3;
    }

    public boolean D4() {
        return this.H3;
    }

    public boolean E4() {
        return this.G3;
    }

    public void F4(int i2) {
        this.I3 = i2;
    }

    public void G4(boolean z) {
        this.F3 = z;
    }

    public void H4(boolean z) {
        this.H3 = z;
    }

    public void I4(boolean z) {
        this.G3 = z;
    }

    @Override // d.a.j0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return J3;
    }
}
