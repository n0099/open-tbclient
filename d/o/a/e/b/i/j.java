package d.o.a.e.b.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.k.e;
import d.o.a.e.b.o.e;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class j implements f, e.c {
    public final boolean A;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f71070a;

    /* renamed from: b  reason: collision with root package name */
    public final m f71071b;

    /* renamed from: c  reason: collision with root package name */
    public final d.o.a.e.b.i.b f71072c;

    /* renamed from: d  reason: collision with root package name */
    public final d.o.a.e.b.k.f f71073d;

    /* renamed from: e  reason: collision with root package name */
    public final g f71074e;
    public d.o.a.e.b.n.b j;
    public d.o.a.e.b.n.b k;
    public long m;
    public int p;
    public BaseException q;
    public volatile boolean r;
    public final d.o.a.e.b.l.d t;
    public final d.o.a.e.b.k.e u;
    public long v;
    public long w;
    public long x;
    public float y;
    public int z;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f71075f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71076g = false;

    /* renamed from: h  reason: collision with root package name */
    public final List<l> f71077h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<o> f71078i = new ArrayList();
    public volatile boolean l = true;
    public final LinkedList<i> n = new LinkedList<>();
    public final List<i> o = new ArrayList();
    public final Object s = new Object();
    public final e.b B = new a();
    public final e.b C = new b();

    /* loaded from: classes7.dex */
    public class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public int f71079a;

        public a() {
        }

        @Override // d.o.a.e.b.k.e.b
        public long a() {
            if (j.this.f71075f || j.this.f71076g) {
                return -1L;
            }
            synchronized (j.this) {
                if (j.this.j == null && j.this.k == null) {
                    long j = j.this.v;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.f71079a++;
                    l q = j.this.q(false, System.currentTimeMillis(), j);
                    if (q != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        j.this.N(q);
                        q.v();
                        return ((this.f71079a / j.this.f71078i.size()) + 1) * j;
                    }
                    return j;
                }
                return -1L;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.b {
        public b() {
        }

        @Override // d.o.a.e.b.k.e.b
        public long a() {
            return j.this.k0();
        }
    }

    public j(@NonNull DownloadInfo downloadInfo, @NonNull m mVar, d.o.a.e.b.k.f fVar) {
        this.f71070a = downloadInfo;
        this.f71071b = mVar;
        d.o.a.e.b.i.b bVar = new d.o.a.e.b.i.b(mVar.g(), this.f71071b.h());
        this.f71072c = bVar;
        this.f71073d = fVar;
        this.f71074e = new g(downloadInfo, fVar, bVar);
        this.u = new d.o.a.e.b.k.e();
        this.t = new d.o.a.e.b.l.d();
        this.A = d.o.a.e.b.j.a.d(downloadInfo.c0()).m("debug") == 1;
    }

    public final boolean A(l lVar, long j, long j2, long j3, double d2) {
        if (lVar.J > 0) {
            long d3 = this.t.d(j, j2);
            int size = this.f71077h.size();
            long j4 = size > 0 ? d3 / size : d3;
            long a2 = lVar.a(j, j2);
            if (a2 < j3 || a2 < j4 * d2) {
                Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + d3 + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + a2 + ",threadIndex = " + lVar.w);
                return true;
            }
            return false;
        }
        return false;
    }

    public final i B(l lVar, o oVar) {
        while (!this.n.isEmpty()) {
            i poll = this.n.poll();
            if (poll != null) {
                w(this.o, poll, true);
                if (n(poll) > 0 || this.m <= 0) {
                    return poll;
                }
            }
        }
        f0();
        i I = I(lVar, oVar);
        if (I != null && n(I) > 0) {
            w(this.o, I, true);
            return I;
        }
        i i0 = i0();
        if (i0 != null) {
            return i0;
        }
        return null;
    }

    public void C() {
        d.o.a.e.b.c.a.h("SegmentDispatcher", "pause");
        this.f71076g = true;
        synchronized (this) {
            for (l lVar : this.f71077h) {
                lVar.u();
            }
        }
        this.f71074e.i();
        this.f71072c.c();
    }

    public final void D(long j) {
        this.t.c(this.f71070a.E(), j);
        for (l lVar : this.f71077h) {
            lVar.m(j);
        }
    }

    public final void E(l lVar, i iVar, o oVar, d.o.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        if (oVar.f71095d) {
            if (this.j == null) {
                this.j = bVar;
                synchronized (this.s) {
                    this.s.notify();
                }
                d.o.a.e.b.k.f fVar = this.f71073d;
                if (fVar != null) {
                    fVar.d(oVar.f71092a, bVar.f71231b, iVar.i());
                }
                long j = bVar.j();
                if (j > 0) {
                    for (i iVar2 : this.o) {
                        if (iVar2.l() <= 0 || iVar2.l() > j - 1) {
                            iVar2.h(j - 1);
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
            if (this.f71070a.Q0() <= 0) {
                this.f71070a.g3(bVar.j());
            }
            synchronized (this.s) {
                this.s.notify();
            }
        }
    }

    public final void F(String str, List<o> list) {
        int l;
        if (this.A) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int n = this.f71071b.n();
        if ((n == 1 || n == 3) && (l = l(str)) >= 0 && l < this.f71078i.size()) {
            this.f71078i.addAll(l + 1, list);
        } else {
            this.f71078i.addAll(list);
        }
    }

    public final void G(List<i> list) {
        long Q0 = this.f71070a.Q0();
        this.m = Q0;
        if (Q0 <= 0) {
            this.m = this.f71070a.Q();
        }
        synchronized (this) {
            this.n.clear();
            if (list != null && !list.isEmpty()) {
                for (i iVar : list) {
                    w(this.n, new i(iVar), false);
                }
                S(this.n);
                M(this.n);
                d.o.a.e.b.c.a.h("SegmentDispatcher", "initSegments: totalLength = " + this.m);
            }
            w(this.n, new i(0L, -1L), false);
            d.o.a.e.b.c.a.h("SegmentDispatcher", "initSegments: totalLength = " + this.m);
        }
    }

    public final i I(l lVar, o oVar) {
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
        long j2 = this.f71071b.j();
        long k = this.f71071b.k();
        if (i2 < 0 || j <= j2) {
            return null;
        }
        i iVar = this.o.get(i2);
        if (this.f71071b.p()) {
            float O = O(lVar, oVar);
            long E = ((float) (this.m - this.f71070a.E())) * O;
            if (E < j2) {
                E = j2;
            }
            if (k <= 0 || E <= k) {
                k = E;
            }
            long j3 = j2 / 2;
            long j4 = j - j3;
            if (k > j4) {
                k = j4;
            } else if (k < j3) {
                k = j3;
            }
            i iVar2 = new i(iVar.k() + (j - k), iVar.l());
            d.o.a.e.b.c.a.h("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j + ", childLength = " + k + ", ratio = " + O + ", threadIndex = " + lVar.w);
            return iVar2;
        }
        i iVar3 = new i(iVar.k() + (j / 2), iVar.l());
        d.o.a.e.b.c.a.h("SegmentDispatcher", "obtainSegment: parent = " + iVar + ",child = " + iVar3);
        return iVar3;
    }

    public final List<o> K(String str, List<InetAddress> list) {
        boolean z;
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
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(oVar.f71094c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(oVar.f71094c, linkedList);
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

    public final void L() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.s) {
            if (this.j == null && this.k == null) {
                this.s.wait();
            }
        }
        if (this.j == null && this.k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    public final void M(List<i> list) {
        long b2 = n.b(list);
        d.o.a.e.b.c.a.h("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f71070a.E() + ", totalBytes = " + this.f71070a.Q0() + ", downloadedBytes = " + b2);
        if (this.f71070a.E() == this.f71070a.Q0() || this.f71070a.E() == b2) {
            return;
        }
        this.f71070a.n2(b2);
    }

    public final boolean N(l lVar) {
        synchronized (this) {
            o P = P(lVar);
            if (P == null) {
                return false;
            }
            return lVar.k(P);
        }
    }

    public final float O(l lVar, o oVar) {
        long l = lVar.l();
        int size = this.f71077h.size();
        if (size <= 1) {
            size = this.f71071b.a();
        }
        float f2 = 1.0f;
        if (l <= 0) {
            float o = this.f71071b.o();
            if (o <= 0.0f || o >= 1.0f) {
                o = 1.0f / size;
            }
            if (lVar.w == 0) {
                return o;
            }
            if (size > 1) {
                f2 = 1.0f - o;
                size--;
            }
        } else {
            long h0 = h0();
            if (h0 > l) {
                return ((float) l) / ((float) h0);
            }
        }
        return f2 / size;
    }

    public final o P(l lVar) {
        o oVar;
        Iterator<o> it = this.f71078i.iterator();
        o oVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                oVar = null;
                break;
            }
            oVar = it.next();
            if (oVar != lVar.l && !oVar.h()) {
                if (oVar2 == null) {
                    oVar2 = oVar;
                }
                if (oVar.a() <= 0) {
                    break;
                }
            }
        }
        if (this.f71071b.e()) {
            if (oVar != null) {
                return oVar;
            }
            if (this.f71071b.f()) {
                return null;
            }
        }
        return oVar2;
    }

    public final void R() throws BaseException {
        try {
            this.f71074e.c(this.f71072c);
        } catch (p unused) {
        } catch (BaseException e2) {
            d.o.a.e.b.c.a.j("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            s(e2);
            throw e2;
        }
        if (this.f71076g || this.f71075f) {
            return;
        }
        if (!this.r && this.q != null) {
            d.o.a.e.b.c.a.j("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
            throw this.q;
        }
        d.o.a.e.b.c.a.h("SegmentDispatcher", "dispatchSegments::download finished");
    }

    public final void S(List<i> list) {
        i iVar = list.get(0);
        long g2 = iVar.g();
        if (g2 > 0) {
            i iVar2 = new i(0L, g2 - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
            list.add(0, iVar2);
        }
        Iterator<i> it = list.iterator();
        if (it.hasNext()) {
            i next = it.next();
            while (it.hasNext()) {
                i next2 = it.next();
                if (next.l() < next2.g() - 1) {
                    d.o.a.e.b.c.a.i("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.g() - 1));
                    next.h(next2.g() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = list.get(list.size() - 1);
        long Q0 = this.f71070a.Q0();
        if (Q0 <= 0 || (iVar3.l() != -1 && iVar3.l() < Q0 - 1)) {
            d.o.a.e.b.c.a.i("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.h(-1L);
        }
    }

    public final void U() {
        int a2 = (this.m <= 0 || this.l) ? 1 : this.f71071b.a();
        d.o.a.e.b.c.a.h("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + a2);
        int i2 = a2 > 0 ? a2 : 1;
        synchronized (this) {
            do {
                if (this.f71077h.size() >= i2) {
                    break;
                }
                if (!this.f71076g && !this.f71075f) {
                    t(c0());
                }
                return;
            } while (!this.f71071b.i());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ee, code lost:
        r3 = r3 + 1;
        r5 = r22.o.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01f6, code lost:
        if (r3 >= r5) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01f8, code lost:
        r6 = r22.o.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0208, code lost:
        if (r6.a() > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x020c, code lost:
        if (r6.f71068f == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020f, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0212, code lost:
        r10 = r24.l();
        r14 = r6.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x021c, code lost:
        if (r10 <= 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0220, code lost:
        if (r10 < r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0222, code lost:
        r14 = r14 - 1;
        r24.h(r14);
        d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: segment set end:" + r14 + ", later = " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0242, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0247, code lost:
        r24.f71068f = r23;
        d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x025d, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(l lVar, i iVar) throws com.ss.android.socialbase.downloader.f.j {
        i iVar2;
        long j;
        d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: start " + iVar);
        if (iVar.f71068f == lVar) {
            d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: " + lVar + " is already the owner of " + iVar);
        } else if (iVar.f71068f == null) {
            if (lVar.x() == iVar.i()) {
                long g2 = iVar.g();
                int k = k(g2);
                if (k != -1 && (iVar2 = this.o.get(k)) != null) {
                    if (iVar2 != iVar) {
                        boolean z = false;
                        if (iVar2.g() != iVar.g() || n(iVar2) <= 0) {
                            j = g2;
                        } else {
                            l lVar2 = iVar2.f71068f;
                            if (lVar2 != null) {
                                j = g2;
                                if (lVar.J - lVar2.J <= 1000 || iVar2.k() - iVar.k() >= n(iVar) / 2) {
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2);
                                }
                            } else {
                                j = g2;
                            }
                            if (lVar2 != null) {
                                Log.i("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2);
                                lVar2.f(true);
                            } else {
                                Log.i("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2);
                            }
                            iVar.h(iVar2.l());
                            iVar.e(iVar2.p());
                            this.o.set(k, iVar);
                            z = true;
                        }
                        if (!z) {
                            d.o.a.e.b.c.a.j("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                            throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist, but has another same segment");
                        }
                    } else {
                        j = g2;
                    }
                    long a2 = iVar.a();
                    int i2 = k - 1;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        i iVar3 = this.o.get(i2);
                        long l = iVar3.l();
                        if (l <= 0 || l >= j) {
                            if (a2 <= 0 && iVar3.k() > j) {
                                d.o.a.e.b.c.a.j("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                this.o.remove(iVar);
                                throw new com.ss.android.socialbase.downloader.f.j(3, "prev overstep");
                            } else if (iVar3.f71068f == null) {
                                iVar3.h(j - 1);
                                d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                if (iVar3.a() > 0) {
                                    Log.d("SegmentDispatcher", "applySegmentLocked:q break");
                                    break;
                                }
                            } else {
                                long j2 = j - 1;
                                if (iVar3.f71068f.g(j2)) {
                                    iVar3.h(j2);
                                    d.o.a.e.b.c.a.h("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar3);
                                } else {
                                    d.o.a.e.b.c.a.j("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar3);
                                    throw new com.ss.android.socialbase.downloader.f.j(4, "prev end adjust fail");
                                }
                            }
                        }
                        i2--;
                    }
                } else {
                    d.o.a.e.b.c.a.j("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + k);
                    throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist");
                }
            } else {
                throw new com.ss.android.socialbase.downloader.f.j(5, "applySegment");
            }
        } else {
            d.o.a.e.b.c.a.j("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.f71068f);
            throw new com.ss.android.socialbase.downloader.f.j(1, "segment already has an owner");
        }
    }

    public final void X() {
        this.f71078i.add(new o(this.f71070a.T0(), true));
        List<String> w = this.f71070a.w();
        if (w != null) {
            for (String str : w) {
                if (!TextUtils.isEmpty(str)) {
                    this.f71078i.add(new o(str, false));
                }
            }
        }
        this.f71071b.c(this.f71078i.size());
    }

    public final void Z() {
        m mVar = this.f71071b;
        this.v = mVar.l();
        this.w = mVar.m();
        this.y = mVar.q();
        int i2 = this.z;
        if (i2 > 0) {
            this.u.b(this.B, i2);
        }
    }

    @Override // d.o.a.e.b.o.e.c
    public void a(String str, List<InetAddress> list) {
        if (this.f71076g || this.f71075f) {
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
            this.f71071b.c(this.f71078i.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            U();
        }
    }

    public final void a0() {
        if (this.w > 0) {
            this.x = System.currentTimeMillis();
            this.u.b(this.C, 0L);
        }
    }

    @Override // d.o.a.e.b.i.f
    public void b(l lVar, i iVar, o oVar, d.o.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.h {
        synchronized (this) {
            if (!this.f71075f && !this.f71076g) {
                E(lVar, iVar, oVar, bVar);
                lVar.o(false);
                if (this.m <= 0) {
                    long Q0 = this.f71070a.Q0();
                    this.m = Q0;
                    if (Q0 <= 0) {
                        this.m = bVar.j();
                    }
                    U();
                } else if (this.f71071b.i()) {
                    U();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    public final void b0() {
        List<String> w;
        int n = this.f71071b.n();
        if (n <= 0) {
            this.l = false;
            U();
            return;
        }
        d.o.a.e.b.o.e a2 = d.o.a.e.b.o.e.a();
        a2.c(this.f71070a.T0(), this, 2000L);
        if (n <= 2 || (w = this.f71070a.w()) == null) {
            return;
        }
        for (String str : w) {
            if (!TextUtils.isEmpty(str)) {
                a2.c(str, this, 2000L);
            }
        }
    }

    @Override // d.o.a.e.b.i.f
    public i c(l lVar, o oVar) {
        if (this.f71075f || this.f71076g) {
            return null;
        }
        synchronized (this) {
            i B = B(lVar, oVar);
            if (B != null) {
                B.n();
                if (B.f71068f != null) {
                    return new i(B);
                }
            }
            return B;
        }
    }

    public final o c0() {
        o oVar;
        synchronized (this) {
            int size = this.p % this.f71078i.size();
            if (this.f71071b.e()) {
                this.p++;
            }
            oVar = this.f71078i.get(size);
        }
        return oVar;
    }

    @Override // d.o.a.e.b.i.f
    public void d(l lVar, i iVar) throws BaseException {
        synchronized (this) {
            V(lVar, iVar);
        }
    }

    public final void d0() {
        d.o.a.e.b.c.a.h("SegmentDispatcher", "onComplete");
        this.f71072c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    @Override // d.o.a.e.b.i.f
    public void e(l lVar, i iVar) {
        synchronized (this) {
            iVar.o();
        }
    }

    public final boolean e0() {
        for (l lVar : this.f71077h) {
            if (!lVar.w()) {
                return false;
            }
        }
        return true;
    }

    @Override // d.o.a.e.b.i.f
    public void f(l lVar, i iVar) {
        synchronized (this) {
            if (iVar.f71068f == lVar) {
                d.o.a.e.b.c.a.h("SegmentDispatcher", "unApplySegment " + iVar);
                iVar.j(lVar.s());
                iVar.f71068f = null;
                lVar.c();
            }
        }
    }

    public final void f0() {
        if (this.m <= 0) {
            return;
        }
        synchronized (this) {
            int size = this.o.size();
            if (size <= 1) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                i iVar = this.o.get(i2);
                i iVar2 = this.o.get(i3);
                if (iVar.k() > iVar2.g() && iVar2.a() <= 0 && iVar2.f71068f == null) {
                    arrayList.add(iVar2);
                    d.o.a.e.b.c.a.h("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                } else if (iVar2.k() > iVar.k()) {
                    i2++;
                }
            }
            if (!arrayList.isEmpty()) {
                this.o.removeAll(arrayList);
            }
        }
    }

    @Override // d.o.a.e.b.i.f
    public void g(l lVar, o oVar, i iVar, BaseException baseException) {
        synchronized (this) {
            d.o.a.e.b.c.a.j("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            lVar.o(true);
            if (lVar.w == 0) {
                this.q = baseException;
            }
            if (e0()) {
                if (this.q == null) {
                    this.q = baseException;
                }
                s(this.q);
            }
        }
    }

    public final boolean g0() {
        long j = this.m;
        if (j <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a2 = n.a(this.o);
            d.o.a.e.b.c.a.h("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a2);
            if (a2 >= j) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    @Override // d.o.a.e.b.i.f
    public e h(l lVar, i iVar) throws BaseException {
        e a2;
        synchronized (this) {
            k kVar = new k(this.f71070a, this.f71072c, iVar);
            this.f71074e.e(kVar);
            a2 = kVar.a();
        }
        return a2;
    }

    public final long h0() {
        long j = 0;
        for (l lVar : this.f71077h) {
            j += lVar.l();
        }
        return j;
    }

    @Override // d.o.a.e.b.i.f
    public void i(l lVar) {
        if (this.A) {
            d.o.a.e.b.c.a.h("SegmentDispatcher", "onReaderRun, threadIndex = " + lVar.w);
        }
    }

    public final i i0() {
        int i2 = 0;
        while (true) {
            i j0 = j0();
            if (j0 == null) {
                return null;
            }
            l lVar = j0.f71068f;
            if (lVar == null) {
                return j0;
            }
            if (j0.p() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            D(currentTimeMillis);
            if (currentTimeMillis - lVar.J > 2000 && A(lVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.A) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + j0 + ", owner.threadIndex = " + lVar.w);
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

    @Override // d.o.a.e.b.i.f
    public void j(l lVar) {
        d.o.a.e.b.c.a.h("SegmentDispatcher", "onReaderExit: threadIndex = " + lVar.w);
        synchronized (this) {
            lVar.r(true);
            this.f71077h.remove(lVar);
            f0();
            if (this.f71077h.isEmpty()) {
                d0();
            } else if (g0()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (l lVar2 : this.f71077h) {
                    lVar2.u();
                }
                d0();
            }
        }
    }

    public final i j0() {
        int p;
        i iVar = null;
        int i2 = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (n(iVar2) > 0 && (p = iVar2.p()) < i2) {
                iVar = iVar2;
                i2 = p;
            }
        }
        return iVar;
    }

    public final int k(long j) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.o.get(i2);
            if (iVar.g() == j) {
                return i2;
            }
            if (iVar.g() > j) {
                return -1;
            }
        }
        return -1;
    }

    public final long k0() {
        if (this.f71075f || this.f71076g) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            D(currentTimeMillis);
            long m = this.f71071b.m();
            if (m > 0) {
                long j = this.x;
                if (j > 0 && currentTimeMillis - j > m && x(currentTimeMillis, m)) {
                    this.x = currentTimeMillis;
                    this.z++;
                }
            }
        }
        return 2000L;
    }

    public final int l(String str) {
        int size = this.f71078i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f71078i.get(i2).f71092a, str)) {
                return i2;
            }
        }
        return -1;
    }

    public final long m(int i2, int i3) {
        i iVar = this.o.get(i2);
        long n = n(iVar);
        int i4 = i2 + 1;
        i iVar2 = i4 < i3 ? this.o.get(i4) : null;
        if (iVar2 == null) {
            return n;
        }
        long g2 = iVar2.g() - iVar.k();
        return n == -1 ? g2 : Math.min(n, g2);
    }

    public final long n(i iVar) {
        long d2 = iVar.d();
        if (d2 == -1) {
            long j = this.m;
            return j > 0 ? j - iVar.k() : d2;
        }
        return d2;
    }

    public final l o(long j, long j2, long j3, int i2) {
        long j4;
        long j5 = Long.MAX_VALUE;
        int i3 = 0;
        l lVar = null;
        for (l lVar2 : this.f71077h) {
            if (lVar2.J > 0) {
                i3++;
                long j6 = j5;
                if (lVar2.J < j) {
                    long a2 = lVar2.a(j, j2);
                    if (this.A) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a2 + ", threadIndex = " + lVar2.w);
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
        d.o.a.e.b.c.a.h("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + lVar.w);
        return lVar;
    }

    public final l q(boolean z, long j, long j2) {
        l lVar = null;
        for (l lVar2 : this.f71077h) {
            if (lVar2.w != 0 || z) {
                if (lVar2.H > 0 && lVar2.I <= 0 && j - lVar2.H > j2 && (lVar == null || lVar2.H < lVar.H)) {
                    lVar = lVar2;
                }
            }
        }
        return lVar;
    }

    public void r() {
        d.o.a.e.b.c.a.h("SegmentDispatcher", QueryResponse.Options.CANCEL);
        this.f71075f = true;
        synchronized (this) {
            for (l lVar : this.f71077h) {
                lVar.u();
            }
        }
        this.f71074e.a();
        this.f71072c.c();
    }

    public final void s(BaseException baseException) {
        d.o.a.e.b.c.a.j("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.f71072c.c();
        synchronized (this) {
            for (l lVar : this.f71077h) {
                lVar.u();
            }
        }
    }

    public final void t(o oVar) {
        l lVar = new l(this.f71070a, this, this.f71072c, oVar, this.f71077h.size());
        this.f71077h.add(lVar);
        lVar.e(d.o.a.e.b.g.d.B0().submit(lVar));
    }

    public final void u(d.o.a.e.b.n.b bVar) throws BaseException {
        d.o.a.e.b.n.b bVar2 = this.j;
        if (bVar2 == null && (bVar2 = this.k) == null) {
            return;
        }
        long j = bVar.j();
        long j2 = bVar2.j();
        if (j == j2) {
            if (!TextUtils.equals(bVar.c(), bVar2.c())) {
                throw new BaseException(1074, "etag not equals with main url");
            }
            return;
        }
        throw new BaseException(1074, "total len not equals,len=" + j + ",sLen=" + j2 + ",code=" + bVar.f71232c + ",sCode=" + bVar2.f71232c + ",range=" + bVar.e() + ",sRange = " + bVar2.e() + ",url = " + bVar.f71230a + ",sUrl=" + bVar2.f71230a);
    }

    public void v(List<i> list) throws BaseException, InterruptedException {
        try {
            X();
            G(list);
            U();
            Z();
            b0();
            long currentTimeMillis = System.currentTimeMillis();
            L();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.f71070a.Y0(currentTimeMillis2);
            this.f71070a.u2(currentTimeMillis2);
            if (!this.f71076g && !this.f71075f) {
                this.f71073d.a(this.m);
                a0();
                R();
                if (!this.f71076g && !this.f71075f) {
                    d.o.a.e.b.c.a.h("SegmentDispatcher", "finally pause");
                    C();
                }
                try {
                    synchronized (this) {
                        while (!this.n.isEmpty()) {
                            i poll = this.n.poll();
                            if (poll != null) {
                                w(this.o, poll, true);
                            }
                        }
                        M(this.o);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.u.c();
                return;
            }
            if (!this.f71076g && !this.f71075f) {
                d.o.a.e.b.c.a.h("SegmentDispatcher", "finally pause");
                C();
            }
            try {
                synchronized (this) {
                    while (!this.n.isEmpty()) {
                        i poll2 = this.n.poll();
                        if (poll2 != null) {
                            w(this.o, poll2, true);
                        }
                    }
                    M(this.o);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.u.c();
        } catch (Throwable th3) {
            if (!this.f71076g && !this.f71075f) {
                d.o.a.e.b.c.a.h("SegmentDispatcher", "finally pause");
                C();
            }
            try {
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            synchronized (this) {
                while (!this.n.isEmpty()) {
                    i poll3 = this.n.poll();
                    if (poll3 != null) {
                        w(this.o, poll3, true);
                    }
                }
                M(this.o);
                this.u.c();
                throw th3;
            }
        }
    }

    public final void w(List<i> list, i iVar, boolean z) {
        long g2 = iVar.g();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && g2 >= list.get(i2).g()) {
            i2++;
        }
        list.add(i2, iVar);
        if (z) {
            iVar.b(size);
        }
    }

    public final boolean x(long j, long j2) {
        long j3 = j - j2;
        long d2 = this.t.d(j3, j);
        int size = this.f71077h.size();
        if (size > 0) {
            d2 /= size;
        }
        l o = o(j3, j, Math.max(10.0f, ((float) d2) * this.y), size / 2);
        if (o != null) {
            N(o);
            d.o.a.e.b.c.a.i("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + o.w);
            o.v();
            return true;
        }
        l q = q(true, j, j2);
        if (q != null) {
            N(q);
            d.o.a.e.b.c.a.i("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + q.w);
            q.v();
            return true;
        }
        return false;
    }

    @Override // d.o.a.e.b.i.f
    public void a(l lVar, o oVar, i iVar, BaseException baseException, int i2, int i3) {
        d.o.a.e.b.l.e.e0(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074) ? true : true) || i2 >= i3) {
            N(lVar);
        }
    }
}
