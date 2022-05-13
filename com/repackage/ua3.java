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
import com.repackage.ta3;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ua3 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ta3.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ mr1 c;
        public final /* synthetic */ ua3 d;

        public a(ua3 ua3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, mr1 mr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua3Var, unitedSchemeEntity, callbackHandler, mr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ua3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = mr1Var;
        }

        @Override // com.repackage.ta3.c
        public void a(float f, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                ux1.i("compass", "handle compass change, angle:" + f + ",accuracy: " + i);
                this.d.k(this.a, this.b, this.c, f, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua3(r13 r13Var) {
        super(r13Var, "/swanAPI/startCompass");
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
            if (u03Var == null) {
                ux1.c("compass", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (r23.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                ux1.c("compass", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (r23.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (r23.b) {
                        Log.d("SwanAppAction", "startCompass --- params is empty");
                    }
                    ux1.c("compass", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (r23.b) {
                        Log.d("SwanAppAction", "startCompass --- cb is empty");
                    }
                    ux1.c("compass", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                ux1.i("compass", "init");
                mr1 mr1Var = new mr1("compassChange", optParamsAsJo, optString);
                ta3 i = ta3.i();
                i.l(context);
                i.o(new a(this, unitedSchemeEntity, callbackHandler, mr1Var));
                ux1.i("compass", "start listen compass");
                i.p();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                mr1Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, mr1 mr1Var, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, mr1Var, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("direction", f);
                jSONObject.put("accuracy", ta3.h(i));
                if (r23.b) {
                    Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
                }
                mr1Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                ux1.c("compass", "handle compass,json error，" + e.toString());
                mr1Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
