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
public class qm2 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qm2(f13 f13Var) {
        super(f13Var, "/swanAPI/map");
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
            if (f23.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.f23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, i03 i03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, i03Var)) == null) {
            if (f23.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            ix1.i("map", "handleSubAction " + str);
            rm2 a = rm2.a(unitedSchemeEntity, callbackHandler);
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
                    um2 j = j(unitedSchemeEntity, um2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return pj2.J().g(context, j, a, i03Var);
                case 1:
                    um2 j2 = j(unitedSchemeEntity, um2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return pj2.J().update(context, j2, a, i03Var);
                case 2:
                    um2 j3 = j(unitedSchemeEntity, um2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return pj2.J().l(context, j3, a, i03Var);
                case 3:
                    xm2 xm2Var = (xm2) j(unitedSchemeEntity, xm2.class);
                    if (k(xm2Var, a)) {
                        return false;
                    }
                    return pj2.J().j(context, xm2Var, a, i03Var);
                case 4:
                    wm2 wm2Var = (wm2) j(unitedSchemeEntity, wm2.class);
                    if (k(wm2Var, a)) {
                        return false;
                    }
                    return pj2.J().h(context, wm2Var, a, i03Var);
                case 5:
                    um2 j4 = j(unitedSchemeEntity, um2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return pj2.J().m(context, j4, a, i03Var);
                case 6:
                    tm2 tm2Var = (tm2) j(unitedSchemeEntity, tm2.class);
                    if (k(tm2Var, a)) {
                        return false;
                    }
                    return pj2.J().b(context, tm2Var, a, i03Var);
                case 7:
                    um2 j5 = j(unitedSchemeEntity, um2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return pj2.J().c(context, j5, a, i03Var);
                case '\b':
                    um2 j6 = j(unitedSchemeEntity, um2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return pj2.J().n(context, j6, a, i03Var);
                case '\t':
                    um2 j7 = j(unitedSchemeEntity, um2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return pj2.J().k(context, j7, a, i03Var);
                case '\n':
                    sm2 sm2Var = (sm2) j(unitedSchemeEntity, sm2.class);
                    if (k(sm2Var, a)) {
                        return false;
                    }
                    return pj2.J().e(context, sm2Var, a, i03Var);
                case 11:
                    ym2 ym2Var = (ym2) j(unitedSchemeEntity, ym2.class);
                    if (k(ym2Var, a)) {
                        return false;
                    }
                    return pj2.J().a(context, ym2Var, a, i03Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, i03Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends um2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    ix1.c("map", "params string is empty");
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
                    ix1.c("map", "params json parse error");
                    return t;
                }
            }
            ix1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(um2 um2Var, rm2 rm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, um2Var, rm2Var)) == null) {
            if (um2Var == null) {
                ix1.c("map", "parse error, model is null");
                rm2Var.d(202);
                return true;
            }
            if (h03.K().q().y0()) {
                um2Var.c = ag3.c().h();
            }
            if (TextUtils.isEmpty(um2Var.c)) {
                String B = ce3.B();
                if (!TextUtils.isEmpty(B)) {
                    um2Var.c = B;
                }
                ix1.o("map", "webView id is empty, use current webView");
            }
            if (ce3.m(um2Var.c) == null) {
                rm2Var.d(202);
                ix1.c("map", "can not find weiView by id " + um2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
