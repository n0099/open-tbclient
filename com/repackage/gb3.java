package com.repackage;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gb3 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb3(r13 r13Var) {
        super(r13Var, "/swanAPI/getAutoRotationSync");
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
                ux1.c("getAutoRotationSync", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (r23.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                ux1.c("getAutoRotationSync", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (r23.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                }
                return false;
            } else {
                try {
                    int i = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                    if (r23.b) {
                        Log.d("SwanAppAction", "getAutoRotationSync --- isRotateOn: " + i);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isRotateOn", i != 0);
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException unused) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                        if (r23.b) {
                            Log.e("SwanAppAction", "getAutoRotationSync --- json exception");
                        }
                        return false;
                    }
                } catch (Exception e) {
                    if (r23.b) {
                        e.printStackTrace();
                        Log.e("SwanAppAction", "getAutoRotationSync --- can't get setting");
                    }
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
