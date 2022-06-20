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
/* loaded from: classes5.dex */
public class am2 extends p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am2(p03 p03Var) {
        super(p03Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p03Var};
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

    @Override // com.repackage.p13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, sz2Var)) == null) {
            if (p13.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.p13
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, sz2 sz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, sz2Var)) == null) {
            if (p13.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            sw1.i("map", "handleSubAction " + str);
            bm2 a = bm2.a(unitedSchemeEntity, callbackHandler);
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
                    em2 j = j(unitedSchemeEntity, em2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return zi2.J().g(context, j, a, sz2Var);
                case 1:
                    em2 j2 = j(unitedSchemeEntity, em2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return zi2.J().update(context, j2, a, sz2Var);
                case 2:
                    em2 j3 = j(unitedSchemeEntity, em2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return zi2.J().l(context, j3, a, sz2Var);
                case 3:
                    hm2 hm2Var = (hm2) j(unitedSchemeEntity, hm2.class);
                    if (k(hm2Var, a)) {
                        return false;
                    }
                    return zi2.J().j(context, hm2Var, a, sz2Var);
                case 4:
                    gm2 gm2Var = (gm2) j(unitedSchemeEntity, gm2.class);
                    if (k(gm2Var, a)) {
                        return false;
                    }
                    return zi2.J().h(context, gm2Var, a, sz2Var);
                case 5:
                    em2 j4 = j(unitedSchemeEntity, em2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return zi2.J().m(context, j4, a, sz2Var);
                case 6:
                    dm2 dm2Var = (dm2) j(unitedSchemeEntity, dm2.class);
                    if (k(dm2Var, a)) {
                        return false;
                    }
                    return zi2.J().b(context, dm2Var, a, sz2Var);
                case 7:
                    em2 j5 = j(unitedSchemeEntity, em2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return zi2.J().c(context, j5, a, sz2Var);
                case '\b':
                    em2 j6 = j(unitedSchemeEntity, em2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return zi2.J().n(context, j6, a, sz2Var);
                case '\t':
                    em2 j7 = j(unitedSchemeEntity, em2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return zi2.J().k(context, j7, a, sz2Var);
                case '\n':
                    cm2 cm2Var = (cm2) j(unitedSchemeEntity, cm2.class);
                    if (k(cm2Var, a)) {
                        return false;
                    }
                    return zi2.J().e(context, cm2Var, a, sz2Var);
                case 11:
                    im2 im2Var = (im2) j(unitedSchemeEntity, im2.class);
                    if (k(im2Var, a)) {
                        return false;
                    }
                    return zi2.J().a(context, im2Var, a, sz2Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, sz2Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends em2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    sw1.c("map", "params string is empty");
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
                    sw1.c("map", "params json parse error");
                    return t;
                }
            }
            sw1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(em2 em2Var, bm2 bm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, em2Var, bm2Var)) == null) {
            if (em2Var == null) {
                sw1.c("map", "parse error, model is null");
                bm2Var.d(202);
                return true;
            }
            if (rz2.K().r().y0()) {
                em2Var.c = kf3.c().h();
            }
            if (TextUtils.isEmpty(em2Var.c)) {
                String B = md3.B();
                if (!TextUtils.isEmpty(B)) {
                    em2Var.c = B;
                }
                sw1.o("map", "webView id is empty, use current webView");
            }
            if (md3.m(em2Var.c) == null) {
                bm2Var.d(202);
                sw1.c("map", "can not find weiView by id " + em2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
