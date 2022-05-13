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
/* loaded from: classes5.dex */
public class e83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755783791, "Lcom/repackage/e83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755783791, "Lcom/repackage/e83;");
                return;
            }
        }
        a = eh1.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String W;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null || (W = a0.V().W()) == null || (queryParameter = Uri.parse(W).getQueryParameter("params")) == null) {
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
