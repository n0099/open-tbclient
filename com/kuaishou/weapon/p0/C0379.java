package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʽᵎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0379 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0379() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m445() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String m89 = C0294.m89();
                if (TextUtils.isEmpty(m89) || m89.contains("arm64")) {
                    return 0;
                }
                return !m89.contains(WebKitFactory.OS_64) ? 1 : 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static JSONObject m446() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                String str = System.getenv("LD_PRELOAD");
                String str2 = System.getenv("LD_LIBRARY_PATH");
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("0", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("1", str2);
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
