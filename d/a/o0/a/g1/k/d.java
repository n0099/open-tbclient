package d.a.o0.a.g1.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.lifecycle.process.LifecycleProcessType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45077c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f45078d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f45079a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.o0.a.g1.k.a> f45080b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-411503511, "Ld/a/o0/a/g1/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-411503511, "Ld/a/o0/a/g1/k/d;");
                return;
            }
        }
        f45077c = k.f46335a;
        f45078d = new d();
    }

    public d() {
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
        this.f45079a = new AtomicBoolean(false);
        d.a.h0.a.b.d<d.a.o0.a.g1.k.a> dVar = new c().f45076a;
        this.f45080b = dVar == null ? null : dVar.getList();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f45078d : (d) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && !this.f45079a.getAndSet(true) && c()) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new b(this, null));
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LifecycleProcessType.getCurrent() == LifecycleProcessType.MAIN : invokeV.booleanValue;
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            if (f45077c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to foreground");
            }
            if (this.f45080b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (d.a.o0.a.g1.k.a aVar : this.f45080b) {
                    if (current == aVar.b()) {
                        aVar.a(true, activity);
                    }
                }
            }
        }
    }

    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            if (f45077c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to background");
            }
            if (this.f45080b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (d.a.o0.a.g1.k.a aVar : this.f45080b) {
                    if (current == aVar.b()) {
                        aVar.a(false, activity);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.o0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f45081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45082f;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45082f = dVar;
            this.f45081e = 0;
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                int i2 = this.f45081e + 1;
                this.f45081e = i2;
                if (i2 == 1) {
                    this.f45082f.d(activity);
                }
            }
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                int i2 = this.f45081e - 1;
                this.f45081e = i2;
                if (i2 == 0) {
                    this.f45082f.e(activity);
                }
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }
}
