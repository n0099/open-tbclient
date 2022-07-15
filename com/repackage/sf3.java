package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sf3 extends g13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sf3(e13 e13Var) {
        super(e13Var, "/swanAPI/animView");
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
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g13
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    @Override // com.repackage.g13
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            cw1 q = q(unitedSchemeEntity);
            if (q == null) {
                n73.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                n73.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, h03Var);
                if (TextUtils.isEmpty(r)) {
                    n73.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (ul2.U().N()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        n73.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (e23.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                yv1 insert = new bw1(context, q, r).insert();
                boolean a = insert.a();
                hx1.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    n73.b("animView", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "insert anim view, but failure: " + insert.b, 1001, "insert anim view, but failure: " + insert.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
                    hx1.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g13
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            cw1 q = q(unitedSchemeEntity);
            if (q == null) {
                n73.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                n73.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                bw1 bw1Var = (bw1) uw1.a(q);
                if (bw1Var == null) {
                    n73.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    hx1.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                yv1 B = bw1Var.B();
                boolean a = B.a();
                hx1.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    n73.b("animView", 2001, "remove anim view, but failure: " + B.b, 1001, "remove anim view, but failure: " + B.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
                    hx1.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g13
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            cw1 q = q(unitedSchemeEntity);
            if (q == null) {
                n73.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                n73.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                bw1 bw1Var = (bw1) uw1.a(q);
                if (bw1Var == null) {
                    n73.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    hx1.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                yv1 update = bw1Var.update((bw1) q);
                boolean a = update.a();
                hx1.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    n73.b("animView", 2001, "update anim view, but failure: " + update.b, 1001, "update anim view, but failure: " + update.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                    hx1.c("AbsSwanAppWidget", "update anim view, but failure: " + update.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final cw1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("SwanAppAction", "params is null");
                return null;
            }
            cw1 cw1Var = new cw1();
            try {
                cw1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                hx1.d("SwanAppAction", "model parse exception:", e);
            }
            return cw1Var;
        }
        return (cw1) invokeL.objValue;
    }

    public final String r(String str, h03 h03Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, h03Var)) == null) {
            if (!TextUtils.isEmpty(str) && h03Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = p73.M(str, h03Var.b);
                    } else {
                        L = p73.L(str, h03Var, h03Var.k0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (jg4.y(file)) {
                        return jg4.E(file);
                    }
                    return null;
                } catch (Exception e) {
                    if (e23.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
