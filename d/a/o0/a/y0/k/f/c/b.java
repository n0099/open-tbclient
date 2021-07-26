package d.a.o0.a.y0.k.f.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f49027b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.y0.k.f.c.f, d.a.o0.a.y0.k.f.c.e
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && e(str)) {
            boolean equals = TextUtils.equals(str2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            boolean equals2 = TextUtils.equals(str2, RetrieveTaskManager.KEY);
            this.f49026a.g("autoPlay", equals ? "1" : "0");
            this.f49026a.g("playMethod", equals2 ? "1" : "0");
        }
    }

    @Override // d.a.o0.a.y0.k.f.c.a, d.a.o0.a.y0.k.f.c.f, d.a.o0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, hybridUbcFlow) == null) {
            UbcFlowEvent f2 = hybridUbcFlow.f("fe_slave_dispatch_start");
            UbcFlowEvent f3 = hybridUbcFlow.f("fe_master_page_oninit_start");
            UbcFlowEvent f4 = hybridUbcFlow.f("master_page_onload_start");
            UbcFlowEvent f5 = hybridUbcFlow.f("video_fe_init");
            UbcFlowEvent f6 = hybridUbcFlow.f("video_fe_init_end");
            if (f2 != null) {
                this.f49026a.i("fe_slave_dispatch_start", z ? f2.g() : 0L);
            }
            if (f3 != null) {
                this.f49026a.i("fe_master_page_oninit_start", z ? f3.g() : 0L);
            }
            if (f4 != null) {
                this.f49026a.i("master_page_onload_start", z ? f4.g() : 0L);
            }
            if (f5 != null) {
                this.f49026a.i("video_fe_init", z ? f5.g() : 0L);
            }
            if (f6 != null) {
                this.f49026a.i("video_fe_init_end", z ? f6.g() : 0L);
            }
            this.f49026a.g("fmpArrived", z ? "1" : "0");
            if (this.f49026a.f()) {
                this.f49026a.k();
                d.a.o0.a.y0.k.f.b.f();
            }
        }
    }

    @Override // d.a.o0.a.y0.k.f.c.f, d.a.o0.a.y0.k.f.c.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f49026a.d("video_will_play")) {
                this.f49026a.h("video_play_cancel");
            }
            d();
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.f49027b, str) : invokeL.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }
}
