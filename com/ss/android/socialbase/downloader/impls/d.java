package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public t f61928b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f61929c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f61930d;

    /* renamed from: e  reason: collision with root package name */
    public h.a f61931e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.h.h f61932f;

    public d() {
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
        this.f61931e = new h.a(this) { // from class: com.ss.android.socialbase.downloader.impls.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
                this.a = this;
            }

            @Override // com.ss.android.socialbase.downloader.h.h.a
            public void a(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                    com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                try {
                                    this.a.a.i();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        };
        this.f61932f = null;
        this.a = new k();
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.i.f.a() && com.ss.android.socialbase.downloader.downloader.c.S()) {
                this.f61928b = com.ss.android.socialbase.downloader.downloader.c.T().a(new c.a.InterfaceC2131a(this) { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d a;

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
                        this.a = this;
                    }

                    @Override // com.ss.android.socialbase.downloader.downloader.c.a.InterfaceC2131a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.f61928b = new com.ss.android.socialbase.downloader.b.e();
                        }
                    }
                });
            } else {
                this.f61928b = new com.ss.android.socialbase.downloader.b.e();
            }
        } else {
            this.f61928b = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f61929c = false;
        this.f61932f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this.f61931e);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (this) {
                this.f61929c = true;
                notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? this.a.c(str) : (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f61929c : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f61929c) {
                return true;
            }
            synchronized (this) {
                if (!this.f61929c) {
                    com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                    try {
                        wait(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
                }
            }
            return this.f61929c;
        }
        return invokeV.booleanValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f61928b : (t) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            DownloadInfo g2 = this.a.g(i2);
            c(g2);
            return g2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public void h() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("task_resume_delay")) {
                j2 = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            } else {
                j2 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
            }
            this.f61932f.sendMessageDelayed(this.f61932f.obtainMessage(1), j2);
        }
    }

    public void i() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.f61929c) {
            if (this.f61930d) {
                com.ss.android.socialbase.downloader.c.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f61930d = true;
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                com.ss.android.socialbase.downloader.downloader.l w = com.ss.android.socialbase.downloader.downloader.c.w();
                if (w != null) {
                    list = w.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> a = this.a.a();
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        int keyAt = a.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo2 = a.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int keyAt2 = sparseArray.keyAt(i3);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (w == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                w.a(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            Map<Long, com.ss.android.socialbase.downloader.f.i> l = this.a.l(i2);
            if (l == null || l.isEmpty()) {
                Map<Long, com.ss.android.socialbase.downloader.f.i> l2 = this.f61928b.l(i2);
                this.a.a(i2, l2);
                return l2;
            }
            return l;
        }
        return (Map) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.a.m(i2);
            this.f61928b.m(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            List<com.ss.android.socialbase.downloader.f.i> n = this.a.n(i2);
            return (n == null || n.size() == 0) ? this.f61928b.n(i2) : n;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.a.b(i2) : (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.a.c(i2) : (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.a.d(str) : (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.p(i2);
                } else {
                    this.f61928b.f(i2);
                }
            } else {
                this.f61928b.f(i2);
            }
            return this.a.f(i2);
        }
        return invokeI.booleanValue;
    }

    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (k) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? this.a.b(str) : (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                this.a.c();
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.f();
                    return;
                } else {
                    this.f61928b.c();
                    return;
                }
            }
            this.f61928b.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.a.d(i2);
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.o(i2);
                    return;
                } else {
                    this.f61928b.d(i2);
                    return;
                }
            }
            this.f61928b.d(i2);
        }
    }

    public void g() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.f61665b);
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
            synchronized (this.a) {
                SparseArray<DownloadInfo> a = this.a.a();
                for (int i2 = 0; i2 < a.size(); i2++) {
                    int keyAt = a.keyAt(i2);
                    if (keyAt != 0 && (downloadInfo = a.get(keyAt)) != null) {
                        sparseArray.put(keyAt, downloadInfo);
                    }
                }
                SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.a.f();
                for (int i3 = 0; i3 < f2.size(); i3++) {
                    int keyAt2 = f2.keyAt(i3);
                    if (keyAt2 != 0 && (list = f2.get(keyAt2)) != null) {
                        sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                    }
                }
            }
            this.f61928b.a(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.b.d(this, sparseArray, sparseArray2) { // from class: com.ss.android.socialbase.downloader.impls.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SparseArray a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SparseArray f61933b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f61934c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sparseArray, sparseArray2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61934c = this;
                    this.a = sparseArray;
                    this.f61933b = sparseArray2;
                }

                @Override // com.ss.android.socialbase.downloader.b.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f61934c.a) {
                            SparseArray<DownloadInfo> a2 = this.f61934c.a.a();
                            if (this.a != null) {
                                for (int i4 = 0; i4 < this.a.size(); i4++) {
                                    int keyAt3 = this.a.keyAt(i4);
                                    if (keyAt3 != 0) {
                                        a2.put(keyAt3, (DownloadInfo) this.a.get(keyAt3));
                                    }
                                }
                            }
                            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f3 = this.f61934c.a.f();
                            if (this.f61933b != null) {
                                for (int i5 = 0; i5 < this.f61933b.size(); i5++) {
                                    int keyAt4 = this.f61933b.keyAt(i5);
                                    if (keyAt4 != 0) {
                                        f3.put(keyAt4, (List) this.f61933b.get(keyAt4));
                                    }
                                }
                            }
                        }
                        this.f61934c.j();
                        this.f61934c.h();
                        com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.f61666c);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.a.a(str) : (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.b() : (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            synchronized (this.a) {
                this.a.a(bVar);
            }
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.a(bVar);
                    return;
                } else {
                    this.f61928b.a(bVar);
                    return;
                }
            }
            this.f61928b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.a(bVar);
                    return;
                } else {
                    this.f61928b.a(bVar);
                    return;
                }
            }
            this.f61928b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            DownloadInfo h2 = this.a.h(i2);
            c(h2);
            return h2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            DownloadInfo j2 = this.a.j(i2);
            c(j2);
            return j2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo d2 = this.a.d(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return d2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    private void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, downloadInfo) == null) {
            a(downloadInfo, true);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo b2 = this.a.b(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo c2 = this.a.c(i2, j2);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return c2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            try {
                if (com.ss.android.socialbase.downloader.i.f.b()) {
                    com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                    if (a != null) {
                        a.n(i2);
                    } else {
                        this.f61928b.e(i2);
                    }
                } else {
                    this.f61928b.e(i2);
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            return this.a.e(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, list) == null) {
            try {
                a(this.a.b(i2));
                if (list == null) {
                    list = this.a.c(i2);
                }
                if (com.ss.android.socialbase.downloader.i.f.b()) {
                    com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                    if (a != null) {
                        a.b(i2, list);
                        return;
                    } else {
                        this.f61928b.b(i2, list);
                        return;
                    }
                }
                this.f61928b.b(i2, list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            this.a.a(i2, i3, j2);
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.a(i2, i3, j2);
                    return;
                } else {
                    this.f61928b.a(i2, i3, j2);
                    return;
                }
            }
            this.f61928b.a(i2, i3, j2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.a(i2, i3, i4, j2);
                    return;
                } else {
                    this.f61928b.a(i2, i3, i4, j2);
                    return;
                }
            }
            this.f61928b.a(i2, i3, i4, j2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.a(i2, i3, i4, i5);
                    return;
                } else {
                    this.f61928b.a(i2, i3, i4, i5);
                    return;
                }
            }
            this.f61928b.a(i2, i3, i4, i5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            DownloadInfo a = this.a.a(i2, i3);
            c(a);
            return a;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            boolean a = this.a.a(downloadInfo);
            c(downloadInfo);
            return a;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            DownloadInfo a = this.a.a(i2, j2, str, str2);
            c(a);
            return a;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            DownloadInfo i3 = this.a.i(i2);
            c(i3);
            return i3;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            DownloadInfo a = this.a.a(i2, j2);
            a(a, false);
            return a;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    private void a(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, this, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.b()) {
            this.f61928b.a(downloadInfo);
        } else if (z) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.c(downloadInfo);
            } else {
                this.f61928b.a(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.a.a(i2, list);
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            this.f61928b.b(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, map)) == null) {
            this.a.a(i2, map);
            this.f61928b.a(i2, map);
            return false;
        }
        return invokeIL.booleanValue;
    }
}
