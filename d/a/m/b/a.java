package d.a.m.b;

import a.a.a.c.b.ac;
import a.a.a.c.b.shuoy;
import a.a.a.c.b.trw;
import a.a.a.c.bv;
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
import d.a.m.b.b;
import d.a.m.b.c.d;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class a implements d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f43392f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public bv f43393a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m.b.c.c f43394b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f43395c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f43396d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f43397e;

    /* renamed from: d.a.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0626a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f43398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43399f;

        public RunnableC0626a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43398e = aVar;
            this.f43399f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f43398e.f43395c.containsKey(this.f43399f)) {
                this.f43398e.f43395c.remove(this.f43399f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f43400e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43400e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f43400e.f43395c.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f43401e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43401e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f43401e.f43395c.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.cancel();
                    }
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43397e = new Handler(Looper.getMainLooper());
        this.f43395c = new LinkedHashMap();
        j(new bv());
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f43392f == null) {
                synchronized (a.class) {
                    if (f43392f == null) {
                        f43392f = new a();
                    }
                }
            }
            return f43392f;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.m.b.c.d.a
    public void a(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            this.f43397e.post(new RunnableC0626a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.f43395c.containsKey(e2)) {
                d dVar = this.f43395c.get(e2);
                if (dVar != null) {
                    dVar.cancel();
                }
                this.f43395c.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43397e.post(new c(this));
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public void f(d.a.m.b.b bVar, String str, d.a.m.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, bVar, str, aVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            shuoy shuoyVar = new shuoy(bVar, new ac(this.f43394b, aVar), this.f43396d, e2, this.f43393a, this);
            this.f43395c.put(e2, shuoyVar);
            shuoyVar.start();
        }
    }

    public final void g(d.a.m.b.b bVar, String str, d.a.m.b.c.a aVar, d.a.m.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, bVar, str, aVar, cVar) == null) {
            Log.d("RtcDownSo", "start down judge is downloading");
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            Log.d("RtcDownSo", "real start down ...");
            shuoy shuoyVar = new shuoy(bVar, new ac(cVar, aVar), this.f43396d, e2, this.f43393a, this);
            this.f43395c.put(e2, shuoyVar);
            shuoyVar.start();
        }
    }

    public void h(String str, String str2, String str3, Looper looper, d.a.m.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, str2, str3, looper, aVar) == null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            b.a aVar2 = new b.a();
            aVar2.d(str);
            aVar2.b(new File(str2));
            aVar2.c(str3);
            g(aVar2.a(), str, aVar, new trw(new Handler(looper)));
        }
    }

    public final void j(@NonNull bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bvVar) == null) {
            int i2 = bvVar.f1493b;
            int i3 = bvVar.f1492a;
            if (i2 > i3) {
                throw new IllegalArgumentException("thread num must < max thread num");
            }
            this.f43393a = bvVar;
            this.f43396d = Executors.newFixedThreadPool(i3);
            this.f43394b = new trw(this.f43397e);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!this.f43395c.containsKey(str) || (dVar = this.f43395c.get(str)) == null) {
                return false;
            }
            if (dVar.isRunning()) {
                d.a.m.b.d.c.c("DownloadInfo has been started!");
                return true;
            }
            d.a.m.b.d.c.c("DownloadInfo not started!");
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e2 = e(str);
            if (!this.f43395c.containsKey(e2) || (dVar = this.f43395c.get(e2)) == null) {
                return false;
            }
            return dVar.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e2 = e(str);
            if (this.f43395c.containsKey(e2)) {
                d dVar = this.f43395c.get(e2);
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
                this.f43395c.remove(e2);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f43397e.post(new b(this));
        }
    }
}
