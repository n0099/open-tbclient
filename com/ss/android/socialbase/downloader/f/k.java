package com.ss.android.socialbase.downloader.f;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.c;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class k implements f, c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public final boolean B;
    public final e.b C;
    public final e.b D;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f69347a;

    /* renamed from: b  reason: collision with root package name */
    public final n f69348b;

    /* renamed from: c  reason: collision with root package name */
    public final b f69349c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.f f69350d;

    /* renamed from: e  reason: collision with root package name */
    public final g f69351e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69352f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f69353g;

    /* renamed from: h  reason: collision with root package name */
    public final List<m> f69354h;

    /* renamed from: i  reason: collision with root package name */
    public final List<q> f69355i;
    public com.ss.android.socialbase.downloader.model.d j;
    public com.ss.android.socialbase.downloader.model.d k;
    public volatile boolean l;
    public long m;
    public final LinkedList<i> n;
    public final List<i> o;
    public int p;
    public BaseException q;
    public volatile boolean r;
    public final Object s;
    public final com.ss.android.socialbase.downloader.i.e t;
    public final com.ss.android.socialbase.downloader.h.e u;
    public volatile boolean v;
    public long w;
    public long x;
    public long y;
    public float z;

    public k(@NonNull DownloadInfo downloadInfo, @NonNull n nVar, com.ss.android.socialbase.downloader.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, nVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69352f = false;
        this.f69353g = false;
        this.f69354h = new ArrayList();
        this.f69355i = new ArrayList();
        this.l = true;
        this.n = new LinkedList<>();
        this.o = new ArrayList();
        this.s = new Object();
        this.v = false;
        this.C = new e.b(this) { // from class: com.ss.android.socialbase.downloader.f.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f69356a;

            /* renamed from: b  reason: collision with root package name */
            public int f69357b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69356a = this;
            }

            @Override // com.ss.android.socialbase.downloader.h.e.b
            public long a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.f69356a.f69352f || this.f69356a.f69353g) {
                        return -1L;
                    }
                    synchronized (this.f69356a) {
                        if (this.f69356a.j == null && this.f69356a.k == null) {
                            long j = this.f69356a.w;
                            if (j <= 0) {
                                return -1L;
                            }
                            this.f69357b++;
                            m a2 = this.f69356a.a(false, System.currentTimeMillis(), j);
                            if (a2 != null) {
                                this.f69356a.c(a2);
                                a2.f();
                                return ((this.f69357b / this.f69356a.f69355i.size()) + 1) * j;
                            }
                            return j;
                        }
                        return -1L;
                    }
                }
                return invokeV.longValue;
            }
        };
        this.D = new e.b(this) { // from class: com.ss.android.socialbase.downloader.f.k.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f69358a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f69358a = this;
            }

            @Override // com.ss.android.socialbase.downloader.h.e.b
            public long a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f69358a.r() : invokeV.longValue;
            }
        };
        this.f69347a = downloadInfo;
        this.f69348b = nVar;
        b bVar = new b(nVar.d(), this.f69348b.e());
        this.f69349c = bVar;
        this.f69350d = fVar;
        this.f69351e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || this.x <= 0) {
            return;
        }
        this.y = System.currentTimeMillis();
        this.u.a(this.D, 0L);
    }

    private void i() {
        List<String> backUpUrls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            int l = this.f69348b.l();
            if (l <= 0) {
                this.l = false;
                e();
                return;
            }
            com.ss.android.socialbase.downloader.network.c a2 = com.ss.android.socialbase.downloader.network.c.a();
            a2.a(this.f69347a.getUrl(), this, 2000L);
            if (l <= 2 || (backUpUrls = this.f69347a.getBackUpUrls()) == null) {
                return;
            }
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    a2.a(str, this, 2000L);
                }
            }
        }
    }

    private q j() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            synchronized (this) {
                int size = this.p % this.f69355i.size();
                if (this.f69348b.b()) {
                    this.p++;
                }
                qVar = this.f69355i.get(size);
            }
            return qVar;
        }
        return (q) invokeV.objValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
            this.f69349c.c();
            synchronized (this.s) {
                this.s.notify();
            }
        }
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
            for (m mVar : this.f69354h) {
                if (!mVar.g()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void m() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65581, this) == null) || this.m <= 0 || (size = this.o.size()) <= 1) {
            return;
        }
        ArrayList<i> arrayList = null;
        int i2 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            i iVar = this.o.get(i2);
            i iVar2 = this.o.get(i3);
            if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.f69338a == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(iVar2);
                if (this.B) {
                    String str = "clearCovered, covered = " + iVar2 + ", prev = " + iVar;
                }
            } else if (iVar2.e() > iVar.e()) {
                i2++;
            }
        }
        if (arrayList != null) {
            for (i iVar3 : arrayList) {
                this.o.remove(iVar3);
                for (m mVar : this.f69354h) {
                    if (mVar.f69362a == iVar3) {
                        if (this.B) {
                            String str2 = "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.f69364c;
                        }
                        mVar.a(true);
                    }
                }
            }
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) {
            long j = this.m;
            if (j <= 0) {
                this.r = false;
                return false;
            }
            synchronized (this) {
                long a2 = o.a(this.o);
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a2);
                if (a2 >= j) {
                    this.r = true;
                    return true;
                }
                this.r = false;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) {
            long j = 0;
            for (m mVar : this.f69354h) {
                j += mVar.b();
            }
            return j;
        }
        return invokeV.longValue;
    }

    private i p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65584, this)) != null) {
            return (i) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            i q = q();
            if (q == null) {
                return null;
            }
            m mVar = q.f69338a;
            if (mVar == null) {
                return q;
            }
            if (q.j() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b(currentTimeMillis);
            if (currentTimeMillis - mVar.f69367f > 2000 && a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    String str = "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q + ", owner.threadIndex = " + mVar.f69364c;
                }
                return q;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.B) {
                    String str2 = "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + q;
                }
                return q;
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

    private i q() {
        InterceptResult invokeV;
        int j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            i iVar = null;
            int i2 = Integer.MAX_VALUE;
            for (i iVar2 : this.o) {
                if (a(iVar2) > 0 && (j = iVar2.j()) < i2) {
                    iVar = iVar2;
                    i2 = j;
                }
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, this)) == null) {
            if (this.f69352f || this.f69353g) {
                return -1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                b(currentTimeMillis);
                long k = this.f69348b.k();
                if (k > 0) {
                    long j = this.y;
                    if (j > 0 && currentTimeMillis - j > k && a(currentTimeMillis, k)) {
                        this.y = currentTimeMillis;
                        this.A++;
                    }
                }
            }
            return 2000L;
        }
        return invokeV.longValue;
    }

    private void b(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, list) == null) {
            long totalBytes = this.f69347a.getTotalBytes();
            this.m = totalBytes;
            if (totalBytes <= 0) {
                this.m = this.f69347a.getExpectFileLength();
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.m);
            }
            synchronized (this) {
                this.n.clear();
                if (list != null && !list.isEmpty()) {
                    for (i iVar : list) {
                        a((List<i>) this.n, new i(iVar), false);
                    }
                    d(this.n);
                    c(this.n);
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
                }
                a((List<i>) this.n, new i(0L, -1L), false);
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.m);
            }
        }
    }

    private void c() throws BaseException, InterruptedException {
        BaseException baseException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            synchronized (this.s) {
                if (this.j == null && this.k == null) {
                    this.s.wait();
                }
            }
            if (this.j == null && this.k == null && (baseException = this.q) != null) {
                throw baseException;
            }
        }
    }

    private void d() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            try {
                this.f69351e.a((d) this.f69349c);
            } catch (p unused) {
            } catch (BaseException e2) {
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
                a(e2);
                throw e2;
            }
            if (this.f69353g || this.f69352f) {
                return;
            }
            try {
                synchronized (this) {
                    while (!this.n.isEmpty()) {
                        i poll = this.n.poll();
                        if (poll != null) {
                            a(this.o, poll, true);
                        }
                    }
                    c(this.o);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.v && this.q != null) {
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
                throw this.q;
            }
            if (this.f69347a.getCurBytes() != this.f69347a.getTotalBytes()) {
                com.ss.android.socialbase.downloader.d.a.a(this.f69347a, this.o);
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
        }
    }

    private void e() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (this.m <= 0 || this.l) {
                i2 = 1;
            } else {
                i2 = this.f69348b.a();
                int h2 = (int) (this.m / this.f69348b.h());
                if (i2 > h2) {
                    i2 = h2;
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i2);
            int i3 = i2 > 0 ? i2 : 1;
            synchronized (this) {
                do {
                    if (this.f69354h.size() >= i3) {
                        break;
                    }
                    if (!this.f69353g && !this.f69352f) {
                        a(j());
                    }
                    return;
                } while (!this.f69348b.f());
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.f69355i.add(new q(this.f69347a.getUrl(), true));
            List<String> backUpUrls = this.f69347a.getBackUpUrls();
            if (backUpUrls != null) {
                for (String str : backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f69355i.add(new q(str, false));
                    }
                }
            }
            this.f69348b.a(this.f69355i.size());
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            n nVar = this.f69348b;
            this.w = nVar.j();
            this.x = nVar.k();
            this.z = nVar.o();
            int i2 = this.A;
            if (i2 > 0) {
                this.u.a(this.C, i2);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, IGET, INVOKE, IF] complete} */
    public boolean a(List<i> list) throws BaseException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            try {
                f();
                b(list);
                e();
                g();
                i();
                long currentTimeMillis = System.currentTimeMillis();
                c();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.f69347a.increaseAllConnectTime(currentTimeMillis2);
                this.f69347a.setFirstSpeedTime(currentTimeMillis2);
                if (!this.f69353g && !this.f69352f) {
                    this.f69350d.a(this.m);
                    h();
                    d();
                    return true;
                }
                if (!this.f69353g && !this.f69352f) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                    b();
                }
                this.u.b();
                return true;
            } finally {
                if (!this.f69353g && !this.f69352f) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                    b();
                }
                this.u.b();
            }
        }
        return invokeL.booleanValue;
    }

    private void c(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, list) == null) {
            long b2 = o.b(list);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f69347a.getCurBytes() + ", totalBytes = " + this.f69347a.getTotalBytes() + ", downloadedBytes = " + b2);
            if (b2 > this.f69347a.getTotalBytes() && this.f69347a.getTotalBytes() > 0) {
                b2 = this.f69347a.getTotalBytes();
            }
            if (this.f69347a.getCurBytes() == this.f69347a.getTotalBytes() || this.f69347a.getCurBytes() == b2) {
                return;
            }
            this.f69347a.setCurBytes(b2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(m mVar, i iVar) throws j {
        i iVar2;
        long j;
        long f2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, this, mVar, iVar) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: start " + iVar);
            if (iVar.f69338a != mVar) {
                if (iVar.f69338a == null) {
                    if (mVar.h() == iVar.e()) {
                        long c2 = iVar.c();
                        int a2 = a(c2);
                        if (a2 != -1 && (iVar2 = this.o.get(a2)) != null) {
                            if (iVar2 != iVar) {
                                if (iVar2.c() == iVar.c()) {
                                    long a3 = a(iVar2);
                                    if (a3 > 0) {
                                        m mVar2 = iVar2.f69338a;
                                        if (mVar2 != null) {
                                            if (a3 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                                j = c2;
                                                if (mVar.f69367f - mVar2.f69367f > 1000) {
                                                }
                                            } else {
                                                j = c2;
                                            }
                                            String str = "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2;
                                            z = false;
                                            if (!z) {
                                                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                                                throw new j(2, "segment not exist, but has another same segment");
                                            }
                                        } else {
                                            j = c2;
                                        }
                                        if (mVar2 != null) {
                                            String str2 = "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2;
                                            mVar2.a(true);
                                        } else {
                                            String str3 = "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2;
                                        }
                                        iVar.c(iVar2.f());
                                        iVar.b(iVar2.j());
                                        this.o.set(a2, iVar);
                                        z = true;
                                        if (!z) {
                                        }
                                    }
                                }
                                j = c2;
                                z = false;
                                if (!z) {
                                }
                            } else {
                                j = c2;
                            }
                            long a4 = iVar.a();
                            int i2 = a2 - 1;
                            while (true) {
                                if (i2 < 0) {
                                    break;
                                }
                                i iVar3 = this.o.get(i2);
                                long f3 = iVar3.f();
                                if (f3 <= 0 || f3 >= j) {
                                    if (a4 <= 0 && iVar3.e() > j) {
                                        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                        this.o.remove(iVar);
                                        throw new j(3, "prev overstep");
                                    } else if (iVar3.f69338a == null) {
                                        iVar3.c(j - 1);
                                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                        if (iVar3.a() > 0) {
                                            break;
                                        }
                                    } else {
                                        long j2 = j - 1;
                                        if (iVar3.f69338a.a(j2)) {
                                            iVar3.c(j2);
                                            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar3);
                                        } else {
                                            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar3);
                                            throw new j(4, "prev end adjust fail");
                                        }
                                    }
                                }
                                i2--;
                            }
                            int size = this.o.size();
                            for (int i3 = a2 + 1; i3 < size; i3++) {
                                i iVar4 = this.o.get(i3);
                                if (iVar4.a() > 0 || iVar4.f69338a != null) {
                                    long f4 = iVar.f();
                                    long c3 = iVar4.c();
                                    if (f4 <= 0 || f4 >= c3) {
                                        long j3 = c3 - 1;
                                        iVar.c(j3);
                                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + iVar4);
                                    }
                                    f2 = iVar.f();
                                    if (f2 <= 0 && (j > f2 || iVar.e() > f2)) {
                                        throw new j(6, "applySegment: " + iVar);
                                    }
                                    iVar.f69338a = mVar;
                                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + iVar);
                                    return;
                                }
                            }
                            f2 = iVar.f();
                            if (f2 <= 0) {
                            }
                            iVar.f69338a = mVar;
                            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + iVar);
                            return;
                        }
                        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + a2);
                        throw new j(2, "segment not exist");
                    }
                    throw new j(5, "applySegment");
                } else {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.f69338a);
                    throw new j(1, "segment already has an owner");
                }
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: " + mVar + " is already the owner of " + iVar);
        }
    }

    private void b(String str, List<q> list) {
        int a2;
        Iterator<q> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, str, list) == null) {
            if (this.B) {
                while (list.iterator().hasNext()) {
                    String str2 = "addIpListLocked: urlRecord = " + it.next();
                }
            }
            int l = this.f69348b.l();
            if ((l == 1 || l == 3) && (a2 = a(str)) >= 0 && a2 < this.f69355i.size()) {
                this.f69355i.addAll(a2 + 1, list);
            } else {
                this.f69355i.addAll(list);
            }
        }
    }

    private List<q> c(String str, List<InetAddress> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, str, list)) == null) {
            if (list != null && !list.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i2 = 0;
                for (InetAddress inetAddress : list) {
                    if (inetAddress != null) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (this.B) {
                                String str2 = "onDnsResolved: ip = " + hostAddress;
                            }
                            q qVar = new q(str, hostAddress);
                            LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.f69375c);
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                linkedHashMap.put(qVar.f69375c, linkedList);
                            }
                            linkedList.add(qVar);
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
                                arrayList.add((q) linkedList2.pollFirst());
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

    private void d(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, list) == null) {
            i iVar = list.get(0);
            long c2 = iVar.c();
            if (c2 > 0) {
                i iVar2 = new i(0L, c2 - 1);
                r0 = "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2;
                a(list, iVar2, true);
            }
            Iterator<i> it = list.iterator();
            if (it.hasNext()) {
                i next = it.next();
                while (it.hasNext()) {
                    i next2 = it.next();
                    if (next.f() < next2.c() - 1) {
                        com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.c() - 1));
                        next.c(next2.c() - 1);
                    }
                    next = next2;
                }
            }
            i iVar3 = list.get(list.size() - 1);
            long totalBytes = this.f69347a.getTotalBytes();
            if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
                com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
                iVar3.c(-1L);
            }
        }
    }

    private i b(m mVar, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, mVar, qVar)) == null) {
            while (!this.n.isEmpty()) {
                i poll = this.n.poll();
                if (poll != null) {
                    a(this.o, poll, true);
                    if (a(poll) > 0 || this.m <= 0) {
                        return poll;
                    }
                }
            }
            m();
            i c2 = c(mVar, qVar);
            if (c2 != null && a(c2) > 0) {
                a(this.o, c2, true);
                return c2;
            }
            i p = p();
            if (p != null) {
                return p;
            }
            return null;
        }
        return (i) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, mVar, iVar) == null) {
            synchronized (this) {
                e(mVar, iVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, list) == null) || this.f69353g || this.f69352f) {
            return;
        }
        List<q> list2 = null;
        try {
            list2 = c(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                b(str, list2);
            }
            this.l = false;
            this.f69348b.a(this.f69355i.size());
            e();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mVar) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.f69364c);
            synchronized (this) {
                mVar.c(true);
                this.f69354h.remove(mVar);
                m();
                if (this.f69354h.isEmpty()) {
                    k();
                } else if (n()) {
                    for (m mVar2 : this.f69354h) {
                        mVar2.e();
                    }
                    k();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, mVar, iVar) == null) {
            synchronized (this) {
                if (iVar.f69338a == mVar) {
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment " + iVar);
                    iVar.d(mVar.d());
                    iVar.f69338a = null;
                    mVar.a();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) throws BaseException {
        InterceptResult invokeLL;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, mVar, iVar)) == null) {
            synchronized (this) {
                l lVar = new l(this.f69347a, this.f69349c, iVar);
                this.f69351e.a(lVar);
                a2 = lVar.a();
            }
            return a2;
        }
        return (e) invokeLL.objValue;
    }

    private int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            int size = this.f69355i.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (TextUtils.equals(this.f69355i.get(i2).f69373a, str)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, mVar)) == null) {
            synchronized (this) {
                q d2 = d(mVar);
                if (d2 == null) {
                    return false;
                }
                return mVar.a(d2);
            }
        }
        return invokeL.booleanValue;
    }

    private void a(List<i> list, i iVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65547, this, list, iVar, z) == null) {
            long c2 = iVar.c();
            int size = list.size();
            int i2 = 0;
            while (i2 < size && c2 >= list.get(i2).c()) {
                i2++;
            }
            list.add(i2, iVar);
            if (z) {
                iVar.a(size);
            }
        }
    }

    private q d(m mVar) {
        InterceptResult invokeL;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, mVar)) == null) {
            Iterator<q> it = this.f69355i.iterator();
            q qVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    qVar = null;
                    break;
                }
                qVar = it.next();
                if (qVar != mVar.f69363b && !qVar.d()) {
                    if (qVar2 == null) {
                        qVar2 = qVar;
                    }
                    if (qVar.a() <= 0) {
                        break;
                    }
                }
            }
            if (this.f69348b.b()) {
                if (qVar != null) {
                    return qVar;
                }
                if (this.f69348b.c()) {
                    return null;
                }
            }
            return qVar2;
        }
        return (q) invokeL.objValue;
    }

    private void b(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, this, mVar, iVar, qVar, dVar) == null) {
            m mVar2 = iVar.f69338a;
            if (mVar2 != null && mVar2 != mVar) {
                throw new j(1, "segment already has an owner");
            }
            if (mVar.h() == iVar.e()) {
                if (!dVar.b()) {
                    if (iVar.e() <= 0) {
                        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.e());
                        if (!dVar.a()) {
                            int i2 = dVar.f69643c;
                            throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + dVar.f69643c + " segment=" + iVar);
                        }
                    } else {
                        int i3 = dVar.f69643c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + dVar.f69643c + " segment=" + iVar);
                    }
                }
                if (qVar.f69376d) {
                    if (this.j == null) {
                        this.j = dVar;
                        synchronized (this.s) {
                            this.s.notify();
                        }
                        com.ss.android.socialbase.downloader.h.f fVar = this.f69350d;
                        if (fVar != null) {
                            fVar.a(qVar.f69373a, dVar.f69642b, iVar.e());
                        }
                        long j = dVar.j();
                        if (j > 0) {
                            for (i iVar2 : this.o) {
                                if (iVar2.f() <= 0 || iVar2.f() > j - 1) {
                                    iVar2.c(j - 1);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                a(dVar);
                if (this.k == null) {
                    this.k = dVar;
                    if (this.f69347a.getTotalBytes() <= 0) {
                        long j2 = dVar.j();
                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j2 + ",url=" + qVar.f69373a);
                        this.f69347a.setTotalBytes(j2);
                    }
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    return;
                }
                return;
            }
            throw new j(5, "applySegment");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i c(m mVar, q qVar) {
        InterceptResult invokeLL;
        String str;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, this, mVar, qVar)) == null) {
            int size = this.o.size();
            long j = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                long a2 = a(i3, size);
                if (a2 > j) {
                    i2 = i3;
                    j = a2;
                }
            }
            long g2 = this.f69348b.g();
            long i4 = this.f69348b.i();
            if (i2 < 0 || j <= g2) {
                return null;
            }
            i iVar = this.o.get(i2);
            int n = this.o.size() < this.f69354h.size() ? 2 : this.f69348b.n();
            if (n == 1) {
                m mVar2 = iVar.f69338a;
                if (mVar2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = currentTimeMillis - PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
                    long a3 = mVar2.a(j2, currentTimeMillis);
                    long a4 = mVar.a(j2, currentTimeMillis);
                    float f4 = (a3 <= 0 || a4 <= 0) ? -1.0f : ((float) a4) / ((float) (a3 + a4));
                    if (f4 == -1.0f) {
                        long b2 = mVar2.b();
                        f2 = f4;
                        long b3 = mVar.b();
                        if (b2 > 0 && b3 > 0) {
                            f3 = ((float) b3) / ((float) (b2 + b3));
                            if (f3 > 0.0f) {
                                float f5 = f3 * 0.9f;
                                long j3 = ((float) j) * f5;
                                if (j3 < g2) {
                                    j3 = g2;
                                }
                                if (i4 <= 0 || j3 <= i4) {
                                    i4 = j3;
                                }
                                long j4 = g2 / 2;
                                long j5 = j - j4;
                                if (i4 > j5) {
                                    i4 = j5;
                                } else if (i4 < j4) {
                                    i4 = j4;
                                }
                                i iVar2 = new i(iVar.e() + (j - i4), iVar.f());
                                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j + ", childLength = " + i4 + ", ratio = " + f5 + ", threadIndex = " + mVar.f69364c);
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
            } else if (n == 2) {
                float d2 = d(mVar, qVar);
                long curBytes = ((float) (this.m - this.f69347a.getCurBytes())) * d2;
                if (curBytes < g2) {
                    curBytes = g2;
                }
                if (i4 <= 0 || curBytes <= i4) {
                    i4 = curBytes;
                }
                long j6 = g2 / 2;
                long j7 = j - j6;
                if (i4 > j7) {
                    i4 = j7;
                } else if (i4 < j6) {
                    i4 = j6;
                }
                i iVar3 = new i(iVar.e() + (j - i4), iVar.f());
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j + ", childLength = " + i4 + ", ratio = " + d2 + ", threadIndex = " + mVar.f69364c);
                return iVar3;
            } else {
                str = "SegmentDispatcher";
            }
            i iVar4 = new i(iVar.e() + (j / 2), iVar.f());
            com.ss.android.socialbase.downloader.c.a.c(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
            return iVar4;
        }
        return (i) invokeLL.objValue;
    }

    private void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, qVar) == null) {
            m mVar = new m(this.f69347a, this, this.f69349c, qVar, this.f69354h.size());
            this.f69354h.add(mVar);
            mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
        }
    }

    private float d(m mVar, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, this, mVar, qVar)) == null) {
            long b2 = mVar.b();
            int size = this.f69354h.size();
            if (size <= 1) {
                size = this.f69348b.a();
            }
            float f2 = 1.0f;
            if (b2 <= 0) {
                float m = this.f69348b.m();
                if (m <= 0.0f || m >= 1.0f) {
                    m = 1.0f / size;
                }
                if (mVar.f69364c == 0) {
                    return m;
                }
                if (size > 1) {
                    f2 = 1.0f - m;
                    size--;
                }
            } else {
                long o = o();
                if (o > b2) {
                    return ((float) b2) / ((float) o);
                }
            }
            return f2 / size;
        }
        return invokeLL.floatValue;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) && this.B) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.f69364c);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, qVar)) == null) {
            if (this.f69352f || this.f69353g) {
                return null;
            }
            synchronized (this) {
                i b2 = b(mVar, qVar);
                if (b2 != null) {
                    b2.h();
                    if (b2.j() > 1) {
                        return new i(b2);
                    }
                }
                return b2;
            }
        }
        return (i) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, mVar, iVar) == null) {
            synchronized (this) {
                iVar.i();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, mVar, iVar, qVar, dVar) == null) {
            synchronized (this) {
                if (!this.f69352f && !this.f69353g) {
                    b(mVar, iVar, qVar, dVar);
                    mVar.b(false);
                    if (this.m <= 0) {
                        long totalBytes = this.f69347a.getTotalBytes();
                        this.m = totalBytes;
                        if (totalBytes <= 0) {
                            this.m = dVar.j();
                        }
                        e();
                    } else if (this.f69348b.f()) {
                        e();
                    }
                } else {
                    throw new p("connected");
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{mVar, qVar, iVar, baseException, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            com.ss.android.socialbase.downloader.i.f.b(baseException);
            int errorCode = baseException.getErrorCode();
            if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i2 >= i3) {
                c(mVar);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
            this.f69353g = true;
            synchronized (this) {
                for (m mVar : this.f69354h) {
                    mVar.e();
                }
            }
            this.f69351e.b();
            this.f69349c.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, mVar, qVar, iVar, baseException) == null) {
            synchronized (this) {
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
                mVar.b(true);
                if (mVar.f69364c == 0) {
                    this.q = baseException;
                }
                if (l()) {
                    if (this.q == null) {
                        this.q = baseException;
                    }
                    this.v = true;
                    a(this.q);
                }
            }
        }
    }

    private void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65553, this, j) == null) {
            this.t.a(this.f69347a.getCurBytes(), j);
            for (m mVar : this.f69354h) {
                mVar.b(j);
            }
        }
    }

    private void a(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, baseException) == null) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
            this.q = baseException;
            this.f69349c.c();
            synchronized (this) {
                for (m mVar : this.f69354h) {
                    mVar.e();
                }
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, dVar) == null) {
            com.ss.android.socialbase.downloader.model.d dVar2 = this.j;
            if (dVar2 == null && (dVar2 = this.k) == null) {
                return;
            }
            long j = dVar.j();
            long j2 = dVar2.j();
            if (j != j2) {
                String str = "total len not equals,len=" + j + ",sLen=" + j2 + ",code=" + dVar.f69643c + ",sCode=" + dVar2.f69643c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.f69641a + ",sUrl=" + dVar2.f69641a;
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
                if (j > 0 && j2 > 0) {
                    throw new BaseException(1074, str);
                }
            }
            String c2 = dVar.c();
            String c3 = dVar2.c();
            if (TextUtils.equals(c2, c3)) {
                return;
            }
            String str2 = "etag not equals with main url, etag = " + c2 + ", mainEtag = " + c3;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str2);
            if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !c2.equalsIgnoreCase(c3)) {
                throw new BaseException(1074, str2);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", QueryResponse.Options.CANCEL);
            this.f69352f = true;
            synchronized (this) {
                for (m mVar : this.f69354h) {
                    mVar.e();
                }
            }
            this.f69351e.a();
            this.f69349c.c();
        }
    }

    private int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = this.o.get(i2);
                if (iVar.c() == j) {
                    return i2;
                }
                if (iVar.c() > j) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    private long a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, this, i2, i3)) == null) {
            i iVar = this.o.get(i2);
            long a2 = a(iVar);
            int i4 = i2 + 1;
            i iVar2 = i4 < i3 ? this.o.get(i4) : null;
            if (iVar2 == null) {
                return a2;
            }
            long c2 = iVar2.c() - iVar.e();
            return a2 == -1 ? c2 : Math.min(a2, c2);
        }
        return invokeII.longValue;
    }

    private long a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iVar)) == null) {
            long b2 = iVar.b();
            if (b2 == -1) {
                long j = this.m;
                return j > 0 ? j - iVar.e() : b2;
            }
            return b2;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(boolean z, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            m mVar = null;
            for (m mVar2 : this.f69354h) {
                if (mVar2.f69364c != 0 || z) {
                    if (mVar2.f69365d > 0 && mVar2.f69366e <= 0 && j - mVar2.f69365d > j2 && (mVar == null || mVar2.f69365d < mVar.f69365d)) {
                        mVar = mVar2;
                    }
                }
            }
            return mVar;
        }
        return (m) invokeCommon.objValue;
    }

    private boolean a(m mVar, long j, long j2, long j3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{mVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2)})) == null) {
            if (mVar.f69367f > 0) {
                long b2 = this.t.b(j, j2);
                int size = this.f69354h.size();
                long j4 = size > 0 ? b2 / size : b2;
                long a2 = mVar.a(j, j2);
                if (a2 < j3 || a2 < j4 * d2) {
                    String str = "isDownloadSpeedPoor: totalSpeed = " + b2 + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + a2 + ",threadIndex = " + mVar.f69364c;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            long b2 = this.t.b(j3, j);
            int size = this.f69354h.size();
            if (size > 0) {
                b2 /= size;
            }
            m a2 = a(j3, j, Math.max(10.0f, ((float) b2) * this.z), size / 2);
            if (a2 != null) {
                c(a2);
                com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a2.f69364c);
                a2.f();
                return true;
            }
            m a3 = a(true, j, j2);
            if (a3 != null) {
                c(a3);
                com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a3.f69364c);
                a3.f();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private m a(long j, long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) {
            long j4 = Long.MAX_VALUE;
            int i3 = 0;
            m mVar = null;
            for (m mVar2 : this.f69354h) {
                if (mVar2.f69367f > 0) {
                    i3++;
                    long j5 = j4;
                    if (mVar2.f69367f < j) {
                        long a2 = mVar2.a(j, j2);
                        if (this.B) {
                            String str = "findPoorReadThread: speed = " + a2 + ", threadIndex = " + mVar2.f69364c;
                        }
                        if (a2 >= 0 && a2 < j5) {
                            j4 = a2;
                            mVar = mVar2;
                        }
                    }
                    j4 = j5;
                }
            }
            long j6 = j4;
            if (mVar == null || i3 < i2 || j6 >= j3) {
                return null;
            }
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j6 + ", threadIndex = " + mVar.f69364c);
            return mVar;
        }
        return (m) invokeCommon.objValue;
    }
}
