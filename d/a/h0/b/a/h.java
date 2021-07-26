package d.a.h0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, h> f42876a;

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f42877b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-49301552, "Ld/a/h0/b/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-49301552, "Ld/a/h0/b/a/h;");
                return;
            }
        }
        f42876a = new HashMap<>();
        f42877b = new ConcurrentHashMap<>();
    }

    public static void a(String str, IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, str, iBinder, z) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                if (f42876a.get(str) == null) {
                    b bVar = new b(null);
                    bVar.f42878a = iBinder;
                    bVar.f42879b = z;
                    f42877b.put(str, bVar);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new SecurityException();
        }
    }

    public static IBinder d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            h hVar = f42876a.get(str);
            if (hVar != null) {
                hVar.b();
                return hVar.c();
            }
            b bVar = f42877b.get(str);
            if (bVar != null) {
                if (!bVar.f42879b && Binder.getCallingUid() != Process.myUid()) {
                    throw new SecurityException();
                }
                return bVar.f42878a;
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                return f42877b.remove(str) != null;
            }
            throw new SecurityException();
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException();
        }
    }

    public abstract IBinder c();

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IBinder f42878a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42879b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42879b = false;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
