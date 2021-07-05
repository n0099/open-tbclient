package d.a.q0.a.h0.o.h.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.t.d;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.h0.o.h.d.c.a f48387a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.h0.o.h.d.b.a f48388b;

    /* renamed from: c  reason: collision with root package name */
    public File f48389c;

    /* renamed from: d  reason: collision with root package name */
    public long f48390d;

    /* renamed from: e  reason: collision with root package name */
    public int f48391e;

    /* renamed from: f  reason: collision with root package name */
    public int f48392f;

    /* renamed from: d.a.q0.a.h0.o.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0808a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.q0.a.h0.o.h.d.c.a f48393a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q0.a.h0.o.h.d.b.a f48394b;

        /* renamed from: c  reason: collision with root package name */
        public File f48395c;

        /* renamed from: d  reason: collision with root package name */
        public long f48396d;

        /* renamed from: e  reason: collision with root package name */
        public int f48397e;

        /* renamed from: f  reason: collision with root package name */
        public int f48398f;

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
            this.f48397e = 0;
            this.f48398f = 0;
        }

        public b g(d.a.q0.a.h0.o.h.d.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f48393a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(d.a.q0.a.h0.o.h.d.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f48394b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.f48396d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f48399a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1550011877, "Ld/a/q0/a/h0/o/h/d/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1550011877, "Ld/a/q0/a/h0/o/h/d/a$c;");
                    return;
                }
            }
            f48399a = new a(null);
        }
    }

    public /* synthetic */ a(C0808a c0808a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f48399a : (a) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
        }
        return (String) invokeV.objValue;
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f48389c == null) {
                String m = d.m();
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                this.f48389c = new File(m, "swan_hybrid");
            }
            return this.f48389c;
        }
        return (File) invokeV.objValue;
    }

    public d.a.q0.a.h0.o.h.d.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f48387a == null) {
                this.f48387a = new d.a.q0.a.h0.o.h.d.c.b();
            }
            return this.f48387a;
        }
        return (d.a.q0.a.h0.o.h.d.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f48391e <= 0) {
                this.f48391e = 60000;
            }
            return this.f48391e;
        }
        return invokeV.intValue;
    }

    public d.a.q0.a.h0.o.h.d.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f48388b == null) {
                this.f48388b = new SystemStrategyImpl();
            }
            return this.f48388b;
        }
        return (d.a.q0.a.h0.o.h.d.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f48390d <= 0) {
                this.f48390d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f48390d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f48392f <= 0) {
                this.f48392f = 60000;
            }
            return this.f48392f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f48387a = bVar.f48393a;
        this.f48388b = bVar.f48394b;
        this.f48389c = bVar.f48395c;
        this.f48390d = bVar.f48396d;
        this.f48391e = bVar.f48397e;
        this.f48392f = bVar.f48398f;
        if (d.a.q0.a.h0.o.h.e.a.f48400a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f48387a + ", InterceptStrategy=" + this.f48388b + ", CacheFolder=" + this.f48389c + ", MaxCacheSize=" + (this.f48390d / 1048576) + "MB, ConnectTimeout=" + this.f48391e + ", ReadTimeout=" + this.f48392f + '}';
        }
        return (String) invokeV.objValue;
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
            }
        }
    }
}
