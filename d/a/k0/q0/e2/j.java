package d.a.k0.q0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.a.k0.q0.r;
import d.a.k0.q0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f58396a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f58397b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.k0.q0.o2.n f58398c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.k0.q0.o2.h f58399d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f58400e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f58401f;

    /* renamed from: g  reason: collision with root package name */
    public final c f58402g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f58397b = frsFragment;
            this.f58399d = frsFragment.P();
            this.f58396a = this.f58397b.y0();
            this.f58398c = this.f58397b.y2();
            this.f58400e = this.f58397b.b0();
            this.f58401f = this.f58397b.v2();
            this.f58402g = this.f58397b.n0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
