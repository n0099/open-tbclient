package d.a.p0.u0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.u0.q;
import d.a.p0.u0.u0;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f62705a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f62706b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.p0.u0.o2.n f62707c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.p0.u0.o2.h f62708d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f62709e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f62710f;

    /* renamed from: g  reason: collision with root package name */
    public final c f62711g;

    public j(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsFragment != null) {
            this.f62706b = frsFragment;
            this.f62708d = frsFragment.Q();
            this.f62705a = this.f62706b.B0();
            this.f62707c = this.f62706b.F2();
            this.f62709e = this.f62706b.d0();
            this.f62710f = this.f62706b.C2();
            this.f62711g = this.f62706b.q0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
