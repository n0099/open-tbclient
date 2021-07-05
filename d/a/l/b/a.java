package d.a.l.b;

import a.a.a.c.b.ac;
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
import d.a.l.b.b;
import d.a.l.b.c.d;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class a implements d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f46114f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public bv f46115a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l.b.c.c f46116b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f46117c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f46118d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f46119e;

    /* renamed from: d.a.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0664a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46121f;

        public RunnableC0664a(a aVar, String str) {
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
            this.f46120e = aVar;
            this.f46121f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46120e.f46117c.containsKey(this.f46121f)) {
                this.f46120e.f46117c.remove(this.f46121f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46122e;

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
            this.f46122e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f46122e.f46117c.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46123e;

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
            this.f46123e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f46123e.f46117c.values()) {
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
        this.f46119e = new Handler(Looper.getMainLooper());
        this.f46117c = new LinkedHashMap();
        j(new bv());
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f46114f == null) {
                synchronized (a.class) {
                    if (f46114f == null) {
                        f46114f = new a();
                    }
                }
            }
            return f46114f;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.l.b.c.d.a
    public void a(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            this.f46119e.post(new RunnableC0664a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.f46117c.containsKey(e2)) {
                d dVar = this.f46117c.get(e2);
                if (dVar != null) {
                    dVar.cancel();
                }
                this.f46117c.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f46119e.post(new c(this));
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

    public void f(d.a.l.b.b bVar, String str, d.a.l.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, bVar, str, aVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            a.a.a.c.b.a aVar2 = new a.a.a.c.b.a(bVar, new ac(this.f46116b, aVar), this.f46118d, e2, this.f46115a, this);
            this.f46117c.put(e2, aVar2);
            aVar2.start();
        }
    }

    public final void g(d.a.l.b.b bVar, String str, d.a.l.b.c.a aVar, d.a.l.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, bVar, str, aVar, cVar) == null) {
            Log.d("RtcDownSo", "start down judge is downloading");
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            Log.d("RtcDownSo", "real start down ...");
            a.a.a.c.b.a aVar2 = new a.a.a.c.b.a(bVar, new ac(cVar, aVar), this.f46118d, e2, this.f46115a, this);
            this.f46117c.put(e2, aVar2);
            aVar2.start();
        }
    }

    public void h(String str, String str2, String str3, Looper looper, d.a.l.b.c.a aVar) {
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
            int i2 = bvVar.f1460b;
            int i3 = bvVar.f1459a;
            if (i2 > i3) {
                throw new IllegalArgumentException("thread num must < max thread num");
            }
            this.f46115a = bvVar;
            this.f46118d = Executors.newFixedThreadPool(i3);
            this.f46116b = new trw(this.f46119e);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!this.f46117c.containsKey(str) || (dVar = this.f46117c.get(str)) == null) {
                return false;
            }
            if (dVar.isRunning()) {
                d.a.l.b.d.c.c("DownloadInfo has been started!");
                return true;
            }
            d.a.l.b.d.c.c("DownloadInfo not started!");
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
            if (!this.f46117c.containsKey(e2) || (dVar = this.f46117c.get(e2)) == null) {
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
            if (this.f46117c.containsKey(e2)) {
                d dVar = this.f46117c.get(e2);
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
                this.f46117c.remove(e2);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f46119e.post(new b(this));
        }
    }
}
