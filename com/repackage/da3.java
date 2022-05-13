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
/* loaded from: classes5.dex */
public final class da3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile da3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<nf3<Exception>> a;
    public ArrayList<nf3<Exception>> b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public a(da3 da3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da3Var, Integer.valueOf(i)};
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
                ux1.k("PresetSwanCoreUpdater", "onPresetCheck start.");
                ca3.s(this.a);
                ux1.k("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ da3 b;

        public b(da3 da3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = da3Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.k("PresetSwanCoreUpdater", "onPresetUpdate start.");
                da3 da3Var = this.b;
                int i = this.a;
                da3Var.c(i, ca3.t(i));
                ux1.k("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;
        public final /* synthetic */ Exception b;

        public c(da3 da3Var, nf3 nf3Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {da3Var, nf3Var, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCallback(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755774181, "Lcom/repackage/da3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755774181, "Lcom/repackage/da3;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public da3() {
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

    public static da3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (da3.class) {
                    if (c == null) {
                        c = new da3();
                    }
                }
            }
            return c;
        }
        return (da3) invokeV.objValue;
    }

    public final void c(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, exc) == null) {
            synchronized (da3.class) {
                try {
                    if (i == 0) {
                        Iterator<nf3<Exception>> it = this.a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.a.clear();
                    } else if (i == 1) {
                        Iterator<nf3<Exception>> it2 = this.b.iterator();
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

    public final void d(nf3<Exception> nf3Var, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nf3Var, exc) == null) || nf3Var == null) {
            return;
        }
        oe3.e0(new c(this, nf3Var, exc));
    }

    public void e(nf3<Exception> nf3Var, int i) {
        ArrayList<nf3<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, nf3Var, i) == null) {
            ux1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (da3.class) {
                boolean q = ca3.q(i);
                ux1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i == 0 && !ca3.r(i)) {
                    ca3.w(true, i);
                    new Thread(new a(this, i), "onPresetCheck").start();
                }
                if (!q) {
                    d(nf3Var, null);
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
                arrayList.add(nf3Var);
                ux1.k("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (da3.class) {
                c(i, ca3.t(i));
            }
        }
    }
}
