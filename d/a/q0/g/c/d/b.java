package d.a.q0.g.c.d;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f52933b = "wifi_resume_download_flag";

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f52934c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f52935a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1054403523, "Ld/a/q0/g/c/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1054403523, "Ld/a/q0/g/c/d/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52935a = KVStorageFactory.getSharedPreferences("gamecenter_wifi_resume_download_switch", 0);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f52934c == null) {
                synchronized (b.class) {
                    if (f52934c == null) {
                        f52934c = new b();
                    }
                }
            }
            return f52934c;
        }
        return (b) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52935a.getBoolean(f52933b, true) : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            SharedPreferences.Editor edit = this.f52935a.edit();
            edit.putBoolean(f52933b, z);
            edit.apply();
        }
    }
}
