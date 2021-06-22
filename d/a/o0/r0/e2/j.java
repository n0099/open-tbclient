package d.a.o0.r0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.a.o0.r0.r;
import d.a.o0.r0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f62353a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f62354b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.o0.r0.o2.n f62355c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.o0.r0.o2.h f62356d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f62357e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f62358f;

    /* renamed from: g  reason: collision with root package name */
    public final c f62359g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f62354b = frsFragment;
            this.f62356d = frsFragment.R();
            this.f62353a = this.f62354b.B0();
            this.f62355c = this.f62354b.B2();
            this.f62357e = this.f62354b.e0();
            this.f62358f = this.f62354b.y2();
            this.f62359g = this.f62354b.q0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
