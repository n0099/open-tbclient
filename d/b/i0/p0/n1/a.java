package d.b.i0.p0.n1;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import d.b.b.j.e.s;
import d.b.i0.p0.n1.d.l0;
import d.b.i0.p0.n1.d.u;
import d.b.i0.p0.n2.d;
/* loaded from: classes4.dex */
public class a implements d.b.i0.p0.n1.e.a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.p0.q2.b f57934a;

    @Override // d.b.i0.p0.n1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.L2()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.b.i0.p0.n1.e.a
    public d.b.i0.p0.n1.e.b b() {
        return new c();
    }

    @Override // d.b.i0.p0.n1.e.a
    public l0 c(FrsFragment frsFragment, s sVar, boolean z) {
        return new u(frsFragment, sVar, z);
    }

    @Override // d.b.i0.p0.n1.e.a
    public d.b.i0.p0.n1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new d.b.i0.p0.n2.b(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.b.i0.p0.n1.e.a
    public d.b.i0.p0.q2.b e(String str, FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return null;
        }
        b bVar = new b(frsFragment, null, null, i);
        this.f57934a = bVar;
        bVar.L(frsFragment.r2());
        return this.f57934a;
    }
}
