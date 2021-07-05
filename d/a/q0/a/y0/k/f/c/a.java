package d.a.q0.a.y0.k.f.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.q0.a.y0.k.f.a f51824a;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51824a = new d.a.q0.a.y0.k.f.a();
    }

    @Override // d.a.q0.a.y0.k.f.c.f, d.a.q0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, hybridUbcFlow) == null) {
            if (this.f51824a.f()) {
                this.f51824a.k();
                d.a.q0.a.y0.k.f.b.f();
                return;
            }
            this.f51824a.g("fmpArrived", z ? "1" : "0");
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f51824a.c();
            if (this.f51824a.e("fmpArrived")) {
                this.f51824a.k();
                d.a.q0.a.y0.k.f.b.f();
            }
        }
    }
}
