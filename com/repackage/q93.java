package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class q93 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q93 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<af3<Exception>> a;
    public ArrayList<af3<Exception>> b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(q93 q93Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q93Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.k("PresetSwanCoreUpdater", "onPresetCheck start.");
                p93.s(this.a);
                hx1.k("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ q93 b;

        public b(q93 q93Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q93Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q93Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.k("PresetSwanCoreUpdater", "onPresetUpdate start.");
                q93 q93Var = this.b;
                int i = this.a;
                q93Var.c(i, p93.t(i));
                hx1.k("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;
        public final /* synthetic */ Exception b;

        public c(q93 q93Var, af3 af3Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q93Var, af3Var, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af3Var;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755425338, "Lcom/repackage/q93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755425338, "Lcom/repackage/q93;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public q93() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public static q93 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (q93.class) {
                    if (c == null) {
                        c = new q93();
                    }
                }
            }
            return c;
        }
        return (q93) invokeV.objValue;
    }

    public final void c(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, exc) == null) {
            synchronized (q93.class) {
                try {
                    if (i == 0) {
                        Iterator<af3<Exception>> it = this.a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.a.clear();
                    } else if (i == 1) {
                        Iterator<af3<Exception>> it2 = this.b.iterator();
                        while (it2.hasNext()) {
                            d(it2.next(), exc);
                        }
                        this.b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d(af3<Exception> af3Var, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var, exc) == null) || af3Var == null) {
            return;
        }
        be3.e0(new c(this, af3Var, exc));
    }

    public void e(af3<Exception> af3Var, int i) {
        ArrayList<af3<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, af3Var, i) == null) {
            hx1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (q93.class) {
                boolean q = p93.q(i);
                hx1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i == 0 && !p93.r(i)) {
                    p93.w(true, i);
                    new Thread(new a(this, i), "onPresetCheck").start();
                }
                if (!q) {
                    d(af3Var, null);
                    return;
                }
                if (i == 1) {
                    arrayList = this.b;
                } else {
                    arrayList = this.a;
                }
                if (arrayList.isEmpty()) {
                    new Thread(new b(this, i), "updateSwanCoreAsync").start();
                }
                arrayList.add(af3Var);
                hx1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (q93.class) {
                c(i, p93.t(i));
            }
        }
    }
}
