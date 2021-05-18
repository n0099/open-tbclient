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
/* loaded from: classes6.dex */
public class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwai.filedownloader.d.c f34316a;

    /* renamed from: c  reason: collision with root package name */
    public final a f34318c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34319d;

    /* renamed from: e  reason: collision with root package name */
    public final int f34320e;

    /* renamed from: f  reason: collision with root package name */
    public final int f34321f;

    /* renamed from: g  reason: collision with root package name */
    public long f34322g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f34323h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f34324i;
    public volatile Thread k;
    public volatile boolean n;
    public volatile boolean j = false;
    public volatile long l = 0;
    public final AtomicLong m = new AtomicLong();
    public boolean o = true;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwai.filedownloader.b.a f34317b = b.a().c();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34325a;

        /* renamed from: b  reason: collision with root package name */
        public Exception f34326b;

        /* renamed from: c  reason: collision with root package name */
        public int f34327c;

        public void a(int i2) {
            this.f34327c = i2;
        }

        public void a(Exception exc) {
            this.f34326b = exc;
        }

        public void a(boolean z) {
            this.f34325a = z;
        }

        public boolean a() {
            return this.f34325a;
        }

        public Exception b() {
            return this.f34326b;
        }

        public int c() {
            return this.f34327c;
        }
    }

    public d(com.kwai.filedownloader.d.c cVar, int i2, int i3, int i4) {
        this.f34316a = cVar;
        this.f34320e = i3 < 5 ? 5 : i3;
        this.f34321f = i4;
        this.f34318c = new a();
        this.f34319d = i2;
    }

    public static long a(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    private void a(byte b2) {
        if (b2 != -2) {
            com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(b2, this.f34316a, this.f34318c));
        } else if (com.kwai.filedownloader.f.d.f34363a) {
            com.kwai.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.f34316a.a()));
        }
    }

    private void a(long j, boolean z) {
        if (this.f34316a.g() == this.f34316a.h()) {
            this.f34317b.a(this.f34316a.a(), this.f34316a.g());
            return;
        }
        if (this.n) {
            this.n = false;
            this.f34316a.a((byte) 3);
        }
        if (z) {
            this.l = j;
            a((byte) 3);
            this.m.set(0L);
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int a2 = this.f34316a.a();
        if (com.kwai.filedownloader.f.d.f34363a) {
            com.kwai.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(a2), sQLiteFullException.toString());
        }
        this.f34316a.c(sQLiteFullException.toString());
        this.f34316a.a((byte) -1);
        this.f34317b.e(a2);
        this.f34317b.d(a2);
    }

    private synchronized void a(Message message) {
        if (!this.f34324i.isAlive()) {
            if (com.kwai.filedownloader.f.d.f34363a) {
                com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.f34323h.sendMessage(message);
        } catch (IllegalStateException e2) {
            if (this.f34324i.isAlive()) {
                throw e2;
            }
            if (com.kwai.filedownloader.f.d.f34363a) {
                com.kwai.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    private void a(Exception exc, int i2) {
        Exception b2 = b(exc);
        this.f34318c.a(b2);
        this.f34318c.a(this.f34319d - i2);
        this.f34316a.a((byte) 5);
        this.f34316a.c(b2.toString());
        this.f34317b.a(this.f34316a.a(), b2);
        a((byte) 5);
    }

    private Exception b(Exception exc) {
        long length;
        String e2 = this.f34316a.e();
        if ((this.f34316a.i() || com.kwai.filedownloader.f.e.a().f34369f) && (exc instanceof IOException) && new File(e2).exists()) {
            long f2 = com.kwai.filedownloader.f.f.f(e2);
            if (f2 <= 4096) {
                File file = new File(e2);
                if (file.exists()) {
                    length = file.length();
                } else {
                    com.kwai.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                }
                return Build.VERSION.SDK_INT >= 9 ? new FileDownloadOutOfSpaceException(f2, 4096L, length, exc) : new FileDownloadOutOfSpaceException(f2, 4096L, length);
            }
            return exc;
        }
        return exc;
    }

    private boolean b(long j) {
        if (!this.o) {
            return this.f34322g != -1 && this.m.get() >= this.f34322g && j - this.l >= ((long) this.f34320e);
        }
        this.o = false;
        return true;
    }

    private void c(Exception exc) {
        Exception exc2;
        Exception b2 = b(exc);
        if (b2 instanceof SQLiteFullException) {
            a((SQLiteFullException) b2);
            exc2 = b2;
        } else {
            try {
                this.f34316a.a((byte) -1);
                this.f34316a.c(exc.toString());
                this.f34317b.a(this.f34316a.a(), b2, this.f34316a.g());
                exc2 = b2;
            } catch (SQLiteFullException e2) {
                SQLiteFullException sQLiteFullException = e2;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.f34318c.a(exc2);
        a((byte) -1);
    }

    private void h() {
        String e2 = this.f34316a.e();
        String d2 = this.f34316a.d();
        File file = new File(e2);
        try {
            File file2 = new File(d2);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwai.filedownloader.f.f.a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", d2, Long.valueOf(length)));
                }
                com.kwai.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", d2, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwai.filedownloader.f.f.a("Can't rename the  temp downloaded file(%s) to the target file(%s)", e2, d2));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwai.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", e2);
            }
            throw th;
        }
    }

    private void i() {
        h();
        this.f34316a.a((byte) -3);
        this.f34317b.b(this.f34316a.a(), this.f34316a.h());
        this.f34317b.d(this.f34316a.a());
        a((byte) -3);
        if (com.kwai.filedownloader.f.e.a().f34370g) {
            com.kwai.filedownloader.services.f.a(this.f34316a);
        }
    }

    private boolean j() {
        if (this.f34316a.i()) {
            com.kwai.filedownloader.d.c cVar = this.f34316a;
            cVar.c(cVar.g());
        } else if (this.f34316a.g() != this.f34316a.h()) {
            a(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.f.f.a("sofar[%d] not equal total[%d]", Long.valueOf(this.f34316a.g()), Long.valueOf(this.f34316a.h()))));
            return true;
        }
        return false;
    }

    private void k() {
        this.f34316a.a((byte) -2);
        this.f34317b.c(this.f34316a.a(), this.f34316a.g());
        a((byte) -2);
    }

    public void a(long j) {
        this.m.addAndGet(j);
        this.f34316a.b(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(elapsedRealtime);
        Handler handler = this.f34323h;
        if (handler == null) {
            a(elapsedRealtime, b2);
        } else if (b2) {
            a(handler.obtainMessage(3));
        }
    }

    public void a(Exception exc) {
        c(exc);
    }

    public void a(Exception exc, int i2, long j) {
        this.m.set(0L);
        this.f34316a.b(-j);
        Handler handler = this.f34323h;
        if (handler == null) {
            a(exc, i2);
        } else {
            a(handler.obtainMessage(5, i2, 0, exc));
        }
    }

    public void a(boolean z, long j, String str, String str2) {
        String j2 = this.f34316a.j();
        if (j2 != null && !j2.equals(str)) {
            throw new IllegalArgumentException(com.kwai.filedownloader.f.f.a("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, j2));
        }
        this.f34318c.a(z);
        this.f34316a.a((byte) 2);
        this.f34316a.c(j);
        this.f34316a.b(str);
        this.f34316a.d(str2);
        this.f34317b.a(this.f34316a.a(), j, str, str2);
        a((byte) 2);
        this.f34322g = a(j, this.f34321f);
        this.n = true;
    }

    public boolean a() {
        HandlerThread handlerThread = this.f34324i;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void b() {
        Handler handler = this.f34323h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f34324i.quit();
            this.k = Thread.currentThread();
            while (this.j) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.k = null;
        }
    }

    public void c() {
        this.f34316a.a((byte) 1);
        this.f34317b.f(this.f34316a.a());
        a((byte) 1);
    }

    public void d() {
        this.f34316a.a((byte) 6);
        a((byte) 6);
        this.f34317b.a(this.f34316a.a());
    }

    public void e() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.f34324i = handlerThread;
        handlerThread.start();
        this.f34323h = new Handler(this.f34324i.getLooper(), this);
    }

    public void f() {
        k();
    }

    public void g() {
        if (j()) {
            return;
        }
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        this.j = true;
        int i2 = message.what;
        try {
            if (i2 != 3) {
                if (i2 == 5) {
                    a((Exception) message.obj, message.arg1);
                }
                return true;
            }
            a(SystemClock.elapsedRealtime(), true);
            return true;
        } finally {
            this.j = false;
            if (this.k != null) {
                LockSupport.unpark(this.k);
            }
        }
    }
}
