package d.a.s0.u0.e2;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.u0.q;
import d.a.s0.u0.u0;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final q f65924a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f65925b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.s0.u0.o2.n f65926c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.s0.u0.o2.h f65927d;

    /* renamed from: e  reason: collision with root package name */
    public final FrsModelController f65928e;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f65929f;

    /* renamed from: g  reason: collision with root package name */
    public final c f65930g;

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
            this.f65925b = frsFragment;
            this.f65927d = frsFragment.Q();
            this.f65924a = this.f65925b.B0();
            this.f65926c = this.f65925b.E2();
            this.f65928e = this.f65925b.d0();
            this.f65929f = this.f65925b.B2();
            this.f65930g = this.f65925b.q0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
