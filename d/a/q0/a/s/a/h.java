package d.a.q0.a.s.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f50520a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f50521b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-354546666, "Ld/a/q0/a/s/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-354546666, "Ld/a/q0/a/s/a/h;");
                return;
            }
        }
        f50521b = new h();
    }

    public h() {
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

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = f50520a;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                f50520a = b();
            }
            return f50520a;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.a.k2.g.b a2 = d.a.q0.a.k2.g.h.a();
            if (a2 != null) {
                return a2.getString("alliance_login_uk", null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void c(int i2, JSONObject jsonObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, jsonObject) == null) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            if (i2 == 0) {
                e(jsonObject);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.a.k2.g.h.a().putString("alliance_login_uk", "");
            f50520a = null;
        }
    }

    public final void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            d.a.q0.a.k2.g.h.a().putString("alliance_login_uk", jSONObject.optString("uk"));
        }
    }
}
