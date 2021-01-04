package com.kwai.filedownloader.download;

import android.os.Process;
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
/* loaded from: classes5.dex */
public class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor o = com.kwai.filedownloader.f.b.a("ConnectionBlock");
    private long A;

    /* renamed from: a  reason: collision with root package name */
    int f11193a;

    /* renamed from: b  reason: collision with root package name */
    private final d f11194b;
    private final int c;
    private final com.kwai.filedownloader.d.c d;
    private final com.kwai.filedownloader.d.b e;
    private final boolean f;
    private final boolean g;
    private final com.kwai.filedownloader.b.a h;
    private final x i;
    private boolean j;
    private final boolean k;
    private final ArrayList<c> l;
    private e m;
    private boolean n;
    private boolean p;
    private boolean q;
    private boolean r;
    private final AtomicBoolean s;
    private volatile boolean t;
    private volatile boolean u;
    private volatile Exception v;
    private String w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class DiscardSafely extends Throwable {
        DiscardSafely() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class RetryDirectly extends Throwable {
        RetryDirectly() {
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private com.kwai.filedownloader.d.c f11195a;

        /* renamed from: b  reason: collision with root package name */
        private com.kwai.filedownloader.d.b f11196b;
        private x c;
        private Integer d;
        private Integer e;
        private Boolean f;
        private Boolean g;
        private Integer h;

        public a a(com.kwai.filedownloader.d.b bVar) {
            this.f11196b = bVar;
            return this;
        }

        public a a(com.kwai.filedownloader.d.c cVar) {
            this.f11195a = cVar;
            return this;
        }

        public a a(x xVar) {
            this.c = xVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f = bool;
            return this;
        }

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public DownloadLaunchRunnable a() {
            if (this.f11195a == null || this.c == null || this.d == null || this.e == null || this.f == null || this.g == null || this.h == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.f11195a, this.f11196b, this.c, this.d.intValue(), this.e.intValue(), this.f.booleanValue(), this.g.booleanValue(), this.h.intValue());
        }

        public a b(Boolean bool) {
            this.g = bool;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public a c(Integer num) {
            this.h = num;
            return this;
        }
    }

    private DownloadLaunchRunnable(com.kwai.filedownloader.d.c cVar, com.kwai.filedownloader.d.b bVar, x xVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.c = 5;
        this.l = new ArrayList<>(5);
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.s = new AtomicBoolean(true);
        this.t = false;
        this.j = false;
        this.d = cVar;
        this.e = bVar;
        this.f = z;
        this.g = z2;
        this.h = b.a().c();
        this.k = b.a().e();
        this.i = xVar;
        this.f11193a = i3;
        this.f11194b = new d(cVar, i3, i, i2);
    }

    private com.kwai.filedownloader.download.a a(List<com.kwai.filedownloader.d.a> list) {
        int n = this.d.n();
        String e = this.d.e();
        String d = this.d.d();
        boolean z = n > 1;
        long length = (!z || this.k) ? com.kwai.filedownloader.f.f.a(this.d.a(), this.d) ? !this.k ? new File(e).length() : z ? n != list.size() ? 0L : com.kwai.filedownloader.d.a.a(list) : this.d.g() : 0L : 0L;
        this.d.a(length);
        this.p = length > 0;
        if (!this.p) {
            this.h.d(this.d.a());
            com.kwai.filedownloader.f.f.c(d, e);
        }
        return new com.kwai.filedownloader.download.a(0L, length, 0L, this.d.h() - length);
    }

    private void a(int i, List<com.kwai.filedownloader.d.a> list) {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        a(list, this.d.h());
    }

    private void a(long j, int i) {
        long j2 = 0;
        long j3 = j / i;
        int a2 = this.d.a();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.d.b(i);
                this.h.a(a2, i);
                a(arrayList, j);
                return;
            }
            long j4 = i3 == i + (-1) ? 0L : (j2 + j3) - 1;
            com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
            aVar.a(a2);
            aVar.b(i3);
            aVar.a(j2);
            aVar.b(j2);
            aVar.c(j4);
            arrayList.add(aVar);
            this.h.a(aVar);
            j2 += j3;
            i2 = i3 + 1;
        }
    }

    private void a(long j, String str) {
        com.kwai.filedownloader.e.a l;
        com.kwai.filedownloader.e.a aVar = null;
        if (j != -1) {
            try {
                l = com.kwai.filedownloader.f.f.l(this.d.e());
            } catch (Throwable th) {
                th = th;
            }
            try {
                long length = new File(str).length();
                long j2 = j - length;
                long f = com.kwai.filedownloader.f.f.f(str);
                if (f < j2) {
                    throw new FileDownloadOutOfSpaceException(f, j2, length);
                }
                if (!com.kwai.filedownloader.f.e.a().f) {
                    l.b(j);
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = l;
                if (aVar != null) {
                    aVar.b();
                }
                throw th;
            }
        } else {
            l = null;
        }
        if (l != null) {
            l.b();
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.download.a aVar2;
        if (this.q) {
            aVar2 = aVar;
        } else {
            this.d.a(0L);
            aVar2 = new com.kwai.filedownloader.download.a(0L, 0L, aVar.c, aVar.d);
        }
        e.a aVar3 = new e.a();
        aVar3.a(this).b(this.d.a()).a(-1).a(this.g).a(bVar).a(aVar2).a(this.d.e());
        this.d.b(1);
        this.h.a(this.d.a(), 1);
        this.m = aVar3.a();
        if (!this.t) {
            this.m.b();
            return;
        }
        this.d.a((byte) -2);
        this.m.a();
    }

    private void a(List<com.kwai.filedownloader.d.a> list, long j) {
        int a2 = this.d.a();
        String j2 = this.d.j();
        String b2 = this.w != null ? this.w : this.d.b();
        String e = this.d.e();
        if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a2), Long.valueOf(j));
        }
        boolean z = this.p;
        long j3 = 0;
        for (com.kwai.filedownloader.d.a aVar : list) {
            long d = aVar.e() == 0 ? j - aVar.d() : (aVar.e() - aVar.d()) + 1;
            long d2 = j3 + (aVar.d() - aVar.c());
            if (d != 0) {
                c a3 = new c.a().a(a2).a(Integer.valueOf(aVar.b())).a(this).a(b2).b(z ? j2 : null).a(this.e).a(this.g).a(new com.kwai.filedownloader.download.a(aVar.c(), aVar.d(), aVar.e(), d)).c(e).a();
                if (com.kwai.filedownloader.f.d.f11227a) {
                    com.kwai.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                if (a3 == null) {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
                this.l.add(a3);
                j3 = d2;
            } else if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.a()), Integer.valueOf(aVar.b()));
                j3 = d2;
            } else {
                j3 = d2;
            }
        }
        if (j3 != this.d.g()) {
            com.kwai.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.d.g()), Long.valueOf(j3));
            this.d.a(j3);
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
            this.d.a((byte) -2);
            return;
        }
        List<Future> invokeAll = o.invokeAll(arrayList);
        if (com.kwai.filedownloader.f.d.f11227a) {
            for (Future future : invokeAll) {
                com.kwai.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.a.b bVar) {
        int a2 = this.d.a();
        int e = bVar.e();
        this.q = e == 206 || e == 1;
        boolean z = e == 200 || e == 201 || e == 0;
        String j = this.d.j();
        String a3 = com.kwai.filedownloader.f.f.a(a2, bVar);
        boolean z2 = false;
        if (e == 412) {
            z2 = true;
        } else if (j != null && !j.equals(a3) && (z || this.q)) {
            z2 = true;
        } else if (e == 201 && connectTask.b()) {
            z2 = true;
        } else if (e == 416 && this.d.g() > 0) {
            z2 = true;
        }
        if (!z2) {
            this.w = connectTask.c();
            if (!this.q && !z) {
                throw new FileDownloadHttpException(e, map, bVar.c());
            }
            long b2 = com.kwai.filedownloader.f.f.b(a2, bVar);
            String a4 = this.d.l() ? com.kwai.filedownloader.f.f.a(bVar, this.d.b()) : null;
            this.r = b2 == -1;
            if (!this.r) {
                b2 += this.d.g();
            }
            this.f11194b.a(this.p && this.q, b2, a3, a4);
            return;
        }
        if (this.p) {
            com.kwai.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(a2), j, a3, Integer.valueOf(e));
        }
        this.h.d(this.d.a());
        com.kwai.filedownloader.f.f.c(this.d.d(), this.d.e());
        this.p = false;
        if (j != 0 && j.equals(a3)) {
            com.kwai.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", j, a3, Integer.valueOf(e), Integer.valueOf(a2));
            a3 = null;
        }
        this.d.a(0L);
        this.d.c(0L);
        this.d.b(a3);
        this.d.o();
        this.h.a(a2, this.d.j(), this.d.g(), this.d.h(), this.d.n());
        throw new RetryDirectly();
    }

    private boolean g() {
        boolean z = true;
        if (!this.p || this.d.n() > 1) {
            if (!this.q || !this.k || this.r) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private void h() {
        if (this.g && !com.kwai.filedownloader.f.f.j("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.d.a()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.g && com.kwai.filedownloader.f.f.d()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void i() {
        int a2 = this.d.a();
        if (this.d.l()) {
            String d = this.d.d();
            int b2 = com.kwai.filedownloader.f.f.b(this.d.b(), d);
            if (com.kwai.filedownloader.f.c.a(a2, d, this.f, false)) {
                this.h.e(a2);
                this.h.d(a2);
                throw new DiscardSafely();
            }
            com.kwai.filedownloader.d.c b3 = this.h.b(b2);
            if (b3 != null) {
                if (com.kwai.filedownloader.f.c.a(a2, b3, this.i, false)) {
                    this.h.e(a2);
                    this.h.d(a2);
                    throw new DiscardSafely();
                }
                List<com.kwai.filedownloader.d.a> c = this.h.c(b2);
                this.h.e(b2);
                this.h.d(b2);
                com.kwai.filedownloader.f.f.n(this.d.d());
                if (com.kwai.filedownloader.f.f.a(b2, b3)) {
                    this.d.a(b3.g());
                    this.d.c(b3.h());
                    this.d.b(b3.j());
                    this.d.b(b3.n());
                    this.h.a(this.d);
                    if (c != null) {
                        for (com.kwai.filedownloader.d.a aVar : c) {
                            aVar.a(a2);
                            this.h.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwai.filedownloader.f.c.a(a2, this.d.g(), this.d.e(), d, this.i)) {
                this.h.e(a2);
                this.h.d(a2);
                throw new DiscardSafely();
            }
        }
    }

    public void a() {
        this.t = true;
        if (this.m != null) {
            this.m.a();
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
        this.f11194b.a(j);
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(c cVar, long j, long j2) {
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.d.a()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.f11202a;
        if (com.kwai.filedownloader.f.d.f11227a) {
            com.kwai.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.d.h()));
        }
        if (!this.n) {
            synchronized (this.l) {
                this.l.remove(cVar);
            }
        } else if (j == 0 || j2 == this.d.h()) {
        } else {
            com.kwai.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.d.h()), Integer.valueOf(this.d.a()));
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public void a(Exception exc, long j) {
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.d.a()));
                return;
            }
            return;
        }
        int i = this.f11193a;
        this.f11193a = i - 1;
        if (i < 0) {
            com.kwai.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(this.f11193a), Integer.valueOf(this.d.a()));
        }
        this.f11194b.a(exc, this.f11193a, j);
    }

    @Override // com.kwai.filedownloader.download.f
    public boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.n && code == 416 && !this.j) {
                com.kwai.filedownloader.f.f.c(this.d.d(), this.d.e());
                this.j = true;
                return true;
            }
        }
        return this.f11193a > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    public void b() {
        if (this.d.n() > 1) {
            List<com.kwai.filedownloader.d.a> c = this.h.c(this.d.a());
            if (this.d.n() == c.size()) {
                this.d.a(com.kwai.filedownloader.d.a.a(c));
            } else {
                this.d.a(0L);
                this.h.d(this.d.a());
            }
        }
        this.f11194b.c();
    }

    @Override // com.kwai.filedownloader.download.f
    public void b(Exception exc) {
        this.u = true;
        this.v = exc;
        if (this.t) {
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.d.a()));
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
        this.h.a(this.d.a(), this.d.g());
    }

    public int d() {
        return this.d.a();
    }

    public boolean e() {
        return this.s.get() || this.f11194b.a();
    }

    public String f() {
        return this.d.e();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IGET]}, finally: {[IGET, INVOKE, IGET, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, IF, IGET, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ce A[Catch: all -> 0x007c, TryCatch #8 {all -> 0x007c, blocks: (B:3:0x0006, B:5:0x0011, B:7:0x0019, B:9:0x001d, B:15:0x0047, B:30:0x00aa, B:32:0x00ae, B:33:0x00b3, B:35:0x00b7, B:37:0x00bb, B:54:0x015a, B:87:0x0200, B:106:0x0244, B:79:0x01d1, B:126:0x0282, B:150:0x02ce, B:151:0x02d1, B:146:0x02c5, B:130:0x028a), top: B:212:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x027d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ca A[Catch: all -> 0x030f, TRY_LEAVE, TryCatch #17 {all -> 0x030f, blocks: (B:50:0x0147, B:52:0x0152, B:66:0x018b, B:68:0x01a3, B:70:0x01a7, B:72:0x01b0, B:73:0x01c2, B:83:0x01f4, B:85:0x01f8, B:101:0x0234, B:103:0x023a, B:113:0x0260, B:75:0x01c4, B:77:0x01ca, B:124:0x027d, B:144:0x02bd, B:81:0x01d6), top: B:213:0x01c4 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.kwai.filedownloader.a.b bVar;
        com.kwai.filedownloader.a.b bVar2;
        List<com.kwai.filedownloader.d.a> c;
        ConnectTask a2;
        try {
            Process.setThreadPriority(10);
            if (this.d.f() != 1) {
                if (this.d.f() != -2) {
                    b(new RuntimeException(com.kwai.filedownloader.f.f.a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.d.a()), Byte.valueOf(this.d.f()), (byte) 1)));
                } else if (com.kwai.filedownloader.f.d.f11227a) {
                    com.kwai.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.d.a()));
                }
                return;
            }
            if (!this.t) {
                this.f11194b.d();
            }
            while (!this.t) {
                try {
                    h();
                    c = this.h.c(this.d.a());
                    a2 = new ConnectTask.a().a(this.d.a()).a(this.d.b()).b(this.d.j()).a(this.e).a(a(c)).a();
                    bVar = a2.a();
                    try {
                        a(a2.d(), a2, bVar);
                    } catch (DiscardSafely e) {
                    } catch (RetryDirectly e2) {
                    } catch (FileDownloadGiveUpRetryException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    } catch (IllegalAccessException e5) {
                        e = e5;
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        bVar2 = bVar;
                    } catch (InterruptedException e7) {
                        e = e7;
                    }
                } catch (DiscardSafely e8) {
                    bVar = null;
                } catch (RetryDirectly e9) {
                    bVar = null;
                } catch (FileDownloadGiveUpRetryException e10) {
                    e = e10;
                    bVar = null;
                } catch (IOException e11) {
                    e = e11;
                    bVar = null;
                } catch (IllegalAccessException e12) {
                    e = e12;
                    bVar = null;
                } catch (IllegalArgumentException e13) {
                    e = e13;
                    bVar2 = null;
                } catch (InterruptedException e14) {
                    e = e14;
                    bVar = null;
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                }
                if (this.t) {
                    this.d.a((byte) -2);
                    if (bVar != null) {
                        bVar.f();
                    }
                    this.f11194b.b();
                    if (this.t) {
                        this.f11194b.f();
                    } else if (this.u) {
                        this.f11194b.a(this.v);
                    } else {
                        try {
                            this.f11194b.g();
                        } catch (IOException e15) {
                            this.f11194b.a(e15);
                        }
                    }
                    this.s.set(false);
                    return;
                }
                i();
                long h = this.d.h();
                a(h, this.d.e());
                int n = g() ? this.p ? this.d.n() : b.a().a(this.d.a(), this.d.b(), this.d.c(), h) : 1;
                if (n <= 0) {
                    throw new IllegalAccessException(com.kwai.filedownloader.f.f.a("invalid connection count %d, the connection count must be larger than 0", bVar));
                }
                if (this.t) {
                    this.d.a((byte) -2);
                    if (bVar != null) {
                        bVar.f();
                    }
                    this.f11194b.b();
                    if (this.t) {
                        this.f11194b.f();
                    } else if (this.u) {
                        this.f11194b.a(this.v);
                    } else {
                        try {
                            this.f11194b.g();
                        } catch (IOException e16) {
                            this.f11194b.a(e16);
                        }
                    }
                    this.s.set(false);
                    return;
                }
                this.n = n == 1;
                if (this.n) {
                    a(a2.e(), bVar);
                    bVar2 = bVar;
                } else {
                    if (bVar != null) {
                        bVar.f();
                        bVar2 = null;
                    } else {
                        bVar2 = bVar;
                    }
                    try {
                        this.f11194b.e();
                        if (this.p) {
                            a(n, c);
                        } else {
                            a(h, n);
                        }
                    } catch (DiscardSafely e17) {
                        bVar = bVar2;
                        if (bVar != null) {
                            bVar.f();
                        }
                        this.f11194b.b();
                        if (this.t) {
                            this.f11194b.f();
                        } else if (this.u) {
                            this.f11194b.a(this.v);
                        } else {
                            try {
                                this.f11194b.g();
                            } catch (IOException e18) {
                                this.f11194b.a(e18);
                            }
                        }
                        this.s.set(false);
                        return;
                    } catch (RetryDirectly e19) {
                        bVar = bVar2;
                        this.d.a((byte) 5);
                        if (bVar != null) {
                            bVar.f();
                        }
                    } catch (FileDownloadGiveUpRetryException e20) {
                        e = e20;
                        bVar = bVar2;
                        try {
                            if (!a(e)) {
                                b(e);
                                if (bVar != null) {
                                    bVar.f();
                                }
                                this.f11194b.b();
                                if (!this.t) {
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
                    } catch (IOException e21) {
                        e = e21;
                        bVar = bVar2;
                        if (!a(e)) {
                        }
                    } catch (IllegalAccessException e22) {
                        e = e22;
                        bVar = bVar2;
                        if (!a(e)) {
                        }
                    } catch (IllegalArgumentException e23) {
                        e = e23;
                        bVar = bVar2;
                        if (!a(e)) {
                        }
                    } catch (InterruptedException e24) {
                        e = e24;
                        bVar = bVar2;
                        if (!a(e)) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bVar = bVar2;
                        if (bVar != null) {
                        }
                        throw th;
                    }
                }
                if (bVar2 != null) {
                    bVar2.f();
                }
                this.f11194b.b();
                if (!this.t) {
                    this.f11194b.f();
                } else if (this.u) {
                    this.f11194b.a(this.v);
                } else {
                    try {
                        this.f11194b.g();
                    } catch (IOException e25) {
                        this.f11194b.a(e25);
                    }
                }
                this.s.set(false);
                return;
            }
            if (com.kwai.filedownloader.f.d.f11227a) {
                com.kwai.filedownloader.f.d.c(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.d.a()));
            }
            this.f11194b.b();
            if (this.t) {
                this.f11194b.f();
            } else if (this.u) {
                this.f11194b.a(this.v);
            } else {
                try {
                    this.f11194b.g();
                } catch (IOException e26) {
                    this.f11194b.a(e26);
                }
            }
            this.s.set(false);
        } finally {
            this.f11194b.b();
            if (this.t) {
                this.f11194b.f();
            } else if (this.u) {
                this.f11194b.a(this.v);
            } else {
                try {
                    this.f11194b.g();
                } catch (IOException e27) {
                    this.f11194b.a(e27);
                }
            }
            this.s.set(false);
        }
    }
}
