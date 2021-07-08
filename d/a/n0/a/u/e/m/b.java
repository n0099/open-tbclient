package d.a.n0.a.u.e.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.k2.h.c;
import d.a.n0.a.k2.h.d;
import d.a.n0.a.v2.q;
import d.a.n0.t.j;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.n0.a.u.e.m.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile d.a.n0.t.b f47771d;

    /* renamed from: e  reason: collision with root package name */
    public static long f47772e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long unused = b.f47772e = b.f47771d.d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1231410123, "Ld/a/n0/a/u/e/m/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1231410123, "Ld/a/n0/a/u/e/m/b;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (b.class) {
            if (f47771d == null) {
                L();
            }
        }
    }

    public static synchronized void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (b.class) {
                if (f47771d == null) {
                    try {
                        f47771d = new c("swan_js_global_storage", 2, e.g().getAbsolutePath());
                    } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                        f47771d = new j("swan_js_global_storage");
                        d.i(1, "swan_js_global_storage");
                    }
                    M();
                }
            }
        }
    }

    public static void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || f47771d == null) {
            return;
        }
        q.e().execute(new a());
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.D(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? super.E(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? super.F(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? super.G(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            M();
        }
    }

    public d.a.n0.a.u.h.b K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? w() : (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? super.r() : (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.s() : (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? super.t(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.t.b v(@NonNull d.a.n0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) ? f47771d : (d.a.n0.t.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f47771d.a()));
                jSONObject.put("currentSize", f47772e / 1024);
                jSONObject.put("limitSize", 10240);
                return new d.a.n0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    e2.printStackTrace();
                }
                return new d.a.n0.a.u.h.b(202, "JSONException");
            }
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public d.a.n0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? super.x(str) : (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.u.e.m.a
    public boolean z(@Nullable d.a.n0.a.a2.e eVar, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, eVar, str, str2)) == null) ? (f47772e - ((long) f47771d.getString(str, "").length())) + ((long) str2.length()) > Config.FULL_TRACE_LOG_LIMIT : invokeLLL.booleanValue;
    }
}
