package com.ss.android.socialbase.downloader.network;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69702a = "k";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final d f69703b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f69704c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<l> f69705d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReference<l> f69706e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f69707f;

    /* renamed from: g  reason: collision with root package name */
    public int f69708g;

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69709a;
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
            f69709a = iArr;
            try {
                iArr[l.f69711a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69709a[l.f69712b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69709a[l.f69713c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f69709a[l.f69714d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f69710a;
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
            f69710a = new k(null);
        }
    }

    /* loaded from: classes2.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f69710a : (k) invokeV.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.f69703b == null) {
                return false;
            }
            try {
                int i2 = AnonymousClass1.f69709a[this.f69705d.get().ordinal()];
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
                double a2 = this.f69703b.a();
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                int size = this.f69707f.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f69707f.get(i2).a(this.f69705d.get());
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
                if (this.f69703b == null) {
                    return l.f69715e;
                }
                return a(this.f69703b.a());
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
        this.f69703b = new d(0.05d);
        this.f69704c = false;
        this.f69705d = new AtomicReference<>(l.f69715e);
        this.f69707f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        l b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                double d2 = ((j * 1.0d) / j2) * 8.0d;
                if (j2 == 0 || d2 < 3.0d) {
                    return;
                }
                try {
                    this.f69703b.a(d2);
                    b2 = b();
                } catch (Throwable unused) {
                }
                if (this.f69704c) {
                    this.f69708g++;
                    if (b2 != this.f69706e.get()) {
                        this.f69704c = false;
                        this.f69708g = 1;
                    }
                    if (this.f69708g >= 5.0d && c()) {
                        this.f69704c = false;
                        this.f69708g = 1;
                        this.f69705d.set(this.f69706e.get());
                        d();
                    }
                    return;
                }
                if (this.f69705d.get() != b2) {
                    this.f69704c = true;
                    this.f69706e = new AtomicReference<>(b2);
                }
            }
        }
    }

    private l a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < 0.0d) {
                return l.f69715e;
            }
            if (d2 < 150.0d) {
                return l.f69711a;
            }
            if (d2 < 550.0d) {
                return l.f69712b;
            }
            if (d2 < 2000.0d) {
                return l.f69713c;
            }
            return l.f69714d;
        }
        return (l) invokeCommon.objValue;
    }
}
