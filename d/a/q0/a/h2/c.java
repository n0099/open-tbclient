package d.a.q0.a.h2;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.j2.c;
import d.a.q0.a.k;
import d.a.q0.a.l;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes8.dex */
public class c implements SoUtils.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48634a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116994500, "Ld/a/q0/a/h2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116994500, "Ld/a/q0/a/h2/c;");
                return;
            }
        }
        f48634a = k.f49133a;
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

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(d.a.q0.a.c1.a.b(), str);
            return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, findSoFilesInLibrary == null ? null : findSoFilesInLibrary.getAbsolutePath(), Long.valueOf(findSoFilesInLibrary == null ? 0L : findSoFilesInLibrary.length()));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.apps.so.SoUtils.a
    public void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArr = {Build.CPU_ABI, Build.CPU_ABI2};
        String str3 = Arrays.toString(strArr) + "\n" + l.a() + "\n" + a("v8.engine") + "\n" + a("zeusv8") + "\n" + str2;
        if (f48634a) {
            Log.d("SoUbcDefaultImpl", "reportSoLoadInfo: " + str3);
        }
        c.b bVar = new c.b(10007);
        bVar.j(str);
        bVar.i(str3);
        bVar.h(d.a.q0.a.a2.e.V());
        bVar.m();
    }
}
