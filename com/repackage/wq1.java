package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wq1 extends vq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vg4 f;
    public static long g;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long unused = wq1.g = wq1.f.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755192838, "Lcom/repackage/wq1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755192838, "Lcom/repackage/wq1;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wq1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (wq1.class) {
            if (f == null) {
                a0();
            }
        }
    }

    public static synchronized void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (wq1.class) {
                if (f == null) {
                    try {
                        f = new l93("swan_js_global_storage", 2, qj2.g().getAbsolutePath());
                    } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                        f = new dh4("swan_js_global_storage");
                        m93.i(1, "swan_js_global_storage");
                    }
                    b0();
                }
            }
        }
    }

    public static void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || f == null) {
            return;
        }
        od3.f().execute(new a());
    }

    @Override // com.repackage.vq1
    public us1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return super.A();
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.repackage.vq1
    public us1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#clearStorageSync", false);
            return super.C();
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.repackage.vq1
    public us1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getStorage", false);
            return super.D(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public vg4 F(@NonNull u03 u03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, u03Var)) == null) ? f : (vg4) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public us1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getStorageInfo", false);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f.a()));
                jSONObject.put("currentSize", g / 1024);
                jSONObject.put("limitSize", 10240);
                return new us1(0, jSONObject);
            } catch (JSONException unused) {
                return new us1(202, "JSONException");
            }
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.repackage.vq1
    public us1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            q("#getStorageInfoSync", false);
            return G();
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.repackage.vq1
    public us1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getStorageSync", false);
            return super.K(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vq1
    public boolean N(@Nullable u03 u03Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u03Var, str, str2)) == null) ? (g - ((long) f.getString(str, "").length())) + ((long) str2.length()) > Config.FULL_TRACE_LOG_LIMIT : invokeLLL.booleanValue;
    }

    @Override // com.repackage.vq1
    public us1 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            q("#removeStorage", false);
            return super.R(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public us1 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#removeStorageSync", false);
            return super.T(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public us1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            q("#setStorage", false);
            return super.U(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public us1 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            q("#setStorageSync", false);
            return super.W(str);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.vq1
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b0();
        }
    }

    @Override // com.repackage.vq1, com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "SwanGlobalStorageApi" : (String) invokeV.objValue;
    }
}
