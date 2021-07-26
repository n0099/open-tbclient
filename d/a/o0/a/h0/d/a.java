package d.a.o0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45094a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.h0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0722a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45095a;

        /* renamed from: b  reason: collision with root package name */
        public int f45096b;

        /* renamed from: c  reason: collision with root package name */
        public long f45097c;

        public C0722a() {
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
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f45098a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(226307223, "Ld/a/o0/a/h0/d/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(226307223, "Ld/a/o0/a/h0/d/a$b;");
                    return;
                }
            }
            f45098a = k.f46335a;
        }

        public static C0722a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                C0722a c0722a = new C0722a();
                c0722a.f45095a = c();
                c0722a.f45096b = d();
                c0722a.f45097c = b();
                if (f45098a) {
                    Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0722a.f45095a + " ,sizeLimit: " + c0722a.f45096b + " ,diskSizeThreshold: " + c0722a.f45097c);
                }
                return c0722a;
            }
            return (C0722a) invokeV.objValue;
        }

        public static long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 31457280L;
            }
            return invokeV.longValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return 20;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return 102400;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447162389, "Ld/a/o0/a/h0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447162389, "Ld/a/o0/a/h0/d/a;");
                return;
            }
        }
        f45094a = k.f46335a;
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
            if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                C0722a a2 = b.a();
                codeCacheSetting.maxCount = a2.f45095a;
                codeCacheSetting.sizeLimit = a2.f45096b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45097c;
            }
            if (f45094a) {
                Log.d("V8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("V8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("V8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
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
