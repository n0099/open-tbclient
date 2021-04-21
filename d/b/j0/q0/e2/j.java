package d.b.j0.q0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.b.j0.q0.r;
import d.b.j0.q0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f59597a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f59598b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.j0.q0.o2.n f59599c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.j0.q0.o2.h f59600d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f59601e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f59602f;

    /* renamed from: g  reason: collision with root package name */
    public final c f59603g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f59598b = frsFragment;
            this.f59600d = frsFragment.w0();
            this.f59597a = this.f59598b.x0();
            this.f59599c = this.f59598b.z2();
            this.f59601e = this.f59598b.M();
            this.f59602f = this.f59598b.w2();
            this.f59603g = this.f59598b.d0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
