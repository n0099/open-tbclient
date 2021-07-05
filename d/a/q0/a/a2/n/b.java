package d.a.q0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46714b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, g> f46715a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154674401, "Ld/a/q0/a/a2/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154674401, "Ld/a/q0/a/a2/n/b;");
                return;
            }
        }
        f46714b = k.f49133a;
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
        this.f46715a = null;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str.endsWith(File.separator)) {
                str3 = str + str2 + ".json";
            } else {
                str3 = str + File.separator + str2 + ".json";
            }
            File file = new File(str3);
            if (f46714b) {
                Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + file.exists());
            }
            if (file.exists()) {
                return d.a.q0.a.a1.e.m(file);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public g a(String str, @NonNull String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, gVar)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return gVar;
            }
            g d2 = d(str, str2, gVar);
            this.f46715a.put(str2, d2);
            return d2;
        }
        return (g) invokeLLL.objValue;
    }

    public g b(String str, String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, gVar)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return gVar;
            }
            if (this.f46715a == null) {
                this.f46715a = new TreeMap();
            }
            g gVar2 = this.f46715a.get(str2);
            if (gVar2 != null) {
                return gVar2;
            }
            g d2 = d(str, str2, gVar);
            this.f46715a.put(str2, d2);
            return d2;
        }
        return (g) invokeLLL.objValue;
    }

    public final g d(String str, String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, gVar)) == null) {
            String c2 = c(str, str2);
            return TextUtils.isEmpty(c2) ? gVar : g.b(c2, gVar);
        }
        return (g) invokeLLL.objValue;
    }
}
