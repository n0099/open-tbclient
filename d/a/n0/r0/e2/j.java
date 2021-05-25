package d.a.n0.r0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.a.n0.r0.r;
import d.a.n0.r0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f58537a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f58538b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.r0.o2.n f58539c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.r0.o2.h f58540d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f58541e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f58542f;

    /* renamed from: g  reason: collision with root package name */
    public final c f58543g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f58538b = frsFragment;
            this.f58540d = frsFragment.P();
            this.f58537a = this.f58538b.y0();
            this.f58539c = this.f58538b.y2();
            this.f58541e = this.f58538b.b0();
            this.f58542f = this.f58538b.v2();
            this.f58543g = this.f58538b.n0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
