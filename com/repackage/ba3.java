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
import com.repackage.aa3;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba3 extends p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements aa3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ kq1 c;
        public final /* synthetic */ ba3 d;

        public a(ba3 ba3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, kq1 kq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var, unitedSchemeEntity, callbackHandler, kq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ba3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = kq1Var;
        }

        @Override // com.repackage.aa3.b
        public void a(float[] fArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fArr) == null) && fArr != null && fArr.length == 3) {
                this.d.k(this.a, this.b, this.c, fArr);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba3(p03 p03Var) {
        super(p03Var, "/swanAPI/startDeviceMotion");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p03Var};
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

    @Override // com.repackage.p13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, sz2Var)) == null) {
            if (sz2Var == null) {
                sw1.c("StartDeviceMotionAction", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
                return false;
            } else if (context == null) {
                sw1.c("StartDeviceMotionAction", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    sw1.c("StartDeviceMotionAction", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    sw1.c("StartDeviceMotionAction", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = optParamsAsJo.optString("interval");
                if ("ui".equals(optString2)) {
                    i = 2;
                } else {
                    i = "game".equals(optString2) ? 1 : 3;
                }
                sw1.i("StartDeviceMotionAction", "startSensor===");
                kq1 kq1Var = new kq1("deviceMotionChange", optParamsAsJo, optString);
                if (!aa3.h().l(i, new a(this, unitedSchemeEntity, callbackHandler, kq1Var))) {
                    sw1.c("StartDeviceMotionAction", "start system sensor fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                kq1Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, kq1 kq1Var, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, kq1Var, fArr) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] dArr = new double[3];
            double d = fArr[0] - 1.5707963267948966d;
            if (d < 0.0d) {
                d += 6.283185307179586d;
            }
            dArr[0] = Math.toDegrees(d);
            dArr[1] = Math.toDegrees(-fArr[2]);
            dArr[2] = Math.toDegrees(-fArr[1]);
            if (p13.b) {
                Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(dArr));
            }
            try {
                jSONObject.put(AnimationProperty.OPACITY, (float) dArr[0]);
                jSONObject.put("beta", (float) dArr[1]);
                jSONObject.put("gamma", (float) dArr[2]);
                kq1Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                sw1.c("StartDeviceMotionAction", "handle orientation,json error，" + e.toString());
                kq1Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
