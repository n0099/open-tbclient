package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i84;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class ei3 implements ui1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755736702, "Lcom/repackage/ei3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755736702, "Lcom/repackage/ei3;");
                return;
            }
        }
        a = rf1.a;
    }

    public ei3() {
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

    @Override // com.repackage.ui1
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            fi3.b().c(bArr);
        }
    }

    @Override // com.repackage.ui1
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, responseCallback) == null) {
            new vi3().q(str, str2, responseCallback);
        }
    }

    @Override // com.repackage.ui1
    public void f(String str, String str2, i84.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, cVar) == null) {
            new ui3().k(str, str2, cVar);
        }
    }

    @Override // com.repackage.ui1
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? fi3.b().e(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.ui1
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? fi3.b().d() : invokeV.booleanValue;
    }

    @Override // com.repackage.ui1
    public boolean i(@NonNull hz2 hz2Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, ae3<String> ae3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{hz2Var, jSONObject, str, str2, callback, ae3Var})) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
                return false;
            }
            String optString = optJSONObject.optString("serviceId");
            if (TextUtils.isEmpty(optString)) {
                if (a) {
                    Log.d("BdtlsImpl", "onFailure: serviceId is invalid");
                }
                if (ae3Var != null) {
                    ae3Var.onCallback("serviceId is invalid");
                    return true;
                }
                return true;
            }
            a63.D(str, hz2Var.X().G(), null, str2);
            new xi3(hz2Var, jSONObject, str2, callback).o(optString);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
