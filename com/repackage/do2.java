package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class do2 extends jo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755760758, "Lcom/repackage/do2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755760758, "Lcom/repackage/do2;");
                return;
            }
        }
        b = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public do2(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.jo2
    public boolean a(zn2 zn2Var, bo2 bo2Var, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{zn2Var, bo2Var, context, unitedSchemeEntity, callbackHandler, hz2Var})) == null) {
            hw1.i("video", "fullscreen, video id:" + bo2Var.j + " slave id: " + bo2Var.c);
            e(zn2Var, bo2Var.s, unitedSchemeEntity, callbackHandler);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final int d(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            String str = hashMap.get("params");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return new JSONObject(str).optInt("direction", -1);
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                    return -1;
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void e(zn2 zn2Var, boolean z, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{zn2Var, Boolean.valueOf(z), unitedSchemeEntity, callbackHandler}) == null) || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
            return;
        }
        zn2Var.u(z, d(params));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
