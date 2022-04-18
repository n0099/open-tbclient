package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
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
public class uf3 extends i13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf3(g13 g13Var) {
        super(g13Var, "/swanAPI/animView");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.i13
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    @Override // com.repackage.i13
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, j03 j03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, j03Var)) == null) {
            ew1 q = q(unitedSchemeEntity);
            if (q == null) {
                p73.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                p73.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, j03Var);
                if (TextUtils.isEmpty(r)) {
                    p73.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (wl2.U().N()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        p73.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (g23.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                aw1 insert = new dw1(context, q, r).insert();
                boolean a = insert.a();
                jx1.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    p73.b("animView", 2009, "insert anim view, but failure: " + insert.b, 1001, "insert anim view, but failure: " + insert.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
                    jx1.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.i13
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, j03 j03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, j03Var)) == null) {
            ew1 q = q(unitedSchemeEntity);
            if (q == null) {
                p73.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                p73.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                dw1 dw1Var = (dw1) ww1.a(q);
                if (dw1Var == null) {
                    p73.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    jx1.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                aw1 B = dw1Var.B();
                boolean a = B.a();
                jx1.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    p73.b("animView", 2001, "remove anim view, but failure: " + B.b, 1001, "remove anim view, but failure: " + B.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
                    jx1.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.i13
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, j03 j03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, j03Var)) == null) {
            ew1 q = q(unitedSchemeEntity);
            if (q == null) {
                p73.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                p73.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                dw1 dw1Var = (dw1) ww1.a(q);
                if (dw1Var == null) {
                    p73.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    jx1.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                aw1 update = dw1Var.update((dw1) q);
                boolean a = update.a();
                jx1.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    p73.b("animView", 2001, "update anim view, but failure: " + update.b, 1001, "update anim view, but failure: " + update.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                    jx1.c("AbsSwanAppWidget", "update anim view, but failure: " + update.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final ew1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("SwanAppAction", "params is null");
                return null;
            }
            ew1 ew1Var = new ew1();
            try {
                ew1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                jx1.d("SwanAppAction", "model parse exception:", e);
            }
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }

    public final String r(String str, j03 j03Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, j03Var)) == null) {
            if (!TextUtils.isEmpty(str) && j03Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = r73.M(str, j03Var.b);
                    } else {
                        L = r73.L(str, j03Var, j03Var.j0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (mg4.y(file)) {
                        return mg4.E(file);
                    }
                    return null;
                } catch (Exception e) {
                    if (g23.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
