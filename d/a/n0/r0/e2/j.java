package d.a.n0.r0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.a.n0.r0.r;
import d.a.n0.r0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f62228a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f62229b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.r0.o2.n f62230c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.r0.o2.h f62231d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f62232e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f62233f;

    /* renamed from: g  reason: collision with root package name */
    public final c f62234g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f62229b = frsFragment;
            this.f62231d = frsFragment.R();
            this.f62228a = this.f62229b.B0();
            this.f62230c = this.f62229b.B2();
            this.f62232e = this.f62229b.e0();
            this.f62233f = this.f62229b.y2();
            this.f62234g = this.f62229b.q0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
