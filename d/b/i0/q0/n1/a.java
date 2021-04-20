package d.b.i0.q0.n1;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import d.b.c.j.e.s;
import d.b.i0.q0.n1.d.e0;
import d.b.i0.q0.n1.d.q;
import d.b.i0.q0.o2.d;
/* loaded from: classes4.dex */
public class a implements d.b.i0.q0.n1.e.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.q0.r2.b f59606a;

    @Override // d.b.i0.q0.n1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.L2()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.b.i0.q0.n1.e.a
    public d.b.i0.q0.n1.e.b b() {
        return new c();
    }

    @Override // d.b.i0.q0.n1.e.a
    public e0 c(FrsFragment frsFragment, s sVar, boolean z) {
        return new q(frsFragment, sVar, z);
    }

    @Override // d.b.i0.q0.n1.e.a
    public d.b.i0.q0.n1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new d.b.i0.q0.o2.b(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.b.i0.q0.n1.e.a
    public d.b.i0.q0.r2.b e(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        b bVar = new b(frsFragment, null, null, i);
        this.f59606a = bVar;
        bVar.L(frsFragment.r2());
        return this.f59606a;
    }
}
