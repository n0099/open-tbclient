package d.a.q0.a.v1.c;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v1.c.f.d;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51226b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f51227a;

    /* renamed from: d.a.q0.a.v1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0997a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v1.c.c f51228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f51229f;

        public RunnableC0997a(a aVar, d.a.q0.a.v1.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51229f = aVar;
            this.f51228e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51229f.g(this.f51228e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f51230a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394812451, "Ld/a/q0/a/v1/c/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1394812451, "Ld/a/q0/a/v1/c/a$b;");
                    return;
                }
            }
            f51230a = new a();
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b(@NonNull d.a.q0.a.v1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(274076833, "Ld/a/q0/a/v1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(274076833, "Ld/a/q0/a/v1/c/a;");
                return;
            }
        }
        f51226b = k.f49133a;
    }

    public a() {
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

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f51230a : (a) invokeV.objValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, null, str) == null) && f51226b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (cVar = this.f51227a) == null) {
            return;
        }
        cVar.d(str);
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f51227a) == null) {
            return;
        }
        cVar.a();
    }

    public void d(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (cVar = this.f51227a) == null) {
            return;
        }
        cVar.c(str);
    }

    public final void g(@NonNull d.a.q0.a.v1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            boolean isMainProcess = ProcessUtils.isMainProcess();
            if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
                f("send: return by process check");
                return;
            }
            if (this.f51227a == null) {
                this.f51227a = isMainProcess ? new d() : new d.a.q0.a.v1.c.e.b();
            }
            f("send: sender=" + this.f51227a);
            this.f51227a.a();
            this.f51227a.b(cVar);
            this.f51227a.a();
        }
    }

    public void h(@NonNull d.a.q0.a.v1.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            long i2 = cVar.i();
            int i3 = (i2 > 0L ? 1 : (i2 == 0L ? 0 : -1));
            if (i3 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
                g(cVar);
                return;
            }
            Handler i4 = d.a.q0.a.a2.d.i();
            RunnableC0997a runnableC0997a = new RunnableC0997a(this, cVar);
            if (i3 < 0) {
                i2 = 0;
            }
            i4.postDelayed(runnableC0997a, i2);
        }
    }
}
