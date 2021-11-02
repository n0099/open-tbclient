package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.f.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements com.ss.android.download.api.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f68775a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-408238484, "Lcom/ss/android/downloadlib/e/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-408238484, "Lcom/ss/android/downloadlib/e/c$a;");
                    return;
                }
            }
            f68775a = new c();
        }
    }

    public c() {
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

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f68775a : (c) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            b(true, str);
        }
    }

    @Override // com.ss.android.download.api.b.a
    public void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
            a(true, th, str);
        }
    }

    public void b(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048581, this, z, str) == null) || b()) {
            return;
        }
        if (z) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", a(new Throwable()));
        j.h().a("service_ttdownloader", 3, jSONObject);
    }

    public void a(boolean z, Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), th, str}) == null) || b()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            b(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", Log.getStackTraceString(th));
        j.h().a("service_ttdownloader", 1, jSONObject);
    }

    private void b(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, th) == null) && e.b(j.getContext())) {
            throw new com.ss.android.downloadlib.e.a(th);
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? j.i().optInt(CyberCfgManager.KEY_INT_ENABLE_MONITOR, 1) != 1 : invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a(true, str);
        }
    }

    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) || b()) {
            return;
        }
        if (z) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", a(new Throwable()));
        j.h().a("service_ttdownloader", 2, jSONObject);
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            try {
                return Log.getStackTraceString(th);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
