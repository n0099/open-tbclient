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
public class pl2 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pl2(e03 e03Var) {
        super(e03Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (e13.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.e13
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            hw1.i("map", "handleSubAction " + str);
            ql2 a = ql2.a(unitedSchemeEntity, callbackHandler);
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
                    tl2 j = j(unitedSchemeEntity, tl2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return oi2.J().g(context, j, a, hz2Var);
                case 1:
                    tl2 j2 = j(unitedSchemeEntity, tl2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return oi2.J().update(context, j2, a, hz2Var);
                case 2:
                    tl2 j3 = j(unitedSchemeEntity, tl2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return oi2.J().l(context, j3, a, hz2Var);
                case 3:
                    wl2 wl2Var = (wl2) j(unitedSchemeEntity, wl2.class);
                    if (k(wl2Var, a)) {
                        return false;
                    }
                    return oi2.J().j(context, wl2Var, a, hz2Var);
                case 4:
                    vl2 vl2Var = (vl2) j(unitedSchemeEntity, vl2.class);
                    if (k(vl2Var, a)) {
                        return false;
                    }
                    return oi2.J().h(context, vl2Var, a, hz2Var);
                case 5:
                    tl2 j4 = j(unitedSchemeEntity, tl2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return oi2.J().m(context, j4, a, hz2Var);
                case 6:
                    sl2 sl2Var = (sl2) j(unitedSchemeEntity, sl2.class);
                    if (k(sl2Var, a)) {
                        return false;
                    }
                    return oi2.J().b(context, sl2Var, a, hz2Var);
                case 7:
                    tl2 j5 = j(unitedSchemeEntity, tl2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return oi2.J().c(context, j5, a, hz2Var);
                case '\b':
                    tl2 j6 = j(unitedSchemeEntity, tl2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return oi2.J().n(context, j6, a, hz2Var);
                case '\t':
                    tl2 j7 = j(unitedSchemeEntity, tl2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return oi2.J().k(context, j7, a, hz2Var);
                case '\n':
                    rl2 rl2Var = (rl2) j(unitedSchemeEntity, rl2.class);
                    if (k(rl2Var, a)) {
                        return false;
                    }
                    return oi2.J().e(context, rl2Var, a, hz2Var);
                case 11:
                    xl2 xl2Var = (xl2) j(unitedSchemeEntity, xl2.class);
                    if (k(xl2Var, a)) {
                        return false;
                    }
                    return oi2.J().a(context, xl2Var, a, hz2Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, hz2Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends tl2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    hw1.c("map", "params string is empty");
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
                    hw1.c("map", "params json parse error");
                    return t;
                }
            }
            hw1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(tl2 tl2Var, ql2 ql2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tl2Var, ql2Var)) == null) {
            if (tl2Var == null) {
                hw1.c("map", "parse error, model is null");
                ql2Var.d(202);
                return true;
            }
            if (gz2.J().r().x0()) {
                tl2Var.c = ze3.c().h();
            }
            if (TextUtils.isEmpty(tl2Var.c)) {
                String B = bd3.B();
                if (!TextUtils.isEmpty(B)) {
                    tl2Var.c = B;
                }
                hw1.o("map", "webView id is empty, use current webView");
            }
            if (bd3.m(tl2Var.c) == null) {
                ql2Var.d(202);
                hw1.c("map", "can not find weiView by id " + tl2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
