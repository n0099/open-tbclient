package com.ss.android.socialbase.downloader.f;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.plugin.PluginCenter;
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
/* loaded from: classes4.dex */
public class k implements f, c.a {
    public int A;
    public final boolean B;
    public final DownloadInfo a;

    /* renamed from: b  reason: collision with root package name */
    public final n f60242b;

    /* renamed from: c  reason: collision with root package name */
    public final b f60243c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.h.f f60244d;

    /* renamed from: e  reason: collision with root package name */
    public final g f60245e;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.d f60250j;
    public com.ss.android.socialbase.downloader.model.d k;
    public long m;
    public int p;
    public BaseException q;
    public volatile boolean r;
    public final com.ss.android.socialbase.downloader.i.e t;
    public final com.ss.android.socialbase.downloader.h.e u;
    public long w;
    public long x;
    public long y;
    public float z;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f60246f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f60247g = false;

    /* renamed from: h  reason: collision with root package name */
    public final List<m> f60248h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<q> f60249i = new ArrayList();
    public volatile boolean l = true;
    public final LinkedList<i> n = new LinkedList<>();
    public final List<i> o = new ArrayList();
    public final Object s = new Object();
    public volatile boolean v = false;
    public final e.b C = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.1

        /* renamed from: b  reason: collision with root package name */
        public int f60251b;

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f60246f || k.this.f60247g) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.f60250j == null && k.this.k == null) {
                    long j2 = k.this.w;
                    if (j2 <= 0) {
                        return -1L;
                    }
                    this.f60251b++;
                    m a = k.this.a(false, System.currentTimeMillis(), j2);
                    if (a != null) {
                        k.this.c(a);
                        a.f();
                        return ((this.f60251b / k.this.f60249i.size()) + 1) * j2;
                    }
                    return j2;
                }
                return -1L;
            }
        }
    };
    public final e.b D = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.2
        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            return k.this.r();
        }
    };

    public k(@NonNull DownloadInfo downloadInfo, @NonNull n nVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.a = downloadInfo;
        this.f60242b = nVar;
        b bVar = new b(nVar.d(), this.f60242b.e());
        this.f60243c = bVar;
        this.f60244d = fVar;
        this.f60245e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private void h() {
        if (this.x > 0) {
            this.y = System.currentTimeMillis();
            this.u.a(this.D, 0L);
        }
    }

    private void i() {
        List<String> backUpUrls;
        int l = this.f60242b.l();
        if (l <= 0) {
            this.l = false;
            e();
            return;
        }
        com.ss.android.socialbase.downloader.network.c a = com.ss.android.socialbase.downloader.network.c.a();
        a.a(this.a.getUrl(), this, 2000L);
        if (l <= 2 || (backUpUrls = this.a.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                a.a(str, this, 2000L);
            }
        }
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.f60249i.size();
            if (this.f60242b.b()) {
                this.p++;
            }
            qVar = this.f60249i.get(size);
        }
        return qVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.f60243c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        for (m mVar : this.f60248h) {
            if (!mVar.g()) {
                return false;
            }
        }
        return true;
    }

    private void m() {
        int size;
        if (this.m > 0 && (size = this.o.size()) > 1) {
            ArrayList<i> arrayList = null;
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                i iVar = this.o.get(i2);
                i iVar2 = this.o.get(i3);
                if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
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
                    for (m mVar : this.f60248h) {
                        if (mVar.a == iVar3) {
                            if (this.B) {
                                String str2 = "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.f60255c;
                            }
                            mVar.a(true);
                        }
                    }
                }
            }
        }
    }

    private boolean n() {
        long j2 = this.m;
        if (j2 <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a);
            if (a >= j2) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    private long o() {
        long j2 = 0;
        for (m mVar : this.f60248h) {
            j2 += mVar.b();
        }
        return j2;
    }

    private i p() {
        int i2 = 0;
        while (true) {
            i q = q();
            if (q == null) {
                return null;
            }
            m mVar = q.a;
            if (mVar == null) {
                return q;
            }
            if (q.j() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b(currentTimeMillis);
            if (currentTimeMillis - mVar.f60258f > 2000 && a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    String str = "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q + ", owner.threadIndex = " + mVar.f60255c;
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
        int j2;
        i iVar = null;
        int i2 = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (j2 = iVar2.j()) < i2) {
                iVar = iVar2;
                i2 = j2;
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        if (this.f60246f || this.f60247g) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            b(currentTimeMillis);
            long k = this.f60242b.k();
            if (k > 0) {
                long j2 = this.y;
                if (j2 > 0 && currentTimeMillis - j2 > k && a(currentTimeMillis, k)) {
                    this.y = currentTimeMillis;
                    this.A++;
                }
            }
        }
        return 2000L;
    }

    private void b(List<i> list) {
        long totalBytes = this.a.getTotalBytes();
        this.m = totalBytes;
        if (totalBytes <= 0) {
            this.m = this.a.getExpectFileLength();
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

    private void c() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.s) {
            if (this.f60250j == null && this.k == null) {
                this.s.wait();
            }
        }
        if (this.f60250j == null && this.k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    private void d() throws BaseException {
        try {
            this.f60245e.a((d) this.f60243c);
        } catch (p unused) {
        } catch (BaseException e2) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            a(e2);
            throw e2;
        }
        if (this.f60247g || this.f60246f) {
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
        if (this.a.getCurBytes() != this.a.getTotalBytes()) {
            com.ss.android.socialbase.downloader.d.a.a(this.a, this.o);
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void e() {
        int i2;
        if (this.m <= 0 || this.l) {
            i2 = 1;
        } else {
            i2 = this.f60242b.a();
            int h2 = (int) (this.m / this.f60242b.h());
            if (i2 > h2) {
                i2 = h2;
            }
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i2);
        int i3 = i2 > 0 ? i2 : 1;
        synchronized (this) {
            do {
                if (this.f60248h.size() >= i3) {
                    break;
                }
                if (!this.f60247g && !this.f60246f) {
                    a(j());
                }
                return;
            } while (!this.f60242b.f());
        }
    }

    private void f() {
        this.f60249i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f60249i.add(new q(str, false));
                }
            }
        }
        this.f60242b.a(this.f60249i.size());
    }

    private void g() {
        n nVar = this.f60242b;
        this.w = nVar.j();
        this.x = nVar.k();
        this.z = nVar.o();
        int i2 = this.A;
        if (i2 > 0) {
            this.u.a(this.C, i2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, IGET, INVOKE, IF] complete} */
    public boolean a(List<i> list) throws BaseException, InterruptedException {
        try {
            f();
            b(list);
            e();
            g();
            i();
            long currentTimeMillis = System.currentTimeMillis();
            c();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.a.increaseAllConnectTime(currentTimeMillis2);
            this.a.setFirstSpeedTime(currentTimeMillis2);
            if (!this.f60247g && !this.f60246f) {
                this.f60244d.a(this.m);
                h();
                d();
                return true;
            }
            if (!this.f60247g && !this.f60246f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
            return true;
        } finally {
            if (!this.f60247g && !this.f60246f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
        }
    }

    private void c(List<i> list) {
        long b2 = o.b(list);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.a.getCurBytes() + ", totalBytes = " + this.a.getTotalBytes() + ", downloadedBytes = " + b2);
        if (b2 > this.a.getTotalBytes() && this.a.getTotalBytes() > 0) {
            b2 = this.a.getTotalBytes();
        }
        if (this.a.getCurBytes() == this.a.getTotalBytes() || this.a.getCurBytes() == b2) {
            return;
        }
        this.a.setCurBytes(b2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(m mVar, i iVar) throws j {
        i iVar2;
        long j2;
        long f2;
        boolean z;
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: start " + iVar);
        if (iVar.a != mVar) {
            if (iVar.a == null) {
                if (mVar.h() == iVar.e()) {
                    long c2 = iVar.c();
                    int a = a(c2);
                    if (a != -1 && (iVar2 = this.o.get(a)) != null) {
                        if (iVar2 != iVar) {
                            if (iVar2.c() == iVar.c()) {
                                long a2 = a(iVar2);
                                if (a2 > 0) {
                                    m mVar2 = iVar2.a;
                                    if (mVar2 != null) {
                                        if (a2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                            j2 = c2;
                                            if (mVar.f60258f - mVar2.f60258f > 1000) {
                                            }
                                        } else {
                                            j2 = c2;
                                        }
                                        String str = "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2;
                                        z = false;
                                        if (!z) {
                                            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                                            throw new j(2, "segment not exist, but has another same segment");
                                        }
                                    } else {
                                        j2 = c2;
                                    }
                                    if (mVar2 != null) {
                                        String str2 = "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2;
                                        mVar2.a(true);
                                    } else {
                                        String str3 = "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2;
                                    }
                                    iVar.c(iVar2.f());
                                    iVar.b(iVar2.j());
                                    this.o.set(a, iVar);
                                    z = true;
                                    if (!z) {
                                    }
                                }
                            }
                            j2 = c2;
                            z = false;
                            if (!z) {
                            }
                        } else {
                            j2 = c2;
                        }
                        long a3 = iVar.a();
                        int i2 = a - 1;
                        while (true) {
                            if (i2 < 0) {
                                break;
                            }
                            i iVar3 = this.o.get(i2);
                            long f3 = iVar3.f();
                            if (f3 <= 0 || f3 >= j2) {
                                if (a3 <= 0 && iVar3.e() > j2) {
                                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                    this.o.remove(iVar);
                                    throw new j(3, "prev overstep");
                                } else if (iVar3.a == null) {
                                    iVar3.c(j2 - 1);
                                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                    if (iVar3.a() > 0) {
                                        break;
                                    }
                                } else {
                                    long j3 = j2 - 1;
                                    if (iVar3.a.a(j3)) {
                                        iVar3.c(j3);
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
                        for (int i3 = a + 1; i3 < size; i3++) {
                            i iVar4 = this.o.get(i3);
                            if (iVar4.a() > 0 || iVar4.a != null) {
                                long f4 = iVar.f();
                                long c3 = iVar4.c();
                                if (f4 <= 0 || f4 >= c3) {
                                    long j4 = c3 - 1;
                                    iVar.c(j4);
                                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: segment set end:" + j4 + ", later = " + iVar4);
                                }
                                f2 = iVar.f();
                                if (f2 <= 0 && (j2 > f2 || iVar.e() > f2)) {
                                    throw new j(6, "applySegment: " + iVar);
                                }
                                iVar.a = mVar;
                                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + iVar);
                                return;
                            }
                        }
                        f2 = iVar.f();
                        if (f2 <= 0) {
                        }
                        iVar.a = mVar;
                        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + iVar);
                        return;
                    }
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + a);
                    throw new j(2, "segment not exist");
                }
                throw new j(5, "applySegment");
            } else {
                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.a);
                throw new j(1, "segment already has an owner");
            }
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: " + mVar + " is already the owner of " + iVar);
    }

    private void b(String str, List<q> list) {
        int a;
        Iterator<q> it;
        if (this.B) {
            while (list.iterator().hasNext()) {
                String str2 = "addIpListLocked: urlRecord = " + it.next();
            }
        }
        int l = this.f60242b.l();
        if ((l == 1 || l == 3) && (a = a(str)) >= 0 && a < this.f60249i.size()) {
            this.f60249i.addAll(a + 1, list);
        } else {
            this.f60249i.addAll(list);
        }
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z;
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
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.f60265c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.f60265c, linkedList);
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

    private void d(List<i> list) {
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
        long totalBytes = this.a.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.c(-1L);
        }
    }

    private i b(m mVar, q qVar) {
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

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) throws BaseException {
        synchronized (this) {
            e(mVar, iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (this.f60247g || this.f60246f) {
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
            this.f60242b.a(this.f60249i.size());
            e();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.f60255c);
        synchronized (this) {
            mVar.c(true);
            this.f60248h.remove(mVar);
            m();
            if (this.f60248h.isEmpty()) {
                k();
            } else if (n()) {
                for (m mVar2 : this.f60248h) {
                    mVar2.e();
                }
                k();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        synchronized (this) {
            if (iVar.a == mVar) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment " + iVar);
                iVar.d(mVar.d());
                iVar.a = null;
                mVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) throws BaseException {
        e a;
        synchronized (this) {
            l lVar = new l(this.a, this.f60243c, iVar);
            this.f60245e.a(lVar);
            a = lVar.a();
        }
        return a;
    }

    private int a(String str) {
        int size = this.f60249i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f60249i.get(i2).a, str)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(m mVar) {
        synchronized (this) {
            q d2 = d(mVar);
            if (d2 == null) {
                return false;
            }
            return mVar.a(d2);
        }
    }

    private void a(List<i> list, i iVar, boolean z) {
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

    private q d(m mVar) {
        q qVar;
        Iterator<q> it = this.f60249i.iterator();
        q qVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            qVar = it.next();
            if (qVar != mVar.f60254b && !qVar.d()) {
                if (qVar2 == null) {
                    qVar2 = qVar;
                }
                if (qVar.a() <= 0) {
                    break;
                }
            }
        }
        if (this.f60242b.b()) {
            if (qVar != null) {
                return qVar;
            }
            if (this.f60242b.c()) {
                return null;
            }
        }
        return qVar2;
    }

    private void b(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        m mVar2 = iVar.a;
        if (mVar2 != null && mVar2 != mVar) {
            throw new j(1, "segment already has an owner");
        }
        if (mVar.h() == iVar.e()) {
            if (!dVar.b()) {
                if (iVar.e() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.e());
                    if (!dVar.a()) {
                        int i2 = dVar.f60442c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + dVar.f60442c + " segment=" + iVar);
                    }
                } else {
                    int i3 = dVar.f60442c;
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + dVar.f60442c + " segment=" + iVar);
                }
            }
            if (qVar.f60266d) {
                if (this.f60250j == null) {
                    this.f60250j = dVar;
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    com.ss.android.socialbase.downloader.h.f fVar = this.f60244d;
                    if (fVar != null) {
                        fVar.a(qVar.a, dVar.f60441b, iVar.e());
                    }
                    long j2 = dVar.j();
                    if (j2 > 0) {
                        for (i iVar2 : this.o) {
                            if (iVar2.f() <= 0 || iVar2.f() > j2 - 1) {
                                iVar2.c(j2 - 1);
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
                if (this.a.getTotalBytes() <= 0) {
                    long j3 = dVar.j();
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j3 + ",url=" + qVar.a);
                    this.a.setTotalBytes(j3);
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i c(m mVar, q qVar) {
        String str;
        float f2;
        float f3;
        int size = this.o.size();
        long j2 = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            long a = a(i3, size);
            if (a > j2) {
                i2 = i3;
                j2 = a;
            }
        }
        long g2 = this.f60242b.g();
        long i4 = this.f60242b.i();
        if (i2 < 0 || j2 <= g2) {
            return null;
        }
        i iVar = this.o.get(i2);
        int n = this.o.size() < this.f60248h.size() ? 2 : this.f60242b.n();
        if (n == 1) {
            m mVar2 = iVar.a;
            if (mVar2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
                long a2 = mVar2.a(j3, currentTimeMillis);
                long a3 = mVar.a(j3, currentTimeMillis);
                float f4 = (a2 <= 0 || a3 <= 0) ? -1.0f : ((float) a3) / ((float) (a2 + a3));
                if (f4 == -1.0f) {
                    long b2 = mVar2.b();
                    f2 = f4;
                    long b3 = mVar.b();
                    if (b2 > 0 && b3 > 0) {
                        f3 = ((float) b3) / ((float) (b2 + b3));
                        if (f3 > 0.0f) {
                            float f5 = f3 * 0.9f;
                            long j4 = ((float) j2) * f5;
                            if (j4 < g2) {
                                j4 = g2;
                            }
                            if (i4 <= 0 || j4 <= i4) {
                                i4 = j4;
                            }
                            long j5 = g2 / 2;
                            long j6 = j2 - j5;
                            if (i4 > j6) {
                                i4 = j6;
                            } else if (i4 < j5) {
                                i4 = j5;
                            }
                            i iVar2 = new i(iVar.e() + (j2 - i4), iVar.f());
                            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j2 + ", childLength = " + i4 + ", ratio = " + f5 + ", threadIndex = " + mVar.f60255c);
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
            long curBytes = ((float) (this.m - this.a.getCurBytes())) * d2;
            if (curBytes < g2) {
                curBytes = g2;
            }
            if (i4 <= 0 || curBytes <= i4) {
                i4 = curBytes;
            }
            long j7 = g2 / 2;
            long j8 = j2 - j7;
            if (i4 > j8) {
                i4 = j8;
            } else if (i4 < j7) {
                i4 = j7;
            }
            i iVar3 = new i(iVar.e() + (j2 - i4), iVar.f());
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j2 + ", childLength = " + i4 + ", ratio = " + d2 + ", threadIndex = " + mVar.f60255c);
            return iVar3;
        } else {
            str = "SegmentDispatcher";
        }
        i iVar4 = new i(iVar.e() + (j2 / 2), iVar.f());
        com.ss.android.socialbase.downloader.c.a.c(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
        return iVar4;
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.f60243c, qVar, this.f60248h.size());
        this.f60248h.add(mVar);
        mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
    }

    private float d(m mVar, q qVar) {
        long b2 = mVar.b();
        int size = this.f60248h.size();
        if (size <= 1) {
            size = this.f60242b.a();
        }
        float f2 = 1.0f;
        if (b2 <= 0) {
            float m = this.f60242b.m();
            if (m <= 0.0f || m >= 1.0f) {
                m = 1.0f / size;
            }
            if (mVar.f60255c == 0) {
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

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.B) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.f60255c);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (this.f60246f || this.f60247g) {
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

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        synchronized (this) {
            if (!this.f60246f && !this.f60247g) {
                b(mVar, iVar, qVar, dVar);
                mVar.b(false);
                if (this.m <= 0) {
                    long totalBytes = this.a.getTotalBytes();
                    this.m = totalBytes;
                    if (totalBytes <= 0) {
                        this.m = dVar.j();
                    }
                    e();
                } else if (this.f60242b.f()) {
                    e();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i2, int i3) {
        com.ss.android.socialbase.downloader.i.f.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i2 >= i3) {
            c(mVar);
        }
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
        this.f60247g = true;
        synchronized (this) {
            for (m mVar : this.f60248h) {
                mVar.e();
            }
        }
        this.f60245e.b();
        this.f60243c.c();
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.f60255c == 0) {
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

    private void b(long j2) {
        this.t.a(this.a.getCurBytes(), j2);
        for (m mVar : this.f60248h) {
            mVar.b(j2);
        }
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.f60243c.c();
        synchronized (this) {
            for (m mVar : this.f60248h) {
                mVar.e();
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.f60250j;
        if (dVar2 == null && (dVar2 = this.k) == null) {
            return;
        }
        long j2 = dVar.j();
        long j3 = dVar2.j();
        if (j2 != j3) {
            String str = "total len not equals,len=" + j2 + ",sLen=" + j3 + ",code=" + dVar.f60442c + ",sCode=" + dVar2.f60442c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
            if (j2 > 0 && j3 > 0) {
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

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", QueryResponse.Options.CANCEL);
        this.f60246f = true;
        synchronized (this) {
            for (m mVar : this.f60248h) {
                mVar.e();
            }
        }
        this.f60245e.a();
        this.f60243c.c();
    }

    private int a(long j2) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.o.get(i2);
            if (iVar.c() == j2) {
                return i2;
            }
            if (iVar.c() > j2) {
                return -1;
            }
        }
        return -1;
    }

    private long a(int i2, int i3) {
        i iVar = this.o.get(i2);
        long a = a(iVar);
        int i4 = i2 + 1;
        i iVar2 = i4 < i3 ? this.o.get(i4) : null;
        if (iVar2 == null) {
            return a;
        }
        long c2 = iVar2.c() - iVar.e();
        return a == -1 ? c2 : Math.min(a, c2);
    }

    private long a(i iVar) {
        long b2 = iVar.b();
        if (b2 == -1) {
            long j2 = this.m;
            return j2 > 0 ? j2 - iVar.e() : b2;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(boolean z, long j2, long j3) {
        m mVar = null;
        for (m mVar2 : this.f60248h) {
            if (mVar2.f60255c != 0 || z) {
                if (mVar2.f60256d > 0 && mVar2.f60257e <= 0 && j2 - mVar2.f60256d > j3 && (mVar == null || mVar2.f60256d < mVar.f60256d)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private boolean a(m mVar, long j2, long j3, long j4, double d2) {
        if (mVar.f60258f > 0) {
            long b2 = this.t.b(j2, j3);
            int size = this.f60248h.size();
            long j5 = size > 0 ? b2 / size : b2;
            long a = mVar.a(j2, j3);
            if (a < j4 || a < j5 * d2) {
                String str = "isDownloadSpeedPoor: totalSpeed = " + b2 + ", threadAvgSpeed = " + j5 + ", poorSpeed = " + j4 + ", speed = " + a + ",threadIndex = " + mVar.f60255c;
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean a(long j2, long j3) {
        long j4 = j2 - j3;
        long b2 = this.t.b(j4, j2);
        int size = this.f60248h.size();
        if (size > 0) {
            b2 /= size;
        }
        m a = a(j4, j2, Math.max(10.0f, ((float) b2) * this.z), size / 2);
        if (a != null) {
            c(a);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a.f60255c);
            a.f();
            return true;
        }
        m a2 = a(true, j2, j3);
        if (a2 != null) {
            c(a2);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a2.f60255c);
            a2.f();
            return true;
        }
        return false;
    }

    private m a(long j2, long j3, long j4, int i2) {
        long j5 = Long.MAX_VALUE;
        int i3 = 0;
        m mVar = null;
        for (m mVar2 : this.f60248h) {
            if (mVar2.f60258f > 0) {
                i3++;
                long j6 = j5;
                if (mVar2.f60258f < j2) {
                    long a = mVar2.a(j2, j3);
                    if (this.B) {
                        String str = "findPoorReadThread: speed = " + a + ", threadIndex = " + mVar2.f60255c;
                    }
                    if (a >= 0 && a < j6) {
                        j5 = a;
                        mVar = mVar2;
                    }
                }
                j5 = j6;
            }
        }
        long j7 = j5;
        if (mVar == null || i3 < i2 || j7 >= j4) {
            return null;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + mVar.f60255c);
        return mVar;
    }
}
