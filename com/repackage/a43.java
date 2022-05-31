package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static b b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;

        public a(j63 j63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("4178", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends j63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e = this.k;
                a("isAuthorized", this.l);
                a("isUserLogin", this.m);
                a("isCompleteLogin", this.n);
                a("isUserCertificated", this.o);
                a("isAuthorizeBtnConfirm", this.q);
                a("isCompleteCertificated", this.p);
                a43.c(this);
            }
        }

        public b h(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.q = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.l = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.p = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.n = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.o = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.m = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public b n(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.k = String.valueOf(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                a43.e();
                g();
                a43.f(this);
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755906799, "Lcom/repackage/a43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755906799, "Lcom/repackage/a43;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void c(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            bVar.a = a63.n(gz2.J().r().V().G());
            bVar.b = "trigger";
            bVar.g = "multiAuthorize";
        }
    }

    public static synchronized b d() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (a43.class) {
                if (b == null) {
                    b = new b(null);
                    if (a) {
                        Log.i("MultiAuthorizeStatisticManager", "MultiAuthorizeInfo-new instance.");
                    }
                }
                bVar = b;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (a43.class) {
                b = null;
            }
        }
    }

    public static void f(j63 j63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, j63Var) == null) {
            bc3.j(new a(j63Var), "SwanAppUBCOnEvent");
        }
    }
}
