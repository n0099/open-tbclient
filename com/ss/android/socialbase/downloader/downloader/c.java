package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile com.ss.android.socialbase.downloader.d.b A;
    public static volatile aa B;
    public static volatile List<ak> C;
    public static volatile boolean D;
    public static volatile OkHttpClient E;
    public static volatile com.ss.android.socialbase.downloader.network.f F;
    public static volatile com.ss.android.socialbase.downloader.network.f G;
    public static volatile u H;
    public static final List<com.ss.android.socialbase.downloader.depend.m> I;
    public static boolean J;
    public static int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static int P;
    public static boolean Q;
    public static final List<com.ss.android.socialbase.downloader.depend.k> R;
    public static final List<ab> S;
    public static int T;
    public static boolean U;
    public static boolean V;
    public static r W;
    public static com.ss.android.socialbase.downloader.d.c X;
    public static volatile boolean Y;

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f69256a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f69257b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f69258c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h f69259d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile af f69260e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile com.ss.android.socialbase.downloader.impls.a f69261f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile o f69262g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile o f69263h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f69264i;
    public static volatile IDownloadHttpService j;
    public static volatile com.ss.android.socialbase.downloader.network.h k;
    public static volatile IDownloadHttpService l;
    public static volatile com.ss.android.socialbase.downloader.network.h m;
    public static volatile l n;
    public static volatile ExecutorService o;
    public static volatile ExecutorService p;
    public static volatile ExecutorService q;
    public static volatile ExecutorService r;
    public static volatile ExecutorService s;
    public static volatile ExecutorService t;
    public static volatile ExecutorService u;
    public static volatile ExecutorService v;
    public static volatile g w;
    public static volatile DownloadReceiver x;
    public static volatile s y;
    public static volatile q z;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC2002a {
            void a();
        }

        o a();

        t a(InterfaceC2002a interfaceC2002a);

        m b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(326251508, "Lcom/ss/android/socialbase/downloader/downloader/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(326251508, "Lcom/ss/android/socialbase/downloader/downloader/c;");
                return;
            }
        }
        C = new ArrayList();
        D = false;
        E = null;
        I = new ArrayList();
        J = false;
        L = Runtime.getRuntime().availableProcessors() + 1;
        M = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        int i2 = L;
        N = i2;
        O = i2;
        P = 8192;
        R = new ArrayList();
        S = new ArrayList();
        U = true;
        V = false;
        Y = false;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<com.ss.android.socialbase.downloader.depend.m> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? I : (List) invokeV.objValue;
    }

    public static k B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f69258c == null) {
                synchronized (c.class) {
                    if (f69258c == null) {
                        f69258c = new com.ss.android.socialbase.downloader.impls.i();
                    }
                }
            }
            return f69258c;
        }
        return (k) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.impls.a C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f69261f == null) {
                synchronized (c.class) {
                    if (f69261f == null) {
                        f69261f = new com.ss.android.socialbase.downloader.impls.e();
                    }
                }
            }
            return f69261f;
        }
        return (com.ss.android.socialbase.downloader.impls.a) invokeV.objValue;
    }

    public static int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? T : invokeV.intValue;
    }

    @NonNull
    public static JSONObject E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (B != null && B.a() != null) {
                return B.a();
            }
            return com.ss.android.socialbase.downloader.constants.e.f69185i;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.f69179c)) {
            com.ss.android.socialbase.downloader.constants.e.f69179c = RomUtils.MANUFACTURER_OPPO;
            com.ss.android.socialbase.downloader.constants.e.f69178b = com.ss.android.socialbase.downloader.constants.e.f69179c.toUpperCase();
        }
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? U : invokeV.booleanValue;
    }

    public static synchronized int H() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (c.class) {
                i2 = P;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static h I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f69259d == null) {
                synchronized (c.class) {
                    if (f69259d == null) {
                        f69259d = new com.ss.android.socialbase.downloader.impls.c();
                    }
                }
            }
            return f69259d;
        }
        return (h) invokeV.objValue;
    }

    public static af J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f69260e : (af) invokeV.objValue;
    }

    public static g K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (w == null) {
                synchronized (c.class) {
                    if (w == null) {
                        w = new com.ss.android.socialbase.downloader.impls.b();
                    }
                }
            }
            return w;
        }
        return (g) invokeV.objValue;
    }

    public static s L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (y == null) {
                synchronized (c.class) {
                    if (y == null) {
                        y = new com.ss.android.socialbase.downloader.impls.j();
                    }
                }
            }
            return y;
        }
        return (s) invokeV.objValue;
    }

    public static u M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (H == null) {
                synchronized (c.class) {
                    if (H == null) {
                        H = new u.a();
                    }
                }
            }
            return H;
        }
        return (u) invokeV.objValue;
    }

    public static synchronized Context N() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (c.class) {
                context = f69256a;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static synchronized boolean O() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            synchronized (c.class) {
                z2 = Q;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.d.c P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (X == null) {
                X = new com.ss.android.socialbase.downloader.d.c() { // from class: com.ss.android.socialbase.downloader.downloader.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.d.c
                    public void a(int i2, String str, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.d.c
                    public void b(int i2, String str, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) {
                        }
                    }
                };
            }
            return X;
        }
        return (com.ss.android.socialbase.downloader.d.c) invokeV.objValue;
    }

    public static r Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? W : (r) invokeV.objValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Y : invokeV.booleanValue;
    }

    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("supportMultiProc::=");
            sb.append(f69264i != null);
            com.ss.android.socialbase.downloader.c.a.a("wjd", sb.toString());
            return f69264i != null;
        }
        return invokeV.booleanValue;
    }

    public static a T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? f69264i : (a) invokeV.objValue;
    }

    public static void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            if (x == null) {
                x = new DownloadReceiver();
            }
            if (J) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                f69256a.registerReceiver(x, intentFilter);
                J = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, downloaderBuilder) == null) {
            synchronized (c.class) {
                if (Y) {
                    com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
                    return;
                }
                boolean z2 = D;
                c(downloaderBuilder);
                if (f69257b == null) {
                    f69257b = new com.ss.android.socialbase.downloader.impls.d();
                }
                if (f69262g == null) {
                    f69262g = new com.ss.android.socialbase.downloader.impls.h();
                }
                if (f69263h == null && f69264i != null) {
                    f69263h = f69264i.a();
                }
                if (f69258c == null) {
                    f69258c = new com.ss.android.socialbase.downloader.impls.i();
                }
                if (f69261f == null) {
                    f69261f = new com.ss.android.socialbase.downloader.impls.e();
                }
                if (f69259d == null) {
                    f69259d = new com.ss.android.socialbase.downloader.impls.c();
                }
                if (w == null) {
                    w = new com.ss.android.socialbase.downloader.impls.b();
                }
                if (y == null) {
                    y = new com.ss.android.socialbase.downloader.impls.j();
                }
                if (K <= 0 || K > L) {
                    K = L;
                }
                U();
                if (D && !z2 && !com.ss.android.socialbase.downloader.i.f.c()) {
                    com.ss.android.socialbase.downloader.impls.l.a(true).startService();
                } else if (com.ss.android.socialbase.downloader.i.f.d()) {
                    ExecutorService m2 = m();
                    if (m2 != null) {
                        m2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Context N2;
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (N2 = c.N()) == null) {
                                    return;
                                }
                                com.ss.android.socialbase.downloader.i.f.d(N2);
                            }
                        });
                    }
                } else {
                    Context N2 = N();
                    if (N2 != null) {
                        com.ss.android.socialbase.downloader.i.f.d(N2);
                    }
                }
                F();
                Y = true;
            }
        }
    }

    public static void a(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, rVar) == null) {
        }
    }

    public static synchronized void b(DownloaderBuilder downloaderBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65596, null, downloaderBuilder) == null) {
            synchronized (c.class) {
                c(downloaderBuilder);
            }
        }
    }

    public static void c(DownloaderBuilder downloaderBuilder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65602, null, downloaderBuilder) == null) || downloaderBuilder == null) {
            return;
        }
        if (downloaderBuilder.getContext() != null) {
            a(downloaderBuilder.getContext());
        }
        if (downloaderBuilder.getDownloadCache() != null) {
            a(downloaderBuilder.getDownloadCache());
        }
        if (downloaderBuilder.getIdGenerator() != null) {
            a(downloaderBuilder.getIdGenerator());
        }
        if (downloaderBuilder.getChunkCntCalculator() != null) {
            a(downloaderBuilder.getChunkCntCalculator());
        }
        if (downloaderBuilder.getNotificationClickCallback() != null) {
            a(downloaderBuilder.getNotificationClickCallback());
        }
        if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
            b(downloaderBuilder.getMaxDownloadPoolSize());
        }
        if (downloaderBuilder.getHttpService() != null) {
            a(downloaderBuilder.getHttpService());
        }
        if (downloaderBuilder.getHeadHttpService() != null) {
            a(downloaderBuilder.getHeadHttpService());
        }
        if (downloaderBuilder.getDownloadLaunchHandler() != null) {
            a(downloaderBuilder.getDownloadLaunchHandler());
        }
        if (downloaderBuilder.getCPUThreadExecutor() != null) {
            c(downloaderBuilder.getCPUThreadExecutor());
        }
        if (downloaderBuilder.getIOThreadExecutor() != null) {
            d(downloaderBuilder.getIOThreadExecutor());
        }
        if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
            e(downloaderBuilder.getMixDefaultDownloadExecutor());
        }
        if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
            f(downloaderBuilder.getMixFrequentDownloadExecutor());
        }
        if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
            g(downloaderBuilder.getMixApkDownloadExecutor());
        }
        if (downloaderBuilder.getDBThreadExecutor() != null) {
            h(downloaderBuilder.getDBThreadExecutor());
        }
        if (downloaderBuilder.getChunkThreadExecutor() != null) {
            a(downloaderBuilder.getChunkThreadExecutor());
        }
        if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
            b(downloaderBuilder.getOkHttpDispatcherExecutor());
        }
        if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
            a(downloaderBuilder.getDownloadCompleteHandlers());
        }
        if (downloaderBuilder.getMonitorConfig() != null) {
            z = downloaderBuilder.getMonitorConfig();
        }
        if (downloaderBuilder.getWriteBufferSize() > 1024) {
            P = downloaderBuilder.getWriteBufferSize();
        }
        if (downloaderBuilder.getChunkAdjustCalculator() != null) {
            a(downloaderBuilder.getChunkAdjustCalculator());
        }
        if (downloaderBuilder.isDownloadInMultiProcess()) {
            D = true;
        }
        if (downloaderBuilder.getDownloadExpSwitch() != 0) {
            T = downloaderBuilder.getDownloadExpSwitch();
        }
        if (downloaderBuilder.getDownloadSetting() != null) {
            a(downloaderBuilder.getDownloadSetting());
        }
        if (downloaderBuilder.getDownloadDns() != null) {
            F = downloaderBuilder.getDownloadDns();
        }
        if (downloaderBuilder.getTTNetHandler() != null) {
            H = downloaderBuilder.getTTNetHandler();
            if (H.a()) {
                a(H.b());
                a(H.c());
            } else {
                a(h());
                a(i());
            }
        }
        b(downloaderBuilder.needAutoRefreshUnSuccessTask());
        if (downloaderBuilder.getDownloadMonitorListener() != null) {
            a(downloaderBuilder.getDownloadMonitorListener());
        }
    }

    public static IDownloadHttpService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? j : (IDownloadHttpService) invokeV.objValue;
    }

    public static List<ak> e() {
        InterceptResult invokeV;
        List<ak> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            synchronized (C) {
                list = C;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.h f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? k : (com.ss.android.socialbase.downloader.network.h) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? A : (com.ss.android.socialbase.downloader.d.b) invokeV.objValue;
    }

    public static IDownloadHttpService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            if (l == null) {
                synchronized (c.class) {
                    if (l == null) {
                        l = new com.ss.android.socialbase.downloader.impls.g();
                    }
                }
            }
            return l;
        }
        return (IDownloadHttpService) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.h i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            if (m == null) {
                synchronized (c.class) {
                    if (m == null) {
                        m = new com.ss.android.socialbase.downloader.impls.f();
                    }
                }
            }
            return m;
        }
        return (com.ss.android.socialbase.downloader.network.h) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) ? com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", V ? 1 : 0) > 0 : invokeV.booleanValue;
    }

    public static synchronized q k() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            synchronized (c.class) {
                qVar = z;
            }
            return qVar;
        }
        return (q) invokeV.objValue;
    }

    public static ExecutorService l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) {
            if (o == null) {
                synchronized (c.class) {
                    if (o == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(L, L, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        o = threadPoolExecutor;
                    }
                }
            }
            return o;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) ? p != null ? p : l() : (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) ? r != null ? r : p() : (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) ? s != null ? s : p() : (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) {
            if (q == null) {
                synchronized (c.class) {
                    if (q == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(N, N, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        q = threadPoolExecutor;
                    }
                }
            }
            return q;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            if (u == null) {
                synchronized (c.class) {
                    if (u == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(M, M, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        u = threadPoolExecutor;
                    }
                }
            }
            return u;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static ExecutorService r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            if (t == null) {
                synchronized (c.class) {
                    if (t == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(O, O, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        t = threadPoolExecutor;
                    }
                }
            }
            return t;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public static OkHttpClient s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) {
            if (E == null) {
                synchronized (c.class) {
                    if (E == null) {
                        E = t().build();
                    }
                }
            }
            return E;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static OkHttpClient.Builder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
            if (v != null) {
                builder.dispatcher(new Dispatcher(v));
            }
            return builder;
        }
        return (OkHttpClient.Builder) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.f u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) ? F : (com.ss.android.socialbase.downloader.network.f) invokeV.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) {
            if (G == null) {
                synchronized (c.class) {
                    if (G == null) {
                        G = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                    }
                                }
                            }

                            @Override // com.ss.android.socialbase.downloader.network.f
                            public List<InetAddress> a(String str) throws UnknownHostException {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? Dns.SYSTEM.lookup(str) : (List) invokeL.objValue;
                            }
                        };
                    }
                }
            }
            return G;
        }
        return (com.ss.android.socialbase.downloader.network.f) invokeV.objValue;
    }

    public static synchronized l w() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) {
            synchronized (c.class) {
                lVar = n;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }

    public static j x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) {
            if (f69257b == null) {
                synchronized (c.class) {
                    if (f69257b == null) {
                        f69257b = new com.ss.android.socialbase.downloader.impls.d();
                    }
                }
            }
            return f69257b;
        }
        return (j) invokeV.objValue;
    }

    public static o y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) {
            if (f69262g == null) {
                synchronized (c.class) {
                    if (f69262g == null) {
                        f69262g = new com.ss.android.socialbase.downloader.impls.h();
                    }
                }
            }
            return f69262g;
        }
        return (o) invokeV.objValue;
    }

    public static o z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) {
            if (f69263h == null) {
                synchronized (c.class) {
                    if (f69263h == null) {
                        f69263h = f69264i.a();
                    }
                }
            }
            return f69263h;
        }
        return (o) invokeV.objValue;
    }

    public static void d(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65606, null, executorService) == null) || executorService == null) {
            return;
        }
        p = executorService;
    }

    public static void f(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65610, null, executorService) == null) || executorService == null) {
            return;
        }
        r = executorService;
    }

    public static void g(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65612, null, executorService) == null) || executorService == null) {
            return;
        }
        s = executorService;
    }

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, null) == null) {
            synchronized (c.class) {
                if (D) {
                    return;
                }
                D = true;
                Intent intent = new Intent(N(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                N().startService(intent);
                if (!com.ss.android.socialbase.downloader.i.f.c()) {
                    com.ss.android.socialbase.downloader.impls.l.a(true).startService();
                }
            }
        }
    }

    public static void e(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65608, null, executorService) == null) || executorService == null) {
            return;
        }
        q = executorService;
    }

    public static void h(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65614, null, executorService) == null) || executorService == null) {
            return;
        }
        t = executorService;
    }

    public static void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, null, kVar) == null) {
            synchronized (R) {
                if (kVar != null) {
                    if (R.contains(kVar)) {
                        R.remove(kVar);
                    }
                }
            }
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65597, null, downloadTask, i2) == null) {
            synchronized (S) {
                for (ab abVar : S) {
                    if (abVar != null) {
                        abVar.b(downloadTask, i2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ss.android.socialbase.downloader.network.g b(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        InterceptResult invokeCommon;
        IOException iOException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65592, null, new Object[]{str, list, Integer.valueOf(i2), Boolean.valueOf(z2), downloadInfo})) == null) {
            com.ss.android.socialbase.downloader.network.h f2 = i2 == 1 ? f() : i();
            if (f2 != null) {
                long j2 = 0;
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            iOException = e2;
                            th = th;
                            if (z2) {
                                com.ss.android.socialbase.downloader.d.a.a(null, str, null, System.currentTimeMillis() - j2, "head", i2, iOException, downloadInfo);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        iOException = null;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                com.ss.android.socialbase.downloader.network.g a2 = f2.a(str, list);
                if (z2) {
                    com.ss.android.socialbase.downloader.d.a.a(a2, str, null, System.currentTimeMillis() - j2, "head", i2, null, downloadInfo);
                }
                return a2;
            }
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        return (com.ss.android.socialbase.downloader.network.g) invokeCommon.objValue;
    }

    public static void b(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65600, null, executorService) == null) || executorService == null) {
            return;
        }
        v = executorService;
    }

    public static void b(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65599, null, runnable, z2) == null) || runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            m().execute(runnable);
        }
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            synchronized (c.class) {
                try {
                    if (J && x != null && f69256a != null) {
                        f69256a.unregisterReceiver(x);
                        J = false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65598, null, runnable) == null) || runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            r().execute(runnable);
        }
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65594, null, i2) == null) || i2 <= 0) {
            return;
        }
        K = i2;
    }

    public static void a(ak akVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, null, akVar) == null) || akVar == null) {
            return;
        }
        synchronized (C) {
            C.add(akVar);
        }
    }

    public static void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65601, null, z2) == null) {
            U = z2;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, kVar) == null) {
            synchronized (R) {
                if (kVar != null) {
                    if (!R.contains(kVar)) {
                        R.add(kVar);
                    }
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, dVar) == null) {
            synchronized (R) {
                for (com.ss.android.socialbase.downloader.depend.k kVar : R) {
                    if (kVar != null) {
                        if (dVar == com.ss.android.socialbase.downloader.constants.d.f69174b) {
                            kVar.a();
                        } else if (dVar == com.ss.android.socialbase.downloader.constants.d.f69175c) {
                            kVar.b();
                        }
                    }
                }
                if (dVar == com.ss.android.socialbase.downloader.constants.d.f69175c) {
                    R.clear();
                }
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65583, null, downloadTask, i2) == null) {
            synchronized (S) {
                for (ab abVar : S) {
                    if (abVar != null) {
                        abVar.a(downloadTask, i2);
                    }
                }
            }
        }
    }

    public static synchronized boolean c() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            synchronized (c.class) {
                z2 = D;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public static void c(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65603, null, executorService) == null) || executorService == null) {
            return;
        }
        o = executorService;
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str, list})) == null) ? a(z2, i2, str, null, list, 0, false, null) : (com.ss.android.socialbase.downloader.network.i) invokeCommon.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        InterceptResult invokeCommon;
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.i a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str, str2, list, Integer.valueOf(i3), Boolean.valueOf(z3), downloadInfo})) == null) {
            if (!TextUtils.isEmpty(str2)) {
                List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
                arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
                list2 = arrayList;
                i4 = 1;
            } else if (z2) {
                list2 = list;
                i4 = i3;
            } else {
                i4 = 2;
                list2 = list;
            }
            int[] a3 = a(i4);
            Exception exc = null;
            for (int i5 : a3) {
                try {
                    a2 = a(i2, str, str2, list2, i5, z3, downloadInfo);
                } catch (Exception e2) {
                    if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(e2) && com.ss.android.socialbase.downloader.i.f.c(list2)) {
                        com.ss.android.socialbase.downloader.c.a.a("dcach::http exception 304, throw excepiton, not retry " + e2);
                        throw e2;
                    }
                    exc = e2;
                }
                if (a2 != null) {
                    return a2;
                }
            }
            if (exc == null) {
                return null;
            }
            throw exc;
        }
        return (com.ss.android.socialbase.downloader.network.i) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.ss.android.socialbase.downloader.network.i a(int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z2, DownloadInfo downloadInfo) throws BaseException, IOException {
        InterceptResult invokeCommon;
        IOException iOException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i2), str, str2, list, Integer.valueOf(i3), Boolean.valueOf(z2), downloadInfo})) == null) {
            IDownloadHttpService d2 = i3 == 1 ? d() : h();
            if (d2 != null) {
                IOException iOException2 = null;
                long j2 = 0;
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        e = e2;
                        iOException = e;
                        try {
                            throw iOException;
                        } catch (Throwable th) {
                            th = th;
                            iOException2 = iOException;
                            if (z2) {
                                com.ss.android.socialbase.downloader.d.a.a(null, str, str2, System.currentTimeMillis() - j2, "get", i3, iOException2, downloadInfo);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (z2) {
                        }
                        throw th;
                    }
                }
                try {
                    com.ss.android.socialbase.downloader.network.i downloadWithConnection = d2.downloadWithConnection(i2, str, list);
                    if (z2) {
                        com.ss.android.socialbase.downloader.d.a.a(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i3, null, downloadInfo);
                    }
                    return downloadWithConnection;
                } catch (IOException e3) {
                    e = e3;
                    iOException = e;
                    throw iOException;
                } catch (Throwable th3) {
                    th = th3;
                    if (z2) {
                    }
                    throw th;
                }
            }
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i3));
        }
        return (com.ss.android.socialbase.downloader.network.i) invokeCommon.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, list)) == null) ? a(str, list, 0, false, null) : (com.ss.android.socialbase.downloader.network.g) invokeLL.objValue;
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        InterceptResult invokeCommon;
        com.ss.android.socialbase.downloader.network.g b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{str, list, Integer.valueOf(i2), Boolean.valueOf(z2), downloadInfo})) == null) {
            Exception e2 = null;
            for (int i3 : a(i2)) {
                try {
                    b2 = b(str, list, i3, z2, downloadInfo);
                } catch (Exception e3) {
                    e2 = e3;
                }
                if (b2 != null) {
                    return b2;
                }
            }
            if (e2 == null) {
                return null;
            }
            throw e2;
        }
        return (com.ss.android.socialbase.downloader.network.g) invokeCommon.objValue;
    }

    public static int[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65591, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0} : (int[]) invokeI.objValue;
    }

    public static synchronized void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, lVar) == null) {
            synchronized (c.class) {
                if (lVar != null) {
                    n = lVar;
                    if (f69257b instanceof com.ss.android.socialbase.downloader.impls.d) {
                        ((com.ss.android.socialbase.downloader.impls.d) f69257b).h();
                    }
                }
            }
        }
    }

    public static void a(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65589, null, executorService) == null) || executorService == null) {
            return;
        }
        u = executorService;
    }

    public static void a(List<com.ss.android.socialbase.downloader.depend.m> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65588, null, list) == null) && I.isEmpty()) {
            synchronized (I) {
                I.addAll(list);
            }
        }
    }

    public static void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65590, null, z2) == null) {
            V = z2;
        }
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, runnable) == null) {
            b(runnable, false);
        }
    }

    public static void a(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65587, null, runnable, z2) == null) || runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.i.f.d()) {
            runnable.run();
        } else {
            l().execute(runnable);
        }
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, iDownloadHttpService) == null) {
            if (iDownloadHttpService != null) {
                j = iDownloadHttpService;
            }
            Q = j != null;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.network.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65585, null, hVar) == null) || hVar == null) {
            return;
        }
        k = hVar;
    }

    public static void a(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65579, null, jVar) == null) || jVar == null) {
            return;
        }
        f69257b = jVar;
    }

    public static void a(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, null, kVar) == null) || kVar == null) {
            return;
        }
        f69258c = kVar;
    }

    public static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, bVar) == null) || bVar == null) {
            return;
        }
        A = bVar;
    }

    public static void a(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, aaVar) == null) {
            B = aaVar;
            com.ss.android.socialbase.downloader.g.a.a();
        }
    }

    public static void a(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65578, null, hVar) == null) || hVar == null) {
            return;
        }
        f69259d = hVar;
    }

    public static void a(af afVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, null, afVar) == null) || afVar == null) {
            return;
        }
        f69260e = afVar;
    }

    public static void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65577, null, gVar) == null) || gVar == null) {
            return;
        }
        w = gVar;
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            synchronized (c.class) {
                if (context != null) {
                    if (f69256a == null) {
                        f69256a = context.getApplicationContext();
                        com.ss.android.socialbase.downloader.a.a.a().a(f69256a);
                    }
                }
            }
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return 0;
            }
            return a(downloadInfo.getUrl(), downloadInfo.getSavePath());
        }
        return invokeL.intValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) {
            k B2 = B();
            if (B2 == null) {
                return 0;
            }
            return B2.a(str, str2);
        }
        return invokeLL.intValue;
    }

    public static void a(com.ss.android.socialbase.downloader.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, cVar) == null) {
            X = cVar;
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, aVar) == null) {
            com.ss.android.socialbase.downloader.c.a.a("wjd", "setIndependentServiceCreator::creator=" + aVar);
            f69264i = aVar;
        }
    }
}
