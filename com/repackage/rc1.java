package com.repackage;

import android.content.Context;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rc1() {
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

    public jd1 a(Context context, sc1 sc1Var) {
        InterceptResult invokeLL;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, sc1Var)) == null) {
            if (sc1Var == null || context == null || (a = sc1Var.a()) == null) {
                return null;
            }
            String optString = a.optString("material_type");
            if ("image".equals(optString)) {
                return new ad1(context, a);
            }
            if (NativeConstants.TYPE_GIF.equals(optString)) {
                return new zc1(context, a);
            }
            if ("video".equals(optString)) {
                return new bd1(context, a);
            }
            return null;
        }
        return (jd1) invokeLL.objValue;
    }
}
