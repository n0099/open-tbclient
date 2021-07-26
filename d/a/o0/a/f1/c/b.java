package d.a.o0.a.f1.c;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44961b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f44962a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.o0.a.f1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0706b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f44963a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1260459828, "Ld/a/o0/a/f1/c/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1260459828, "Ld/a/o0/a/f1/c/b$b;");
                    return;
                }
            }
            f44963a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1299245582, "Ld/a/o0/a/f1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1299245582, "Ld/a/o0/a/f1/c/b;");
                return;
            }
        }
        f44961b = k.f46335a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0706b.f44963a : (b) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f44962a != null) {
                    this.f44962a.evictAll();
                }
            }
        }
    }

    public synchronized <RESULT> RESULT b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                RESULT result = (RESULT) this.f44962a.get(str);
                if (result == null) {
                    if (f44961b) {
                        Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
                    }
                    return null;
                }
                try {
                    if (f44961b) {
                        Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
                    }
                    return result;
                } catch (Exception e2) {
                    if (f44961b) {
                        Log.e("SwanAppLaunchCache", Log.getStackTraceString(e2));
                    }
                    return null;
                }
            }
        }
        return (RESULT) invokeL.objValue;
    }

    public synchronized <RESULT> void d(String str, RESULT result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, result) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str) && result != null) {
                    if (f44961b) {
                        Log.d("SwanAppLaunchCache", "putConfig key: " + str);
                    }
                    this.f44962a.put(str, result);
                }
            }
        }
    }

    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f44961b) {
                    Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
                }
                this.f44962a.remove(str);
            }
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
        this.f44962a = new LruCache<>(10);
    }
}
