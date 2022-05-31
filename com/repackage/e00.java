package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f00;
import com.repackage.j00;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class e00 implements j00.a {
    public static /* synthetic */ Interceptable $ic;
    public static e00 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, j00> a;
    public p b;
    public ExecutorService c;
    public i00 d;
    public Handler e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e00 b;

        public a(e00 e00Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e00Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e00Var;
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e00 a;

        public b(e00 e00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e00Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (j00 j00Var : this.a.a.values()) {
                    if (j00Var != null && j00Var.isRunning()) {
                        j00Var.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e00 a;

        public c(e00 e00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e00Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (j00 j00Var : this.a.a.values()) {
                    if (j00Var != null && j00Var.isRunning()) {
                        j00Var.cancel();
                    }
                }
            }
        }
    }

    public e00() {
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
        j(new p());
    }

    public static e00 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (e00.class) {
                    if (f == null) {
                        f = new e00();
                    }
                }
            }
            return f;
        }
        return (e00) invokeV.objValue;
    }

    @Override // com.repackage.j00.a
    public void a(String str, j00 j00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, j00Var) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                j00 j00Var = this.a.get(e);
                if (j00Var != null) {
                    j00Var.cancel();
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

    public void f(f00 f00Var, String str, g00 g00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, f00Var, str, g00Var) == null) {
            String e = e(str);
            if (k(e)) {
                return;
            }
            m mVar = new m(f00Var, new g(this.d, g00Var), this.c, e, this.b, this);
            this.a.put(e, mVar);
            mVar.start();
        }
    }

    public final void g(f00 f00Var, String str, g00 g00Var, i00 i00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, f00Var, str, g00Var, i00Var) == null) {
            Log.d("RtcDownSo", "start down judge is downloading");
            String e = e(str);
            if (k(e)) {
                return;
            }
            Log.d("RtcDownSo", "real start down ...");
            m mVar = new m(f00Var, new g(i00Var, g00Var), this.c, e, this.b, this);
            this.a.put(e, mVar);
            mVar.start();
        }
    }

    public void h(String str, String str2, String str3, Looper looper, g00 g00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, looper, g00Var) == null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            f00.a aVar = new f00.a();
            aVar.d(str);
            aVar.b(new File(str2));
            aVar.c(str3);
            g(aVar.a(), str, g00Var, new n(new Handler(looper)));
        }
    }

    public final void j(@NonNull p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            int i = pVar.b;
            int i2 = pVar.a;
            if (i <= i2) {
                this.b = pVar;
                this.c = Executors.newFixedThreadPool(i2);
                this.d = new n(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!this.a.containsKey(str) || (j00Var = this.a.get(str)) == null) {
                return false;
            }
            if (j00Var.isRunning()) {
                m00.c("DownloadInfo has been started!");
                return true;
            }
            m00.c("DownloadInfo not started!");
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        j00 j00Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String e = e(str);
            if (!this.a.containsKey(e) || (j00Var = this.a.get(e)) == null) {
                return false;
            }
            return j00Var.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                j00 j00Var = this.a.get(e);
                if (j00Var != null && j00Var.isRunning()) {
                    j00Var.pause();
                }
                this.a.remove(e);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.post(new b(this));
        }
    }
}
