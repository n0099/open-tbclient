package d.a.o0.a.h0.o.h.d;

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
import d.a.o0.t.d;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.h0.o.h.d.c.a f45589a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.h0.o.h.d.b.a f45590b;

    /* renamed from: c  reason: collision with root package name */
    public File f45591c;

    /* renamed from: d  reason: collision with root package name */
    public long f45592d;

    /* renamed from: e  reason: collision with root package name */
    public int f45593e;

    /* renamed from: f  reason: collision with root package name */
    public int f45594f;

    /* renamed from: d.a.o0.a.h0.o.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0766a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.a.h0.o.h.d.c.a f45595a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.o0.a.h0.o.h.d.b.a f45596b;

        /* renamed from: c  reason: collision with root package name */
        public File f45597c;

        /* renamed from: d  reason: collision with root package name */
        public long f45598d;

        /* renamed from: e  reason: collision with root package name */
        public int f45599e;

        /* renamed from: f  reason: collision with root package name */
        public int f45600f;

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
            this.f45599e = 0;
            this.f45600f = 0;
        }

        public b g(d.a.o0.a.h0.o.h.d.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f45595a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(d.a.o0.a.h0.o.h.d.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f45596b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.f45598d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f45601a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(444132829, "Ld/a/o0/a/h0/o/h/d/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(444132829, "Ld/a/o0/a/h0/o/h/d/a$c;");
                    return;
                }
            }
            f45601a = new a(null);
        }
    }

    public /* synthetic */ a(C0766a c0766a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f45601a : (a) invokeV.objValue;
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
            if (this.f45591c == null) {
                String m = d.m();
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                this.f45591c = new File(m, "swan_hybrid");
            }
            return this.f45591c;
        }
        return (File) invokeV.objValue;
    }

    public d.a.o0.a.h0.o.h.d.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f45589a == null) {
                this.f45589a = new d.a.o0.a.h0.o.h.d.c.b();
            }
            return this.f45589a;
        }
        return (d.a.o0.a.h0.o.h.d.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f45593e <= 0) {
                this.f45593e = 60000;
            }
            return this.f45593e;
        }
        return invokeV.intValue;
    }

    public d.a.o0.a.h0.o.h.d.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f45590b == null) {
                this.f45590b = new SystemStrategyImpl();
            }
            return this.f45590b;
        }
        return (d.a.o0.a.h0.o.h.d.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f45592d <= 0) {
                this.f45592d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f45592d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f45594f <= 0) {
                this.f45594f = 60000;
            }
            return this.f45594f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f45589a = bVar.f45595a;
        this.f45590b = bVar.f45596b;
        this.f45591c = bVar.f45597c;
        this.f45592d = bVar.f45598d;
        this.f45593e = bVar.f45599e;
        this.f45594f = bVar.f45600f;
        if (d.a.o0.a.h0.o.h.e.a.f45602a) {
            Log.d("HybridIntercept", toString());
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f45589a + ", InterceptStrategy=" + this.f45590b + ", CacheFolder=" + this.f45591c + ", MaxCacheSize=" + (this.f45592d / 1048576) + "MB, ConnectTimeout=" + this.f45593e + ", ReadTimeout=" + this.f45594f + '}';
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
