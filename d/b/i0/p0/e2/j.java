package d.b.i0.p0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import d.b.i0.p0.r;
import d.b.i0.p0.v0;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final r f57476a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f57477b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.p0.n2.n f57478c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.p0.n2.h f57479d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f57480e;

    /* renamed from: f  reason: collision with root package name */
    public final v0 f57481f;

    /* renamed from: g  reason: collision with root package name */
    public final c f57482g;

    public j(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f57477b = frsFragment;
            this.f57479d = frsFragment.w0();
            this.f57476a = this.f57477b.x0();
            this.f57478c = this.f57477b.z2();
            this.f57480e = this.f57477b.M();
            this.f57481f = this.f57477b.w2();
            this.f57482g = this.f57477b.d0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
