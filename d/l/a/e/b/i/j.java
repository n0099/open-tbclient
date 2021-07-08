package d.l.a.e.b.i;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.k.e;
import d.l.a.e.b.o.e;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class j implements f, e.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean A;
    public final e.b B;
    public final e.b C;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f71843a;

    /* renamed from: b  reason: collision with root package name */
    public final m f71844b;

    /* renamed from: c  reason: collision with root package name */
    public final d.l.a.e.b.i.b f71845c;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.e.b.k.f f71846d;

    /* renamed from: e  reason: collision with root package name */
    public final g f71847e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f71848f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71849g;

    /* renamed from: h  reason: collision with root package name */
    public final List<l> f71850h;

    /* renamed from: i  reason: collision with root package name */
    public final List<o> f71851i;
    public d.l.a.e.b.n.b j;
    public d.l.a.e.b.n.b k;
    public volatile boolean l;
    public long m;
    public final LinkedList<i> n;
    public final List<i> o;
    public int p;
    public BaseException q;
    public final Object r;
    public final d.l.a.e.b.l.e s;
    public final d.l.a.e.b.k.e t;
    public volatile boolean u;
    public long v;
    public long w;
    public long x;
    public float y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f71853b;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71853b = jVar;
        }

        @Override // d.l.a.e.b.k.e.b
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f71853b.f71848f || this.f71853b.f71849g) {
                    return -1L;
                }
                synchronized (this.f71853b) {
                    if (this.f71853b.j == null && this.f71853b.k == null) {
                        long j = this.f71853b.v;
                        if (j <= 0) {
                            return -1L;
                        }
                        this.f71852a++;
                        l q = this.f71853b.q(false, System.currentTimeMillis(), j);
                        if (q != null) {
                            Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                            this.f71853b.N(q);
                            q.u();
                            return ((this.f71852a / this.f71853b.f71851i.size()) + 1) * j;
                        }
                        return j;
                    }
                    return -1L;
                }
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f71854a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71854a = jVar;
        }

        @Override // d.l.a.e.b.k.e.b
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71854a.k0() : invokeV.longValue;
        }
    }

    public j(@NonNull DownloadInfo downloadInfo, @NonNull m mVar, d.l.a.e.b.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, mVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71848f = false;
        this.f71849g = false;
        this.f71850h = new ArrayList();
        this.f71851i = new ArrayList();
        this.l = true;
        this.n = new LinkedList<>();
        this.o = new ArrayList();
        this.r = new Object();
        this.u = false;
        this.B = new a(this);
        this.C = new b(this);
        this.f71843a = downloadInfo;
        this.f71844b = mVar;
        d.l.a.e.b.i.b bVar = new d.l.a.e.b.i.b(mVar.g(), this.f71844b.h());
        this.f71845c = bVar;
        this.f71846d = fVar;
        this.f71847e = new g(downloadInfo, fVar, bVar);
        this.t = new d.l.a.e.b.k.e();
        this.s = new d.l.a.e.b.l.e();
        this.A = d.l.a.e.b.j.a.d(downloadInfo.getId()).m("debug") == 1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, IGET, INVOKE, IF] complete} */
    public boolean A(List<i> list) throws BaseException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            try {
                X();
                G(list);
                U();
                Z();
                b0();
                long currentTimeMillis = System.currentTimeMillis();
                L();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.f71843a.increaseAllConnectTime(currentTimeMillis2);
                this.f71843a.setFirstSpeedTime(currentTimeMillis2);
                if (!this.f71849g && !this.f71848f) {
                    this.f71846d.a(this.m);
                    a0();
                    R();
                    return true;
                }
                if (!this.f71849g && !this.f71848f) {
                    d.l.a.e.b.c.a.i("SegmentDispatcher", "finally pause");
                    C();
                }
                this.t.c();
                return true;
            } finally {
                if (!this.f71849g && !this.f71848f) {
                    d.l.a.e.b.c.a.i("SegmentDispatcher", "finally pause");
                    C();
                }
                this.t.c();
            }
        }
        return invokeL.booleanValue;
    }

    public final i B(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, oVar)) == null) {
            while (!this.n.isEmpty()) {
                i poll = this.n.poll();
                if (poll != null) {
                    v(this.o, poll, true);
                    if (n(poll) > 0 || this.m <= 0) {
                        return poll;
                    }
                }
            }
            f0();
            i I = I(lVar, oVar);
            if (I != null && n(I) > 0) {
                v(this.o, I, true);
                return I;
            }
            i i0 = i0();
            if (i0 != null) {
                return i0;
            }
            return null;
        }
        return (i) invokeLL.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", "pause1");
            this.f71849g = true;
            synchronized (this) {
                for (l lVar : this.f71850h) {
                    lVar.t();
                }
            }
            this.f71847e.i();
            this.f71845c.c();
        }
    }

    public final void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.s.c(this.f71843a.getCurBytes(), j);
            for (l lVar : this.f71850h) {
                lVar.l(j);
            }
        }
    }

    public final void E(l lVar, i iVar, o oVar, d.l.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, lVar, iVar, oVar, bVar) == null) {
            l lVar2 = iVar.f71840f;
            if (lVar2 != null && lVar2 != lVar) {
                throw new com.ss.android.socialbase.downloader.f.j(1, "segment already has an owner");
            }
            if (lVar.w() == iVar.l()) {
                if (!bVar.b()) {
                    if (iVar.l() <= 0) {
                        d.l.a.e.b.c.a.k("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.l());
                        if (!bVar.a()) {
                            int i2 = bVar.f72014c;
                            throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + bVar.f72014c + " segment=" + iVar);
                        }
                    } else {
                        int i3 = bVar.f72014c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + bVar.f72014c + " segment=" + iVar);
                    }
                }
                if (oVar.f71868d) {
                    if (this.j == null) {
                        this.j = bVar;
                        synchronized (this.r) {
                            this.r.notify();
                        }
                        d.l.a.e.b.k.f fVar = this.f71846d;
                        if (fVar != null) {
                            fVar.d(oVar.f71865a, bVar.f72013b, iVar.l());
                        }
                        long j = bVar.j();
                        if (j > 0) {
                            for (i iVar2 : this.o) {
                                if (iVar2.m() <= 0 || iVar2.m() > j - 1) {
                                    iVar2.i(j - 1);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                u(bVar);
                if (this.k == null) {
                    this.k = bVar;
                    if (this.f71843a.getTotalBytes() <= 0) {
                        long j2 = bVar.j();
                        d.l.a.e.b.c.a.i("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j2 + ",url=" + oVar.f71865a);
                        this.f71843a.setTotalBytes(j2);
                    }
                    synchronized (this.r) {
                        this.r.notify();
                    }
                    return;
                }
                return;
            }
            throw new com.ss.android.socialbase.downloader.f.j(5, "applySegment");
        }
    }

    public final void F(String str, List<o> list) {
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, list) == null) {
            if (this.A) {
                Iterator<o> it = list.iterator();
                while (it.hasNext()) {
                    Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
                }
            }
            int o = this.f71844b.o();
            if ((o == 1 || o == 3) && (l = l(str)) >= 0 && l < this.f71851i.size()) {
                this.f71851i.addAll(l + 1, list);
            } else {
                this.f71851i.addAll(list);
            }
        }
    }

    public final void G(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            long totalBytes = this.f71843a.getTotalBytes();
            this.m = totalBytes;
            if (totalBytes <= 0) {
                this.m = this.f71843a.getExpectFileLength();
                d.l.a.e.b.c.a.i("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.m);
            }
            synchronized (this) {
                this.n.clear();
                if (list != null && !list.isEmpty()) {
                    for (i iVar : list) {
                        v(this.n, new i(iVar), false);
                    }
                    S(this.n);
                    M(this.n);
                    d.l.a.e.b.c.a.i("SegmentDispatcher", "initSegments: totalLength = " + this.m);
                }
                v(this.n, new i(0L, -1L), false);
                d.l.a.e.b.c.a.i("SegmentDispatcher", "initSegments: totalLength = " + this.m);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final i I(l lVar, o oVar) {
        InterceptResult invokeLL;
        String str;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, lVar, oVar)) == null) {
            int size = this.o.size();
            long j = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                long m = m(i3, size);
                if (m > j) {
                    i2 = i3;
                    j = m;
                }
            }
            long j2 = this.f71844b.j();
            long l = this.f71844b.l();
            if (i2 < 0 || j <= j2) {
                return null;
            }
            i iVar = this.o.get(i2);
            int q = this.o.size() < this.f71850h.size() ? 2 : this.f71844b.q();
            if (q == 1) {
                l lVar2 = iVar.f71840f;
                if (lVar2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
                    long a2 = lVar2.a(j3, currentTimeMillis);
                    long a3 = lVar.a(j3, currentTimeMillis);
                    float f4 = (a2 <= 0 || a3 <= 0) ? -1.0f : ((float) a3) / ((float) (a2 + a3));
                    if (f4 == -1.0f) {
                        long k = lVar2.k();
                        f2 = f4;
                        long k2 = lVar.k();
                        if (k > 0 && k2 > 0) {
                            f3 = ((float) k2) / ((float) (k + k2));
                            if (f3 > 0.0f) {
                                float f5 = f3 * 0.9f;
                                long j4 = ((float) j) * f5;
                                if (j4 < j2) {
                                    j4 = j2;
                                }
                                if (l <= 0 || j4 <= l) {
                                    l = j4;
                                }
                                long j5 = j2 / 2;
                                long j6 = j - j5;
                                if (l > j6) {
                                    l = j6;
                                } else if (l < j5) {
                                    l = j5;
                                }
                                i iVar2 = new i(iVar.l() + (j - l), iVar.m());
                                d.l.a.e.b.c.a.i("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j + ", childLength = " + l + ", ratio = " + f5 + ", threadIndex = " + lVar.x);
                                return iVar2;
                            }
                        }
                    } else {
                        f2 = f4;
                    }
                    f3 = f2;
                    if (f3 > 0.0f) {
                    }
                }
                str = "SegmentDispatcher";
            } else if (q == 2) {
                float O = O(lVar, oVar);
                long curBytes = ((float) (this.m - this.f71843a.getCurBytes())) * O;
                if (curBytes < j2) {
                    curBytes = j2;
                }
                if (l <= 0 || curBytes <= l) {
                    l = curBytes;
                }
                long j7 = j2 / 2;
                long j8 = j - j7;
                if (l > j8) {
                    l = j8;
                } else if (l < j7) {
                    l = j7;
                }
                i iVar3 = new i(iVar.l() + (j - l), iVar.m());
                d.l.a.e.b.c.a.i("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j + ", childLength = " + l + ", ratio = " + O + ", threadIndex = " + lVar.x);
                return iVar3;
            } else {
                str = "SegmentDispatcher";
            }
            i iVar4 = new i(iVar.l() + (j / 2), iVar.m());
            d.l.a.e.b.c.a.i(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
            return iVar4;
        }
        return (i) invokeLL.objValue;
    }

    public final List<o> K(String str, List<InetAddress> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list)) == null) {
            if (list != null && !list.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i2 = 0;
                for (InetAddress inetAddress : list) {
                    if (inetAddress != null) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (this.A) {
                                Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                            }
                            o oVar = new o(str, hostAddress);
                            LinkedList linkedList = (LinkedList) linkedHashMap.get(oVar.f71867c);
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                linkedHashMap.put(oVar.f71867c, linkedList);
                            }
                            linkedList.add(oVar);
                            i2++;
                        }
                    }
                }
                if (i2 > 0) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        z = false;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            LinkedList linkedList2 = (LinkedList) entry.getValue();
                            if (linkedList2 != null && !linkedList2.isEmpty()) {
                                arrayList.add((o) linkedList2.pollFirst());
                                i2--;
                                z = true;
                            }
                        }
                        if (i2 <= 0) {
                            break;
                        }
                    } while (z);
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public final void L() throws BaseException, InterruptedException {
        BaseException baseException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.r) {
                if (this.j == null && this.k == null) {
                    this.r.wait();
                }
            }
            if (this.j == null && this.k == null && (baseException = this.q) != null) {
                throw baseException;
            }
        }
    }

    public final void M(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            long b2 = n.b(list);
            d.l.a.e.b.c.a.i("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f71843a.getCurBytes() + ", totalBytes = " + this.f71843a.getTotalBytes() + ", downloadedBytes = " + b2);
            if (b2 > this.f71843a.getTotalBytes() && this.f71843a.getTotalBytes() > 0) {
                b2 = this.f71843a.getTotalBytes();
            }
            if (this.f71843a.getCurBytes() == this.f71843a.getTotalBytes() || this.f71843a.getCurBytes() == b2) {
                return;
            }
            this.f71843a.setCurBytes(b2);
        }
    }

    public final boolean N(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, lVar)) == null) {
            synchronized (this) {
                o P = P(lVar);
                if (P == null) {
                    return false;
                }
                return lVar.j(P);
            }
        }
        return invokeL.booleanValue;
    }

    public final float O(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, lVar, oVar)) == null) {
            long k = lVar.k();
            int size = this.f71850h.size();
            if (size <= 1) {
                size = this.f71844b.a();
            }
            float f2 = 1.0f;
            if (k <= 0) {
                float p = this.f71844b.p();
                if (p <= 0.0f || p >= 1.0f) {
                    p = 1.0f / size;
                }
                if (lVar.x == 0) {
                    return p;
                }
                if (size > 1) {
                    f2 = 1.0f - p;
                    size--;
                }
            } else {
                long h0 = h0();
                if (h0 > k) {
                    return ((float) k) / ((float) h0);
                }
            }
            return f2 / size;
        }
        return invokeLL.floatValue;
    }

    public final o P(l lVar) {
        InterceptResult invokeL;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, lVar)) == null) {
            Iterator<o> it = this.f71851i.iterator();
            o oVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    oVar = null;
                    break;
                }
                oVar = it.next();
                if (oVar != lVar.m && !oVar.h()) {
                    if (oVar2 == null) {
                        oVar2 = oVar;
                    }
                    if (oVar.a() <= 0) {
                        break;
                    }
                }
            }
            if (this.f71844b.e()) {
                if (oVar != null) {
                    return oVar;
                }
                if (this.f71844b.f()) {
                    return null;
                }
            }
            return oVar2;
        }
        return (o) invokeL.objValue;
    }

    public final void R() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                this.f71847e.c(this.f71845c);
            } catch (p unused) {
            } catch (BaseException e2) {
                d.l.a.e.b.c.a.k("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
                s(e2);
                throw e2;
            }
            if (this.f71849g || this.f71848f) {
                return;
            }
            try {
                synchronized (this) {
                    while (!this.n.isEmpty()) {
                        i poll = this.n.poll();
                        if (poll != null) {
                            v(this.o, poll, true);
                        }
                    }
                    M(this.o);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.u && this.q != null) {
                d.l.a.e.b.c.a.k("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
                throw this.q;
            }
            if (this.f71843a.getCurBytes() != this.f71843a.getTotalBytes()) {
                d.l.a.e.b.e.a.h(this.f71843a, this.o);
            }
            d.l.a.e.b.c.a.i("SegmentDispatcher", "dispatchSegments::download finished");
        }
    }

    public final void S(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            i iVar = list.get(0);
            long h2 = iVar.h();
            if (h2 > 0) {
                i iVar2 = new i(0L, h2 - 1);
                Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
                v(list, iVar2, true);
            }
            Iterator<i> it = list.iterator();
            if (it.hasNext()) {
                i next = it.next();
                while (it.hasNext()) {
                    i next2 = it.next();
                    if (next.m() < next2.h() - 1) {
                        d.l.a.e.b.c.a.j("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.h() - 1));
                        next.i(next2.h() - 1);
                    }
                    next = next2;
                }
            }
            i iVar3 = list.get(list.size() - 1);
            long totalBytes = this.f71843a.getTotalBytes();
            if (totalBytes <= 0 || (iVar3.m() != -1 && iVar3.m() < totalBytes - 1)) {
                d.l.a.e.b.c.a.j("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
                iVar3.i(-1L);
            }
        }
    }

    public final void U() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.m <= 0 || this.l) {
                i2 = 1;
            } else {
                i2 = this.f71844b.a();
                int k = (int) (this.m / this.f71844b.k());
                if (i2 > k) {
                    i2 = k;
                }
            }
            d.l.a.e.b.c.a.i("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i2);
            int i3 = i2 > 0 ? i2 : 1;
            synchronized (this) {
                do {
                    if (this.f71850h.size() >= i3) {
                        break;
                    }
                    if (!this.f71849g && !this.f71848f) {
                        t(c0());
                    }
                    return;
                } while (!this.f71844b.i());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
        if ((r10.l() - r24.l()) < (r14 / 2)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f6, code lost:
        r3 = r3 + 1;
        r6 = r22.o.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01fe, code lost:
        if (r3 >= r6) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0200, code lost:
        r7 = r22.o.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0210, code lost:
        if (r7.a() > 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0214, code lost:
        if (r7.f71840f == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0217, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x021a, code lost:
        r11 = r24.m();
        r15 = r7.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0224, code lost:
        if (r11 <= 0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0228, code lost:
        if (r11 < r15) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x022a, code lost:
        r8 = r15 - 1;
        r24.i(r8);
        d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: segment set end:" + r8 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x024b, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0250, code lost:
        r6 = r24.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
        if (r6 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x025c, code lost:
        if (r20 > r6) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0264, code lost:
        if (r24.l() > r6) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x027c, code lost:
        throw new com.ss.android.socialbase.downloader.f.j(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x027d, code lost:
        r24.f71840f = r23;
        d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0293, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(l lVar, i iVar) throws com.ss.android.socialbase.downloader.f.j {
        i iVar2;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048593, this, lVar, iVar) != null) {
            return;
        }
        d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: start " + iVar);
        if (iVar.f71840f == lVar) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: " + lVar + " is already the owner of " + iVar);
        } else if (iVar.f71840f == null) {
            if (lVar.w() == iVar.l()) {
                long h2 = iVar.h();
                int k = k(h2);
                if (k != -1 && (iVar2 = this.o.get(k)) != null) {
                    if (iVar2 != iVar) {
                        if (iVar2.h() == iVar.h()) {
                            long n = n(iVar2);
                            if (n > 0) {
                                l lVar2 = iVar2.f71840f;
                                if (lVar2 != null) {
                                    if (n < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                        j = h2;
                                        if (lVar.K - lVar2.K > 1000) {
                                        }
                                    } else {
                                        j = h2;
                                    }
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2);
                                    z = false;
                                    if (!z) {
                                        d.l.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                                        throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist, but has another same segment");
                                    }
                                } else {
                                    j = h2;
                                }
                                if (lVar2 != null) {
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2);
                                    lVar2.e(true);
                                } else {
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2);
                                }
                                iVar.i(iVar2.m());
                                iVar.f(iVar2.q());
                                this.o.set(k, iVar);
                                z = true;
                                if (!z) {
                                }
                            }
                        }
                        j = h2;
                        z = false;
                        if (!z) {
                        }
                    } else {
                        j = h2;
                    }
                    long a2 = iVar.a();
                    int i2 = k - 1;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        i iVar3 = this.o.get(i2);
                        long m = iVar3.m();
                        if (m <= 0 || m >= j) {
                            if (a2 <= 0 && iVar3.l() > j) {
                                d.l.a.e.b.c.a.k("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                this.o.remove(iVar);
                                throw new com.ss.android.socialbase.downloader.f.j(3, "prev overstep");
                            } else if (iVar3.f71840f == null) {
                                iVar3.i(j - 1);
                                d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                if (iVar3.a() > 0) {
                                    Log.d("SegmentDispatcher", "applySegmentLocked:q break");
                                    break;
                                }
                            } else {
                                long j2 = j - 1;
                                if (iVar3.f71840f.f(j2)) {
                                    iVar3.i(j2);
                                    d.l.a.e.b.c.a.i("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar3);
                                } else {
                                    d.l.a.e.b.c.a.k("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar3);
                                    throw new com.ss.android.socialbase.downloader.f.j(4, "prev end adjust fail");
                                }
                            }
                        }
                        i2--;
                    }
                } else {
                    d.l.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + k);
                    throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist");
                }
            } else {
                throw new com.ss.android.socialbase.downloader.f.j(5, "applySegment");
            }
        } else {
            d.l.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.f71840f);
            throw new com.ss.android.socialbase.downloader.f.j(1, "segment already has an owner");
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f71851i.add(new o(this.f71843a.getUrl(), true));
            List<String> backUpUrls = this.f71843a.getBackUpUrls();
            if (backUpUrls != null) {
                for (String str : backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f71851i.add(new o(str, false));
                    }
                }
            }
            this.f71844b.c(this.f71851i.size());
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            m mVar = this.f71844b;
            this.v = mVar.m();
            this.w = mVar.n();
            this.y = mVar.r();
            int i2 = this.z;
            if (i2 > 0) {
                this.t.b(this.B, i2);
            }
        }
    }

    @Override // d.l.a.e.b.o.e.c
    public void a(String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, list) == null) || this.f71849g || this.f71848f) {
            return;
        }
        List<o> list2 = null;
        try {
            list2 = K(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                F(str, list2);
            }
            this.l = false;
            this.f71844b.c(this.f71851i.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            U();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.w <= 0) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.t.b(this.C, 0L);
    }

    @Override // d.l.a.e.b.i.f
    public void b(l lVar, i iVar, o oVar, d.l.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048599, this, lVar, iVar, oVar, bVar) == null) {
            synchronized (this) {
                if (!this.f71848f && !this.f71849g) {
                    E(lVar, iVar, oVar, bVar);
                    lVar.n(false);
                    if (this.m <= 0) {
                        long totalBytes = this.f71843a.getTotalBytes();
                        this.m = totalBytes;
                        if (totalBytes <= 0) {
                            this.m = bVar.j();
                        }
                        U();
                    } else if (this.f71844b.i()) {
                        U();
                    }
                } else {
                    throw new p("connected");
                }
            }
        }
    }

    public final void b0() {
        List<String> backUpUrls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int o = this.f71844b.o();
            if (o <= 0) {
                this.l = false;
                U();
                return;
            }
            d.l.a.e.b.o.e a2 = d.l.a.e.b.o.e.a();
            a2.c(this.f71843a.getUrl(), this, 2000L);
            if (o <= 2 || (backUpUrls = this.f71843a.getBackUpUrls()) == null) {
                return;
            }
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    a2.c(str, this, 2000L);
                }
            }
        }
    }

    @Override // d.l.a.e.b.i.f
    public i c(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, lVar, oVar)) == null) {
            if (this.f71848f || this.f71849g) {
                return null;
            }
            synchronized (this) {
                i B = B(lVar, oVar);
                if (B != null) {
                    B.o();
                    if (B.q() > 1) {
                        return new i(B);
                    }
                }
                return B;
            }
        }
        return (i) invokeLL.objValue;
    }

    public final o c0() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                int size = this.p % this.f71851i.size();
                if (this.f71844b.e()) {
                    this.p++;
                }
                oVar = this.f71851i.get(size);
            }
            return oVar;
        }
        return (o) invokeV.objValue;
    }

    @Override // d.l.a.e.b.i.f
    public void d(l lVar, i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, lVar, iVar) == null) {
            synchronized (this) {
                V(lVar, iVar);
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", "onComplete");
            this.f71845c.c();
            synchronized (this.r) {
                this.r.notify();
            }
        }
    }

    @Override // d.l.a.e.b.i.f
    public void e(l lVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, lVar, iVar) == null) {
            synchronized (this) {
                iVar.p();
            }
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            for (l lVar : this.f71850h) {
                if (!lVar.v()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.i.f
    public void f(l lVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, lVar, iVar) == null) {
            synchronized (this) {
                if (iVar.f71840f == lVar) {
                    d.l.a.e.b.c.a.i("SegmentDispatcher", "unApplySegment " + iVar);
                    iVar.k(lVar.r());
                    iVar.f71840f = null;
                    lVar.c();
                }
            }
        }
    }

    public final void f0() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.m <= 0 || (size = this.o.size()) <= 1) {
            return;
        }
        ArrayList<i> arrayList = null;
        int i2 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            i iVar = this.o.get(i2);
            i iVar2 = this.o.get(i3);
            if (iVar.l() > iVar2.h() && iVar2.a() <= 0 && iVar2.f71840f == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(iVar2);
                if (this.A) {
                    Log.w("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                }
            } else if (iVar2.l() > iVar.l()) {
                i2++;
            }
        }
        if (arrayList != null) {
            for (i iVar3 : arrayList) {
                this.o.remove(iVar3);
                for (l lVar : this.f71850h) {
                    if (lVar.l == iVar3) {
                        if (this.A) {
                            Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + lVar.x);
                        }
                        lVar.e(true);
                    }
                }
            }
        }
    }

    @Override // d.l.a.e.b.i.f
    public void g(l lVar, o oVar, i iVar, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, lVar, oVar, iVar, baseException) == null) {
            synchronized (this) {
                d.l.a.e.b.c.a.k("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
                lVar.n(true);
                if (lVar.x == 0) {
                    this.q = baseException;
                }
                if (e0()) {
                    if (this.q == null) {
                        this.q = baseException;
                    }
                    this.u = true;
                    s(this.q);
                }
            }
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long j = this.m;
            if (j <= 0) {
                return false;
            }
            synchronized (this) {
                long a2 = n.a(this.o);
                d.l.a.e.b.c.a.i("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a2);
                return a2 >= j;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.i.f
    public e h(l lVar, i iVar) throws BaseException {
        InterceptResult invokeLL;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, lVar, iVar)) == null) {
            synchronized (this) {
                k kVar = new k(this.f71843a, this.f71845c, iVar);
                this.f71847e.e(kVar);
                a2 = kVar.a();
            }
            return a2;
        }
        return (e) invokeLL.objValue;
    }

    public final long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            long j = 0;
            for (l lVar : this.f71850h) {
                j += lVar.k();
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // d.l.a.e.b.i.f
    public void i(l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, lVar) == null) && this.A) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", "onReaderRun, threadIndex = " + lVar.x);
        }
    }

    public final i i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048614, this)) != null) {
            return (i) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            i j0 = j0();
            if (j0 == null) {
                return null;
            }
            l lVar = j0.f71840f;
            if (lVar == null) {
                return j0;
            }
            if (j0.q() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            D(currentTimeMillis);
            if (currentTimeMillis - lVar.K > 2000 && z(lVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.A) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + j0 + ", owner.threadIndex = " + lVar.x);
                }
                return j0;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.A) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + j0);
                }
                return j0;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    @Override // d.l.a.e.b.i.f
    public void j(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, lVar) == null) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", "onReaderExit: threadIndex = " + lVar.x);
            synchronized (this) {
                lVar.q(true);
                this.f71850h.remove(lVar);
                f0();
                if (this.f71850h.isEmpty()) {
                    d0();
                } else if (g0()) {
                    Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    for (l lVar2 : this.f71850h) {
                        lVar2.t();
                    }
                    d0();
                }
            }
        }
    }

    public final i j0() {
        InterceptResult invokeV;
        int q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            i iVar = null;
            int i2 = Integer.MAX_VALUE;
            for (i iVar2 : this.o) {
                if (n(iVar2) > 0 && (q = iVar2.q()) < i2) {
                    iVar = iVar2;
                    i2 = q;
                }
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    public final int k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j)) == null) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = this.o.get(i2);
                if (iVar.h() == j) {
                    return i2;
                }
                if (iVar.h() > j) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public final long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.f71848f || this.f71849g) {
                return -1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                D(currentTimeMillis);
                long n = this.f71844b.n();
                if (n > 0) {
                    long j = this.x;
                    if (j > 0 && currentTimeMillis - j > n && w(currentTimeMillis, n)) {
                        this.x = currentTimeMillis;
                        this.z++;
                    }
                }
            }
            return 2000L;
        }
        return invokeV.longValue;
    }

    public final int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            int size = this.f71851i.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (TextUtils.equals(this.f71851i.get(i2).f71865a, str)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final long m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i2, i3)) == null) {
            i iVar = this.o.get(i2);
            long n = n(iVar);
            int i4 = i2 + 1;
            i iVar2 = i4 < i3 ? this.o.get(i4) : null;
            if (iVar2 == null) {
                return n;
            }
            long h2 = iVar2.h() - iVar.l();
            return n == -1 ? h2 : Math.min(n, h2);
        }
        return invokeII.longValue;
    }

    public final long n(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, iVar)) == null) {
            long e2 = iVar.e();
            if (e2 == -1) {
                long j = this.m;
                return j > 0 ? j - iVar.l() : e2;
            }
            return e2;
        }
        return invokeL.longValue;
    }

    public final l o(long j, long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) {
            long j5 = Long.MAX_VALUE;
            int i3 = 0;
            l lVar = null;
            for (l lVar2 : this.f71850h) {
                if (lVar2.K > 0) {
                    i3++;
                    long j6 = j5;
                    if (lVar2.K < j) {
                        long a2 = lVar2.a(j, j2);
                        if (this.A) {
                            Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a2 + ", threadIndex = " + lVar2.x);
                            j4 = 0;
                        } else {
                            j4 = 0;
                        }
                        if (a2 >= j4 && a2 < j6) {
                            j5 = a2;
                            lVar = lVar2;
                        }
                    }
                    j5 = j6;
                }
            }
            long j7 = j5;
            if (lVar == null || i3 < i2 || j7 >= j3) {
                return null;
            }
            d.l.a.e.b.c.a.i("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + lVar.x);
            return lVar;
        }
        return (l) invokeCommon.objValue;
    }

    public final l q(boolean z, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            l lVar = null;
            for (l lVar2 : this.f71850h) {
                if (lVar2.x != 0 || z) {
                    if (lVar2.I > 0 && lVar2.J <= 0 && j - lVar2.I > j2 && (lVar == null || lVar2.I < lVar.I)) {
                        lVar = lVar2;
                    }
                }
            }
            return lVar;
        }
        return (l) invokeCommon.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d.l.a.e.b.c.a.i("SegmentDispatcher", QueryResponse.Options.CANCEL);
            this.f71848f = true;
            synchronized (this) {
                for (l lVar : this.f71850h) {
                    lVar.t();
                }
            }
            this.f71847e.a();
            this.f71845c.c();
        }
    }

    public final void s(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, baseException) == null) {
            d.l.a.e.b.c.a.k("SegmentDispatcher", "onError, e = " + baseException);
            this.q = baseException;
            this.f71845c.c();
            synchronized (this) {
                for (l lVar : this.f71850h) {
                    lVar.t();
                }
            }
        }
    }

    public final void t(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, oVar) == null) {
            l lVar = new l(this.f71843a, this, this.f71845c, oVar, this.f71850h.size());
            this.f71850h.add(lVar);
            lVar.d(d.l.a.e.b.g.e.F0().submit(lVar));
        }
    }

    public final void u(d.l.a.e.b.n.b bVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bVar) == null) {
            d.l.a.e.b.n.b bVar2 = this.j;
            if (bVar2 == null && (bVar2 = this.k) == null) {
                return;
            }
            long j = bVar.j();
            long j2 = bVar2.j();
            if (j != j2) {
                String str = "total len not equals,len=" + j + ",sLen=" + j2 + ",code=" + bVar.f72014c + ",sCode=" + bVar2.f72014c + ",range=" + bVar.e() + ",sRange = " + bVar2.e() + ",url = " + bVar.f72012a + ",sUrl=" + bVar2.f72012a;
                d.l.a.e.b.c.a.k("SegmentDispatcher", str);
                if (j > 0 && j2 > 0) {
                    throw new BaseException(1074, str);
                }
            }
            String c2 = bVar.c();
            String c3 = bVar2.c();
            if (TextUtils.equals(c2, c3)) {
                return;
            }
            String str2 = "etag not equals with main url, etag = " + c2 + ", mainEtag = " + c3;
            d.l.a.e.b.c.a.k("SegmentDispatcher", str2);
            if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !c2.equalsIgnoreCase(c3)) {
                throw new BaseException(1074, str2);
            }
        }
    }

    public final void v(List<i> list, i iVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048628, this, list, iVar, z) == null) {
            long h2 = iVar.h();
            int size = list.size();
            int i2 = 0;
            while (i2 < size && h2 >= list.get(i2).h()) {
                i2++;
            }
            list.add(i2, iVar);
            if (z) {
                iVar.c(size);
            }
        }
    }

    public final boolean w(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            long d2 = this.s.d(j3, j);
            int size = this.f71850h.size();
            if (size > 0) {
                d2 /= size;
            }
            l o = o(j3, j, Math.max(10.0f, ((float) d2) * this.y), size / 2);
            if (o != null) {
                N(o);
                d.l.a.e.b.c.a.j("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + o.x);
                o.u();
                return true;
            }
            l q = q(true, j, j2);
            if (q != null) {
                N(q);
                d.l.a.e.b.c.a.j("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + q.x);
                q.u();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z(l lVar, long j, long j2, long j3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2)})) == null) {
            if (lVar.K > 0) {
                long d3 = this.s.d(j, j2);
                int size = this.f71850h.size();
                long j4 = size > 0 ? d3 / size : d3;
                long a2 = lVar.a(j, j2);
                if (a2 < j3 || a2 < j4 * d2) {
                    Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + d3 + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + a2 + ",threadIndex = " + lVar.x);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.l.a.e.b.i.f
    public void a(l lVar, o oVar, i iVar, BaseException baseException, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{lVar, oVar, iVar, baseException, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            d.l.a.e.b.l.f.h0(baseException);
            int errorCode = baseException.getErrorCode();
            if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i2 >= i3) {
                N(lVar);
            }
        }
    }
}
