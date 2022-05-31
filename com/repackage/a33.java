package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m52;
import com.repackage.qy1;
import com.repackage.w23;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a33 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements w23.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uk2 b;
        public final /* synthetic */ qy1 c;
        public final /* synthetic */ hp2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ a33 i;

        /* renamed from: com.repackage.a33$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0375a implements m52.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m52.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0375a(a aVar, m52.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = eVar;
                this.b = jSONObject;
            }

            @Override // com.repackage.m52.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ns2.e(this.a, this.c.a);
                    nl1 nl1Var = this.a.a;
                    a aVar = this.c;
                    q23.e(nl1Var, aVar.d, aVar.a);
                    ns2.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(a33 a33Var, String str, uk2 uk2Var, qy1 qy1Var, hp2 hp2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a33Var, str, uk2Var, qy1Var, hp2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = a33Var;
            this.a = str;
            this.b = uk2Var;
            this.c = qy1Var;
            this.d = hp2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.repackage.w23.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ns2.d(this.a);
                this.b.o();
                py1 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.v3(this.d.d))) {
                    JSONObject c = q23.c(l.v3(this.d.d));
                    ns2.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                m52.e f = m52.f(this.b.getActivity(), r52.c(this.d.d));
                JSONObject c2 = q23.c(str);
                HybridUbcFlow q = ms2.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f.b ? "1" : "0");
                m52.q(f, new C0375a(this, f, c2));
            }
        }

        @Override // com.repackage.w23.e
        public void c(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                this.b.o();
                if (e13.b) {
                    Context context = this.g;
                    zy2.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01a1) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    q23.j(this.f, this.e, this.h);
                }
                v53.j(this.d, ab3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qy1 a;
        public final /* synthetic */ hp2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a33 d;

        public b(a33 a33Var, qy1 qy1Var, hp2 hp2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a33Var, qy1Var, hp2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a33Var;
            this.a = qy1Var;
            this.b = hp2Var;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.m(this.a, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a33(e03 e03Var) {
        super(e03Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (e13.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            String o = q23.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hw1.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = hc3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            uk2 U = uk2.U();
            qy1 V = U.V();
            if (V == null) {
                hw1.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hp2 d = hp2.d(o, U.z());
            d.e = "4";
            d.f = uuid;
            v53.g(d);
            if (!bd3.c(U.s(), d)) {
                hw1.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v53.i(d);
                return false;
            }
            String n = q23.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = ms2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            w23.g(hz2Var, d, "", new a(this, uuid, U, V, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            hw1.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(qy1 qy1Var, hp2 hp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qy1Var, hp2Var, str) == null) {
            py1.R3(bd3.n());
            qy1.b i = qy1Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(hp2Var).b();
            ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ns2.a(str, hp2Var);
        }
    }

    public final void n(qy1 qy1Var, hp2 hp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, qy1Var, hp2Var, str) == null) {
            if (bd3.O()) {
                m(qy1Var, hp2Var, str);
            } else {
                bd3.a0(new b(this, qy1Var, hp2Var, str));
            }
        }
    }
}
