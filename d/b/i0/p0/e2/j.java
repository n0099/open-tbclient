package d.b.i0.p0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.b.i0.p0.r;
import d.b.i0.p0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f57477a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f57478b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.p0.n2.n f57479c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.p0.n2.h f57480d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f57481e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f57482f;

    /* renamed from: g  reason: collision with root package name */
    public final c f57483g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f57478b = frsFragment;
            this.f57480d = frsFragment.w0();
            this.f57477a = this.f57478b.x0();
            this.f57479c = this.f57478b.z2();
            this.f57481e = this.f57478b.M();
            this.f57482f = this.f57478b.w2();
            this.f57483g = this.f57478b.d0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
