package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755482037, "Lcom/repackage/mz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755482037, "Lcom/repackage/mz3;");
                return;
            }
        }
        a = rg1.a;
    }

    public mz3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, responseCallback) == null) {
            if (a) {
                Log.d("requestWithUrlAndBody", HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            uj1 e = oj2.e();
            if (e.h() && e.g(str)) {
                e.e(str, str2, responseCallback);
                return;
            }
            j74.g().postStringRequest().url(str).cookieManager(oj2.q().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
        }
    }
}
