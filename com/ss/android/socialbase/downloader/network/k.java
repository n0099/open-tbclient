package com.ss.android.socialbase.downloader.network;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "k";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final d f62637b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f62638c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<l> f62639d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReference<l> f62640e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f62641f;

    /* renamed from: g  reason: collision with root package name */
    public int f62642g;

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746298210, "Lcom/ss/android/socialbase/downloader/network/k$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1746298210, "Lcom/ss/android/socialbase/downloader/network/k$1;");
                    return;
                }
            }
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.f62643b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.f62644c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.f62645d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final k a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746299698, "Lcom/ss/android/socialbase/downloader/network/k$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1746299698, "Lcom/ss/android/socialbase/downloader/network/k$a;");
                    return;
                }
            }
            a = new k(null);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(l lVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1709912753, "Lcom/ss/android/socialbase/downloader/network/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1709912753, "Lcom/ss/android/socialbase/downloader/network/k;");
        }
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (k) invokeV.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.f62637b == null) {
                return false;
            }
            try {
                int i2 = AnonymousClass1.a[this.f62639d.get().ordinal()];
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
                double a2 = this.f62637b.a();
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

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            try {
                int size = this.f62641f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f62641f.get(i2).a(this.f62639d.get());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized l b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f62637b == null) {
                    return l.f62646e;
                }
                return a(this.f62637b.a());
            }
        }
        return (l) invokeV.objValue;
    }

    public k() {
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
        this.f62637b = new d(0.05d);
        this.f62638c = false;
        this.f62639d = new AtomicReference<>(l.f62646e);
        this.f62641f = new ArrayList<>();
    }

    public synchronized void a(long j2, long j3) {
        l b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (this) {
                double d2 = ((j2 * 1.0d) / j3) * 8.0d;
                if (j3 == 0 || d2 < 3.0d) {
                    return;
                }
                try {
                    this.f62637b.a(d2);
                    b2 = b();
                } catch (Throwable unused) {
                }
                if (this.f62638c) {
                    this.f62642g++;
                    if (b2 != this.f62640e.get()) {
                        this.f62638c = false;
                        this.f62642g = 1;
                    }
                    if (this.f62642g >= 5.0d && c()) {
                        this.f62638c = false;
                        this.f62642g = 1;
                        this.f62639d.set(this.f62640e.get());
                        d();
                    }
                    return;
                }
                if (this.f62639d.get() != b2) {
                    this.f62638c = true;
                    this.f62640e = new AtomicReference<>(b2);
                }
            }
        }
    }

    private l a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < 0.0d) {
                return l.f62646e;
            }
            if (d2 < 150.0d) {
                return l.a;
            }
            if (d2 < 550.0d) {
                return l.f62643b;
            }
            if (d2 < 2000.0d) {
                return l.f62644c;
            }
            return l.f62645d;
        }
        return (l) invokeCommon.objValue;
    }
}
