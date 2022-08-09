package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a33 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a33(w13 w13Var) {
        super(w13Var, "/swanAPI/setBackgroundColor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w13Var};
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

    @Override // com.repackage.w23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, z03Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                zx1.c(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (w23.b) {
                Log.d(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, optParamsAsJo.toString());
            }
            i02 V = mm2.U().V();
            if (V == null) {
                zx1.c(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = optParamsAsJo.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
            if (TextUtils.isEmpty(optString) && (!TextUtils.isEmpty(optParamsAsJo.optString("backgroundColorTop")) || !TextUtils.isEmpty(optParamsAsJo.optString("backgroundColorBottom")))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101);
                return false;
            }
            h02 o = V.o();
            if (o == null) {
                zx1.c(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "slave container is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals("7", o.N1().l())) {
                zx1.c(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "this page is from showModalPage api");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
                return false;
            } else if (!o.L2(o.x3(), SwanAppConfigData.t(optString), true)) {
                zx1.c(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "set window background fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
