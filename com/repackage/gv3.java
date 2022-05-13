package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gv3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755664627, "Lcom/repackage/gv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755664627, "Lcom/repackage/gv3;");
                return;
            }
        }
        a = eh1.a;
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
                ev3 a2 = fv3.a();
                codeCacheSetting.maxCount = a2.a;
                codeCacheSetting.sizeLimit = a2.b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.c;
            }
            if (a) {
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
