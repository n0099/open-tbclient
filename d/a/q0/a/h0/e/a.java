package d.a.q0.a.h0.e;

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
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.g1.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/sConsole");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        boolean optBoolean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("ConsoleAction", "handleSubAction subAction: " + str);
            }
            if (!d.a.q0.a.e0.a.a() && !d.a.q0.a.e0.d.d() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1923550429:
                    if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1792428120:
                    if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -797920904:
                    if (str.equals("/swanAPI/sConsole/hide")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -797593805:
                    if (str.equals("/swanAPI/sConsole/show")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -161927599:
                    if (str.equals("/swanAPI/sConsole/postMessage")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1089933937:
                    if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2136057821:
                    if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (optParamsAsJo != null && (optBoolean = optParamsAsJo.optBoolean("enableDebug")) != d.a.q0.a.e0.a.a()) {
                        d.a.q0.a.e0.a.c(context, optBoolean);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        d.a.q0.a.e0.d.g("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                    }
                    return true;
                case 1:
                    f.V().q().R(true);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    d.a.q0.a.e0.d.g("ConsoleAction", "sConsole show");
                    return true;
                case 2:
                    f.V().q().R(false);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    d.a.q0.a.e0.d.g("ConsoleAction", "sConsole hide");
                    return true;
                case 3:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        d.a.q0.a.e0.d.g("ConsoleAction", "send san inc data");
                        b.d(optParamsAsJo.toString());
                    } else {
                        d.a.q0.a.e0.d.b("ConsoleAction", "san inc data is null");
                    }
                    return true;
                case 4:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        d.a.q0.a.e0.d.g("ConsoleAction", "send san full data");
                        b.c(optParamsAsJo.toString());
                    } else {
                        d.a.q0.a.e0.d.b("ConsoleAction", "san full data is null");
                    }
                    return true;
                case 5:
                    d.a.q0.a.e0.d.g("ConsoleAction", "request san full data");
                    b.b();
                    return true;
                case 6:
                    d.a.q0.a.p.b.a.f h2 = d.a.q0.a.c1.b.h();
                    if (h2 != null) {
                        h2.c(optParamsAsJo);
                    }
                    return true;
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
