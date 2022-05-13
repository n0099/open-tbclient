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
import com.repackage.v94;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public class rj3 implements hk1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755348458, "Lcom/repackage/rj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755348458, "Lcom/repackage/rj3;");
                return;
            }
        }
        a = eh1.a;
    }

    public rj3() {
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

    @Override // com.repackage.hk1
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            sj3.b().c(bArr);
        }
    }

    @Override // com.repackage.hk1
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, responseCallback) == null) {
            new ik3().q(str, str2, responseCallback);
        }
    }

    @Override // com.repackage.hk1
    public void f(String str, String str2, v94.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, cVar) == null) {
            new hk3().k(str, str2, cVar);
        }
    }

    @Override // com.repackage.hk1
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? sj3.b().e(str) : invokeL.booleanValue;
    }

    @Override // com.repackage.hk1
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? sj3.b().d() : invokeV.booleanValue;
    }

    @Override // com.repackage.hk1
    public boolean i(@NonNull u03 u03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, nf3<String> nf3Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{u03Var, jSONObject, str, str2, callback, nf3Var})) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
                return false;
            }
            String optString = optJSONObject.optString("serviceId");
            if (TextUtils.isEmpty(optString)) {
                if (a) {
                    Log.d("BdtlsImpl", "onFailure: serviceId is invalid");
                }
                if (nf3Var != null) {
                    nf3Var.onCallback("serviceId is invalid");
                    return true;
                }
                return true;
            }
            n73.D(str, u03Var.X().G(), null, str2);
            new kk3(u03Var, jSONObject, str2, callback).o(optString);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
