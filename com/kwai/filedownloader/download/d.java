package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes4.dex */
public class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwai.filedownloader.d.c f10907a;
    private final a c;
    private final int d;
    private final int e;
    private final int f;
    private long g;
    private Handler h;
    private HandlerThread i;
    private volatile Thread k;
    private volatile boolean n;
    private volatile boolean j = false;
    private volatile long l = 0;
    private final AtomicLong m = new AtomicLong();
    private boolean o = true;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwai.filedownloader.b.a f10908b = b.a().c();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10909a;

        /* renamed from: b  reason: collision with root package name */
        private Exception f10910b;
        private int c;

        void a(int i) {
            this.c = i;
        }

        void a(Exception exc) {
            this.f10910b = exc;
        }

        void a(boolean z) {
            this.f10909a = z;
        }

        public boolean a() {
            return this.f10909a;
        }

        public Exception b() {
            return this.f10910b;
        }

        public int c() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwai.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.f10907a = cVar;
        this.e = i2 < 5 ? 5 : i2;
        this.f = i3;
        this.c = new a();
        this.d = i;
    }

    private static long a(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j != -1) {
            long j3 = j / (j2 + 1);
            if (j3 > 0) {
                return j3;
            }
            return 1L;
        }
        return 1L;
    }

    private void a(byte b2) {
        if (b2 != -2) {
            com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(b2, this.f10907a, this.c));
        } else if (com.kwai.filedownloader.f.d.f10928a) {
            com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f10907a.a()));
        }
    }

    private void a(long j, boolean z) {
        if (this.f10907a.g() == this.f10907a.h()) {
            this.f10908b.a(this.f10907a.a(), this.f10907a.g());
            return;
        }
        if (this.n) {
            this.n = false;
            this.f10907a.a((byte) 3);
        }
        if (z) {
            this.l = j;
            a((byte) 3);
            this.m.set(0L);
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int a2 = this.f10907a.a();
        if (com.kwai.filedownloader.f.d.f10928a) {
            com.kwai.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a2), sQLiteFullException.toString());
        }
        this.f10907a.c(sQLiteFullException.toString());
        this.f10907a.a((byte) -1);
        this.f10908b.e(a2);
        this.f10908b.d(a2);
    }

    private synchronized void a(Message message) {
        if (this.i.isAlive()) {
            try {
                this.h.sendMessage(message);
            } catch (IllegalStateException e) {
                if (this.i.isAlive()) {
                    throw e;
                }
                if (com.kwai.filedownloader.f.d.f10928a) {
                    com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
            }
        } else if (com.kwai.filedownloader.f.d.f10928a) {
            com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
        }
    }

    private void a(Exception exc, int i) {
        Exception b2 = b(exc);
        this.c.a(b2);
        this.c.a(this.d - i);
        this.f10907a.a((byte) 5);
        this.f10907a.c(b2.toString());
        this.f10908b.a(this.f10907a.a(), b2);
        a((byte) 5);
    }

    private Exception b(Exception exc) {
        String e = this.f10907a.e();
        if ((this.f10907a.i() || com.kwai.filedownloader.f.e.a().f) && (exc instanceof IOException) && new File(e).exists()) {
            long f = com.kwai.filedownloader.f.f.f(e);
            if (f <= 4096) {
                long j = 0;
                File file = new File(e);
                if (file.exists()) {
                    j = file.length();
                } else {
                    com.kwai.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                }
                return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(f, 4096L, j, exc) : new FileDownloadOutOfSpaceException(f, 4096L, j);
            }
            return exc;
        }
        return exc;
    }

    private boolean b(long j) {
        if (!this.o) {
            return this.g != -1 && this.m.get() >= this.g && j - this.l >= ((long) this.e);
        }
        this.o = false;
        return true;
    }

    private void c(Exception exc) {
        Exception e = b(exc);
        if (e instanceof SQLiteFullException) {
            a((SQLiteFullException) e);
        } else {
            try {
                this.f10907a.a((byte) -1);
                this.f10907a.c(exc.toString());
                this.f10908b.a(this.f10907a.a(), e, this.f10907a.g());
            } catch (SQLiteFullException e2) {
                e = e2;
                a((SQLiteFullException) e);
            }
        }
        this.c.a(e);
        a((byte) -1);
    }

    private void h() {
        String e = this.f10907a.e();
        String d = this.f10907a.d();
        File file = new File(e);
        try {
            File file2 = new File(d);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwai.filedownloader.f.f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d, Long.valueOf(length)));
                }
                com.kwai.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwai.filedownloader.f.f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e, d));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e);
            }
            throw th;
        }
    }

    private void i() {
        h();
        this.f10907a.a((byte) -3);
        this.f10908b.b(this.f10907a.a(), this.f10907a.h());
        this.f10908b.d(this.f10907a.a());
        a((byte) -3);
        if (com.kwai.filedownloader.f.e.a().g) {
            com.kwai.filedownloader.services.f.a(this.f10907a);
        }
    }

    private boolean j() {
        if (this.f10907a.i()) {
            this.f10907a.c(this.f10907a.g());
        } else if (this.f10907a.g() != this.f10907a.h()) {
            a(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.f10907a.g()), Long.valueOf(this.f10907a.h()))));
            return true;
        }
        return false;
    }

    private void k() {
        this.f10907a.a((byte) -2);
        this.f10908b.c(this.f10907a.a(), this.f10907a.g());
        a((byte) -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.m.addAndGet(j);
        this.f10907a.b(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(elapsedRealtime);
        if (this.h == null) {
            a(elapsedRealtime, b2);
        } else if (b2) {
            a(this.h.obtainMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Exception exc) {
        c(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Exception exc, int i, long j) {
        this.m.set(0L);
        this.f10907a.b(-j);
        if (this.h == null) {
            a(exc, i);
        } else {
            a(this.h.obtainMessage(5, i, 0, exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, long j, String str, String str2) {
        String j2 = this.f10907a.j();
        if (j2 != null && !j2.equals(str)) {
            throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j2));
        }
        this.c.a(z);
        this.f10907a.a((byte) 2);
        this.f10907a.c(j);
        this.f10907a.b(str);
        this.f10907a.d(str2);
        this.f10908b.a(this.f10907a.a(), j, str, str2);
        a((byte) 2);
        this.g = a(j, this.f);
        this.n = true;
    }

    public boolean a() {
        return this.i != null && this.i.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.h != null) {
            this.h.removeCallbacksAndMessages(null);
            this.i.quit();
            this.k = Thread.currentThread();
            while (this.j) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.k = null;
        }
    }

    public void c() {
        this.f10907a.a((byte) 1);
        this.f10908b.f(this.f10907a.a());
        a((byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f10907a.a((byte) 6);
        a((byte) 6);
        this.f10908b.a(this.f10907a.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.i = new HandlerThread("source-status-callback", 10);
        this.i.start();
        this.h = new Handler(this.i.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (j()) {
            return;
        }
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000f A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        this.j = true;
        try {
            switch (message.what) {
                case 3:
                    a(SystemClock.elapsedRealtime(), true);
                    break;
                case 4:
                default:
                    return true;
                case 5:
                    a((Exception) message.obj, message.arg1);
                    break;
            }
            return true;
        } finally {
            this.j = false;
            if (this.k != null) {
                LockSupport.unpark(this.k);
            }
        }
    }
}
