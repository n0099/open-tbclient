package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wf1 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* loaded from: classes7.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ wf1 g;

        public a(wf1 wf1Var, hz2 hz2Var, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf1Var, hz2Var, context, Boolean.valueOf(z), str, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = wf1Var;
            this.a = hz2Var;
            this.b = context;
            this.c = z;
            this.d = str;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                boolean e = this.a.M().e(this.b);
                if (!f43.h(k43Var)) {
                    if (!e && !this.c) {
                        a63.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 4, this.d);
                    }
                    f43.q(k43Var, this.e, this.g.c);
                    return;
                }
                if (e && !this.c) {
                    a63.S("success", 4, this.d);
                }
                this.g.l(this.b, this.f, this.e, this.a, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ wf1 c;

        public b(wf1 wf1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf1Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wf1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
        }

        @Override // com.repackage.xf1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), this.c.c);
                } else {
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), this.c.c);
                }
            }
        }

        @Override // com.repackage.xf1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.c.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf1(e03 e03Var) {
        super(e03Var, "/swanAPI/chooseAddress");
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
            if (hz2Var == null) {
                hw1.i("ChooseAddress", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (hz2Var.m0()) {
                if (e13.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject m = m(unitedSchemeEntity.getParam("params"));
                String optString = m.optString("cb");
                this.c = optString;
                if (TextUtils.isEmpty(optString)) {
                    hw1.i("ChooseAddress", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = m.optString("invokeFrom");
                boolean e = hz2Var.M().e(context);
                if (!e) {
                    a63.S("show", 4, optString2);
                }
                hz2Var.d0().h(context, "mapp_choose_address", f43.j(m), new a(this, hz2Var, context, e, optString2, callbackHandler, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, hz2Var, str) == null) {
            oi2.j0().a(context, hz2Var.b, hz2Var.N(), new b(this, callbackHandler, unitedSchemeEntity));
        }
    }

    public final JSONObject m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (e13.b) {
                    Log.w("SwanAppAction", "JSONObject parsed error!!", e);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
