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
import com.repackage.d02;
import com.repackage.j43;
import com.repackage.z62;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n43 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements j43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hm2 b;
        public final /* synthetic */ d02 c;
        public final /* synthetic */ uq2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ n43 i;

        /* renamed from: com.repackage.n43$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0472a implements z62.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z62.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0472a(a aVar, z62.e eVar, JSONObject jSONObject) {
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

            @Override // com.repackage.z62.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    au2.e(this.a, this.c.a);
                    an1 an1Var = this.a.a;
                    a aVar = this.c;
                    d43.e(an1Var, aVar.d, aVar.a);
                    au2.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(n43 n43Var, String str, hm2 hm2Var, d02 d02Var, uq2 uq2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n43Var, str, hm2Var, d02Var, uq2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = n43Var;
            this.a = str;
            this.b = hm2Var;
            this.c = d02Var;
            this.d = uq2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.repackage.j43.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                au2.d(this.a);
                this.b.o();
                c02 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.v3(this.d.d))) {
                    JSONObject c = d43.c(l.v3(this.d.d));
                    au2.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                z62.e f = z62.f(this.b.getActivity(), e72.c(this.d.d));
                JSONObject c2 = d43.c(str);
                HybridUbcFlow q = zt2.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f.b ? "1" : "0");
                z62.q(f, new C0472a(this, f, c2));
            }
        }

        @Override // com.repackage.j43.e
        public void c(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                this.b.o();
                if (r23.b) {
                    Context context = this.g;
                    m03.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01a0) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    d43.j(this.f, this.e, this.h);
                }
                i73.j(this.d, nc3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d02 a;
        public final /* synthetic */ uq2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ n43 d;

        public b(n43 n43Var, d02 d02Var, uq2 uq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n43Var, d02Var, uq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n43Var;
            this.a = d02Var;
            this.b = uq2Var;
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
    public n43(r13 r13Var) {
        super(r13Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (r23.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            String o = d43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ux1.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = ud3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            hm2 U = hm2.U();
            d02 V = U.V();
            if (V == null) {
                ux1.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            uq2 d = uq2.d(o, U.z());
            d.e = "4";
            d.f = uuid;
            i73.g(d);
            if (!oe3.c(U.s(), d)) {
                ux1.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                i73.i(d);
                return false;
            }
            String n = d43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = zt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            j43.g(u03Var, d, "", new a(this, uuid, U, V, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            ux1.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(d02 d02Var, uq2 uq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d02Var, uq2Var, str) == null) {
            c02.R3(oe3.n());
            d02.b i = d02Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(uq2Var).b();
            zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            au2.a(str, uq2Var);
        }
    }

    public final void n(d02 d02Var, uq2 uq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, d02Var, uq2Var, str) == null) {
            if (oe3.O()) {
                m(d02Var, uq2Var, str);
            } else {
                oe3.a0(new b(this, d02Var, uq2Var, str));
            }
        }
    }
}
