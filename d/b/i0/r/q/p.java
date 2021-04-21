package d.b.i0.r.q;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class p extends a2 {
    public static final BdUniqueId I3 = BdUniqueId.gen();
    public boolean E3 = false;
    public boolean F3 = false;
    public boolean G3 = false;
    public int H3;

    public boolean A4() {
        return this.E3;
    }

    public boolean B4() {
        return this.G3;
    }

    public boolean C4() {
        return this.F3;
    }

    public void D4(int i) {
        this.H3 = i;
    }

    public void E4(boolean z) {
        this.E3 = z;
    }

    public void F4(boolean z) {
        this.G3 = z;
    }

    public void G4(boolean z) {
        this.F3 = z;
    }

    @Override // d.b.i0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return I3;
    }

    public int z4() {
        return this.H3;
    }
}
