package com.ss.android.socialbase.downloader.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.g.e;
import d.l.a.e.b.g.t;
import d.l.a.e.b.i.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class f implements ServiceConnection, t {
    public static /* synthetic */ Interceptable $ic;
    public static boolean l;
    public static int m;
    public static long n;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.c f38615e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f38616f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f38617g;

    /* renamed from: h  reason: collision with root package name */
    public e.d.a f38618h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f38619i;
    public Future<?> j;
    public CountDownLatch k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f38625e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38625e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f.l || this.f38625e.f38618h == null) {
                return;
            }
            this.f38625e.f38618h.a();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IBinder f38626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f38627f;

        /* loaded from: classes6.dex */
        public class a implements IBinder.DeathRecipient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f38628e;

            public a(b bVar) {
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
                this.f38628e = bVar;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = f.l = false;
                    if (this.f38628e.f38627f.w() || this.f38628e.f38627f.f38618h == null) {
                        return;
                    }
                    this.f38628e.f38627f.f38616f.postDelayed(this.f38628e.f38627f.f38619i, 2000L);
                }
            }
        }

        public b(f fVar, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, iBinder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38627f = fVar;
            this.f38626e = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                        if (this.f38627f.f38617g != null && this.f38627f.f38615e != null) {
                            this.f38627f.f38615e.a(this.f38627f.f38617g);
                        }
                        this.f38627f.k.countDown();
                        this.f38626e.linkToDeath(new a(this), 0);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f38629e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38629e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SqlDownloadCacheService.a(d.l.a.e.b.g.e.n(), this.f38629e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(479221888, "Lcom/ss/android/socialbase/downloader/b/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(479221888, "Lcom/ss/android/socialbase/downloader/b/f;");
        }
    }

    public f() {
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
        this.f38616f = new Handler(Looper.getMainLooper());
        this.f38617g = null;
        this.f38619i = new a(this);
        this.k = new CountDownLatch(1);
        SqlDownloadCacheService.a(d.l.a.e.b.g.e.n(), this);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.b.run():void] */
    public static /* synthetic */ e.d.a a(f fVar) {
        return fVar.f38618h;
    }

    @Override // d.l.a.e.b.g.k
    public boolean a(int i2, Map<Long, i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, map)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.b(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.c(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.d(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.e(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.f(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.g(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.h(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.i(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.j(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.l.a.e.b.g.k
    /* renamed from: k */
    public ArrayList<i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            return null;
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public Map<Long, i> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            return null;
        }
        return (Map) invokeI.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
        }
    }

    public void m(com.ss.android.socialbase.downloader.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
            synchronized (this) {
                if (this.f38615e != null) {
                    try {
                        this.f38615e.a(bVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    this.f38617g = bVar;
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, componentName, iBinder) == null) {
            l = true;
            this.f38616f.removeCallbacks(this.f38619i);
            try {
                this.f38615e = c.a.a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.j = d.l.a.e.b.g.e.A0().submit(new b(this, iBinder));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, componentName) == null) {
            this.f38615e = null;
            l = false;
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (Build.VERSION.SDK_INT < 26 && !l) {
                if (m > 5) {
                    d.l.a.e.b.c.a.j("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - n < 15000) {
                    d.l.a.e.b.c.a.j("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                    return false;
                }
                m++;
                n = currentTimeMillis;
                this.f38616f.postDelayed(new c(this), 1000L);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.t
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, d.l.a.e.b.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray, sparseArray2, bVar) == null) {
            d.l.a.e.b.g.e.A0().submit(new Runnable(this, sparseArray, sparseArray2, bVar) { // from class: com.ss.android.socialbase.downloader.b.f.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ SparseArray f38620e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SparseArray f38621f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ d.l.a.e.b.b.b f38622g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ f f38623h;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sparseArray, sparseArray2, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38623h = this;
                    this.f38620e = sparseArray;
                    this.f38621f = sparseArray2;
                    this.f38622g = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    d.l.a.e.b.b.b bVar2;
                    Future future;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38623h.m(new b.a(this) { // from class: com.ss.android.socialbase.downloader.b.f.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f38624a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f38624a = this;
                            }

                            @Override // com.ss.android.socialbase.downloader.b.b
                            public void a(Map map, Map map2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLL(1048576, this, map, map2) == null) {
                                    d.l.a.e.b.l.f.v(this.f38624a.f38620e, map);
                                    d.l.a.e.b.l.f.v(this.f38624a.f38621f, map2);
                                    this.f38624a.f38622g.a();
                                    this.f38624a.f38623h.m((com.ss.android.socialbase.downloader.b.b) null);
                                }
                            }
                        });
                        try {
                            z = !this.f38623h.k.await(5000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            z = false;
                        }
                        if (z && (future = this.f38623h.j) != null) {
                            future.cancel(true);
                        }
                        this.f38623h.l();
                        if (!z || (bVar2 = this.f38622g) == null) {
                            return;
                        }
                        bVar2.a();
                    }
                }
            });
        }
    }

    public void n(e.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, aVar) == null) {
            this.f38618h = aVar;
        }
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.a(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.b(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.c(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.d(i2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.e();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.b();
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.c();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo d(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.d(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a(i2, i3, j);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.b(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo c(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.c(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.d();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a(i2, i3, i4, j);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo b(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.b(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a(i2, i3, i4, i5);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadInfo) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.b(downloadInfo);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.a(i2, i3);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, list) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.b(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadInfo)) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.a(downloadInfo);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2})) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.a(i2, j, str, str2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f38615e != null) {
                    return this.f38615e.a(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, list) == null) {
            try {
                if (this.f38615e != null) {
                    this.f38615e.a(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
