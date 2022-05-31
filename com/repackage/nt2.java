package com.repackage;

import android.os.Bundle;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mh2;
/* loaded from: classes6.dex */
public class nt2 implements ae3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ae3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nt2 nt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || nt2.a(hybridUbcFlow)) {
                return;
            }
            long f = hybridUbcFlow.f("na_first_meaningful_paint", "naStart");
            if (f <= 0) {
                f = hybridUbcFlow.f("na_first_paint", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("slave_first_rendered", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("fe_page_show", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("na_page_show", "naStart");
            }
            if (f <= 0) {
                f = hybridUbcFlow.f("na_receive_intent", "naStart");
            }
            if (f <= 0) {
                f = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("property_launch_cost", f);
            xv2 e = xv2.e();
            zv2 zv2Var = new zv2(20, bundle);
            zv2Var.f(true);
            e.h(zv2Var);
            us2.j().c(f);
            kt2.e().f();
        }
    }

    public nt2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridUbcFlow)) == null) ? hybridUbcFlow.p("performanceEnd") && !hybridUbcFlow.p("na_first_meaningful_paint") : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ae3
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            hybridUbcFlow.J("670");
            hybridUbcFlow.D("preload_scene", "1");
            hybridUbcFlow.E("from", "swan");
            hybridUbcFlow.H("component_reporter", new is2());
            hybridUbcFlow.H("component_reporter", new lr2());
            hybridUbcFlow.H("component_reporter", new fs2());
            hybridUbcFlow.H("component_reporter", new ks2());
            hybridUbcFlow.H("callback_on_submit", new mh2.a());
            hybridUbcFlow.H("fmp_callback", new qt2("fmp_callback"));
            hybridUbcFlow.H("fmp_callback", new eu2());
            hybridUbcFlow.H("callback_on_submit", new qt2("callback_on_submit"));
            hybridUbcFlow.H("callback_on_submit", new fb3());
            hybridUbcFlow.H("callback_on_submit", new a(this));
        }
    }
}
