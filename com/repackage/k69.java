package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l69;
import com.repackage.s69;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class k69 implements s69.a {
    public static /* synthetic */ Interceptable $ic;
    public static k69 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, s69> a;
    public j69 b;
    public ExecutorService c;
    public q69 d;
    public Handler e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k69 b;

        public a(k69 k69Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k69Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k69Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.containsKey(this.a)) {
                this.b.a.remove(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k69 a;

        public b(k69 k69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (s69 s69Var : this.a.a.values()) {
                    if (s69Var != null && s69Var.isRunning()) {
                        s69Var.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k69 a;

        public c(k69 k69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (s69 s69Var : this.a.a.values()) {
                    if (s69Var != null && s69Var.isRunning()) {
                        s69Var.cancel();
                    }
                }
            }
        }
    }

    public k69() {
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
        this.e = new Handler(Looper.getMainLooper());
        this.a = new LinkedHashMap();
        i(new j69());
    }

    public static k69 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (k69.class) {
                    if (f == null) {
                        f = new k69();
                    }
                }
            }
            return f;
        }
        return (k69) invokeV.objValue;
    }

    @Override // com.repackage.s69.a
    public void a(String str, s69 s69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, s69Var) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                s69 s69Var = this.a.get(e);
                if (s69Var != null) {
                    s69Var.cancel();
                }
                this.a.remove(e);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.post(new c(this));
        }
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public void f(l69 l69Var, String str, n69 n69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, l69Var, str, n69Var) == null) {
            String e = e(str);
            if (j(e)) {
                return;
            }
            y69 y69Var = new y69(l69Var, new v69(this.d, n69Var), this.c, e, this.b, this);
            this.a.put(e, y69Var);
            y69Var.start();
        }
    }

    public void g(String str, String str2, String str3, n69 n69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, n69Var) == null) {
            l69.b bVar = new l69.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, n69Var);
        }
    }

    public final void i(@NonNull j69 j69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, j69Var) == null) {
            if (j69Var.b() <= j69Var.a()) {
                this.b = j69Var;
                this.c = Executors.newFixedThreadPool(j69Var.a());
                this.d = new w69(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        s69 s69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.a.containsKey(str) && (s69Var = this.a.get(str)) != null && s69Var.isRunning()) {
                c99.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        s69 s69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e = e(str);
            if (!this.a.containsKey(e) || (s69Var = this.a.get(e)) == null) {
                return false;
            }
            return s69Var.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                s69 s69Var = this.a.get(e);
                if (s69Var != null && s69Var.isRunning()) {
                    s69Var.pause();
                }
                this.a.remove(e);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.post(new b(this));
        }
    }
}
