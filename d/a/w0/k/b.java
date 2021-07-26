package d.a.w0.k;

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
import d.a.w0.k.c;
import d.a.w0.k.e.f;
import d.a.w0.k.f.e;
import d.a.w0.t.i;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class b implements f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f68615f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, f> f68616a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.w0.k.a f68617b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f68618c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w0.k.e.d f68619d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f68620e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f68622f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68622f = bVar;
            this.f68621e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f68622f.f68616a.containsKey(this.f68621e)) {
                this.f68622f.f68616a.remove(this.f68621e);
            }
        }
    }

    /* renamed from: d.a.w0.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1936b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f68623e;

        public RunnableC1936b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68623e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (f fVar : this.f68623e.f68616a.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.pause();
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
        public final /* synthetic */ b f68624e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68624e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (f fVar : this.f68624e.f68616a.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.cancel();
                    }
                }
            }
        }
    }

    public b() {
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
        this.f68620e = new Handler(Looper.getMainLooper());
        this.f68616a = new LinkedHashMap();
        i(new d.a.w0.k.a());
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68615f == null) {
                synchronized (b.class) {
                    if (f68615f == null) {
                        f68615f = new b();
                    }
                }
            }
            return f68615f;
        }
        return (b) invokeV.objValue;
    }

    @Override // d.a.w0.k.e.f.a
    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, fVar) == null) {
            this.f68620e.post(new a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.f68616a.containsKey(e2)) {
                f fVar = this.f68616a.get(e2);
                if (fVar != null) {
                    fVar.cancel();
                }
                this.f68616a.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68620e.post(new c(this));
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

    public void f(d.a.w0.k.c cVar, String str, d.a.w0.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cVar, str, aVar) == null) {
            String e2 = e(str);
            if (j(e2)) {
                return;
            }
            e eVar = new e(cVar, new d.a.w0.k.f.b(this.f68619d, aVar), this.f68618c, e2, this.f68617b, this);
            this.f68616a.put(e2, eVar);
            eVar.start();
        }
    }

    public void g(String str, String str2, String str3, d.a.w0.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, aVar) == null) {
            c.b bVar = new c.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, aVar);
        }
    }

    public final void i(@NonNull d.a.w0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (aVar.b() <= aVar.a()) {
                this.f68617b = aVar;
                this.f68618c = Executors.newFixedThreadPool(aVar.a());
                this.f68619d = new d.a.w0.k.f.c(this.f68620e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f68616a.containsKey(str) && (fVar = this.f68616a.get(str)) != null && fVar.isRunning()) {
                i.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String e2 = e(str);
            if (!this.f68616a.containsKey(e2) || (fVar = this.f68616a.get(e2)) == null) {
                return false;
            }
            return fVar.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            String e2 = e(str);
            if (this.f68616a.containsKey(e2)) {
                f fVar = this.f68616a.get(e2);
                if (fVar != null && fVar.isRunning()) {
                    fVar.pause();
                }
                this.f68616a.remove(e2);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f68620e.post(new RunnableC1936b(this));
        }
    }
}
