package d.a.j0.q0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.a.j0.q0.r;
import d.a.j0.q0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f57654a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f57655b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.j0.q0.o2.n f57656c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.j0.q0.o2.h f57657d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f57658e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f57659f;

    /* renamed from: g  reason: collision with root package name */
    public final c f57660g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f57655b = frsFragment;
            this.f57657d = frsFragment.P();
            this.f57654a = this.f57655b.z0();
            this.f57656c = this.f57655b.z2();
            this.f57658e = this.f57655b.b0();
            this.f57659f = this.f57655b.w2();
            this.f57660g = this.f57655b.n0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
