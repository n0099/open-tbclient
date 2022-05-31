package com.repackage;

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
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class jl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static final jl2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final List<gl2> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755584895, "Lcom/repackage/jl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755584895, "Lcom/repackage/jl2;");
                return;
            }
        }
        c = rf1.a;
        d = new jl2();
    }

    public jl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        ra1<gl2> ra1Var = new il2().a;
        this.b = ra1Var == null ? null : ra1Var.getList();
    }

    public static jl2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d : (jl2) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && !this.a.getAndSet(true) && c()) {
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
            if (c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to foreground");
            }
            if (this.b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (gl2 gl2Var : this.b) {
                    if (current == gl2Var.b()) {
                        gl2Var.a(true, activity);
                    }
                }
            }
        }
    }

    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            if (c) {
                String curProcessName = ProcessUtils.getCurProcessName();
                Log.d("ProcessLifecycleDispatcher", curProcessName + " to background");
            }
            if (this.b != null) {
                LifecycleProcessType current = LifecycleProcessType.getCurrent();
                for (gl2 gl2Var : this.b) {
                    if (current == gl2Var.b()) {
                        gl2Var.a(false, activity);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends pk2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ jl2 b;

        public b(jl2 jl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jl2Var;
            this.a = 0;
        }

        @Override // com.repackage.pk2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                int i = this.a + 1;
                this.a = i;
                if (i == 1) {
                    this.b.d(activity);
                }
            }
        }

        @Override // com.repackage.pk2, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                int i = this.a - 1;
                this.a = i;
                if (i == 0) {
                    this.b.e(activity);
                }
            }
        }

        public /* synthetic */ b(jl2 jl2Var, a aVar) {
            this(jl2Var);
        }
    }
}
