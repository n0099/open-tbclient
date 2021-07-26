package d.l.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.g.e;
import d.l.a.e.b.g.t;
import d.l.a.e.b.k.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class d implements d.l.a.e.b.g.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f72404e;

    /* renamed from: f  reason: collision with root package name */
    public t f72405f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f72406g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f72407h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f72408i;
    public d.l.a.e.b.k.h j;

    /* loaded from: classes8.dex */
    public class a implements h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f72409a;

        /* renamed from: d.l.a.e.b.m.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC2043a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f72410e;

            public RunnableC2043a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72410e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f72410e.f72409a.n();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72409a = dVar;
        }

        @Override // d.l.a.e.b.k.h.a
        public void a(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                d.l.a.e.b.g.e.A0().execute(new RunnableC2043a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements e.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f72411a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72411a = dVar;
        }

        @Override // d.l.a.e.b.g.e.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72411a.f72405f = new com.ss.android.socialbase.downloader.b.e();
                Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.l.a.e.b.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f72412a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f72413b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f72414c;

        public c(d dVar, SparseArray sparseArray, SparseArray sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, sparseArray, sparseArray2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72414c = dVar;
            this.f72412a = sparseArray;
            this.f72413b = sparseArray2;
        }

        @Override // d.l.a.e.b.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f72414c.f72404e) {
                    SparseArray<DownloadInfo> a2 = this.f72414c.f72404e.a();
                    if (this.f72412a != null) {
                        for (int i2 = 0; i2 < this.f72412a.size(); i2++) {
                            int keyAt = this.f72412a.keyAt(i2);
                            if (keyAt != 0) {
                                a2.put(keyAt, (DownloadInfo) this.f72412a.get(keyAt));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.f72414c.f72404e.f();
                    if (this.f72413b != null) {
                        for (int i3 = 0; i3 < this.f72413b.size(); i3++) {
                            int keyAt2 = this.f72413b.keyAt(i3);
                            if (keyAt2 != 0) {
                                f2.put(keyAt2, (List) this.f72413b.get(keyAt2));
                            }
                        }
                    }
                }
                this.f72414c.o();
                this.f72414c.m();
                d.l.a.e.b.g.e.D(com.ss.android.socialbase.downloader.constants.d.f38644c);
            }
        }
    }

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
        this.f72408i = new a(this);
        this.j = null;
        this.f72404e = new k();
        if (d.l.a.e.b.j.a.r().l("fix_sigbus_downloader_db")) {
            if (!d.l.a.e.b.l.f.F() && d.l.a.e.b.g.e.s()) {
                this.f72405f = d.l.a.e.b.g.e.t().a(new b(this));
            } else {
                this.f72405f = new com.ss.android.socialbase.downloader.b.e();
            }
        } else {
            this.f72405f = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f72406g = false;
        this.j = new d.l.a.e.b.k.h(Looper.getMainLooper(), this.f72408i);
        l();
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.f72404e.b(i2) : (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? this.f72404e.c(str) : (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f72406g : invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f72406g) {
                return true;
            }
            synchronized (this) {
                if (!this.f72406g) {
                    d.l.a.e.b.c.a.j("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                    try {
                        wait(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    d.l.a.e.b.c.a.j("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
                }
            }
            return this.f72406g;
        }
        return invokeV.booleanValue;
    }

    public k f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f72404e : (k) invokeV.objValue;
    }

    public final void h(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048608, this, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        if (!d.l.a.e.b.l.f.e0()) {
            this.f72405f.a(downloadInfo);
        } else if (z) {
            d.l.a.e.b.g.n a2 = l.a(true);
            if (a2 != null) {
                a2.c(downloadInfo);
            } else {
                this.f72405f.a(downloadInfo);
            }
        }
    }

    public final void j(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, downloadInfo) == null) {
            h(downloadInfo, true);
        }
    }

    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f72405f : (t) invokeV.objValue;
    }

    public void l() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            d.l.a.e.b.g.e.D(com.ss.android.socialbase.downloader.constants.d.f38643b);
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
            synchronized (this.f72404e) {
                SparseArray<DownloadInfo> a2 = this.f72404e.a();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    int keyAt = a2.keyAt(i2);
                    if (keyAt != 0 && (downloadInfo = a2.get(keyAt)) != null) {
                        sparseArray.put(keyAt, downloadInfo);
                    }
                }
                SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.f72404e.f();
                for (int i3 = 0; i3 < f2.size(); i3++) {
                    int keyAt2 = f2.keyAt(i3);
                    if (keyAt2 != 0 && (list = f2.get(keyAt2)) != null) {
                        sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                    }
                }
            }
            this.f72405f.a(sparseArray, sparseArray2, new c(this, sparseArray, sparseArray2));
        }
    }

    public void m() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (d.l.a.e.b.j.a.r().l("task_resume_delay")) {
                j = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            } else {
                j = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
            }
            this.j.sendMessageDelayed(this.j.obtainMessage(1), j);
        }
    }

    public void n() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.f72406g) {
            if (this.f72407h) {
                d.l.a.e.b.c.a.g("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f72407h = true;
            if (d.l.a.e.b.l.f.F()) {
                d.l.a.e.b.g.m L0 = d.l.a.e.b.g.e.L0();
                if (L0 != null) {
                    list = L0.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> a2 = this.f72404e.a();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        int keyAt = a2.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo2 = a2.get(keyAt)) != null) {
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
                            d.l.a.e.b.e.a.d(d.l.a.e.b.g.e.t0(), downloadInfo, null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (d.l.a.e.b.j.a.d(downloadInfo.getId()).m("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (L0 == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                L0.a(arrayList, 1);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            synchronized (this) {
                this.f72406g = true;
                notifyAll();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f72404e.a(str) : (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.f72404e.b(str) : (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f72404e.c(i2) : (List) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? this.f72404e.d(str) : (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.p(i2);
                } else {
                    this.f72405f.f(i2);
                }
            } else {
                this.f72405f.f(i2);
            }
            return this.f72404e.f(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            DownloadInfo g2 = this.f72404e.g(i2);
            j(g2);
            return g2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            DownloadInfo i3 = this.f72404e.i(i2);
            j(i3);
            return i3;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            DownloadInfo j = this.f72404e.j(i2);
            j(j);
            return j;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            synchronized (this.f72404e) {
                this.f72404e.a(bVar);
            }
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(bVar);
                    return;
                } else {
                    this.f72405f.a(bVar);
                    return;
                }
            }
            this.f72405f.a(bVar);
        }
    }

    @Override // d.l.a.e.b.g.k
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f72404e.b() : (List) invokeV.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                this.f72404e.c();
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.g();
                    return;
                } else {
                    this.f72405f.c();
                    return;
                }
            }
            this.f72405f.c();
        }
    }

    @Override // d.l.a.e.b.g.k
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f72404e.d(i2);
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.o(i2);
                    return;
                } else {
                    this.f72405f.d(i2);
                    return;
                }
            }
            this.f72405f.d(i2);
        }
    }

    @Override // d.l.a.e.b.g.k
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(bVar);
                    return;
                } else {
                    this.f72405f.a(bVar);
                    return;
                }
            }
            this.f72405f.a(bVar);
        }
    }

    @Override // d.l.a.e.b.g.k
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f72404e.m(i2);
            this.f72405f.m(i2);
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            DownloadInfo h2 = this.f72404e.h(i2);
            j(h2);
            return h2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo b(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            DownloadInfo b2 = this.f72404e.b(i2, j);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return b2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo d(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            DownloadInfo d2 = this.f72404e.d(i2, j);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return d2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo c(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            DownloadInfo c2 = this.f72404e.c(i2, j);
            b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
            return c2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        this.f72404e.a(downloadInfo);
    }

    @Override // d.l.a.e.b.g.k
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            try {
                if (d.l.a.e.b.l.f.e0()) {
                    d.l.a.e.b.g.n a2 = l.a(true);
                    if (a2 != null) {
                        a2.n(i2);
                    } else {
                        this.f72405f.e(i2);
                    }
                } else {
                    this.f72405f.e(i2);
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            return this.f72404e.e(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            this.f72404e.a(i2, i3, j);
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, j);
                    return;
                } else {
                    this.f72405f.a(i2, i3, j);
                    return;
                }
            }
            this.f72405f.a(i2, i3, j);
        }
    }

    @Override // d.l.a.e.b.g.k
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, list) == null) {
            try {
                a(this.f72404e.b(i2));
                if (list == null) {
                    list = this.f72404e.c(i2);
                }
                if (d.l.a.e.b.l.f.e0()) {
                    d.l.a.e.b.g.n a2 = l.a(true);
                    if (a2 != null) {
                        a2.b(i2, list);
                        return;
                    } else {
                        this.f72405f.b(i2, list);
                        return;
                    }
                }
                this.f72405f.b(i2, list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, i4, j);
                    return;
                } else {
                    this.f72405f.a(i2, i3, i4, j);
                    return;
                }
            }
            this.f72405f.a(i2, i3, i4, j);
        }
    }

    @Override // d.l.a.e.b.g.k
    public Map<Long, d.l.a.e.b.i.i> l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            Map<Long, d.l.a.e.b.i.i> l = this.f72404e.l(i2);
            if (l == null || l.isEmpty()) {
                Map<Long, d.l.a.e.b.i.i> l2 = this.f72405f.l(i2);
                this.f72404e.a(i2, l2);
                return l2;
            }
            return l;
        }
        return (Map) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            if (d.l.a.e.b.l.f.e0()) {
                d.l.a.e.b.g.n a2 = l.a(true);
                if (a2 != null) {
                    a2.a(i2, i3, i4, i5);
                    return;
                } else {
                    this.f72405f.a(i2, i3, i4, i5);
                    return;
                }
            }
            this.f72405f.a(i2, i3, i4, i5);
        }
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            DownloadInfo a2 = this.f72404e.a(i2, i3);
            j(a2);
            return a2;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            boolean a2 = this.f72404e.a(downloadInfo);
            j(downloadInfo);
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2})) == null) {
            DownloadInfo a2 = this.f72404e.a(i2, j, str, str2);
            j(a2);
            return a2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public DownloadInfo a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            DownloadInfo a2 = this.f72404e.a(i2, j);
            h(a2, false);
            return a2;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public List<d.l.a.e.b.i.i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            List<d.l.a.e.b.i.i> n = this.f72404e.n(i2);
            return (n == null || n.size() == 0) ? this.f72405f.n(i2) : n;
        }
        return (List) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.k
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.f72404e.a(i2, list);
        if (d.l.a.e.b.l.f.p0()) {
            this.f72405f.b(i2, list);
        }
    }

    @Override // d.l.a.e.b.g.k
    public boolean a(int i2, Map<Long, d.l.a.e.b.i.i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, map)) == null) {
            this.f72404e.a(i2, map);
            this.f72405f.a(i2, map);
            return false;
        }
        return invokeIL.booleanValue;
    }
}
