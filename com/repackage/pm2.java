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
/* loaded from: classes6.dex */
public class pm2 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pm2(e13 e13Var) {
        super(e13Var, "/swanAPI/map");
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
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.e23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            if (e23.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            hx1.i("map", "handleSubAction " + str);
            qm2 a = qm2.a(unitedSchemeEntity, callbackHandler);
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
                    tm2 j = j(unitedSchemeEntity, tm2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return oj2.J().g(context, j, a, h03Var);
                case 1:
                    tm2 j2 = j(unitedSchemeEntity, tm2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return oj2.J().update(context, j2, a, h03Var);
                case 2:
                    tm2 j3 = j(unitedSchemeEntity, tm2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return oj2.J().l(context, j3, a, h03Var);
                case 3:
                    wm2 wm2Var = (wm2) j(unitedSchemeEntity, wm2.class);
                    if (k(wm2Var, a)) {
                        return false;
                    }
                    return oj2.J().j(context, wm2Var, a, h03Var);
                case 4:
                    vm2 vm2Var = (vm2) j(unitedSchemeEntity, vm2.class);
                    if (k(vm2Var, a)) {
                        return false;
                    }
                    return oj2.J().h(context, vm2Var, a, h03Var);
                case 5:
                    tm2 j4 = j(unitedSchemeEntity, tm2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return oj2.J().m(context, j4, a, h03Var);
                case 6:
                    sm2 sm2Var = (sm2) j(unitedSchemeEntity, sm2.class);
                    if (k(sm2Var, a)) {
                        return false;
                    }
                    return oj2.J().b(context, sm2Var, a, h03Var);
                case 7:
                    tm2 j5 = j(unitedSchemeEntity, tm2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return oj2.J().c(context, j5, a, h03Var);
                case '\b':
                    tm2 j6 = j(unitedSchemeEntity, tm2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return oj2.J().n(context, j6, a, h03Var);
                case '\t':
                    tm2 j7 = j(unitedSchemeEntity, tm2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return oj2.J().k(context, j7, a, h03Var);
                case '\n':
                    rm2 rm2Var = (rm2) j(unitedSchemeEntity, rm2.class);
                    if (k(rm2Var, a)) {
                        return false;
                    }
                    return oj2.J().e(context, rm2Var, a, h03Var);
                case 11:
                    xm2 xm2Var = (xm2) j(unitedSchemeEntity, xm2.class);
                    if (k(xm2Var, a)) {
                        return false;
                    }
                    return oj2.J().a(context, xm2Var, a, h03Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, h03Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends tm2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    hx1.c("map", "params string is empty");
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
                    hx1.c("map", "params json parse error");
                    return t;
                }
            }
            hx1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(tm2 tm2Var, qm2 qm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tm2Var, qm2Var)) == null) {
            if (tm2Var == null) {
                hx1.c("map", "parse error, model is null");
                qm2Var.d(202);
                return true;
            }
            if (g03.K().q().y0()) {
                tm2Var.c = zf3.c().h();
            }
            if (TextUtils.isEmpty(tm2Var.c)) {
                String B = be3.B();
                if (!TextUtils.isEmpty(B)) {
                    tm2Var.c = B;
                }
                hx1.o("map", "webView id is empty, use current webView");
            }
            if (be3.m(tm2Var.c) == null) {
                qm2Var.d(202);
                hx1.c("map", "can not find weiView by id " + tm2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
