package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755397469, "Lcom/repackage/r73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755397469, "Lcom/repackage/r73;");
                return;
            }
        }
        a = rg1.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String W;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || (W = b0.W().W()) == null || (queryParameter = Uri.parse(W).getQueryParameter("params")) == null) {
                return false;
            }
            try {
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
        }
        return invokeV.booleanValue;
    }
}
