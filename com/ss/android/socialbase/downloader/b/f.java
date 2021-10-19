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
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.t;
import c.p.a.e.b.i.i;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class f implements ServiceConnection, t {
    public static /* synthetic */ Interceptable $ic;
    public static boolean l;
    public static int m;
    public static long n;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.c f76162e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f76163f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f76164g;

    /* renamed from: h  reason: collision with root package name */
    public e.d.a f76165h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f76166i;

    /* renamed from: j  reason: collision with root package name */
    public Future<?> f76167j;
    public CountDownLatch k;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f76173e;

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
            this.f76173e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f.l || this.f76173e.f76165h == null) {
                return;
            }
            this.f76173e.f76165h.a();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IBinder f76174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f76175f;

        /* loaded from: classes10.dex */
        public class a implements IBinder.DeathRecipient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f76176e;

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
                this.f76176e = bVar;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    boolean unused = f.l = false;
                    if (this.f76176e.f76175f.w() || this.f76176e.f76175f.f76165h == null) {
                        return;
                    }
                    this.f76176e.f76175f.f76163f.postDelayed(this.f76176e.f76175f.f76166i, 2000L);
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
            this.f76175f = fVar;
            this.f76174e = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                        if (this.f76175f.f76164g != null && this.f76175f.f76162e != null) {
                            this.f76175f.f76162e.a(this.f76175f.f76164g);
                        }
                        this.f76175f.k.countDown();
                        this.f76174e.linkToDeath(new a(this), 0);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f76177e;

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
            this.f76177e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SqlDownloadCacheService.a(c.p.a.e.b.g.e.n(), this.f76177e);
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
        this.f76163f = new Handler(Looper.getMainLooper());
        this.f76164g = null;
        this.f76166i = new a(this);
        this.k = new CountDownLatch(1);
        SqlDownloadCacheService.a(c.p.a.e.b.g.e.n(), this);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.b.run():void] */
    public static /* synthetic */ e.d.a a(f fVar) {
        return fVar.f76165h;
    }

    @Override // c.p.a.e.b.g.k
    public boolean a(int i2, Map<Long, i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, map)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.b(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.c(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.d(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.e(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.f(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.g(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.h(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.i(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.j(i2);
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
    @Override // c.p.a.e.b.g.k
    /* renamed from: k */
    public ArrayList<i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            return null;
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
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
                if (this.f76162e != null) {
                    this.f76162e.a();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
        }
    }

    public void m(com.ss.android.socialbase.downloader.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
            synchronized (this) {
                if (this.f76162e != null) {
                    try {
                        this.f76162e.a(bVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    this.f76164g = bVar;
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, componentName, iBinder) == null) {
            l = true;
            this.f76163f.removeCallbacks(this.f76166i);
            try {
                this.f76162e = c.a.a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f76167j = c.p.a.e.b.g.e.A0().submit(new b(this, iBinder));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, componentName) == null) {
            this.f76162e = null;
            l = false;
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (Build.VERSION.SDK_INT < 26 && !l) {
                if (m > 5) {
                    c.p.a.e.b.c.a.j("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - n < 15000) {
                    c.p.a.e.b.c.a.j("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                    return false;
                }
                m++;
                n = currentTimeMillis;
                this.f76163f.postDelayed(new c(this), 1000L);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.t
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, c.p.a.e.b.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray, sparseArray2, bVar) == null) {
            c.p.a.e.b.g.e.A0().submit(new Runnable(this, sparseArray, sparseArray2, bVar) { // from class: com.ss.android.socialbase.downloader.b.f.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ SparseArray f76168e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SparseArray f76169f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ c.p.a.e.b.b.b f76170g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ f f76171h;

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
                    this.f76171h = this;
                    this.f76168e = sparseArray;
                    this.f76169f = sparseArray2;
                    this.f76170g = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    c.p.a.e.b.b.b bVar2;
                    Future future;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f76171h.m(new b.a(this) { // from class: com.ss.android.socialbase.downloader.b.f.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f76172a;

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
                                this.f76172a = this;
                            }

                            @Override // com.ss.android.socialbase.downloader.b.b
                            public void a(Map map, Map map2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLL(1048576, this, map, map2) == null) {
                                    c.p.a.e.b.l.f.v(this.f76172a.f76168e, map);
                                    c.p.a.e.b.l.f.v(this.f76172a.f76169f, map2);
                                    this.f76172a.f76170g.a();
                                    this.f76172a.f76171h.m((com.ss.android.socialbase.downloader.b.b) null);
                                }
                            }
                        });
                        try {
                            z = !this.f76171h.k.await(5000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            z = false;
                        }
                        if (z && (future = this.f76171h.f76167j) != null) {
                            future.cancel(true);
                        }
                        this.f76171h.l();
                        if (!z || (bVar2 = this.f76170g) == null) {
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
            this.f76165h = aVar;
        }
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.a(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.b(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.c(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.d(i2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.e();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.a(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.b();
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.c();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.d(i2, j2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.a(i2, i3, j2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.b(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.c(i2, j2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.d();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.a(i2, i3, i4, j2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.b(i2, j2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.a(i2, i3, i4, i5);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadInfo) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.b(downloadInfo);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.a(i2, i3);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, list) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.b(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.k
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadInfo)) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.a(downloadInfo);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.a(i2, j2, str, str2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                if (this.f76162e != null) {
                    return this.f76162e.a(i2, j2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // c.p.a.e.b.g.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, list) == null) {
            try {
                if (this.f76162e != null) {
                    this.f76162e.a(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
