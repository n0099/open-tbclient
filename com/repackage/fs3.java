package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final fs3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-375652274, "Lcom/repackage/fs3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-375652274, "Lcom/repackage/fs3$a;");
                    return;
                }
            }
            a = new fs3();
        }
    }

    public fs3() {
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

    public static fs3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (fs3) invokeV.objValue;
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ms3Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                ms3Var.a(new ns3(31008, "download is not exist"));
            } else {
                kx3.c().c(optString);
            }
        }
    }

    public void c(@NonNull JSONObject jSONObject, @NonNull ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ms3Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                ms3Var.a(new ns3(31008, "download is not exist"));
            } else {
                kx3.c().e(optString);
            }
        }
    }

    public void d(@NonNull JSONObject jSONObject, @NonNull ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, ms3Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            if (!optBoolean) {
                ms3Var.a(new ns3(31008, "download is not exist"));
                return;
            }
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("apkId");
            String optString3 = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                if (kx3.c().a(optString3, optString, optString2, optBoolean, new hs3(ms3Var))) {
                    return;
                }
                ms3Var.a(new ns3(31006, "is not in main process"));
                return;
            }
            ms3Var.a(new ns3(31007, "invalid params"));
        }
    }

    public void e(@NonNull JSONObject jSONObject, @NonNull ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, ms3Var) == null) {
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString = jSONObject.optString("url");
            if (!optBoolean) {
                ms3Var.a(new ns3(31008, "download is not exist"));
            } else {
                kx3.c().f(optString);
            }
        }
    }
}
