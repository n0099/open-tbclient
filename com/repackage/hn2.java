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
public class hn2 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn2(w13 w13Var) {
        super(w13Var, "/swanAPI/map");
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
            if (w23.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.w23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, z03 z03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, z03Var)) == null) {
            if (w23.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            zx1.i("map", "handleSubAction " + str);
            in2 a = in2.a(unitedSchemeEntity, callbackHandler);
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
                    ln2 j = j(unitedSchemeEntity, ln2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return gk2.J().g(context, j, a, z03Var);
                case 1:
                    ln2 j2 = j(unitedSchemeEntity, ln2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return gk2.J().update(context, j2, a, z03Var);
                case 2:
                    ln2 j3 = j(unitedSchemeEntity, ln2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return gk2.J().l(context, j3, a, z03Var);
                case 3:
                    on2 on2Var = (on2) j(unitedSchemeEntity, on2.class);
                    if (k(on2Var, a)) {
                        return false;
                    }
                    return gk2.J().j(context, on2Var, a, z03Var);
                case 4:
                    nn2 nn2Var = (nn2) j(unitedSchemeEntity, nn2.class);
                    if (k(nn2Var, a)) {
                        return false;
                    }
                    return gk2.J().h(context, nn2Var, a, z03Var);
                case 5:
                    ln2 j4 = j(unitedSchemeEntity, ln2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return gk2.J().m(context, j4, a, z03Var);
                case 6:
                    kn2 kn2Var = (kn2) j(unitedSchemeEntity, kn2.class);
                    if (k(kn2Var, a)) {
                        return false;
                    }
                    return gk2.J().b(context, kn2Var, a, z03Var);
                case 7:
                    ln2 j5 = j(unitedSchemeEntity, ln2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return gk2.J().c(context, j5, a, z03Var);
                case '\b':
                    ln2 j6 = j(unitedSchemeEntity, ln2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return gk2.J().n(context, j6, a, z03Var);
                case '\t':
                    ln2 j7 = j(unitedSchemeEntity, ln2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return gk2.J().k(context, j7, a, z03Var);
                case '\n':
                    jn2 jn2Var = (jn2) j(unitedSchemeEntity, jn2.class);
                    if (k(jn2Var, a)) {
                        return false;
                    }
                    return gk2.J().e(context, jn2Var, a, z03Var);
                case 11:
                    pn2 pn2Var = (pn2) j(unitedSchemeEntity, pn2.class);
                    if (k(pn2Var, a)) {
                        return false;
                    }
                    return gk2.J().a(context, pn2Var, a, z03Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, z03Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ln2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    zx1.c("map", "params string is empty");
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
                    zx1.c("map", "params json parse error");
                    return t;
                }
            }
            zx1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ln2 ln2Var, in2 in2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ln2Var, in2Var)) == null) {
            if (ln2Var == null) {
                zx1.c("map", "parse error, model is null");
                in2Var.d(202);
                return true;
            }
            if (y03.K().q().y0()) {
                ln2Var.c = rg3.c().h();
            }
            if (TextUtils.isEmpty(ln2Var.c)) {
                String B = te3.B();
                if (!TextUtils.isEmpty(B)) {
                    ln2Var.c = B;
                }
                zx1.o("map", "webView id is empty, use current webView");
            }
            if (te3.m(ln2Var.c) == null) {
                in2Var.d(202);
                zx1.c("map", "can not find weiView by id " + ln2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
