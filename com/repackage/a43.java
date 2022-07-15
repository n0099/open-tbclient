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
import com.repackage.m62;
import com.repackage.qz1;
import com.repackage.w33;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a43 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements w33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ul2 b;
        public final /* synthetic */ qz1 c;
        public final /* synthetic */ hq2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ a43 i;

        /* renamed from: com.repackage.a43$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0587a implements m62.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m62.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0587a(a aVar, m62.e eVar, JSONObject jSONObject) {
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

            @Override // com.repackage.m62.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    nt2.e(this.a, this.c.a);
                    nm1 nm1Var = this.a.a;
                    a aVar = this.c;
                    q33.e(nm1Var, aVar.d, aVar.a);
                    nt2.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(a43 a43Var, String str, ul2 ul2Var, qz1 qz1Var, hq2 hq2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a43Var, str, ul2Var, qz1Var, hq2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = a43Var;
            this.a = str;
            this.b = ul2Var;
            this.c = qz1Var;
            this.d = hq2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.repackage.w33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                nt2.d(this.a);
                this.b.o();
                pz1 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.w3(this.d.d))) {
                    JSONObject c = q33.c(l.w3(this.d.d));
                    nt2.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                m62.e f = m62.f(this.b.getActivity(), r62.c(this.d.d));
                JSONObject c2 = q33.c(str);
                HybridUbcFlow q = mt2.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f.b ? "1" : "0");
                m62.q(f, new C0587a(this, f, c2));
            }
        }

        @Override // com.repackage.w33.e
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                this.b.o();
                if (e23.b) {
                    Context context = this.g;
                    zz2.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01a3) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    q33.j(this.f, this.e, this.h);
                }
                v63.j(this.d, ac3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;
        public final /* synthetic */ hq2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a43 d;

        public b(a43 a43Var, qz1 qz1Var, hq2 hq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a43Var, qz1Var, hq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a43Var;
            this.a = qz1Var;
            this.b = hq2Var;
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
    public a43(e13 e13Var) {
        super(e13Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
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

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            String o = q33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hx1.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = hd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            ul2 U = ul2.U();
            qz1 V = U.V();
            if (V == null) {
                hx1.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hq2 d = hq2.d(o, U.z());
            d.e = "4";
            d.f = uuid;
            v63.g(d);
            if (!be3.c(U.s(), d)) {
                hx1.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v63.i(d);
                return false;
            }
            String n = q33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = mt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            w33.g(h03Var, d, "", new a(this, uuid, U, V, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            hx1.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(qz1 qz1Var, hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qz1Var, hq2Var, str) == null) {
            pz1.S3(be3.n());
            qz1.b i = qz1Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(hq2Var).b();
            mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(str, hq2Var);
        }
    }

    public final void n(qz1 qz1Var, hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, qz1Var, hq2Var, str) == null) {
            if (be3.O()) {
                m(qz1Var, hq2Var, str);
            } else {
                be3.a0(new b(this, qz1Var, hq2Var, str));
            }
        }
    }
}
