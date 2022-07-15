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
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bz1 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz1(e13 e13Var) {
        super(e13Var, "/swanAPI/sConsole");
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
                Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.e23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        boolean optBoolean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            if (e23.b) {
                Log.d("ConsoleAction", "handleSubAction subAction: " + str);
            }
            if (!ex1.a() && !hx1.f() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, h03Var);
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c = 65535;
            switch (str.hashCode()) {
                case -1923550429:
                    if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1792428120:
                    if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                        c = 4;
                        break;
                    }
                    break;
                case -797920904:
                    if (str.equals("/swanAPI/sConsole/hide")) {
                        c = 2;
                        break;
                    }
                    break;
                case -797593805:
                    if (str.equals("/swanAPI/sConsole/show")) {
                        c = 1;
                        break;
                    }
                    break;
                case -161927599:
                    if (str.equals("/swanAPI/sConsole/postMessage")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1089933937:
                    if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2136057821:
                    if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (optParamsAsJo != null && (optBoolean = optParamsAsJo.optBoolean("enableDebug")) != ex1.a()) {
                        ex1.c(context, optBoolean);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        hx1.i("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                    }
                    return true;
                case 1:
                    ul2.U().q().R(true);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    hx1.i("ConsoleAction", "sConsole show");
                    return true;
                case 2:
                    ul2.U().q().R(false);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    hx1.i("ConsoleAction", "sConsole hide");
                    return true;
                case 3:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        hx1.i("ConsoleAction", "send san inc data");
                        cz1.d(optParamsAsJo.toString());
                    } else {
                        hx1.c("ConsoleAction", "san inc data is null");
                    }
                    return true;
                case 4:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        hx1.i("ConsoleAction", "send san full data");
                        cz1.c(optParamsAsJo.toString());
                    } else {
                        hx1.c("ConsoleAction", "san full data is null");
                    }
                    return true;
                case 5:
                    hx1.i("ConsoleAction", "request san full data");
                    cz1.b();
                    return true;
                case 6:
                    qh1 h = pj2.h();
                    if (h != null) {
                        h.c(optParamsAsJo);
                    }
                    return true;
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, h03Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
