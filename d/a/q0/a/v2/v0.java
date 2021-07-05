package d.a.q0.a.v2;

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
/* loaded from: classes8.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51421f;

    /* renamed from: g  reason: collision with root package name */
    public static c f51422g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Application f51423a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.g1.a f51424b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51425c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51426d;

    /* renamed from: e  reason: collision with root package name */
    public int f51427e;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a.g1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f51428e;

        /* renamed from: d.a.q0.a.v2.v0$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1008a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f51429e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f51430f;

            public RunnableC1008a(a aVar, Activity activity) {
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
                this.f51430f = aVar;
                this.f51429e = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.f51429e.getIntent();
                    d.a.q0.a.p.d.a0 n = d.a.q0.a.c1.a.n();
                    ComponentName component = intent.getComponent();
                    if (this.f51430f.f51428e.f51425c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && n != null && component != null && TextUtils.equals(n.y(), component.getClassName())) {
                        if (this.f51430f.f51428e.f51426d) {
                            if (v0.f51421f) {
                                Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                return;
                            }
                            return;
                        }
                        d.a.q0.a.v2.c m = d.a.q0.a.v2.c.m();
                        if (d.a() && d.a.q0.a.v2.c.k()) {
                            u = m.w(this.f51429e, this.f51430f.f51428e.f51427e, false);
                        } else {
                            u = m.u(this.f51430f.f51428e.f51427e, false, false);
                        }
                        if (v0.f51421f) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + this.f51430f.f51428e.f51427e);
                        }
                        m.i();
                    }
                    if (v0.f51421f) {
                        Log.d("SwanHomeScreenLaunch", "class=" + this.f51429e + ", swanAppForeground=" + this.f51430f.f51428e.f51425c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
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
            this.f51428e = v0Var;
        }

        @Override // d.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && d.a.q0.a.v2.c.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC1008a runnableC1008a = new RunnableC1008a(this, activity);
                if (d.a()) {
                    runnableC1008a.run();
                } else {
                    q.i(runnableC1008a, "moveTaskToFront");
                }
            }
        }

        @Override // d.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                v0 v0Var = this.f51428e;
                v0Var.f51425c = v0Var.f51425c && activity != null && activity.getTaskId() == this.f51428e.f51427e;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f51431a;

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
            this.f51431a = v0Var;
        }

        @Override // d.a.q0.a.v2.v0.c
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z) {
                    this.f51431a.f51425c = true;
                    this.f51431a.f51427e = i2;
                } else if (this.f51431a.f51425c && i2 == 1) {
                    this.f51431a.f51425c = false;
                }
                this.f51431a.f51426d = z;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-267311705, "Ld/a/q0/a/v2/v0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-267311705, "Ld/a/q0/a/v2/v0;");
                return;
            }
        }
        f51421f = d.a.q0.a.k.f49133a;
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
        this.f51423a = application;
        this.f51424b = new a(this);
        f51422g = new b(this);
        application.registerActivityLifecycleCallbacks(this.f51424b);
    }

    public static void h(boolean z, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (cVar = f51422g) == null) {
            return;
        }
        cVar.a(z, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f51422g = null;
            this.f51423a.unregisterActivityLifecycleCallbacks(this.f51424b);
        }
    }
}
