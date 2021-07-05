package d.l.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.v;
import d.l.a.e.b.f.z;
import d.l.a.e.b.g.r;
import d.l.a.e.b.k.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes10.dex */
public abstract class a implements h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f74876a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f74877b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f74878c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f74879d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f74880e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<SparseArray<d.l.a.e.b.n.a>> f74881f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<Integer, d.l.a.e.b.n.a> f74882g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Long> f74883h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedBlockingDeque<d.l.a.e.b.n.a> f74884i;
    public final d.l.a.e.b.g.k j;
    public final d.l.a.e.b.k.h k;

    /* renamed from: d.l.a.e.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC2075a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f74885e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74886f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SparseArray f74887g;

        public RunnableC2075a(a aVar, SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, downloadInfo, sparseArray2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74885e = sparseArray;
            this.f74886f = downloadInfo;
            this.f74887g = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SparseArray sparseArray2 = this.f74885e;
                if (sparseArray2 != null) {
                    synchronized (sparseArray2) {
                        for (int i2 = 0; i2 < this.f74885e.size(); i2++) {
                            d.l.a.e.b.f.b bVar = (d.l.a.e.b.f.b) this.f74885e.get(this.f74885e.keyAt(i2));
                            if (bVar != null) {
                                bVar.e(this.f74886f);
                            }
                        }
                    }
                }
                DownloadInfo downloadInfo = this.f74886f;
                if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = this.f74887g) == null) {
                    return;
                }
                synchronized (sparseArray) {
                    for (int i3 = 0; i3 < this.f74887g.size(); i3++) {
                        d.l.a.e.b.f.b bVar2 = (d.l.a.e.b.f.b) this.f74887g.get(this.f74887g.keyAt(i3));
                        if (bVar2 != null) {
                            bVar2.e(this.f74886f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74888e;

        public b(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74888e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.l.a.e.b.p.b.a().m(this.f74888e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f74890f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f74891g;

        public c(a aVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74891g = aVar;
            this.f74889e = i2;
            this.f74890f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.l.a.e.b.n.a T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f74891g.D(this.f74889e) == null && (T = this.f74891g.T(this.f74889e)) != null) {
                    DownloadInfo J = T.J();
                    SparseArray<d.l.a.e.b.f.b> M = T.M(com.ss.android.socialbase.downloader.constants.g.f41461b);
                    if (M != null) {
                        synchronized (M) {
                            for (int i2 = 0; i2 < M.size(); i2++) {
                                d.l.a.e.b.f.b bVar = M.get(M.keyAt(i2));
                                if (bVar != null) {
                                    bVar.e(J);
                                }
                            }
                        }
                    }
                }
                this.f74891g.H(this.f74889e, this.f74890f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74892e;

        public d(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74892e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.l.a.e.b.p.b.a().m(this.f74892e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f74894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f74895g;

        public e(a aVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74895g = aVar;
            this.f74893e = i2;
            this.f74894f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74895g.D(this.f74893e);
                this.f74895g.I(this.f74893e, this.f74894f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.f.b f74896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f74897f;

        public f(a aVar, d.l.a.e.b.f.b bVar, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74896e = bVar;
            this.f74897f = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f74896e == null) {
                return;
            }
            if (this.f74897f.getStatus() == -3) {
                this.f74896e.f(this.f74897f);
            } else if (this.f74897f.getStatus() == -1) {
                this.f74896e.h(this.f74897f, new BaseException(1000, "try add listener for failed task"));
            }
        }
    }

    public a() {
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
        this.f74876a = new SparseArray<>();
        this.f74877b = new SparseArray<>();
        this.f74878c = new SparseArray<>();
        this.f74879d = new SparseArray<>();
        this.f74880e = new SparseArray<>();
        this.f74881f = new SparseArray<>();
        this.f74882g = new com.ss.android.socialbase.downloader.i.h<>();
        this.f74883h = new SparseArray<>();
        this.f74884i = new LinkedBlockingDeque<>();
        this.k = new d.l.a.e.b.k.h(Looper.getMainLooper(), this);
        this.j = d.l.a.e.b.g.e.M0();
    }

    public final void A(d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            int P = aVar.P();
            if (P == 0 && aVar.Z()) {
                P = aVar.f();
            }
            if (P == 0) {
                return;
            }
            SparseArray<d.l.a.e.b.n.a> sparseArray = this.f74881f.get(aVar.I());
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.f74881f.put(aVar.I(), sparseArray);
            }
            d.l.a.e.b.c.a.g("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + aVar.I() + " listener hasCode:" + P);
            sparseArray.put(P, aVar);
        }
    }

    public synchronized void B(List<String> list) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (d.l.a.e.b.l.f.g0(d.l.a.e.b.g.e.n())) {
                    for (int i2 = 0; i2 < this.f74876a.size(); i2++) {
                        d.l.a.e.b.n.a aVar = this.f74876a.get(this.f74876a.keyAt(i2));
                        if (aVar != null && (J = aVar.J()) != null && J.getMimeType() != null && list.contains(J.getMimeType()) && C(J)) {
                            J.setAutoResumed(true);
                            J.setShowNotificationForNetworkResumed(true);
                            o(aVar);
                            J.setDownloadFromReserveWifi(true);
                            r n = d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).n();
                            if (n != null) {
                                n.a(J, 5, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean C(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
            if (downloadInfo != null && downloadInfo.statusInPause()) {
                return downloadInfo.isPauseReserveOnWifi();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract d.l.a.e.b.k.c D(int i2);

    public void E(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null) {
                n(b2);
            }
            this.k.post(new d(this, i2));
            d.l.a.e.b.g.e.W(new e(this, i2, z), false);
        }
    }

    public final void F(d.l.a.e.b.n.a aVar) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || (J = aVar.J()) == null) {
            return;
        }
        try {
            if (this.f74884i.isEmpty()) {
                p(aVar, true);
                this.f74884i.put(aVar);
            } else if (J.getEnqueueType() == com.ss.android.socialbase.downloader.constants.f.f41458c) {
                if (this.f74884i.getFirst().I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                Iterator<d.l.a.e.b.n.a> it = this.f74884i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.l.a.e.b.n.a next = it.next();
                    if (next != null && next.I() == aVar.I()) {
                        it.remove();
                        break;
                    }
                }
                this.f74884i.put(aVar);
                new d.l.a.e.b.g.h(aVar, this.k).b();
            } else {
                d.l.a.e.b.n.a first = this.f74884i.getFirst();
                if (first.I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                J(first.I());
                p(aVar, true);
                if (first.I() != aVar.I()) {
                    this.f74884i.putFirst(aVar);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized DownloadInfo G(int i2) {
        InterceptResult invokeI;
        DownloadInfo b2;
        d.l.a.e.b.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this) {
                b2 = this.j.b(i2);
                if (b2 == null && (aVar = this.f74876a.get(i2)) != null) {
                    b2 = aVar.J();
                }
            }
            return b2;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public final synchronized void H(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                d.l.a.e.b.c.a.g("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
                DownloadInfo b2 = this.j.b(i2);
                if (b2 != null) {
                    if (z) {
                        d.l.a.e.b.l.f.w(b2);
                    } else {
                        d.l.a.e.b.l.f.n0(b2.getTempPath(), b2.getTempName());
                    }
                    b2.erase();
                }
                try {
                    this.j.f(i2);
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
                e(i2, 0, -4);
                if (this.f74878c.get(i2) != null) {
                    this.f74878c.remove(i2);
                }
                if (this.f74877b.get(i2) != null) {
                    this.f74877b.remove(i2);
                }
                this.f74882g.remove(Integer.valueOf(i2));
                d.l.a.e.b.j.a.p(i2);
            }
        }
    }

    public final void I(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                DownloadInfo b2 = this.j.b(i2);
                if (b2 != null) {
                    d.l.a.e.b.l.f.z(b2, z);
                    b2.erase();
                }
                try {
                    this.j.d(i2);
                    this.j.a(b2);
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
                if (this.f74878c.get(i2) != null) {
                    this.f74878c.remove(i2);
                }
                if (this.f74877b.get(i2) != null) {
                    this.f74877b.remove(i2);
                }
                this.f74882g.remove(Integer.valueOf(i2));
                d.l.a.e.b.j.a.p(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.c.a.g("AbsDownloadEngine", "pause id=" + i2);
                DownloadInfo b2 = this.j.b(i2);
                if (b2 == null || b2.getStatus() != 11) {
                    synchronized (this.f74876a) {
                        v(i2);
                    }
                    if (b2 == null) {
                        d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                        if (aVar != null) {
                            new d.l.a.e.b.g.h(aVar, this.k).u();
                            return true;
                        }
                    } else {
                        n(b2);
                        if (b2.getStatus() == 1) {
                            d.l.a.e.b.n.a aVar2 = this.f74876a.get(i2);
                            if (aVar2 != null) {
                                new d.l.a.e.b.g.h(aVar2, this.k).u();
                                return true;
                            }
                        } else if (d.l.a.e.b.d.a.b(b2.getStatus())) {
                            b2.setStatus(-2);
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null) {
                    DownloadInfo J = aVar.J();
                    if (J != null) {
                        J.setDownloadFromReserveWifi(false);
                    }
                    o(aVar);
                } else {
                    L(i2);
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74878c.get(i2);
                if (aVar == null) {
                    aVar = this.f74879d.get(i2);
                }
                if (aVar != null) {
                    DownloadInfo J = aVar.J();
                    if (J != null) {
                        J.setDownloadFromReserveWifi(false);
                    }
                    o(aVar);
                    return true;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized d.l.a.e.b.f.i M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null) {
                    return aVar.S();
                }
                d.l.a.e.b.n.a aVar2 = this.f74877b.get(i2);
                if (aVar2 != null) {
                    return aVar2.S();
                }
                d.l.a.e.b.n.a aVar3 = this.f74878c.get(i2);
                if (aVar3 != null) {
                    return aVar3.S();
                }
                d.l.a.e.b.n.a aVar4 = this.f74879d.get(i2);
                if (aVar4 != null) {
                    return aVar4.S();
                }
                d.l.a.e.b.n.a aVar5 = this.f74880e.get(i2);
                if (aVar5 != null) {
                    return aVar5.S();
                }
                return null;
            }
        }
        return (d.l.a.e.b.f.i) invokeI.objValue;
    }

    public synchronized d.l.a.e.b.f.d N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null) {
                    return aVar.T();
                }
                d.l.a.e.b.n.a aVar2 = this.f74877b.get(i2);
                if (aVar2 != null) {
                    return aVar2.T();
                }
                d.l.a.e.b.n.a aVar3 = this.f74878c.get(i2);
                if (aVar3 != null) {
                    return aVar3.T();
                }
                d.l.a.e.b.n.a aVar4 = this.f74879d.get(i2);
                if (aVar4 != null) {
                    return aVar4.T();
                }
                d.l.a.e.b.n.a aVar5 = this.f74880e.get(i2);
                if (aVar5 != null) {
                    return aVar5.T();
                }
                return null;
            }
        }
        return (d.l.a.e.b.f.d) invokeI.objValue;
    }

    public synchronized v O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null) {
                    return aVar.N();
                }
                d.l.a.e.b.n.a aVar2 = this.f74877b.get(i2);
                if (aVar2 != null) {
                    return aVar2.N();
                }
                d.l.a.e.b.n.a aVar3 = this.f74878c.get(i2);
                if (aVar3 != null) {
                    return aVar3.N();
                }
                d.l.a.e.b.n.a aVar4 = this.f74879d.get(i2);
                if (aVar4 != null) {
                    return aVar4.N();
                }
                d.l.a.e.b.n.a aVar5 = this.f74880e.get(i2);
                if (aVar5 != null) {
                    return aVar5.N();
                }
                return null;
            }
        }
        return (v) invokeI.objValue;
    }

    public synchronized boolean P(int i2) {
        InterceptResult invokeI;
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74879d.get(i2);
                if (aVar != null && (J = aVar.J()) != null) {
                    if (J.canStartRetryDelayTask()) {
                        p(aVar, false);
                    }
                    return true;
                }
                DownloadInfo b2 = this.j.b(i2);
                if (b2 != null && b2.canStartRetryDelayTask()) {
                    p(new d.l.a.e.b.n.a(b2), false);
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean Q(int i2) {
        InterceptResult invokeI;
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74880e.get(i2);
                if (aVar == null || (J = aVar.J()) == null) {
                    return false;
                }
                if (J.canReStartAsyncTask()) {
                    o(aVar);
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized void R(int i2) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null && (J = aVar.J()) != null) {
                    J.setForceIgnoreRecommendSize(true);
                    o(aVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r4.f74878c.get(r5) != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean S(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            synchronized (this) {
                if (i2 != 0) {
                    if (this.f74876a.get(i2) == null) {
                    }
                    z = true;
                }
                z = false;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final d.l.a.e.b.n.a T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
            if (aVar == null) {
                d.l.a.e.b.n.a aVar2 = this.f74878c.get(i2);
                if (aVar2 == null) {
                    d.l.a.e.b.n.a aVar3 = this.f74877b.get(i2);
                    if (aVar3 == null) {
                        d.l.a.e.b.n.a aVar4 = this.f74879d.get(i2);
                        return aVar4 == null ? this.f74880e.get(i2) : aVar4;
                    }
                    return aVar3;
                }
                return aVar2;
            }
            return aVar;
        }
        return (d.l.a.e.b.n.a) invokeI.objValue;
    }

    public final void U(int i2) {
        d.l.a.e.b.n.a first;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.f74884i.isEmpty()) {
            return;
        }
        d.l.a.e.b.n.a first2 = this.f74884i.getFirst();
        if (first2 != null && first2.I() == i2) {
            this.f74884i.poll();
        }
        if (this.f74884i.isEmpty() || (first = this.f74884i.getFirst()) == null) {
            return;
        }
        p(first, true);
    }

    public abstract List<Integer> b();

    public synchronized List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                List<DownloadInfo> a2 = this.j.a(str);
                if (a2 == null || a2.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    int size = this.f74876a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.l.a.e.b.n.a valueAt = this.f74876a.valueAt(i2);
                        if (valueAt != null && valueAt.J() != null && str.equals(valueAt.J().getUrl())) {
                            arrayList.add(valueAt.J());
                        }
                    }
                    return arrayList;
                }
                return a2;
            }
        }
        return (List) invokeL.objValue;
    }

    public final void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            d.l.a.e.b.c.a.g("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
            if (i3 == 0) {
                this.f74876a.remove(i2);
                this.f74881f.remove(i2);
                return;
            }
            SparseArray<d.l.a.e.b.n.a> sparseArray = this.f74881f.get(i2);
            if (sparseArray != null) {
                sparseArray.remove(i3);
                d.l.a.e.b.c.a.g("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
                if (sparseArray.size() == 0) {
                    this.f74876a.remove(i2);
                    this.f74881f.remove(i2);
                    return;
                }
                return;
            }
            this.f74876a.remove(i2);
        }
    }

    public synchronized void e(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048601, this, i2, i3, i4) == null) {
            synchronized (this) {
                if (i4 != -7) {
                    if (i4 == -6) {
                        this.f74877b.put(i2, this.f74876a.get(i2));
                        d(i2, i3);
                    } else if (i4 == -4) {
                        d(i2, i3);
                        U(i2);
                    } else if (i4 == -3) {
                        this.f74877b.put(i2, this.f74876a.get(i2));
                        d(i2, i3);
                        U(i2);
                    } else if (i4 != -1) {
                        if (i4 == 7) {
                            d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                            if (aVar != null) {
                                if (this.f74879d.get(i2) == null) {
                                    this.f74879d.put(i2, aVar);
                                }
                                d(i2, i3);
                            }
                            U(i2);
                        } else if (i4 == 8) {
                            d.l.a.e.b.n.a aVar2 = this.f74876a.get(i2);
                            if (aVar2 != null && this.f74880e.get(i2) == null) {
                                this.f74880e.put(i2, aVar2);
                            }
                            U(i2);
                        }
                    }
                }
                d.l.a.e.b.n.a aVar3 = this.f74876a.get(i2);
                if (aVar3 != null) {
                    if (this.f74878c.get(i2) == null) {
                        this.f74878c.put(i2, aVar3);
                    }
                    d(i2, i3);
                }
                U(i2);
            }
        }
    }

    public synchronized void f(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a T = T(i2);
                if (T == null) {
                    T = this.f74882g.get(Integer.valueOf(i2));
                }
                if (T != null) {
                    T.z0(i3, bVar, gVar, z);
                }
            }
        }
    }

    public synchronized void g(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a T = T(i2);
                if (T != null) {
                    T.c(i3, bVar, gVar, z);
                    DownloadInfo J = T.J();
                    if (z2 && J != null && !r(i2) && (gVar == com.ss.android.socialbase.downloader.constants.g.f41460a || gVar == com.ss.android.socialbase.downloader.constants.g.f41462c)) {
                        boolean z3 = true;
                        if (gVar == com.ss.android.socialbase.downloader.constants.g.f41462c && !J.canShowNotification()) {
                            z3 = false;
                        }
                        if (z3) {
                            this.k.post(new f(this, bVar, J));
                        }
                    }
                } else if (d.l.a.e.b.l.a.a(32768) && (b2 = this.j.b(i2)) != null && b2.getStatus() != -3) {
                    d.l.a.e.b.n.a aVar = this.f74882g.get(Integer.valueOf(i2));
                    if (aVar == null) {
                        aVar = new d.l.a.e.b.n.a(b2);
                        this.f74882g.put(Integer.valueOf(i2), aVar);
                    }
                    aVar.c(i3, bVar, gVar, z);
                }
            }
        }
    }

    public abstract void h(int i2, long j);

    public synchronized void i(int i2, d.l.a.e.b.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i2, dVar) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar != null) {
                    aVar.J0(dVar);
                }
            }
        }
    }

    public final void j(int i2, BaseException baseException, d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048606, this, i2, baseException, aVar) == null) || aVar == null) {
            return;
        }
        DownloadInfo J = aVar.J();
        SparseArray<d.l.a.e.b.f.b> M = aVar.M(com.ss.android.socialbase.downloader.constants.g.f41460a);
        SparseArray<d.l.a.e.b.f.b> M2 = aVar.M(com.ss.android.socialbase.downloader.constants.g.f41462c);
        boolean z = aVar.j() || J.isAutoInstallWithoutNotification();
        d.l.a.e.b.l.c.a(i2, M, true, J, baseException);
        d.l.a.e.b.l.c.a(i2, M2, z, J, baseException);
    }

    public abstract void k(int i2, d.l.a.e.b.n.a aVar);

    public abstract void l(d.l.a.e.b.k.c cVar);

    public final void n(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        try {
            if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.h.f41464a) {
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.f41464a);
                d.l.a.e.b.c.a.g("AbsDownloadEngine", "cancelAlarm");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void o(d.l.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                DownloadInfo J = aVar.J();
                if (J == null) {
                    return;
                }
                J.setDownloadFromReserveWifi(false);
                if (J.getEnqueueType() != com.ss.android.socialbase.downloader.constants.f.f41456a) {
                    F(aVar);
                } else {
                    p(aVar, true);
                }
            }
        }
    }

    public final void p(d.l.a.e.b.n.a aVar, boolean z) {
        DownloadInfo J;
        int i2;
        DownloadInfo J2;
        d.l.a.e.b.n.a remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048611, this, aVar, z) == null) || aVar == null || (J = aVar.J()) == null) {
            return;
        }
        if (J.isEntityInvalid()) {
            z R = aVar.R();
            d.l.a.e.b.e.a.e(R, J, new BaseException(1003, "downloadInfo is Invalid, url is " + J.getUrl() + " name is " + J.getName() + " savePath is " + J.getSavePath()), J.getStatus());
            return;
        }
        boolean z2 = false;
        if (d.l.a.e.b.j.a.d(J.getId()).b("no_net_opt", 0) == 1 && !d.l.a.e.b.l.f.r0(d.l.a.e.b.g.e.n()) && !J.isFirstDownload()) {
            new d.l.a.e.b.g.h(aVar, this.k).g(new BaseException((int) SDKLogTypeConstants.TYPE_LP_LOAD_URL, "network_not_available"));
            return;
        }
        int id = J.getId();
        if (z) {
            n(J);
        }
        if (this.f74878c.get(id) != null) {
            this.f74878c.remove(id);
        }
        if (this.f74877b.get(id) != null) {
            this.f74877b.remove(id);
        }
        if (this.f74879d.get(id) != null) {
            this.f74879d.remove(id);
        }
        if (this.f74880e.get(id) != null) {
            this.f74880e.remove(id);
        }
        if (r(id) && !J.canReStartAsyncTask()) {
            d.l.a.e.b.c.a.g("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            aVar.d();
            d.l.a.e.b.e.a.e(aVar.R(), J, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), J.getStatus());
            return;
        }
        d.l.a.e.b.c.a.g("AbsDownloadEngine", "no downloading task :" + id);
        if (J.canReStartAsyncTask()) {
            J.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f41443c);
        }
        if (d.l.a.e.b.l.a.a(32768) && (remove = this.f74882g.remove(Integer.valueOf(id))) != null) {
            aVar.m(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        d.l.a.e.b.n.a aVar2 = this.f74876a.get(id);
        if (aVar2 == null || (J2 = aVar2.J()) == null) {
            i2 = 0;
        } else {
            i2 = J2.getStatus();
            if (d.l.a.e.b.d.a.b(i2)) {
                z2 = true;
            }
        }
        d.l.a.e.b.c.a.g("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i2);
        if (z2) {
            aVar.d();
            return;
        }
        A(aVar);
        this.f74876a.put(id, aVar);
        this.f74883h.put(id, Long.valueOf(uptimeMillis));
        k(id, aVar);
    }

    public synchronized void q(List<String> list) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            synchronized (this) {
                try {
                    boolean g0 = d.l.a.e.b.l.a.a(1048576) ? d.l.a.e.b.l.f.g0(d.l.a.e.b.g.e.n()) : true;
                    for (int i2 = 0; i2 < this.f74878c.size(); i2++) {
                        d.l.a.e.b.n.a aVar = this.f74878c.get(this.f74878c.keyAt(i2));
                        if (aVar != null && (J = aVar.J()) != null && J.getMimeType() != null && list.contains(J.getMimeType()) && (!J.isOnlyWifi() || g0)) {
                            J.setAutoResumed(true);
                            J.setShowNotificationForNetworkResumed(true);
                            o(aVar);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public abstract boolean r(int i2);

    public synchronized boolean s(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                d.l.a.e.b.n.a aVar = this.f74876a.get(i2);
                if (aVar == null && d.l.a.e.b.l.a.a(65536)) {
                    aVar = T(i2);
                }
                if (aVar != null) {
                    if (!d.l.a.e.b.j.a.d(i2).q("fix_on_cancel_call_twice", true)) {
                        new d.l.a.e.b.g.h(aVar, this.k).s();
                    }
                    this.k.post(new RunnableC2075a(this, aVar.M(com.ss.android.socialbase.downloader.constants.g.f41460a), aVar.J(), aVar.M(com.ss.android.socialbase.downloader.constants.g.f41462c)));
                }
                DownloadInfo b2 = this.j.b(i2);
                if (d.l.a.e.b.l.a.a(65536)) {
                    if (b2 != null) {
                        b2.setStatus(-4);
                    }
                } else if (b2 != null && d.l.a.e.b.d.a.b(b2.getStatus())) {
                    b2.setStatus(-4);
                }
                y(i2, z);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public List<DownloadInfo> t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Integer num : b()) {
                DownloadInfo G = G(num.intValue());
                if (G != null && str.equals(G.getMimeType())) {
                    arrayList.add(G);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void u() {
        List<Integer> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (b2 = b()) == null) {
            return;
        }
        for (Integer num : b2) {
            J(num.intValue());
        }
    }

    public abstract void v(int i2);

    public synchronized void w(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                g(i2, i3, bVar, gVar, z, true);
            }
        }
    }

    public void x(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null) {
                b2.setThrottleNetSpeed(j);
            }
            h(i2, j);
        }
    }

    public void y(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            DownloadInfo b2 = this.j.b(i2);
            if (b2 != null) {
                n(b2);
            }
            this.k.post(new b(this, i2));
            d.l.a.e.b.g.e.W(new c(this, i2, z), false);
        }
    }

    @Override // d.l.a.e.b.k.h.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            d.l.a.e.b.c.a.g("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
            Object obj = message.obj;
            d.l.a.e.b.n.a aVar = null;
            BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
            synchronized (this) {
                if (i3 == 0) {
                    aVar = this.f74876a.get(i2);
                } else {
                    SparseArray<d.l.a.e.b.n.a> sparseArray = this.f74881f.get(i2);
                    if (sparseArray != null) {
                        aVar = sparseArray.get(i3);
                    }
                }
                if (aVar == null) {
                    return;
                }
                j(message.what, baseException, aVar);
                e(i2, i3, message.what);
            }
        }
    }
}
