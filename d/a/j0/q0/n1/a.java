package d.a.j0.q0.n1;

import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.j.e.s;
import d.a.j0.q0.n1.d.e0;
import d.a.j0.q0.n1.d.q;
import d.a.j0.q0.o2.d;
/* loaded from: classes4.dex */
public class a implements d.a.j0.q0.n1.e.a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.q0.r2.b f58106a;

    @Override // d.a.j0.q0.n1.e.a
    public d a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment.L2()) {
            return null;
        }
        return new d(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.a.j0.q0.n1.e.a
    public e0 b(FrsFragment frsFragment, s sVar, boolean z) {
        return new q(frsFragment, sVar, z);
    }

    @Override // d.a.j0.q0.n1.e.a
    public d.a.j0.q0.n1.e.b c() {
        return new c();
    }

    @Override // d.a.j0.q0.n1.e.a
    public d.a.j0.q0.n1.e.c d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        return new d.a.j0.q0.o2.b(frsFragment, noPressedRelativeLayout);
    }

    @Override // d.a.j0.q0.n1.e.a
    public d.a.j0.q0.r2.b e(String str, FrsFragment frsFragment, int i2) {
        if (frsFragment == null) {
            return null;
        }
        b bVar = new b(frsFragment, null, null, i2);
        this.f58106a = bVar;
        bVar.L(frsFragment.r2());
        return this.f58106a;
    }
}
