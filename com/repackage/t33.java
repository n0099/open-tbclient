package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qz1;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class t33 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t33(e13 e13Var) {
        super(e13Var, "/swanAPI/navigateBack");
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
        int optInt;
        hq2 hq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            String str = unitedSchemeEntity.getParams().get("params");
            if (TextUtils.isEmpty(str)) {
                optInt = 1;
            } else {
                try {
                    optInt = new JSONObject(str).optInt("delta", 1);
                } catch (JSONException e) {
                    if (e23.b) {
                        e.printStackTrace();
                    }
                    hx1.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            }
            qz1 V = ul2.U().V();
            if (V == null) {
                hx1.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = V.k();
            if (e23.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                hx1.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (e23.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            nz1 j = V.j((k - optInt) - 1);
            if (j instanceof pz1) {
                hq2Var = ((pz1) j).m3();
                hq2Var.e = "1";
                hq2Var.f = uuid;
            } else {
                hq2Var = null;
            }
            v63.g(hq2Var);
            nt2.c(1, uuid);
            rc3.a(V, context);
            qz1.b i = V.i("navigateBack");
            i.n(qz1.i, qz1.h);
            i.h(optInt);
            i.a();
            pz1 o = V.o();
            hq2 m3 = o != null ? o.m3() : null;
            mt2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(uuid, m3);
            if (!(V.m() instanceof pz1)) {
                hx1.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v63.i(hq2Var);
                return false;
            }
            pz1 pz1Var = (pz1) V.m();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(q33.c(pz1Var != null ? pz1Var.t3() : ""), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
