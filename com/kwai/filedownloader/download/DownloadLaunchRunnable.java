package com.kwai.filedownloader.download;

import android.os.Process;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwai.filedownloader.download.ConnectTask;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class DownloadLaunchRunnable implements f, Runnable {
    public static final ThreadPoolExecutor o = com.kwai.filedownloader.f.b.a("ConnectionBlock");
    public long A;

    /* renamed from: a  reason: collision with root package name */
    public int f37688a;

    /* renamed from: b  reason: collision with root package name */
    public final d f37689b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37690c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwai.filedownloader.d.c f37691d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f37692e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37693f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37694g;

    /* renamed from: h  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f37695h;

    /* renamed from: i  reason: collision with root package name */
    public final x f37696i;
    public boolean j;
    public final boolean k;
    public final ArrayList<c> l;
    public e m;
    public boolean n;
    public boolean p;
    public boolean q;
    public boolean r;
    public final AtomicBoolean s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile Exception v;
    public String w;
    public long x;
    public long y;
    public long z;

    /* loaded from: classes7.dex */
    public class DiscardSafely extends Throwable {
        public DiscardSafely() {
        }
    }

    /* loaded from: classes7.dex */
    public class RetryDirectly extends Throwable {
        public RetryDirectly() {
        }
    }

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwai.filedownloader.d.c f37697a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f37698b;

        /* renamed from: c  reason: collision with root package name */
        public x f37699c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f37700d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f37701e;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f37702f;

        /* renamed from: g  reason: collision with root package name */
        public Boolean f37703g;

        /* renamed from: h  reason: collision with root package name */
        public Integer f37704h;

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f37698b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.d.c cVar) {
            this.f37697a = cVar;
            return this;
        }

        public a a(x xVar) {
            this.f37699c = xVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f37702f = bool;
            return this;
        }

        public a a(Integer num) {
            this.f37700d = num;
            return this;
        }

        public DownloadLaunchRunnable a() {
            if (this.f37697a == null || this.f37699c == null || this.f37700d == null || this.f37701e == null || this.f37702f == null || this.f37703g == null || this.f37704h == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.f37697a, this.f37698b, this.f37699c, this.f37700d.intValue(), this.f37701e.intValue(), this.f37702f.booleanValue(), this.f37703g.booleanValue(), this.f37704h.intValue());
        }

        public a b(Boolean bool) {
            this.f37703g = bool;
            return this;
        }

        public a b(Integer num) {
            this.f37701e = num;
            return this;
        }

        public a c(Integer num) {
            this.f37704h = num;
            return this;
        }
    }

    public DownloadLaunchRunnable(com.kwai.filedownloader.d.c cVar, com.kwai.filedownloader.d.b bVar, x xVar, int i2, int i3, boolean z, boolean z2, int i4) {
        this.f37690c = 5;
        this.l = new ArrayList<>(5);
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.s = new AtomicBoolean(true);
        this.t = false;
        this.j = false;
        this.f37691d = cVar;
        this.f37692e = bVar;
        this.f37693f = z;
        this.f37694g = z2;
        this.f37695h = b.a().c();
        this.k = b.a().e();
        this.f37696i = xVar;
        this.f37688a = i4;
        this.f37689b = new d(cVar, i4, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.kwai.filedownloader.download.a a(List<com.kwai.filedownloader.d.a> list) {
        long g2;
        long j;
        boolean z;
        int n = this.f37691d.n();
        String e2 = this.f37691d.e();
        String d2 = this.f37691d.d();
        boolean z2 = n > 1;
        if ((!z2 || this.k) && com.kwai.filedownloader.f.f.a(this.f37691d.a(), this.f37691d)) {
            if (!this.k) {
                g2 = new File(e2).length();
            } else if (!z2) {
                g2 = this.f37691d.g();
            } else if (n == list.size()) {
                g2 = com.kwai.filedownloader.d.a.a(list);
            }
            j = g2;
            this.f37691d.a(j);
            z = j > 0;
            this.p = z;
            if (!z) {
                this.f37695h.d(this.f37691d.a());
                com.kwai.filedownloader.f.f.c(d2, e2);
            }
            return new com.kwai.filedownloader.download.a(0L, j, 0L, this.f37691d.h() - j);
        }
        j = 0;
        this.f37691d.a(j);
        if (j > 0) {
        }
        this.p = z;
        if (!z) {
        }
        return new com.kwai.filedownloader.download.a(0L, j, 0L, this.f37691d.h() - j);
    }

    private void a(int i2, List<com.kwai.filedownloader.d.a> list) {
        if (i2 <= 1 || list.size() != i2) {
            throw new IllegalArgumentException();
        }
        a(list, this.f37691d.h());
    }

    private void a(long j, int i2) {
        long j2 = j / i2;
        int a2 = this.f37691d.a();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j3 = 0;
        while (i3 < i2) {
            long j4 = i3 == i2 + (-1) ? 0L : (j3 + j2) - 1;
            com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
            aVar.a(a2);
            aVar.b(i3);
            aVar.a(j3);
            aVar.b(j3);
            aVar.c(j4);
            arrayList.add(aVar);
            this.f37695h.a(aVar);
            j3 += j2;
            i3++;
        }
        this.f37691d.b(i2);
        this.f37695h.a(a2, i2);
        a(arrayList, j);
    }

    private void a(long j, String str) {
        com.kwai.filedownloader.e.a aVar = null;
        if (j != -1) {
            try {
                aVar = com.kwai.filedownloader.f.f.l(this.f37691d.e());
                long length = new File(str).length();
                long j2 = j - length;
                long f2 = com.kwai.filedownloader.f.f.f(str);
                if (f2 < j2) {
                    throw new FileDownloadOutOfSpaceException(f2, j2, length);
                }
                if (!com.kwai.filedownloader.f.e.a().f37782f) {
                    aVar.b(j);
                }
            } finally {
                if (0 != 0) {
                    aVar.b();
                }
            }
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.a.b bVar) {
        if (!this.q) {
            this.f37691d.a(0L);
            aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.f37707c, aVar.f37708d);
        }
        e.a aVar2 = new e.a();
        aVar2.a(this).b(this.f37691d.a()).a(-1).a(this.f37694g).a(bVar).a(aVar).a(this.f37691d.e());
        this.f37691d.b(1);
        this.f37695h.a(this.f37691d.a(), 1);
        this.m = aVar2.a();
        if (!this.t) {
            this.m.b();
            return;
        }
        this.f37691d.a((byte) -2);
        this.m.a();
    }

    private void a(List<com.kwai.filedownloader.d.a> list, long j) {
        int a2 = this.f37691d.a();
        String j2 = this.f37691d.j();
        String str = this.w;
        if (str == null) {
            str = this.f37691d.b();
        }
        String e2 = this.f37691d.e();
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a2), Long.valueOf(j));
        }
        boolean z = this.p;
        long j3 = 0;
        long j4 = 0;
        for (com.kwai.filedownloader.d.a aVar : list) {
            long d2 = aVar.e() == j3 ? j - aVar.d() : (aVar.e() - aVar.d()) + 1;
            j4 += aVar.d() - aVar.c();
            if (d2 != j3) {
                c a3 = new c.a().a(a2).a(Integer.valueOf(aVar.b())).a(this).a(str).b(z ? j2 : null).a(this.f37692e).a(this.f37694g).a(new com.kwai.filedownloader.download.a(aVar.c(), aVar.d(), aVar.e(), d2)).c(e2).a();
                if (com.kwai.filedownloader.f.d.f37776a) {
                    com.kwai.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                if (a3 == null) {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
                this.l.add(a3);
            } else if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.a()), Integer.valueOf(aVar.b()));
            }
            j3 = 0;
        }
        if (j4 != this.f37691d.g()) {
            com.kwai.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f37691d.g()), Long.valueOf(j4));
            this.f37691d.a(j4);
        }
        ArrayList arrayList = new ArrayList(this.l.size());
        Iterator<c> it = this.l.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.t) {
                next.a();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.t) {
            this.f37691d.a((byte) -2);
            return;
        }
        List<Future> invokeAll = o.invokeAll(arrayList);
        if (com.kwai.filedownloader.f.d.f37776a) {
            for (Future future : invokeAll) {
                com.kwai.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.a.b bVar) {
        int a2 = this.f37691d.a();
        int e2 = bVar.e();
        this.q = e2 == 206 || e2 == 1;
        boolean z = e2 == 200 || e2 == 201 || e2 == 0;
        String j = this.f37691d.j();
        String a3 = com.kwai.filedownloader.f.f.a(a2, bVar);
        if (!(e2 == 412 || !(j == null || j.equals(a3) || (!z && !this.q)) || ((e2 == 201 && connectTask.b()) || (e2 == 416 && this.f37691d.g() > 0)))) {
            this.w = connectTask.c();
            if (!this.q && !z) {
                throw new FileDownloadHttpException(e2, map, bVar.c());
            }
            long b2 = com.kwai.filedownloader.f.f.b(a2, bVar);
            String a4 = this.f37691d.l() ? com.kwai.filedownloader.f.f.a(bVar, this.f37691d.b()) : null;
            boolean z2 = b2 == -1;
            this.r = z2;
            this.f37689b.a(this.p && this.q, !z2 ? this.f37691d.g() + b2 : b2, a3, a4);
            return;
        }
        if (this.p) {
            com.kwai.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(a2), j, a3, Integer.valueOf(e2));
        }
        this.f37695h.d(this.f37691d.a());
        com.kwai.filedownloader.f.f.c(this.f37691d.d(), this.f37691d.e());
        this.p = false;
        if (j != 0 && j.equals(a3)) {
            com.kwai.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", j, a3, Integer.valueOf(e2), Integer.valueOf(a2));
            a3 = null;
        }
        this.f37691d.a(0L);
        this.f37691d.c(0L);
        this.f37691d.b(a3);
        this.f37691d.o();
        this.f37695h.a(a2, this.f37691d.j(), this.f37691d.g(), this.f37691d.h(), this.f37691d.n());
        throw new RetryDirectly();
    }

    private boolean g() {
        return (!this.p || this.f37691d.n() > 1) && this.q && this.k && !this.r;
    }

    private void h() {
        if (this.f37694g && !com.kwai.filedownloader.f.f.j(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f37691d.a()), DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
        }
        if (this.f37694g && com.kwai.filedownloader.f.f.d()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void i() {
        int a2 = this.f37691d.a();
        if (this.f37691d.l()) {
            String d2 = this.f37691d.d();
            int b2 = com.kwai.filedownloader.f.f.b(this.f37691d.b(), d2);
            if (com.kwai.filedownloader.f.c.a(a2, d2, this.f37693f, false)) {
                this.f37695h.e(a2);
                this.f37695h.d(a2);
                throw new DiscardSafely();
            }
            com.kwai.filedownloader.d.c b3 = this.f37695h.b(b2);
            if (b3 != null) {
                if (com.kwai.filedownloader.f.c.a(a2, b3, this.f37696i, false)) {
                    this.f37695h.e(a2);
                    this.f37695h.d(a2);
                    throw new DiscardSafely();
                }
                List<com.kwai.filedownloader.d.a> c2 = this.f37695h.c(b2);
                this.f37695h.e(b2);
                this.f37695h.d(b2);
                com.kwai.filedownloader.f.f.n(this.f37691d.d());
                if (com.kwai.filedownloader.f.f.a(b2, b3)) {
                    this.f37691d.a(b3.g());
                    this.f37691d.c(b3.h());
                    this.f37691d.b(b3.j());
                    this.f37691d.b(b3.n());
                    this.f37695h.a(this.f37691d);
                    if (c2 != null) {
                        for (com.kwai.filedownloader.d.a aVar : c2) {
                            aVar.a(a2);
                            this.f37695h.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwai.filedownloader.f.c.a(a2, this.f37691d.g(), this.f37691d.e(), d2, this.f37696i)) {
                this.f37695h.e(a2);
                this.f37695h.d(a2);
                throw new DiscardSafely();
            }
        }
    }

    public void a() {
        this.t = true;
        e eVar = this.m;
        if (eVar != null) {
            eVar.a();
        }
        Iterator it = ((ArrayList) this.l.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(long j) {
        if (this.t) {
            return;
        }
        this.f37689b.a(j);
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(c cVar, long j, long j2) {
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f37691d.a()));
                return;
            }
            return;
        }
        int i2 = cVar == null ? -1 : cVar.f37716a;
        if (com.kwai.filedownloader.f.d.f37776a) {
            com.kwai.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f37691d.h()));
        }
        if (!this.n) {
            synchronized (this.l) {
                this.l.remove(cVar);
            }
        } else if (j == 0 || j2 == this.f37691d.h()) {
        } else {
            com.kwai.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.f37691d.h()), Integer.valueOf(this.f37691d.a()));
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(Exception exc, long j) {
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f37691d.a()));
                return;
            }
            return;
        }
        int i2 = this.f37688a;
        int i3 = i2 - 1;
        this.f37688a = i3;
        if (i2 < 0) {
            com.kwai.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.f37691d.a()));
        }
        this.f37689b.a(exc, this.f37688a, j);
    }

    @Override // com.kwai.filedownloader.download.f
    public boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.n && code == 416 && !this.j) {
                com.kwai.filedownloader.f.f.c(this.f37691d.d(), this.f37691d.e());
                this.j = true;
                return true;
            }
        }
        return this.f37688a > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    public void b() {
        if (this.f37691d.n() > 1) {
            List<com.kwai.filedownloader.d.a> c2 = this.f37695h.c(this.f37691d.a());
            if (this.f37691d.n() == c2.size()) {
                this.f37691d.a(com.kwai.filedownloader.d.a.a(c2));
            } else {
                this.f37691d.a(0L);
                this.f37695h.d(this.f37691d.a());
            }
        }
        this.f37689b.c();
    }

    @Override // com.kwai.filedownloader.download.f
    public void b(Exception exc) {
        this.u = true;
        this.v = exc;
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f37776a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f37691d.a()));
                return;
            }
            return;
        }
        Iterator it = ((ArrayList) this.l.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void c() {
        this.f37695h.a(this.f37691d.a(), this.f37691d.g());
    }

    public int d() {
        return this.f37691d.a();
    }

    public boolean e() {
        return this.s.get() || this.f37689b.a();
    }

    public String f() {
        return this.f37691d.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f2, code lost:
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.f.f.a("invalid connection count %d, the connection count must be larger than 0", r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (com.kwai.filedownloader.f.d.f37776a == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        com.kwai.filedownloader.f.d.c(r18, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r18.f37691d.a()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b1, code lost:
        r18.f37689b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        if (r18.t == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        if (r18.u == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
        r18.f37689b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011a, code lost:
        if (r18.t == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011c, code lost:
        r18.f37691d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0121, code lost:
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
        r8.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0126, code lost:
        r18.f37689b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012d, code lost:
        if (r18.t == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
        if (r18.u == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0137, code lost:
        r18.f37689b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0141, code lost:
        i();
        r14 = r18.f37691d.h();
        a(r14, r18.f37691d.e());
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
        if (g() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
        if (r18.p == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015d, code lost:
        r9 = r18.f37691d.n();
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0166, code lost:
        r16 = r14;
        r9 = com.kwai.filedownloader.download.b.a().a(r18.f37691d.a(), r18.f37691d.b(), r18.f37691d.c(), r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0183, code lost:
        r16 = r14;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0186, code lost:
        if (r9 <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
        if (r18.t == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018c, code lost:
        r18.f37691d.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0191, code lost:
        if (r8 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0193, code lost:
        r8.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        r18.f37689b.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019d, code lost:
        if (r18.t == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a3, code lost:
        if (r18.u == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a7, code lost:
        r18.f37689b.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ae, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b1, code lost:
        if (r9 != 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b3, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b5, code lost:
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b6, code lost:
        r18.n = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b8, code lost:
        if (r10 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ba, code lost:
        a(r7.e(), r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c2, code lost:
        if (r8 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c4, code lost:
        r8.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c8, code lost:
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c9, code lost:
        r18.f37689b.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d0, code lost:
        if (r18.p == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d2, code lost:
        a(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d6, code lost:
        a(r16, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
        r8 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dc, code lost:
        if (r8 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01de, code lost:
        r8.f();
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0246 A[Catch: all -> 0x0206, TryCatch #3 {all -> 0x0206, blocks: (B:43:0x00c9, B:92:0x01c9, B:94:0x01d2, B:95:0x01d6, B:143:0x0240, B:145:0x0246, B:148:0x024e, B:118:0x0209), top: B:182:0x0240 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0285 A[Catch: all -> 0x0289, TRY_ENTER, TryCatch #7 {all -> 0x0289, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:24:0x008f, B:26:0x0093, B:27:0x0098, B:29:0x009c, B:31:0x00a0, B:48:0x0123, B:71:0x0193, B:98:0x01de, B:164:0x0285, B:165:0x0288, B:123:0x0219, B:120:0x0211, B:150:0x0253), top: B:185:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x024e A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ConnectTask a2;
        com.kwai.filedownloader.a.b a3;
        try {
            Process.setThreadPriority(10);
            if (this.f37691d.f() != 1) {
                if (this.f37691d.f() != -2) {
                    b(new RuntimeException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f37691d.a()), Byte.valueOf(this.f37691d.f()), (byte) 1)));
                } else if (com.kwai.filedownloader.f.d.f37776a) {
                    com.kwai.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f37691d.a()));
                }
                this.f37689b.b();
                if (!this.t) {
                    if (!this.u) {
                        try {
                            this.f37689b.g();
                        } catch (IOException e2) {
                            e = e2;
                            this.f37689b.a(e);
                            this.s.set(false);
                        }
                    }
                    this.f37689b.a(this.v);
                }
                this.f37689b.f();
            } else {
                if (!this.t) {
                    this.f37689b.d();
                }
                while (true) {
                    if (this.t) {
                        break;
                    }
                    com.kwai.filedownloader.a.b bVar = null;
                    try {
                        h();
                        List<com.kwai.filedownloader.d.a> c2 = this.f37695h.c(this.f37691d.a());
                        a2 = new ConnectTask.a().a(this.f37691d.a()).a(this.f37691d.b()).b(this.f37691d.j()).a(this.f37692e).a(a(c2)).a();
                        a3 = a2.a();
                    } catch (DiscardSafely unused) {
                    } catch (RetryDirectly unused2) {
                    } catch (FileDownloadGiveUpRetryException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    } catch (IllegalAccessException e5) {
                        e = e5;
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                    } catch (InterruptedException e7) {
                        e = e7;
                    }
                    try {
                        a(a2.d(), a2, a3);
                        break;
                    } catch (DiscardSafely unused3) {
                        bVar = a3;
                        if (bVar != null) {
                            bVar.f();
                        }
                        this.f37689b.b();
                        if (!this.t) {
                            if (!this.u) {
                                try {
                                    this.f37689b.g();
                                } catch (IOException e8) {
                                    e = e8;
                                    this.f37689b.a(e);
                                    this.s.set(false);
                                }
                                this.s.set(false);
                            }
                            this.f37689b.a(this.v);
                            this.s.set(false);
                        }
                        this.f37689b.f();
                        this.s.set(false);
                    } catch (RetryDirectly unused4) {
                        bVar = a3;
                        this.f37691d.a((byte) 5);
                        if (bVar != null) {
                            bVar.f();
                        }
                    } catch (FileDownloadGiveUpRetryException e9) {
                        e = e9;
                        bVar = a3;
                        try {
                            if (!a(e)) {
                                b(e);
                                if (bVar != null) {
                                    bVar.f();
                                }
                                this.f37689b.b();
                                if (this.t) {
                                    this.f37689b.f();
                                } else if (this.u) {
                                    this.f37689b.a(this.v);
                                } else {
                                    try {
                                        this.f37689b.g();
                                    } catch (IOException e10) {
                                        this.f37689b.a(e10);
                                    }
                                }
                                this.s.set(false);
                                return;
                            }
                            a(e, 0L);
                            if (bVar != null) {
                                bVar.f();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bVar != null) {
                                bVar.f();
                            }
                            throw th;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        bVar = a3;
                        if (!a(e)) {
                        }
                    } catch (IllegalAccessException e12) {
                        e = e12;
                        bVar = a3;
                        if (!a(e)) {
                        }
                    } catch (IllegalArgumentException e13) {
                        e = e13;
                        bVar = a3;
                        if (!a(e)) {
                        }
                    } catch (InterruptedException e14) {
                        e = e14;
                        bVar = a3;
                        if (!a(e)) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bVar = a3;
                        if (bVar != null) {
                        }
                        throw th;
                    }
                }
                this.f37689b.a(this.v);
            }
            this.s.set(false);
        } catch (Throwable th4) {
            this.f37689b.b();
            if (this.t) {
                this.f37689b.f();
            } else if (this.u) {
                this.f37689b.a(this.v);
            } else {
                try {
                    this.f37689b.g();
                } catch (IOException e15) {
                    this.f37689b.a(e15);
                }
            }
            this.s.set(false);
            throw th4;
        }
    }
}
