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
import com.repackage.oq1;
import com.repackage.t93;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u93 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements t93.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ zq1 c;
        public final /* synthetic */ u93 d;

        public a(u93 u93Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zq1 zq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u93Var, unitedSchemeEntity, callbackHandler, zq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = u93Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = zq1Var;
        }

        @Override // com.repackage.t93.a
        public void a(double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                if (dArr != null && dArr.length == 3) {
                    hx1.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    this.d.k(this.a, this.b, this.c, dArr);
                    return;
                }
                hx1.c("accelerometer", "illegal accelerometers");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u93(e13 e13Var) {
        super(e13Var, "/swanAPI/startAccelerometer");
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
            if (h03Var == null) {
                hx1.c("accelerometer", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (e23.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                hx1.c("accelerometer", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (e23.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (e23.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                    }
                    hx1.c("accelerometer", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (e23.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                    }
                    hx1.c("accelerometer", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                hx1.i("accelerometer", " init ");
                zq1 zq1Var = new zq1("accelerometerChange", optParamsAsJo, optString);
                t93 a2 = t93.a();
                a2.b(context, oq1.b.a(optParamsAsJo.optString("interval")));
                a2.e(new a(this, unitedSchemeEntity, callbackHandler, zq1Var));
                a2.f();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                zq1Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zq1 zq1Var, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, zq1Var, dArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", dArr[0]);
                jSONObject.put("y", dArr[1]);
                jSONObject.put("z", dArr[2]);
                zq1Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                hx1.c("accelerometer", "handle compass,json error，" + e.toString());
                zq1Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
