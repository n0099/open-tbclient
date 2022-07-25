package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
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
public class mn2 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mn2(f13 f13Var) {
        super(f13Var, "/swanAPI/backgroundAudio");
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
            if (unitedSchemeEntity != null) {
                ln2.b("AudioBGPlayerAction", "#handle entity.uri=" + unitedSchemeEntity.getUri());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.f23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, i03 i03Var) {
        InterceptResult invokeLLLLL;
        in2 b;
        char c;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, i03Var)) == null) {
            if (i03Var == null) {
                o73.b("audio", 2001, "SwanApp is null", 1001, "SwanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ln2.b("AudioBGPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            JSONObject j = j(unitedSchemeEntity.getParam("params"));
            if (j == null) {
                o73.b("audio", 2001, "param is null", 201, "param is null");
                ix1.c("backgroundAudio", "param is null!");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            kn2 P = i03Var.P();
            if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
                b = in2.b(j, new in2());
            } else {
                b = in2.b(j, P.q());
            }
            ln2.b("AudioBGPlayerAction", "#handleSubAction playerParams=" + b);
            JSONObject jSONObject = null;
            switch (str.hashCode()) {
                case 312101659:
                    if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 335869926:
                    if (str.equals("/swanAPI/backgroundAudio/open")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 335895760:
                    if (str.equals("/swanAPI/backgroundAudio/play")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 335978516:
                    if (str.equals("/swanAPI/backgroundAudio/seek")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 335993246:
                    if (str.equals("/swanAPI/backgroundAudio/stop")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 820188005:
                    if (str.equals("/swanAPI/backgroundAudio/update")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822525402:
                    if (str.equals("/swanAPI/backgroundAudio/pause")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    ix1.i("backgroundAudio", "open, audioId " + b.a);
                    P.z(b, callbackHandler);
                    z = true;
                    break;
                case 1:
                    ix1.i("backgroundAudio", "update, audioId " + b.a);
                    P.update(b);
                    z = true;
                    break;
                case 2:
                    ix1.i("backgroundAudio", "play, audioId " + b.a);
                    P.F();
                    z = true;
                    break;
                case 3:
                    ix1.i("backgroundAudio", "pause, audioId " + b.a);
                    P.A();
                    z = true;
                    break;
                case 4:
                    ix1.i("backgroundAudio", "seek, audioId " + b.a + " position " + b.l);
                    P.G(b.l);
                    z = true;
                    break;
                case 5:
                    ix1.i("backgroundAudio", "stop, audioId " + b.a);
                    P.L();
                    z = true;
                    break;
                case 6:
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(b.m, P.t(b.m));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException e) {
                        o73.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "json exception", -1, "");
                        ix1.c("backgroundAudio", "getParams error " + e.toString());
                        ln2.c("backgroundAudio", "getParamsSync error", e);
                        break;
                    }
                default:
                    z = false;
                    break;
            }
            ln2.b("AudioBGPlayerAction", "#handleSubAction invokeSuccess=" + z);
            if (z) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            return super.i(context, unitedSchemeEntity, callbackHandler, str, i03Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e) {
                    if (f23.b) {
                        Log.d("AudioBGPlayerAction", Log.getStackTraceString(e));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
