package com.repackage;

import android.content.Context;
import android.text.TextUtils;
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
public class ls1 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements ks1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ ls1 b;

        public a(ls1 ls1Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls1Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ls1Var;
            this.a = callbackHandler;
        }

        @Override // com.repackage.ks1
        public void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (str == null) {
                    str = "";
                    str3 = str;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("scanType", str2);
                    jSONObject.put("charSet", str3);
                    jSONObject.put("result", str);
                    hx1.i("scanCode", jSONObject.toString());
                    this.a.handleSchemeDispatchCallback(this.b.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    if (e23.b) {
                        e.printStackTrace();
                    }
                    hx1.i("scanCode", "scanCode exec fail");
                    this.a.handleSchemeDispatchCallback(this.b.c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ls1(e13 e13Var) {
        super(e13Var, "/swanAPI/scanCode");
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
                hx1.i("scanCode", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (h03Var.n0()) {
                if (e23.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String optString = hd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
                this.c = optString;
                if (TextUtils.isEmpty(optString)) {
                    hx1.i("scanCode", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                oj2.b0().a(h03Var.w(), new a(this, callbackHandler));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
