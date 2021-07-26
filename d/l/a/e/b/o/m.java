package d.l.a.e.b.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f72524a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f72525b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f72526c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f72527d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f72528e;

    /* renamed from: f  reason: collision with root package name */
    public int f72529f;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f72530a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1227800976, "Ld/l/a/e/b/o/m$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1227800976, "Ld/l/a/e/b/o/m$a;");
                    return;
                }
            }
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f72530a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.f38811a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72530a[com.ss.android.socialbase.downloader.network.l.f38812b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72530a[com.ss.android.socialbase.downloader.network.l.f38813c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72530a[com.ss.android.socialbase.downloader.network.l.f38814d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final m f72531a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1227800945, "Ld/l/a/e/b/o/m$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1227800945, "Ld/l/a/e/b/o/m$b;");
                    return;
                }
            }
            f72531a = new m(null);
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799837709, "Ld/l/a/e/b/o/m;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799837709, "Ld/l/a/e/b/o/m;");
        }
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f72531a : (m) invokeV.objValue;
    }

    public final com.ss.android.socialbase.downloader.network.l b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < 0.0d) {
                return com.ss.android.socialbase.downloader.network.l.f38815e;
            }
            if (d2 < 150.0d) {
                return com.ss.android.socialbase.downloader.network.l.f38811a;
            }
            if (d2 < 550.0d) {
                return com.ss.android.socialbase.downloader.network.l.f38812b;
            }
            if (d2 < 2000.0d) {
                return com.ss.android.socialbase.downloader.network.l.f38813c;
            }
            return com.ss.android.socialbase.downloader.network.l.f38814d;
        }
        return (com.ss.android.socialbase.downloader.network.l) invokeCommon.objValue;
    }

    public synchronized void c(long j, long j2) {
        com.ss.android.socialbase.downloader.network.l d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                double d3 = ((j * 1.0d) / j2) * 8.0d;
                if (j2 == 0 || d3 < 3.0d) {
                    return;
                }
                try {
                    this.f72524a.b(d3);
                    d2 = d();
                } catch (Throwable unused) {
                }
                if (this.f72525b) {
                    this.f72529f++;
                    if (d2 != this.f72527d.get()) {
                        this.f72525b = false;
                        this.f72529f = 1;
                    }
                    if (this.f72529f >= 5.0d && e()) {
                        this.f72525b = false;
                        this.f72529f = 1;
                        this.f72526c.set(this.f72527d.get());
                        f();
                    }
                    return;
                }
                if (this.f72526c.get() != d2) {
                    this.f72525b = true;
                    this.f72527d = new AtomicReference<>(d2);
                }
            }
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f72524a == null) {
                    return com.ss.android.socialbase.downloader.network.l.f38815e;
                }
                return b(this.f72524a.a());
            }
        }
        return (com.ss.android.socialbase.downloader.network.l) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f72524a == null) {
                return false;
            }
            try {
                int i2 = a.f72530a[this.f72526c.get().ordinal()];
                double d2 = 2000.0d;
                double d3 = 550.0d;
                if (i2 == 1) {
                    d3 = 0.0d;
                    d2 = 150.0d;
                } else if (i2 == 2) {
                    d2 = 550.0d;
                    d3 = 150.0d;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return true;
                    }
                    d2 = 3.4028234663852886E38d;
                    d3 = 2000.0d;
                }
                double a2 = this.f72524a.a();
                if (a2 > d2) {
                    if (a2 > d2 * 1.25d) {
                        return true;
                    }
                } else if (a2 < d3 * 0.8d) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                int size = this.f72528e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f72528e.get(i2).a(this.f72526c.get());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72524a = new f(0.05d);
        this.f72525b = false;
        this.f72526c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.f38815e);
        this.f72528e = new ArrayList<>();
    }
}
