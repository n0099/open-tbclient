package com.repackage;

import android.content.Context;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cd1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ud1 a(Context context, dd1 dd1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, dd1Var)) == null) {
            if (dd1Var == null || context == null) {
                return null;
            }
            try {
                JSONObject a = dd1Var.a();
                if (a != null) {
                    String optString = a.optString("material_type");
                    if ("image".equals(optString)) {
                        return new ld1(context, a);
                    }
                    if (NativeConstants.TYPE_GIF.equals(optString)) {
                        return new kd1(context, a);
                    }
                    if ("video".equals(optString)) {
                        return new md1(context, a);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ud1) invokeLL.objValue;
    }
}
