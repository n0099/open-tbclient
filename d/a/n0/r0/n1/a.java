package d.a.n0.r0.n1;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.k.e.s;
import d.a.n0.r0.n1.d.e0;
import d.a.n0.r0.n1.d.q;
import d.a.n0.r0.o2.d;
/* loaded from: classes4.dex */
public class a implements d.a.n0.r0.n1.e.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.r0.r2.b f62680a;

    @Override // d.a.n0.r0.n1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.N2()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.a.n0.r0.n1.e.a
    public e0 b(FrsFragment frsFragment, s sVar, boolean z) {
        return new q(frsFragment, sVar, z);
    }

    @Override // d.a.n0.r0.n1.e.a
    public d.a.n0.r0.n1.e.b c() {
        return new c();
    }

    @Override // d.a.n0.r0.n1.e.a
    public d.a.n0.r0.n1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new d.a.n0.r0.o2.b(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.a.n0.r0.n1.e.a
    public d.a.n0.r0.r2.b e(String str, FrsFragment frsFragment, int i2) {
        if (frsFragment == null) {
            return null;
        }
        b bVar = new b(frsFragment, null, null, i2);
        this.f62680a = bVar;
        bVar.L(frsFragment.t2());
        return this.f62680a;
    }
}
