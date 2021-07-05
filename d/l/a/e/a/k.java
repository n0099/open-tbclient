package d.l.a.e.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.a.a;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f74640a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f74641b;

    /* renamed from: c  reason: collision with root package name */
    public long f74642c;

    /* renamed from: d  reason: collision with root package name */
    public long f74643d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f74644e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f74645f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f74646g;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f74647e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74647e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74647e.l();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f74648e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74648e = kVar;
        }

        @Override // d.l.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f74648e.f74640a.isEmpty()) {
                return;
            }
            long c2 = d.l.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - this.f74648e.f74643d;
            if (currentTimeMillis < c2) {
                if (this.f74648e.f74645f.hasCallbacks(this.f74648e.f74646g)) {
                    return;
                }
                this.f74648e.f74645f.postDelayed(this.f74648e.f74646g, c2 - currentTimeMillis);
                return;
            }
            this.f74648e.f74643d = System.currentTimeMillis();
            this.f74648e.l();
        }

        @Override // d.l.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f74649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f74650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f74651g;

        public c(k kVar, Context context, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74651g = kVar;
            this.f74649e = context;
            this.f74650f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74651g.h(this.f74649e, this.f74650f.intValue(), false);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f74652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f74653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f74654g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f74655h;

        public d(k kVar, Context context, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, context, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74655h = kVar;
            this.f74652e = context;
            this.f74653f = i2;
            this.f74654g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74655h.a(this.f74652e, this.f74653f, this.f74654g);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f74656a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1771078575, "Ld/l/a/e/a/k$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1771078575, "Ld/l/a/e/a/k$e;");
                    return;
                }
            }
            f74656a = new k(null);
        }
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? e.f74656a : (k) invokeV.objValue;
    }

    public int a(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return h(context, i2, z);
            }
            if (n()) {
                this.f74645f.postDelayed(new d(this, context, i2, z), 1000L);
                return 1;
            } else if (d.l.a.e.b.a.a.c().k()) {
                d.l.a.e.b.c.a.i("leaves", "on Foreground");
                return h(context, i2, z);
            } else if (d.l.a.e.a.c.k()) {
                return 1;
            } else {
                boolean z2 = Build.VERSION.SDK_INT < 29;
                if (this.f74640a.isEmpty() && !this.f74641b && z2) {
                    return h(context, i2, z);
                }
                int b2 = d.l.a.e.b.j.a.r().b("install_queue_size", 3);
                synchronized (this.f74640a) {
                    while (this.f74640a.size() > b2) {
                        this.f74640a.poll();
                    }
                }
                if (z2) {
                    this.f74645f.removeCallbacks(this.f74646g);
                    this.f74645f.postDelayed(this.f74646g, d.l.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
                }
                synchronized (this.f74640a) {
                    if (!this.f74640a.contains(Integer.valueOf(i2))) {
                        this.f74640a.offer(Integer.valueOf(i2));
                    }
                }
                return 1;
            }
        }
        return invokeCommon.intValue;
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jumpUnknownSourceActivity) == null) {
            this.f74644e = new SoftReference<>(jumpUnknownSourceActivity);
        }
    }

    public void g(DownloadInfo downloadInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, str) == null) || downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        l();
    }

    public final int h(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int D = d.l.a.e.a.d.D(context, i2, z);
            if (D == 1) {
                this.f74641b = true;
            }
            this.f74642c = System.currentTimeMillis();
            return D;
        }
        return invokeCommon.intValue;
    }

    public JumpUnknownSourceActivity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SoftReference<JumpUnknownSourceActivity> softReference = this.f74644e;
            JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
            this.f74644e = null;
            return jumpUnknownSourceActivity;
        }
        return (JumpUnknownSourceActivity) invokeV.objValue;
    }

    public final void l() {
        Integer poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Build.VERSION.SDK_INT < 29 || d.l.a.e.b.a.a.c().k()) {
                synchronized (this.f74640a) {
                    poll = this.f74640a.poll();
                }
                this.f74645f.removeCallbacks(this.f74646g);
                if (poll != null) {
                    Context n = d.l.a.e.b.g.e.n();
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        this.f74645f.post(new c(this, n, poll));
                    } else {
                        h(n, poll.intValue(), false);
                    }
                    this.f74645f.postDelayed(this.f74646g, 20000L);
                    return;
                }
                this.f74641b = false;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? System.currentTimeMillis() - this.f74642c < 1000 : invokeV.booleanValue;
    }

    public k() {
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
        this.f74640a = new ArrayDeque();
        this.f74641b = false;
        this.f74645f = new Handler(Looper.getMainLooper());
        this.f74646g = new a(this);
        d.l.a.e.b.a.a.c().f(new b(this));
    }
}
