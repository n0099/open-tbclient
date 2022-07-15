package com.repackage;

import android.content.Context;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pc1() {
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

    public hd1 a(Context context, qc1 qc1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, qc1Var)) == null) {
            if (qc1Var == null || context == null) {
                return null;
            }
            try {
                JSONObject a = qc1Var.a();
                if (a != null) {
                    String optString = a.optString("material_type");
                    if ("image".equals(optString)) {
                        return new yc1(context, a);
                    }
                    if (NativeConstants.TYPE_GIF.equals(optString)) {
                        return new xc1(context, a);
                    }
                    if ("video".equals(optString)) {
                        return new zc1(context, a);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (hd1) invokeLL.objValue;
    }
}
