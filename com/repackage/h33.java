package com.repackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h33 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h33(e13 e13Var) {
        super(e13Var, "/swanAPI/getMenuButtonBoundingClientRect");
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (e23.b) {
                Log.d("GetMenuButtonBounding", "handle entity: " + unitedSchemeEntity.toString());
            }
            qz1 V = ul2.U().V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            nz1 m = V.m();
            if (m == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (h03Var.w0()) {
                View q = pj2.i().q(m);
                if (q == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(q);
                return true;
            } else {
                SwanAppActionBar K1 = m.K1();
                if (K1 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                View rightMenu = K1.getRightMenu();
                if (rightMenu == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                unitedSchemeEntity.result = j(rightMenu);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject j(View view2) {
        InterceptResult invokeL;
        JSONObject wrapCallbackParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            h03 M = h03.M();
            int P = M != null ? M.w0() : false ? 0 : (int) (yd3.P(yd3.t()) + 0.5f);
            int P2 = (int) (yd3.P(view2.getLeft()) + 0.5f);
            int P3 = (int) (yd3.P(view2.getRight()) + 0.5f);
            int P4 = ((int) (yd3.P(view2.getTop()) + 0.5f)) + P;
            int P5 = ((int) (yd3.P(view2.getBottom()) + 0.5f)) + P;
            int i = P3 - P2;
            int i2 = P5 - P4;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", i);
                jSONObject.put("height", i2);
                jSONObject.put("left", P2);
                jSONObject.put("right", P3);
                jSONObject.put("top", P4);
                jSONObject.put("bottom", P5);
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            } catch (JSONException e) {
                if (e23.b) {
                    e.printStackTrace();
                }
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
            }
            if (e23.b) {
                Log.e("GetMenuButtonBounding", wrapCallbackParams.toString());
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeL.objValue;
    }
}
