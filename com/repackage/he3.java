package com.repackage;

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
/* loaded from: classes6.dex */
public class he3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static c g;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Application a;
    @Nullable
    public pl2 b;
    public boolean c;
    public boolean d;
    public int e;

    /* loaded from: classes6.dex */
    public class a extends pl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he3 a;

        /* renamed from: com.repackage.he3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0648a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ a b;

            public RunnableC0648a(a aVar, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean u;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Intent intent = this.a.getIntent();
                    rk1 o = oj2.o();
                    ComponentName component = intent.getComponent();
                    if (this.b.a.c && intent.hasCategory("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction()) && o != null && component != null && TextUtils.equals(o.A(), component.getClassName())) {
                        if (this.b.a.d) {
                            if (he3.f) {
                                Log.w("SwanHomeScreenLaunch", "SwanApp is Foreground Now");
                                return;
                            }
                            return;
                        }
                        nc3 m = nc3.m();
                        if (oc3.a() && nc3.k()) {
                            u = m.w(this.a, this.b.a.e, false);
                        } else {
                            u = m.u(this.b.a.e, false, false);
                        }
                        if (he3.f) {
                            Log.d("SwanHomeScreenLaunch", "moveTaskToFront " + u + ", taskId=" + this.b.a.e);
                        }
                        m.i();
                    }
                    if (he3.f) {
                        Log.d("SwanHomeScreenLaunch", "class=" + this.a + ", swanAppForeground=" + this.b.a.c + ", flag=" + intent.getFlags() + ", ComponentName=" + component);
                    }
                }
            }
        }

        public a(he3 he3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he3Var;
        }

        @Override // com.repackage.pl2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) && nc3.j()) {
                super.onActivityCreated(activity, bundle);
                if (activity == null || activity.getIntent() == null) {
                    return;
                }
                RunnableC0648a runnableC0648a = new RunnableC0648a(this, activity);
                if (oc3.a()) {
                    runnableC0648a.run();
                } else {
                    bd3.j(runnableC0648a, "moveTaskToFront");
                }
            }
        }

        @Override // com.repackage.pl2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                super.onActivityStarted(activity);
                he3 he3Var = this.a;
                he3Var.c = he3Var.c && activity != null && activity.getTaskId() == this.a.e;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he3 a;

        public b(he3 he3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {he3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = he3Var;
        }

        @Override // com.repackage.he3.c
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z) {
                    this.a.c = true;
                    this.a.e = i;
                } else if (this.a.c && i == 1) {
                    this.a.c = false;
                }
                this.a.d = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755651173, "Lcom/repackage/he3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755651173, "Lcom/repackage/he3;");
                return;
            }
        }
        f = rg1.a;
    }

    public he3(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = application;
        this.b = new a(this);
        g = new b(this);
        application.registerActivityLifecycleCallbacks(this.b);
    }

    public static void h(boolean z, int i) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (cVar = g) == null) {
            return;
        }
        cVar.a(z, i);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g = null;
            this.a.unregisterActivityLifecycleCallbacks(this.b);
        }
    }
}
