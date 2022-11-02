package com.ss.android.socialbase.downloader.f;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class k implements f, c.a {
    public int A;
    public final boolean B;
    public final DownloadInfo a;
    public final n b;
    public final b c;
    public final com.ss.android.socialbase.downloader.h.f d;
    public final g e;
    public com.ss.android.socialbase.downloader.model.d j;
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
    public volatile boolean f = false;
    public volatile boolean g = false;
    public final List<m> h = new ArrayList();
    public final List<q> i = new ArrayList();
    public volatile boolean l = true;
    public final LinkedList<i> n = new LinkedList<>();
    public final List<i> o = new ArrayList();
    public final Object s = new Object();
    public volatile boolean v = false;
    public final e.b C = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.1
        public int b;

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f || k.this.g) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.j == null && k.this.k == null) {
                    long j = k.this.w;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.b++;
                    m a = k.this.a(false, System.currentTimeMillis(), j);
                    if (a != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        k.this.c(a);
                        a.f();
                        return ((this.b / k.this.i.size()) + 1) * j;
                    }
                    return j;
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
        this.b = nVar;
        b bVar = new b(nVar.d(), this.b.e());
        this.c = bVar;
        this.d = fVar;
        this.e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private int a(long j) {
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.o.get(i);
            if (iVar.c() == j) {
                return i;
            }
            if (iVar.c() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void b(long j) {
        this.t.a(this.a.getCurBytes(), j);
        for (m mVar : this.h) {
            mVar.b(j);
        }
    }

    private int a(String str) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.i.get(i).a, str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(m mVar) {
        synchronized (this) {
            q d = d(mVar);
            if (d == null) {
                return false;
            }
            return mVar.a(d);
        }
    }

    private long a(int i, int i2) {
        i iVar;
        i iVar2 = this.o.get(i);
        long a = a(iVar2);
        int i3 = i + 1;
        if (i3 < i2) {
            iVar = this.o.get(i3);
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return a;
        }
        long c = iVar.c() - iVar2.e();
        if (a == -1) {
            return c;
        }
        return Math.min(a, c);
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) throws BaseException {
        synchronized (this) {
            e(mVar, iVar);
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
            l lVar = new l(this.a, this.c, iVar);
            this.e.a(lVar);
            a = lVar.a();
        }
        return a;
    }

    private long a(i iVar) {
        long b = iVar.b();
        if (b == -1) {
            long j = this.m;
            if (j > 0) {
                return j - iVar.e();
            }
            return b;
        }
        return b;
    }

    private m a(long j, long j2, long j3, int i) {
        long j4;
        long j5 = Long.MAX_VALUE;
        int i2 = 0;
        m mVar = null;
        for (m mVar2 : this.h) {
            if (mVar2.f > 0) {
                i2++;
                long j6 = j5;
                if (mVar2.f < j) {
                    long a = mVar2.a(j, j2);
                    if (this.B) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a + ", threadIndex = " + mVar2.c);
                        j4 = 0;
                    } else {
                        j4 = 0;
                    }
                    if (a >= j4 && a < j6) {
                        j5 = a;
                        mVar = mVar2;
                    }
                }
                j5 = j6;
            }
        }
        long j7 = j5;
        if (mVar != null && i2 >= i && j7 < j3) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + mVar.c);
            return mVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(boolean z, long j, long j2) {
        m mVar = null;
        for (m mVar2 : this.h) {
            if (mVar2.c != 0 || z) {
                if (mVar2.d > 0 && mVar2.e <= 0 && j - mVar2.d > j2 && (mVar == null || mVar2.d < mVar.d)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.c.c();
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
    }

    private q d(m mVar) {
        q qVar;
        Iterator<q> it = this.i.iterator();
        q qVar2 = null;
        while (true) {
            if (it.hasNext()) {
                qVar = it.next();
                if (qVar != mVar.b && !qVar.d()) {
                    if (qVar2 == null) {
                        qVar2 = qVar;
                    }
                    if (qVar.a() <= 0) {
                        break;
                    }
                }
            } else {
                qVar = null;
                break;
            }
        }
        if (this.b.b()) {
            if (qVar != null) {
                return qVar;
            }
            if (this.b.c()) {
                return null;
            }
        }
        return qVar2;
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.c, qVar, this.h.size());
        this.h.add(mVar);
        mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.j;
        if (dVar2 == null && (dVar2 = this.k) == null) {
            return;
        }
        long j = dVar.j();
        long j2 = dVar2.j();
        if (j != j2) {
            String str = "total len not equals,len=" + j + ",sLen=" + j2 + ",code=" + dVar.c + ",sCode=" + dVar2.c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
            if (j > 0 && j2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String c = dVar.c();
        String c2 = dVar2.c();
        if (!TextUtils.equals(c, c2)) {
            String str2 = "etag not equals with main url, etag = " + c + ", mainEtag = " + c2;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str2);
            if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(c2) && !c.equalsIgnoreCase(c2)) {
                throw new BaseException(1074, str2);
            }
        }
    }

    private void d(List<i> list) {
        i iVar = list.get(0);
        long c = iVar.c();
        if (c > 0) {
            i iVar2 = new i(0L, c - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
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

    private void a(List<i> list, i iVar, boolean z) {
        long c = iVar.c();
        int size = list.size();
        int i = 0;
        while (i < size && c >= list.get(i).c()) {
            i++;
        }
        list.add(i, iVar);
        if (z) {
            iVar.a(size);
        }
    }

    private boolean a(long j, long j2) {
        long j3 = j - j2;
        long b = this.t.b(j3, j);
        int size = this.h.size();
        if (size > 0) {
            b /= size;
        }
        m a = a(j3, j, Math.max(10.0f, ((float) b) * this.z), size / 2);
        if (a != null) {
            c(a);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a.c);
            a.f();
            return true;
        }
        m a2 = a(true, j, j2);
        if (a2 != null) {
            c(a2);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a2.c);
            a2.f();
            return true;
        }
        return false;
    }

    private boolean a(m mVar, long j, long j2, long j3, double d) {
        long j4;
        if (mVar.f > 0) {
            long b = this.t.b(j, j2);
            int size = this.h.size();
            if (size > 0) {
                j4 = b / size;
            } else {
                j4 = b;
            }
            long a = mVar.a(j, j2);
            if (a < j3 || a < j4 * d) {
                Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + b + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + a + ",threadIndex = " + mVar.c);
                return true;
            }
            return false;
        }
        return false;
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
        i c = c(mVar, qVar);
        if (c != null && a(c) > 0) {
            a(this.o, c, true);
            return c;
        }
        i p = p();
        if (p != null) {
            return p;
        }
        return null;
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
                        int i = dVar.c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i, "2: response code error : " + dVar.c + " segment=" + iVar);
                    }
                } else {
                    int i2 = dVar.c;
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "1: response code error : " + dVar.c + " segment=" + iVar);
                }
            }
            if (qVar.d) {
                if (this.j == null) {
                    this.j = dVar;
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    com.ss.android.socialbase.downloader.h.f fVar = this.d;
                    if (fVar != null) {
                        fVar.a(qVar.a, dVar.b, iVar.e());
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
                if (this.a.getTotalBytes() <= 0) {
                    long j2 = dVar.j();
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j2 + ",url=" + qVar.a);
                    this.a.setTotalBytes(j2);
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

    private void b(String str, List<q> list) {
        int a;
        if (this.B) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int l = this.b.l();
        if ((l == 1 || l == 3) && (a = a(str)) >= 0 && a < this.i.size()) {
            this.i.addAll(a + 1, list);
        } else {
            this.i.addAll(list);
        }
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

    private void c(List<i> list) {
        long b = o.b(list);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.a.getCurBytes() + ", totalBytes = " + this.a.getTotalBytes() + ", downloadedBytes = " + b);
        if (b > this.a.getTotalBytes() && this.a.getTotalBytes() > 0) {
            b = this.a.getTotalBytes();
        }
        if (this.a.getCurBytes() != this.a.getTotalBytes() && this.a.getCurBytes() != b) {
            this.a.setCurBytes(b);
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
            if (!this.g && !this.f) {
                this.d.a(this.m);
                h();
                d();
                return true;
            }
            if (!this.g && !this.f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
            return true;
        } finally {
            if (!this.g && !this.f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i c(m mVar, q qVar) {
        int n;
        String str;
        float f;
        float f2;
        float f3;
        int size = this.o.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long a = a(i2, size);
            if (a > j) {
                i = i2;
                j = a;
            }
        }
        long g = this.b.g();
        long i3 = this.b.i();
        if (i >= 0 && j > g) {
            i iVar = this.o.get(i);
            if (this.o.size() < this.h.size()) {
                n = 2;
            } else {
                n = this.b.n();
            }
            if (n == 1) {
                m mVar2 = iVar.a;
                if (mVar2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = currentTimeMillis - 4000;
                    long a2 = mVar2.a(j2, currentTimeMillis);
                    long a3 = mVar.a(j2, currentTimeMillis);
                    if (a2 > 0 && a3 > 0) {
                        f = ((float) a3) / ((float) (a2 + a3));
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f) {
                        long b = mVar2.b();
                        f2 = f;
                        long b2 = mVar.b();
                        if (b > 0 && b2 > 0) {
                            f3 = ((float) b2) / ((float) (b + b2));
                            if (f3 > 0.0f) {
                                float f4 = f3 * 0.9f;
                                long j3 = ((float) j) * f4;
                                if (j3 < g) {
                                    j3 = g;
                                }
                                if (i3 <= 0 || j3 <= i3) {
                                    i3 = j3;
                                }
                                long j4 = g / 2;
                                long j5 = j - j4;
                                if (i3 > j5) {
                                    i3 = j5;
                                } else if (i3 < j4) {
                                    i3 = j4;
                                }
                                i iVar2 = new i(iVar.e() + (j - i3), iVar.f());
                                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j + ", childLength = " + i3 + ", ratio = " + f4 + ", threadIndex = " + mVar.c);
                                return iVar2;
                            }
                        }
                    } else {
                        f2 = f;
                    }
                    f3 = f2;
                    if (f3 > 0.0f) {
                    }
                }
                str = "SegmentDispatcher";
            } else if (n != 2) {
                str = "SegmentDispatcher";
            } else {
                float d = d(mVar, qVar);
                long curBytes = ((float) (this.m - this.a.getCurBytes())) * d;
                if (curBytes < g) {
                    curBytes = g;
                }
                if (i3 <= 0 || curBytes <= i3) {
                    i3 = curBytes;
                }
                long j6 = g / 2;
                long j7 = j - j6;
                if (i3 > j7) {
                    i3 = j7;
                } else if (i3 < j6) {
                    i3 = j6;
                }
                i iVar3 = new i(iVar.e() + (j - i3), iVar.f());
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j + ", childLength = " + i3 + ", ratio = " + d + ", threadIndex = " + mVar.c);
                return iVar3;
            }
            i iVar4 = new i(iVar.e() + (j / 2), iVar.f());
            com.ss.android.socialbase.downloader.c.a.c(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
            return iVar4;
        }
        return null;
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.B) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        q qVar = new q(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.c, linkedList);
                        }
                        linkedList.add(qVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    z = false;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        LinkedList linkedList2 = (LinkedList) entry.getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((q) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void c() throws BaseException, InterruptedException {
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

    private void g() {
        n nVar = this.b;
        this.w = nVar.j();
        this.x = nVar.k();
        this.z = nVar.o();
        int i = this.A;
        if (i > 0) {
            this.u.a(this.C, i);
        }
    }

    private void h() {
        if (this.x > 0) {
            this.y = System.currentTimeMillis();
            this.u.a(this.D, 0L);
        }
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.i.size();
            if (this.b.b()) {
                this.p++;
            }
            qVar = this.i.get(size);
        }
        return qVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        for (m mVar : this.h) {
            if (!mVar.g()) {
                return false;
            }
        }
        return true;
    }

    private long o() {
        long j = 0;
        for (m mVar : this.h) {
            j += mVar.b();
        }
        return j;
    }

    private i q() {
        int j;
        i iVar = null;
        int i = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (j = iVar2.j()) < i) {
                iVar = iVar2;
                i = j;
            }
        }
        return iVar;
    }

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "cancel");
        this.f = true;
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
        this.e.a();
        this.c.c();
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
        this.g = true;
        synchronized (this) {
            for (m mVar : this.h) {
                mVar.e();
            }
        }
        this.e.b();
        this.c.c();
    }

    private float d(m mVar, q qVar) {
        long b = mVar.b();
        int size = this.h.size();
        if (size <= 1) {
            size = this.b.a();
        }
        float f = 1.0f;
        if (b <= 0) {
            float m = this.b.m();
            if (m <= 0.0f || m >= 1.0f) {
                m = 1.0f / size;
            }
            if (mVar.c == 0) {
                return m;
            }
            if (size > 1) {
                f = 1.0f - m;
                size--;
            }
        } else {
            long o = o();
            if (o > b) {
                return ((float) b) / ((float) o);
            }
        }
        return f / size;
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (!this.g && !this.f) {
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
                this.b.a(this.i.size());
                Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                e();
            }
        }
    }

    private void d() throws BaseException {
        try {
            this.e.a((d) this.c);
        } catch (p unused) {
        } catch (BaseException e) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e);
            a(e);
            throw e;
        }
        if (!this.g && !this.f) {
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
    }

    private void e() {
        int i;
        int i2 = 1;
        if (this.m > 0 && !this.l) {
            i = this.b.a();
            int h = (int) (this.m / this.b.h());
            if (i > h) {
                i = h;
            }
        } else {
            i = 1;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i);
        if (i > 0) {
            i2 = i;
        }
        synchronized (this) {
            do {
                if (this.h.size() >= i2) {
                    break;
                }
                if (!this.g && !this.f) {
                    a(j());
                }
                return;
            } while (!this.b.f());
        }
    }

    private i p() {
        int i = 0;
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
            if (currentTimeMillis - mVar.f > 2000 && a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q + ", owner.threadIndex = " + mVar.c);
                }
                return q;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + q);
                }
                return q;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f2, code lost:
        r3 = r3 + 1;
        r6 = r22.o.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fa, code lost:
        if (r3 >= r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fc, code lost:
        r7 = r22.o.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020c, code lost:
        if (r7.a() > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0210, code lost:
        if (r7.a == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0213, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
        r11 = r24.f();
        r15 = r7.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0220, code lost:
        if (r11 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0224, code lost:
        if (r11 < r15) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0226, code lost:
        r8 = r15 - 1;
        r24.c(r8);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: segment set end:" + r8 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0247, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024c, code lost:
        r6 = r24.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0254, code lost:
        if (r6 <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
        if (r20 > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0260, code lost:
        if (r24.e() > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0278, code lost:
        throw new com.ss.android.socialbase.downloader.f.j(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0279, code lost:
        r24.a = r23;
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(m mVar, i iVar) throws j {
        i iVar2;
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: start " + iVar);
        if (iVar.a == mVar) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: " + mVar + " is already the owner of " + iVar);
        } else if (iVar.a == null) {
            if (mVar.h() == iVar.e()) {
                long c = iVar.c();
                int a = a(c);
                if (a != -1 && (iVar2 = this.o.get(a)) != null) {
                    if (iVar2 != iVar) {
                        if (iVar2.c() == iVar.c()) {
                            long a2 = a(iVar2);
                            if (a2 > 0) {
                                m mVar2 = iVar2.a;
                                if (mVar2 != null) {
                                    if (a2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                        j = c;
                                        if (mVar.f - mVar2.f > 1000) {
                                        }
                                    } else {
                                        j = c;
                                    }
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2);
                                    z = false;
                                    if (!z) {
                                        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                                        throw new j(2, "segment not exist, but has another same segment");
                                    }
                                } else {
                                    j = c;
                                }
                                if (mVar2 != null) {
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2);
                                    mVar2.a(true);
                                } else {
                                    Log.i("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2);
                                }
                                iVar.c(iVar2.f());
                                iVar.b(iVar2.j());
                                this.o.set(a, iVar);
                                z = true;
                                if (!z) {
                                }
                            }
                        }
                        j = c;
                        z = false;
                        if (!z) {
                        }
                    } else {
                        j = c;
                    }
                    long a3 = iVar.a();
                    int i = a - 1;
                    while (true) {
                        if (i < 0) {
                            break;
                        }
                        i iVar3 = this.o.get(i);
                        long f = iVar3.f();
                        if (f <= 0 || f >= j) {
                            if (a3 <= 0 && iVar3.e() > j) {
                                com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                this.o.remove(iVar);
                                throw new j(3, "prev overstep");
                            } else if (iVar3.a == null) {
                                iVar3.c(j - 1);
                                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                if (iVar3.a() > 0) {
                                    Log.d("SegmentDispatcher", "applySegmentLocked:q break");
                                    break;
                                }
                            } else {
                                long j2 = j - 1;
                                if (iVar3.a.a(j2)) {
                                    iVar3.c(j2);
                                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar3);
                                } else {
                                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar3);
                                    throw new j(4, "prev end adjust fail");
                                }
                            }
                        }
                        i--;
                    }
                } else {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + a);
                    throw new j(2, "segment not exist");
                }
            } else {
                throw new j(5, "applySegment");
            }
        } else {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.a);
            throw new j(1, "segment already has an owner");
        }
    }

    private void f() {
        this.i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.i.add(new q(str, false));
                }
            }
        }
        this.b.a(this.i.size());
    }

    private void i() {
        List<String> backUpUrls;
        int l = this.b.l();
        if (l <= 0) {
            this.l = false;
            e();
            return;
        }
        com.ss.android.socialbase.downloader.network.c a = com.ss.android.socialbase.downloader.network.c.a();
        a.a(this.a.getUrl(), this, 2000L);
        if (l > 2 && (backUpUrls = this.a.getBackUpUrls()) != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    a.a(str, this, 2000L);
                }
            }
        }
    }

    private boolean n() {
        long j = this.m;
        if (j <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a);
            if (a >= j) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        if (!this.f && !this.g) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                b(currentTimeMillis);
                long k = this.b.k();
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
        return -1L;
    }

    private void m() {
        int size;
        if (this.m <= 0 || (size = this.o.size()) <= 1) {
            return;
        }
        ArrayList<i> arrayList = null;
        int i = 0;
        for (int i2 = 1; i2 < size; i2++) {
            i iVar = this.o.get(i);
            i iVar2 = this.o.get(i2);
            if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(iVar2);
                if (this.B) {
                    Log.w("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                }
            } else if (iVar2.e() > iVar.e()) {
                i++;
            }
        }
        if (arrayList != null) {
            for (i iVar3 : arrayList) {
                this.o.remove(iVar3);
                for (m mVar : this.h) {
                    if (mVar.a == iVar3) {
                        if (this.B) {
                            Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.c);
                        }
                        mVar.a(true);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (!this.f && !this.g) {
            synchronized (this) {
                i b = b(mVar, qVar);
                if (b != null) {
                    b.h();
                    if (b.j() > 1) {
                        return new i(b);
                    }
                }
                return b;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.B) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.c);
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
            if (!this.f && !this.g) {
                b(mVar, iVar, qVar, dVar);
                mVar.b(false);
                if (this.m <= 0) {
                    long totalBytes = this.a.getTotalBytes();
                    this.m = totalBytes;
                    if (totalBytes <= 0) {
                        this.m = dVar.j();
                    }
                    e();
                } else if (this.b.f()) {
                    e();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.c == 0) {
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

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i, int i2) {
        com.ss.android.socialbase.downloader.i.f.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i >= i2) {
            c(mVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.c);
        synchronized (this) {
            mVar.c(true);
            this.h.remove(mVar);
            m();
            if (this.h.isEmpty()) {
                k();
            } else if (n()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (m mVar2 : this.h) {
                    mVar2.e();
                }
                k();
            }
        }
    }
}
