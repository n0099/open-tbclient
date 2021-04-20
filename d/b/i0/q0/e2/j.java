package d.b.i0.q0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.b.i0.q0.r;
import d.b.i0.q0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f59176a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f59177b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.q0.o2.n f59178c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.q0.o2.h f59179d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f59180e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f59181f;

    /* renamed from: g  reason: collision with root package name */
    public final c f59182g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f59177b = frsFragment;
            this.f59179d = frsFragment.w0();
            this.f59176a = this.f59177b.x0();
            this.f59178c = this.f59177b.z2();
            this.f59180e = this.f59177b.M();
            this.f59181f = this.f59177b.w2();
            this.f59182g = this.f59177b.d0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
