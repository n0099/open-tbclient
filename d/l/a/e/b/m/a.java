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
/* loaded from: classes8.dex */
public abstract class a implements h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f71928a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f71929b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f71930c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f71931d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.n.a> f71932e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<SparseArray<d.l.a.e.b.n.a>> f71933f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.h<Integer, d.l.a.e.b.n.a> f71934g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<Long> f71935h;

    /* renamed from: i  reason: collision with root package name */
    public final LinkedBlockingDeque<d.l.a.e.b.n.a> f71936i;
    public final d.l.a.e.b.g.k j;
    public final d.l.a.e.b.k.h k;

    /* renamed from: d.l.a.e.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC2043a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f71937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SparseArray f71939g;

        public RunnableC2043a(a aVar, SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
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
            this.f71937e = sparseArray;
            this.f71938f = downloadInfo;
            this.f71939g = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SparseArray sparseArray2 = this.f71937e;
                if (sparseArray2 != null) {
                    synchronized (sparseArray2) {
                        for (int i2 = 0; i2 < this.f71937e.size(); i2++) {
                            d.l.a.e.b.f.b bVar = (d.l.a.e.b.f.b) this.f71937e.get(this.f71937e.keyAt(i2));
                            if (bVar != null) {
                                bVar.e(this.f71938f);
                            }
                        }
                    }
                }
                DownloadInfo downloadInfo = this.f71938f;
                if (downloadInfo == null || !downloadInfo.canShowNotification() || (sparseArray = this.f71939g) == null) {
                    return;
                }
                synchronized (sparseArray) {
                    for (int i3 = 0; i3 < this.f71939g.size(); i3++) {
                        d.l.a.e.b.f.b bVar2 = (d.l.a.e.b.f.b) this.f71939g.get(this.f71939g.keyAt(i3));
                        if (bVar2 != null) {
                            bVar2.e(this.f71938f);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71940e;

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
            this.f71940e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.l.a.e.b.p.b.a().m(this.f71940e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f71942f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f71943g;

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
            this.f71943g = aVar;
            this.f71941e = i2;
            this.f71942f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.l.a.e.b.n.a T;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f71943g.D(this.f71941e) == null && (T = this.f71943g.T(this.f71941e)) != null) {
                    DownloadInfo J = T.J();
                    SparseArray<d.l.a.e.b.f.b> M = T.M(com.ss.android.socialbase.downloader.constants.g.f38475b);
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
                this.f71943g.H(this.f71941e, this.f71942f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71944e;

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
            this.f71944e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.l.a.e.b.p.b.a().m(this.f71944e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f71945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f71946f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f71947g;

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
            this.f71947g = aVar;
            this.f71945e = i2;
            this.f71946f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71947g.D(this.f71945e);
                this.f71947g.I(this.f71945e, this.f71946f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.f.b f71948e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71949f;

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
            this.f71948e = bVar;
            this.f71949f = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71948e == null) {
                return;
            }
            if (this.f71949f.getStatus() == -3) {
                this.f71948e.f(this.f71949f);
            } else if (this.f71949f.getStatus() == -1) {
                this.f71948e.h(this.f71949f, new BaseException(1000, "try add listener for failed task"));
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
        this.f71928a = new SparseArray<>();
        this.f71929b = new SparseArray<>();
        this.f71930c = new SparseArray<>();
        this.f71931d = new SparseArray<>();
        this.f71932e = new SparseArray<>();
        this.f71933f = new SparseArray<>();
        this.f71934g = new com.ss.android.socialbase.downloader.i.h<>();
        this.f71935h = new SparseArray<>();
        this.f71936i = new LinkedBlockingDeque<>();
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
            SparseArray<d.l.a.e.b.n.a> sparseArray = this.f71933f.get(aVar.I());
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.f71933f.put(aVar.I(), sparseArray);
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
                    for (int i2 = 0; i2 < this.f71928a.size(); i2++) {
                        d.l.a.e.b.n.a aVar = this.f71928a.get(this.f71928a.keyAt(i2));
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
            if (this.f71936i.isEmpty()) {
                p(aVar, true);
                this.f71936i.put(aVar);
            } else if (J.getEnqueueType() == com.ss.android.socialbase.downloader.constants.f.f38472c) {
                if (this.f71936i.getFirst().I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                Iterator<d.l.a.e.b.n.a> it = this.f71936i.iterator();
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
                this.f71936i.put(aVar);
                new d.l.a.e.b.g.h(aVar, this.k).b();
            } else {
                d.l.a.e.b.n.a first = this.f71936i.getFirst();
                if (first.I() == aVar.I() && r(aVar.I())) {
                    return;
                }
                J(first.I());
                p(aVar, true);
                if (first.I() != aVar.I()) {
                    this.f71936i.putFirst(aVar);
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
                if (b2 == null && (aVar = this.f71928a.get(i2)) != null) {
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
                if (this.f71930c.get(i2) != null) {
                    this.f71930c.remove(i2);
                }
                if (this.f71929b.get(i2) != null) {
                    this.f71929b.remove(i2);
                }
                this.f71934g.remove(Integer.valueOf(i2));
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
                if (this.f71930c.get(i2) != null) {
                    this.f71930c.remove(i2);
                }
                if (this.f71929b.get(i2) != null) {
                    this.f71929b.remove(i2);
                }
                this.f71934g.remove(Integer.valueOf(i2));
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
                    synchronized (this.f71928a) {
                        v(i2);
                    }
                    if (b2 == null) {
                        d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                        if (aVar != null) {
                            new d.l.a.e.b.g.h(aVar, this.k).u();
                            return true;
                        }
                    } else {
                        n(b2);
                        if (b2.getStatus() == 1) {
                            d.l.a.e.b.n.a aVar2 = this.f71928a.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71930c.get(i2);
                if (aVar == null) {
                    aVar = this.f71931d.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                if (aVar != null) {
                    return aVar.S();
                }
                d.l.a.e.b.n.a aVar2 = this.f71929b.get(i2);
                if (aVar2 != null) {
                    return aVar2.S();
                }
                d.l.a.e.b.n.a aVar3 = this.f71930c.get(i2);
                if (aVar3 != null) {
                    return aVar3.S();
                }
                d.l.a.e.b.n.a aVar4 = this.f71931d.get(i2);
                if (aVar4 != null) {
                    return aVar4.S();
                }
                d.l.a.e.b.n.a aVar5 = this.f71932e.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                if (aVar != null) {
                    return aVar.T();
                }
                d.l.a.e.b.n.a aVar2 = this.f71929b.get(i2);
                if (aVar2 != null) {
                    return aVar2.T();
                }
                d.l.a.e.b.n.a aVar3 = this.f71930c.get(i2);
                if (aVar3 != null) {
                    return aVar3.T();
                }
                d.l.a.e.b.n.a aVar4 = this.f71931d.get(i2);
                if (aVar4 != null) {
                    return aVar4.T();
                }
                d.l.a.e.b.n.a aVar5 = this.f71932e.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                if (aVar != null) {
                    return aVar.N();
                }
                d.l.a.e.b.n.a aVar2 = this.f71929b.get(i2);
                if (aVar2 != null) {
                    return aVar2.N();
                }
                d.l.a.e.b.n.a aVar3 = this.f71930c.get(i2);
                if (aVar3 != null) {
                    return aVar3.N();
                }
                d.l.a.e.b.n.a aVar4 = this.f71931d.get(i2);
                if (aVar4 != null) {
                    return aVar4.N();
                }
                d.l.a.e.b.n.a aVar5 = this.f71932e.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71931d.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71932e.get(i2);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                if (aVar != null && (J = aVar.J()) != null) {
                    J.setForceIgnoreRecommendSize(true);
                    o(aVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r4.f71930c.get(r5) != null) goto L15;
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
                    if (this.f71928a.get(i2) == null) {
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
            d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
            if (aVar == null) {
                d.l.a.e.b.n.a aVar2 = this.f71930c.get(i2);
                if (aVar2 == null) {
                    d.l.a.e.b.n.a aVar3 = this.f71929b.get(i2);
                    if (aVar3 == null) {
                        d.l.a.e.b.n.a aVar4 = this.f71931d.get(i2);
                        return aVar4 == null ? this.f71932e.get(i2) : aVar4;
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
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.f71936i.isEmpty()) {
            return;
        }
        d.l.a.e.b.n.a first2 = this.f71936i.getFirst();
        if (first2 != null && first2.I() == i2) {
            this.f71936i.poll();
        }
        if (this.f71936i.isEmpty() || (first = this.f71936i.getFirst()) == null) {
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
                    int size = this.f71928a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.l.a.e.b.n.a valueAt = this.f71928a.valueAt(i2);
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
                this.f71928a.remove(i2);
                this.f71933f.remove(i2);
                return;
            }
            SparseArray<d.l.a.e.b.n.a> sparseArray = this.f71933f.get(i2);
            if (sparseArray != null) {
                sparseArray.remove(i3);
                d.l.a.e.b.c.a.g("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
                if (sparseArray.size() == 0) {
                    this.f71928a.remove(i2);
                    this.f71933f.remove(i2);
                    return;
                }
                return;
            }
            this.f71928a.remove(i2);
        }
    }

    public synchronized void e(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048601, this, i2, i3, i4) == null) {
            synchronized (this) {
                if (i4 != -7) {
                    if (i4 == -6) {
                        this.f71929b.put(i2, this.f71928a.get(i2));
                        d(i2, i3);
                    } else if (i4 == -4) {
                        d(i2, i3);
                        U(i2);
                    } else if (i4 == -3) {
                        this.f71929b.put(i2, this.f71928a.get(i2));
                        d(i2, i3);
                        U(i2);
                    } else if (i4 != -1) {
                        if (i4 == 7) {
                            d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                            if (aVar != null) {
                                if (this.f71931d.get(i2) == null) {
                                    this.f71931d.put(i2, aVar);
                                }
                                d(i2, i3);
                            }
                            U(i2);
                        } else if (i4 == 8) {
                            d.l.a.e.b.n.a aVar2 = this.f71928a.get(i2);
                            if (aVar2 != null && this.f71932e.get(i2) == null) {
                                this.f71932e.put(i2, aVar2);
                            }
                            U(i2);
                        }
                    }
                }
                d.l.a.e.b.n.a aVar3 = this.f71928a.get(i2);
                if (aVar3 != null) {
                    if (this.f71930c.get(i2) == null) {
                        this.f71930c.put(i2, aVar3);
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
                    T = this.f71934g.get(Integer.valueOf(i2));
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
                    if (z2 && J != null && !r(i2) && (gVar == com.ss.android.socialbase.downloader.constants.g.f38474a || gVar == com.ss.android.socialbase.downloader.constants.g.f38476c)) {
                        boolean z3 = true;
                        if (gVar == com.ss.android.socialbase.downloader.constants.g.f38476c && !J.canShowNotification()) {
                            z3 = false;
                        }
                        if (z3) {
                            this.k.post(new f(this, bVar, J));
                        }
                    }
                } else if (d.l.a.e.b.l.a.a(32768) && (b2 = this.j.b(i2)) != null && b2.getStatus() != -3) {
                    d.l.a.e.b.n.a aVar = this.f71934g.get(Integer.valueOf(i2));
                    if (aVar == null) {
                        aVar = new d.l.a.e.b.n.a(b2);
                        this.f71934g.put(Integer.valueOf(i2), aVar);
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
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
        SparseArray<d.l.a.e.b.f.b> M = aVar.M(com.ss.android.socialbase.downloader.constants.g.f38474a);
        SparseArray<d.l.a.e.b.f.b> M2 = aVar.M(com.ss.android.socialbase.downloader.constants.g.f38476c);
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
            if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.h.f38478a) {
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.f38478a);
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
                if (J.getEnqueueType() != com.ss.android.socialbase.downloader.constants.f.f38470a) {
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
        if (this.f71930c.get(id) != null) {
            this.f71930c.remove(id);
        }
        if (this.f71929b.get(id) != null) {
            this.f71929b.remove(id);
        }
        if (this.f71931d.get(id) != null) {
            this.f71931d.remove(id);
        }
        if (this.f71932e.get(id) != null) {
            this.f71932e.remove(id);
        }
        if (r(id) && !J.canReStartAsyncTask()) {
            d.l.a.e.b.c.a.g("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            aVar.d();
            d.l.a.e.b.e.a.e(aVar.R(), J, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), J.getStatus());
            return;
        }
        d.l.a.e.b.c.a.g("AbsDownloadEngine", "no downloading task :" + id);
        if (J.canReStartAsyncTask()) {
            J.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.f38457c);
        }
        if (d.l.a.e.b.l.a.a(32768) && (remove = this.f71934g.remove(Integer.valueOf(id))) != null) {
            aVar.m(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        d.l.a.e.b.n.a aVar2 = this.f71928a.get(id);
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
        this.f71928a.put(id, aVar);
        this.f71935h.put(id, Long.valueOf(uptimeMillis));
        k(id, aVar);
    }

    public synchronized void q(List<String> list) {
        DownloadInfo J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, list) == null) {
            synchronized (this) {
                try {
                    boolean g0 = d.l.a.e.b.l.a.a(1048576) ? d.l.a.e.b.l.f.g0(d.l.a.e.b.g.e.n()) : true;
                    for (int i2 = 0; i2 < this.f71930c.size(); i2++) {
                        d.l.a.e.b.n.a aVar = this.f71930c.get(this.f71930c.keyAt(i2));
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
                d.l.a.e.b.n.a aVar = this.f71928a.get(i2);
                if (aVar == null && d.l.a.e.b.l.a.a(65536)) {
                    aVar = T(i2);
                }
                if (aVar != null) {
                    if (!d.l.a.e.b.j.a.d(i2).q("fix_on_cancel_call_twice", true)) {
                        new d.l.a.e.b.g.h(aVar, this.k).s();
                    }
                    this.k.post(new RunnableC2043a(this, aVar.M(com.ss.android.socialbase.downloader.constants.g.f38474a), aVar.J(), aVar.M(com.ss.android.socialbase.downloader.constants.g.f38476c)));
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
                    aVar = this.f71928a.get(i2);
                } else {
                    SparseArray<d.l.a.e.b.n.a> sparseArray = this.f71933f.get(i2);
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
