package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rm2 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm2(g13 g13Var) {
        super(g13Var, "/swanAPI/map");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (g23.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.g23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, j03 j03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, j03Var)) == null) {
            if (g23.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            jx1.i("map", "handleSubAction " + str);
            sm2 a = sm2.a(unitedSchemeEntity, callbackHandler);
            char c = 65535;
            switch (str.hashCode()) {
                case -2079680864:
                    if (str.equals("/swanAPI/map/translateMarker")) {
                        c = 3;
                        break;
                    }
                    break;
                case -2068557416:
                    if (str.equals("/swanAPI/map/getCenterLocation")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -398143716:
                    if (str.equals("/swanAPI/map/getScale")) {
                        c = 7;
                        break;
                    }
                    break;
                case 51993511:
                    if (str.equals("/swanAPI/map/openLocation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 379323012:
                    if (str.equals("/swanAPI/map/create")) {
                        c = 0;
                        break;
                    }
                    break;
                case 515840866:
                    if (str.equals("/swanAPI/map/getRegion")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 797006348:
                    if (str.equals("/swanAPI/map/remove")) {
                        c = 2;
                        break;
                    }
                    break;
                case 892770897:
                    if (str.equals("/swanAPI/map/update")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1007473955:
                    if (str.equals("/swanAPI/map/includePoints")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1142165295:
                    if (str.equals("/swanAPI/map/openWalkNavigation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1256916873:
                    if (str.equals("/swanAPI/map/moveToLocation")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1475857524:
                    if (str.equals("/swanAPI/map/chooseLocation")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    vm2 j = j(unitedSchemeEntity, vm2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return qj2.J().g(context, j, a, j03Var);
                case 1:
                    vm2 j2 = j(unitedSchemeEntity, vm2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return qj2.J().update(context, j2, a, j03Var);
                case 2:
                    vm2 j3 = j(unitedSchemeEntity, vm2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return qj2.J().l(context, j3, a, j03Var);
                case 3:
                    ym2 ym2Var = (ym2) j(unitedSchemeEntity, ym2.class);
                    if (k(ym2Var, a)) {
                        return false;
                    }
                    return qj2.J().j(context, ym2Var, a, j03Var);
                case 4:
                    xm2 xm2Var = (xm2) j(unitedSchemeEntity, xm2.class);
                    if (k(xm2Var, a)) {
                        return false;
                    }
                    return qj2.J().h(context, xm2Var, a, j03Var);
                case 5:
                    vm2 j4 = j(unitedSchemeEntity, vm2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return qj2.J().m(context, j4, a, j03Var);
                case 6:
                    um2 um2Var = (um2) j(unitedSchemeEntity, um2.class);
                    if (k(um2Var, a)) {
                        return false;
                    }
                    return qj2.J().b(context, um2Var, a, j03Var);
                case 7:
                    vm2 j5 = j(unitedSchemeEntity, vm2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return qj2.J().c(context, j5, a, j03Var);
                case '\b':
                    vm2 j6 = j(unitedSchemeEntity, vm2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return qj2.J().n(context, j6, a, j03Var);
                case '\t':
                    vm2 j7 = j(unitedSchemeEntity, vm2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return qj2.J().k(context, j7, a, j03Var);
                case '\n':
                    tm2 tm2Var = (tm2) j(unitedSchemeEntity, tm2.class);
                    if (k(tm2Var, a)) {
                        return false;
                    }
                    return qj2.J().e(context, tm2Var, a, j03Var);
                case 11:
                    zm2 zm2Var = (zm2) j(unitedSchemeEntity, zm2.class);
                    if (k(zm2Var, a)) {
                        return false;
                    }
                    return qj2.J().a(context, zm2Var, a, j03Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, j03Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends vm2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        T newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, cls)) == null) {
            T t = null;
            if (unitedSchemeEntity == null) {
                return null;
            }
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (params != null && !params.isEmpty()) {
                String str = params.get("params");
                if (str == null) {
                    jx1.c("map", "params string is empty");
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str);
                    newInstance = cls.newInstance();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    newInstance.a(jSONObject);
                    return newInstance;
                } catch (Exception e2) {
                    e = e2;
                    t = newInstance;
                    e.printStackTrace();
                    jx1.c("map", "params json parse error");
                    return t;
                }
            }
            jx1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(vm2 vm2Var, sm2 sm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vm2Var, sm2Var)) == null) {
            if (vm2Var == null) {
                jx1.c("map", "parse error, model is null");
                sm2Var.d(202);
                return true;
            }
            if (i03.J().r().x0()) {
                vm2Var.c = bg3.c().h();
            }
            if (TextUtils.isEmpty(vm2Var.c)) {
                String B = de3.B();
                if (!TextUtils.isEmpty(B)) {
                    vm2Var.c = B;
                }
                jx1.o("map", "webView id is empty, use current webView");
            }
            if (de3.m(vm2Var.c) == null) {
                sm2Var.d(202);
                jx1.c("map", "can not find weiView by id " + vm2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
