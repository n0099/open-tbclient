package d.a.o0.a.v2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48623f;

    /* renamed from: g  reason: collision with root package name */
    public static c f48624g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f48625a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.g1.a f48626b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48627c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48628d;

    /* renamed from: e  reason: collision with root package name */
    public int f48629e;

    /* loaded from: classes7.dex */
    public class a extends d.a.o0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f48630e;

        /* renamed from: d.a.o0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0966a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f48631e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48632f;

            public RunnableC0966a(a aVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48632f = aVar;
                this.f48631e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f48631e.getIntent();
                    d.a.o0.a.p.d.a0 n = d.a.o0.a.c1.a.n();
                    ComponentName component = intent.getComponent();
                    if (this.f48632f.f48630e.f48627c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                        if (this.f48632f.f48630e.f48628d) {
                            if (v0.f48623f) {
                                Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                return;
                            }
                            return;
                        }
                        d.a.o0.a.v2.c m = d.a.o0.a.v2.c.m();
                        if (d.a() && d.a.o0.a.v2.c.k()) {
                            u = m.w(this.f48631e, this.f48632f.f48630e.f48629e, false);
                        } else {
                            u = m.u(this.f48632f.f48630e.f48629e, false, false);
                        }
                        if (v0.f48623f) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + this.f48632f.f48630e.f48629e);
                        }
                        m.i();
                    }
                    if (v0.f48623f) {
                        Log.d("SwanHomeScreenLaunch", "class=" + this.f48631e + ", swanAppForeground=" + this.f48632f.f48630e.f48627c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                    }
                }
            }
        }

        public a(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48630e = v0Var;
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && d.a.o0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0966a runnableC0966a = new RunnableC0966a(this, activity);
                if (d.a()) {
                    runnableC0966a.run();
                } else {
                    q.i(runnableC0966a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.o0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                v0 v0Var = this.f48630e;
                v0Var.f48627c = v0Var.f48627c && activity != null && activity.getTaskId() == this.f48630e.f48629e;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f48633a;

        public b(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48633a = v0Var;
        }

        @Override // d.a.o0.a.v2.v0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.f48633a.f48627c = true;
                    this.f48633a.f48629e = i2;
                } else if (this.f48633a.f48627c && i2 == 1) {
                    this.f48633a.f48627c = false;
                }
                this.f48633a.f48628d = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-968376283, "Ld/a/o0/a/v2/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-968376283, "Ld/a/o0/a/v2/v0;");
                return;
            }
        }
        f48623f = d.a.o0.a.k.f46335a;
    }

    public v0(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48625a = application;
        this.f48626b = new a(this);
        f48624g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f48626b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f48624g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f48624g = null;
            this.f48625a.unregisterActivityLifecycleCallbacks(this.f48626b);
        }
    }
}
