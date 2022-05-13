package com.repackage;

import android.os.Handler;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class nm2 implements lm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final boolean b;
    public long c;
    public volatile boolean d;
    @NonNull
    public final List<lm2> e;
    public final Runnable f;
    public final Runnable g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm2 a;

        public a(nm2 nm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm2 a;

        public b(nm2 nm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final nm2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-152189921, "Lcom/repackage/nm2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-152189921, "Lcom/repackage/nm2$c;");
                    return;
                }
            }
            a = new nm2(null);
        }
    }

    public /* synthetic */ nm2(a aVar) {
        this();
    }

    public static lm2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a : (lm2) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            boolean z = this.b && !this.d && ProcessUtils.isSwanProcess() && le3.C(true);
            ux1.i("SwanBackStageManager", "performPause: shouldPerform=" + z + " for " + currentTimeMillis + "/" + this.a);
            if (z) {
                for (lm2 lm2Var : this.e) {
                    ux1.i("SwanBackStageManager", "performPause for strategy=" + lm2Var);
                    lm2Var.onPause();
                }
                this.d = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.b && this.d;
            ux1.i("SwanBackStageManager", "performResume: shouldPerform=" + z);
            for (lm2 lm2Var : this.e) {
                ux1.i("SwanBackStageManager", "performResume for strategy=" + lm2Var);
                lm2Var.onResume();
            }
            this.d = false;
        }
    }

    @Override // com.repackage.lm2
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ux1.i("SwanBackStageManager", "onPause: enable=" + this.b + " delay=" + this.a);
            if (this.b) {
                this.c = System.currentTimeMillis();
                Handler L = t03.L();
                L.removeCallbacks(this.f);
                L.removeCallbacks(this.g);
                L.postDelayed(this.f, this.a);
            }
        }
    }

    @Override // com.repackage.lm2
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ux1.i("SwanBackStageManager", "onResume: enable=" + this.b);
            if (this.b) {
                Handler L = t03.L();
                L.removeCallbacks(this.f);
                L.removeCallbacks(this.g);
                oe3.e0(this.g);
            }
        }
    }

    public nm2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        long millis = TimeUnit.SECONDS.toMillis(sm2.b.a());
        this.a = millis;
        this.b = millis >= 0 && sm2.b.e();
        this.c = 0L;
        this.d = false;
        this.f = new a(this);
        this.g = new b(this);
        this.e = new ArrayList();
        if (sm2.b.e()) {
            if (sm2.b.d()) {
                this.e.add(new om2());
            }
            if (sm2.b.b()) {
                this.e.add(new pm2());
            }
            if (sm2.b.c()) {
                this.e.add(new mm2());
            }
        }
    }
}
