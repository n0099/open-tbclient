package d.a.q0.c.a;

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
import com.baidu.wallet.lightapp.base.LightappConstants;
import d.a.q0.a.k;
import d.a.q0.n.i.a;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes8.dex */
public class c implements d.a.q0.a.p.d.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f52381a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(892106461, "Ld/a/q0/c/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(892106461, "Ld/a/q0/c/a/c;");
                return;
            }
        }
        f52381a = k.f49133a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.p.d.d
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            d.b().c(bArr);
        }
    }

    @Override // d.a.q0.a.p.d.d
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, responseCallback) == null) {
            new d.a.q0.c.a.k.b().q(str, str2, responseCallback);
        }
    }

    @Override // d.a.q0.a.p.d.d
    public void f(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, cVar) == null) {
            new d.a.q0.c.a.k.a().k(str, str2, cVar);
        }
    }

    @Override // d.a.q0.a.p.d.d
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? d.b().e(str) : invokeL.booleanValue;
    }

    @Override // d.a.q0.a.p.d.d
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.b().d() : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.p.d.d
    public boolean i(@NonNull d.a.q0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, d.a.q0.a.v2.e1.b<String> bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, jSONObject, str, str2, callback, bVar})) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
                return false;
            }
            String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
            if (TextUtils.isEmpty(optString)) {
                if (f52381a) {
                    Log.d("BdtlsImpl", "onFailure: serviceId is invalid");
                }
                if (bVar != null) {
                    bVar.onCallback("serviceId is invalid");
                    return true;
                }
                return true;
            }
            d.a.q0.a.j2.k.y(str, eVar.N().G(), null);
            new d.a.q0.c.a.k.d(eVar, jSONObject, str2, callback).o(optString);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
