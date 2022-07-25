package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n53;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u43 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ u43 f;

        public a(u43 u43Var, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u43Var, callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u43Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = activity;
            this.d = str2;
            this.e = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    if (f23.b) {
                        Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                    }
                    this.f.m(this.a, this.b, this.c, this.d, this.e, false);
                    return;
                }
                ix1.k("SwanAppAction", "onCallback: no permission scope_mobile_api");
                b73.U(this.e, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no permission ");
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bf3<u53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ u43 h;

        public b(u43 u43Var, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u43Var, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = u43Var;
            this.a = activity;
            this.b = z;
            this.c = str;
            this.d = callbackHandler;
            this.e = str2;
            this.f = str3;
            this.g = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u53Var) == null) {
                ix1.b("OpenData", "onOpenDataCallback:: ", u53Var);
                i03 c = this.h.c();
                if (!u53Var.D()) {
                    if (c != null && !c.N().e(this.a) && !this.b) {
                        b73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 2, this.c);
                    }
                    if (f23.b) {
                        Log.i("SwanAppAction", "onCallback: no open datamobile");
                    }
                    g53.n(u53Var, this.d, this.e);
                    b73.U(this.f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no open data");
                    if (this.g) {
                        b73.s("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        return;
                    }
                    return;
                }
                ix1.k("SwanAppAction", "onCallback: got open datamobile");
                if (c != null && c.N().e(this.a) && !this.b) {
                    b73.S("success", 2, this.c);
                }
                b73.T(this.f, "success");
                if (this.g) {
                    b73.s("click", "telLogin", "succ_agree");
                }
                this.d.handleSchemeDispatchCallback(this.e, UnitedSchemeUtility.wrapCallbackParams(u53Var.g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u43(f13 f13Var) {
        super(f13Var, "/swanAPI/getPhoneNumber");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f13Var};
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

    @Override // com.repackage.f23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (i03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("invokeFrom");
            String str = optString.equals(NativeConstants.COMPONENT) ? "getPhoneNumberButton" : "getPhoneNumberApi";
            b73.T(str, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                b73.U(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return false;
            }
            SwanAppActivity w = h03.K().w();
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                b73.U(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                return false;
            }
            if (!i03Var.N().e(context)) {
                b73.S("show", 2, optString);
            }
            if (optParamsAsJo.optString("invokeFrom").equals("api")) {
                n(callbackHandler, optString2, w, optString, str);
            } else {
                m(callbackHandler, optString2, w, optString, str, TextUtils.equals("login", optParamsAsJo.optString("from")));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callbackHandler, str, activity, str2, str3, Boolean.valueOf(z)}) == null) {
            boolean e = h03.K().q().N().e(activity);
            b73.T(str3, "checkScope");
            if (z) {
                b73.s("show", "telLogin", null);
            }
            u53.B(activity, "mobile", null, false, str3, new b(this, activity, e, str2, callbackHandler, str, str3, z));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            b73.T(str3, "checkScope");
            h03.K().q().e0().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
