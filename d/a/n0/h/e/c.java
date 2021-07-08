package d.a.n0.h.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.k;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49937a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132199823, "Ld/a/n0/h/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132199823, "Ld/a/n0/h/e/c;");
                return;
            }
        }
        f49937a = k.f45831a;
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting a(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
            codeCacheSetting.id = str;
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.add(str2);
            if (((str.hashCode() == -1253235525 && str.equals("gamejs")) ? (char) 0 : (char) 65535) != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                a a2 = b.a();
                codeCacheSetting.maxCount = a2.f49932a;
                codeCacheSetting.sizeLimit = a2.f49933b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f49934c;
            }
            if (f49937a) {
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting cachePath: " + str2);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
                Log.d("GameV8CodeCacheHelper", "buildCacheSetting diskCodeCacheSizeThreshold: " + codeCacheSetting.diskCodeCacheSizeThreshold);
            }
            return codeCacheSetting;
        }
        return (V8EngineConfiguration.CodeCacheSetting) invokeLL.objValue;
    }

    public static int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z && z2) {
                return 3;
            }
            if (z) {
                return 1;
            }
            return z2 ? 2 : 0;
        }
        return invokeCommon.intValue;
    }
}
