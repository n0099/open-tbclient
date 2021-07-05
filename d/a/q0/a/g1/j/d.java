package d.a.q0.a.g1.j;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.u.g;
/* loaded from: classes8.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.a f47873a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a() {
        d.a.q0.a.h0.l.a P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.q0.a.l0.a aVar = this.f47873a;
            if ((aVar == null || aVar.isDestroyed()) && (P = g.N().P()) != null && (P.g() instanceof d.a.q0.a.l0.a)) {
                this.f47873a = (d.a.q0.a.l0.a) P.g();
            }
        }
    }

    @Override // d.a.q0.a.g1.j.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            d.a.q0.a.l0.a aVar = this.f47873a;
            if (aVar != null) {
                aVar.onPause();
            }
        }
    }

    @Override // d.a.q0.a.g1.j.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            d.a.q0.a.l0.a aVar = this.f47873a;
            if (aVar != null) {
                aVar.onResume();
            }
        }
    }
}
