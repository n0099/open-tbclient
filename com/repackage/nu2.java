package com.repackage;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mi2;
/* loaded from: classes6.dex */
public class nu2 implements af3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nu2 nu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu2Var};
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) || nu2.b(hybridUbcFlow)) {
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
            xw2 e = xw2.e();
            zw2 zw2Var = new zw2(20, bundle);
            zw2Var.f(true);
            e.h(zw2Var);
            ut2.j().c(f);
            ku2.e().f();
        }
    }

    public nu2() {
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

    public static boolean b(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridUbcFlow)) == null) ? hybridUbcFlow.p("performanceEnd") && !hybridUbcFlow.p("na_first_meaningful_paint") : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.af3
    /* renamed from: c */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            hybridUbcFlow.J("670");
            hybridUbcFlow.D("preload_scene", "1");
            hybridUbcFlow.E("from", "swan");
            hybridUbcFlow.H("component_reporter", new it2());
            hybridUbcFlow.H("component_reporter", new ls2());
            hybridUbcFlow.H("component_reporter", new ft2());
            hybridUbcFlow.H("component_reporter", new kt2());
            hybridUbcFlow.H("callback_on_submit", new mi2.a());
            hybridUbcFlow.H("fmp_callback", new qu2("fmp_callback"));
            hybridUbcFlow.H("fmp_callback", new ev2());
            hybridUbcFlow.H("callback_on_submit", new qu2("callback_on_submit"));
            hybridUbcFlow.H("callback_on_submit", new fc3());
            hybridUbcFlow.H("callback_on_submit", new a(this));
        }
    }
}
