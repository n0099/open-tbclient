package d.a.q0.u0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.q;
import d.a.q0.u0.u0;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f63348a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f63349b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.q0.u0.o2.n f63350c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.q0.u0.o2.h f63351d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f63352e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f63353f;

    /* renamed from: g  reason: collision with root package name */
    public final c f63354g;

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
            this.f63349b = frsFragment;
            this.f63351d = frsFragment.R();
            this.f63348a = this.f63349b.G0();
            this.f63350c = this.f63349b.K2();
            this.f63352e = this.f63349b.g0();
            this.f63353f = this.f63349b.H2();
            this.f63354g = this.f63349b.u0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
