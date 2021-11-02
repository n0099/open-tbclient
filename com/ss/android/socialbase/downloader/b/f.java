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
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f implements ServiceConnection, t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f69126b;

    /* renamed from: c  reason: collision with root package name */
    public static int f69127c;

    /* renamed from: d  reason: collision with root package name */
    public static long f69128d;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public c f69129a;

    /* renamed from: e  reason: collision with root package name */
    public Handler f69130e;

    /* renamed from: f  reason: collision with root package name */
    public b f69131f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.InterfaceC2002a f69132g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f69133h;

    /* renamed from: i  reason: collision with root package name */
    public Future<?> f69134i;
    public CountDownLatch j;

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
        this.f69130e = new Handler(Looper.getMainLooper());
        this.f69131f = null;
        this.f69133h = new Runnable(this) { // from class: com.ss.android.socialbase.downloader.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f69135a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69135a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || f.f69126b || this.f69135a.f69132g == null) {
                    return;
                }
                this.f69135a.f69132g.a();
            }
        };
        this.j = new CountDownLatch(1);
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), this);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.2.run():void] */
    public static /* synthetic */ c.a.InterfaceC2002a a(f fVar) {
        return fVar.f69132g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: a */
    public ArrayList<i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return null;
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, map)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.i(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.j(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            return null;
        }
        return (Map) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, componentName, iBinder) == null) {
            f69126b = true;
            this.f69130e.removeCallbacks(this.f69133h);
            try {
                this.f69129a = c.a.a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f69134i = com.ss.android.socialbase.downloader.downloader.c.l().submit(new Runnable(this, iBinder) { // from class: com.ss.android.socialbase.downloader.b.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IBinder f69136a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f69137b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iBinder};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69137b = this;
                    this.f69136a = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this) {
                            try {
                                if (this.f69137b.f69131f != null && this.f69137b.f69129a != null) {
                                    this.f69137b.f69129a.a(this.f69137b.f69131f);
                                }
                                this.f69137b.j.countDown();
                                this.f69136a.linkToDeath(new IBinder.DeathRecipient(this) { // from class: com.ss.android.socialbase.downloader.b.f.2.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f69138a;

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
                                        this.f69138a = this;
                                    }

                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            boolean unused = f.f69126b = false;
                                            if (this.f69138a.f69137b.g() || this.f69138a.f69137b.f69132g == null) {
                                                return;
                                            }
                                            this.f69138a.f69137b.f69130e.postDelayed(this.f69138a.f69137b.f69133h, 2000L);
                                        }
                                    }
                                }, 0);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, componentName) == null) {
            this.f69129a = null;
            f69126b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (Build.VERSION.SDK_INT < 26 && !f69126b) {
                if (f69127c > 5) {
                    com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f69128d < 15000) {
                    com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                    return false;
                }
                f69127c++;
                f69128d = currentTimeMillis;
                this.f69130e.postDelayed(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.b.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f69139a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69139a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), this.f69139a);
                        }
                    }
                }, 1000L);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.b(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.c(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.d(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.e(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.h(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public void a(c.a.InterfaceC2002a interfaceC2002a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC2002a) == null) {
            this.f69132g = interfaceC2002a;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.f(i2);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, sparseArray, sparseArray2, dVar) == null) {
            com.ss.android.socialbase.downloader.downloader.c.l().submit(new Runnable(this, sparseArray, sparseArray2, dVar) { // from class: com.ss.android.socialbase.downloader.b.f.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SparseArray f69140a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SparseArray f69141b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f69142c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ f f69143d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sparseArray, sparseArray2, dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69143d = this;
                    this.f69140a = sparseArray;
                    this.f69141b = sparseArray2;
                    this.f69142c = dVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    d dVar2;
                    Future future;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69143d.a(new b.a(this) { // from class: com.ss.android.socialbase.downloader.b.f.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f69144a;

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
                                this.f69144a = this;
                            }

                            @Override // com.ss.android.socialbase.downloader.b.b
                            public void a(Map map, Map map2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLL(1048576, this, map, map2) == null) {
                                    com.ss.android.socialbase.downloader.i.f.a(this.f69144a.f69140a, map);
                                    com.ss.android.socialbase.downloader.i.f.a(this.f69144a.f69141b, map2);
                                    this.f69144a.f69142c.a();
                                    this.f69144a.f69143d.a((b) null);
                                }
                            }
                        });
                        try {
                            z = !this.f69143d.j.await(5000L, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            z = false;
                        }
                        if (z && (future = this.f69143d.f69134i) != null) {
                            future.cancel(true);
                        }
                        this.f69143d.a();
                        if (!z || (dVar2 = this.f69142c) == null) {
                            return;
                        }
                        dVar2.a();
                    }
                }
            });
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            synchronized (this) {
                if (this.f69129a != null) {
                    try {
                        this.f69129a.a(bVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    this.f69131f = bVar;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.b(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.c(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.d(i2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.e();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.b();
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.c();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.d(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a();
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.b(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.c(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.d();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.g(i2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.a(str);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.b(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a(bVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadInfo) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.b(downloadInfo);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a(i2, i3, j);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, list) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.b(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a(i2, i3, i4, j);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a(i2, i3, i4, i5);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.a(i2, i3);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadInfo)) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.a(downloadInfo);
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2})) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.a(i2, j, str, str2);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                if (this.f69129a != null) {
                    return this.f69129a.a(i2, j);
                }
                return null;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, list) == null) {
            try {
                if (this.f69129a != null) {
                    this.f69129a.a(i2, list);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
