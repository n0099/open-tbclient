package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes10.dex */
public final class d implements Handler.Callback {
    public final com.kwad.framework.filedownloader.d.c afL;
    public volatile Thread afg;
    public volatile boolean agB;
    public final a agt;
    public final int agu;
    public final int agv;
    public final int agw;
    public long agx;
    public HandlerThread agy;
    public Handler handler;
    public volatile boolean agz = false;
    public volatile long agf = 0;
    public final AtomicLong agA = new AtomicLong();
    public boolean agC = true;
    public final com.kwad.framework.filedownloader.b.a afG = b.ve().vg();

    /* loaded from: classes10.dex */
    public static class a {
        public boolean agD;
        public Exception agE;
        public int agF;

        public final Exception getException() {
            return this.agE;
        }

        public final int tP() {
            return this.agF;
        }

        public final boolean vG() {
            return this.agD;
        }

        public final void bd(boolean z) {
            this.agD = z;
        }

        public final void bp(int i) {
            this.agF = i;
        }

        public final void f(Exception exc) {
            this.agE = exc;
        }
    }

    public d(com.kwad.framework.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.afL = cVar;
        this.agv = i2 < 5 ? 5 : i2;
        this.agw = i3;
        this.agt = new a();
        this.agu = i;
    }

    private boolean L(long j) {
        if (this.agC) {
            this.agC = false;
            return true;
        }
        long j2 = j - this.agf;
        if (this.agx != -1 && this.agA.get() >= this.agx && j2 >= this.agv) {
            return true;
        }
        return false;
    }

    private void c(byte b) {
        if (b == -2) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.afL.getId()));
                return;
            }
            return;
        }
        com.kwad.framework.filedownloader.message.e.vV().s(com.kwad.framework.filedownloader.message.f.a(b, this.afL, this.agt));
    }

    public final void onProgress(long j) {
        this.agA.addAndGet(j);
        this.afL.P(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean L = L(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, L);
        } else if (L) {
            b(handler.obtainMessage(3));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.afL.getId();
        if (com.kwad.framework.filedownloader.f.d.ahW) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.afL.bh(sQLiteFullException.toString());
        this.afL.d((byte) -1);
        this.afG.bi(id);
        this.afG.bh(id);
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception d = d(exc);
        if (d instanceof SQLiteFullException) {
            a((SQLiteFullException) d);
            exc2 = d;
        } else {
            try {
                this.afL.d((byte) -1);
                this.afL.bh(exc.toString());
                this.afG.a(this.afL.getId(), d, this.afL.wb());
                exc2 = d;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException = e;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.agt.f(exc2);
        c((byte) -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        this.agz = true;
        int i = message.what;
        try {
            if (i != 3) {
                if (i == 5) {
                    a((Exception) message.obj, message.arg1);
                }
                return true;
            }
            b(SystemClock.elapsedRealtime(), true);
            return true;
        } finally {
            this.agz = false;
            if (this.afg != null) {
                LockSupport.unpark(this.afg);
            }
        }
    }

    private void a(Exception exc, int i) {
        Exception d = d(exc);
        this.agt.f(d);
        this.agt.bp(this.agu - i);
        this.afL.d((byte) 5);
        this.afL.bh(d.toString());
        this.afG.a(this.afL.getId(), d);
        c((byte) 5);
    }

    public static long h(long j, long j2) {
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

    private void b(long j, boolean z) {
        if (this.afL.wb() == this.afL.getTotal()) {
            this.afG.c(this.afL.getId(), this.afL.wb());
            return;
        }
        if (this.agB) {
            this.agB = false;
            this.afL.d((byte) 3);
        }
        if (z) {
            this.agf = j;
            c((byte) 3);
            this.agA.set(0L);
        }
    }

    private synchronized void b(Message message) {
        if (!this.agy.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.ahW) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (!this.agy.isAlive()) {
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e;
        }
    }

    private Exception d(Exception exc) {
        long length;
        String vt = this.afL.vt();
        if ((this.afL.isChunked() || com.kwad.framework.filedownloader.f.e.wD().aic) && (exc instanceof IOException) && new File(vt).exists()) {
            long availableBytes = h.getAvailableBytes(vt);
            if (availableBytes <= 4096) {
                File file = new File(vt);
                if (!file.exists()) {
                    com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    length = 0;
                } else {
                    length = file.length();
                }
                if (Build.VERSION.SDK_INT >= 9) {
                    return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
                }
                return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length);
            }
            return exc;
        }
        return exc;
    }

    private void vC() {
        String vt = this.afL.vt();
        String targetFilePath = this.afL.getTargetFilePath();
        File file = new File(vt);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (file2.delete()) {
                    com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
                } else {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
            }
            if (file.renameTo(file2)) {
                if (file.exists() && !file.delete()) {
                    com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", vt);
                    return;
                }
                return;
            }
            throw new IOException(com.kwad.framework.filedownloader.f.f.b("Can't rename the  temp downloaded file(%s) to the target file(%s)", vt, targetFilePath));
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", vt);
            }
            throw th;
        }
    }

    private void vD() {
        vC();
        this.afL.d((byte) -3);
        this.afG.d(this.afL.getId(), this.afL.getTotal());
        this.afG.bh(this.afL.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.wD().aid) {
            com.kwad.framework.filedownloader.services.f.f(this.afL);
        }
    }

    private boolean vE() {
        if (this.afL.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.afL;
            cVar.Q(cVar.wb());
        } else if (this.afL.wb() != this.afL.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("sofar[%d] not equal total[%d]", Long.valueOf(this.afL.wb()), Long.valueOf(this.afL.getTotal()))));
            return true;
        }
        return false;
    }

    private void vF() {
        this.afL.d((byte) -2);
        this.afG.e(this.afL.getId(), this.afL.wb());
        c((byte) -2);
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.agy;
        if (handlerThread != null && handlerThread.isAlive()) {
            return true;
        }
        return false;
    }

    public final void vA() {
        vF();
    }

    public final void vB() {
        if (vE()) {
            return;
        }
        vD();
    }

    public final void vw() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.agy.quit();
            this.afg = Thread.currentThread();
            while (this.agz) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.afg = null;
        }
    }

    public final void vx() {
        this.afL.d((byte) 1);
        this.afG.bj(this.afL.getId());
        c((byte) 1);
    }

    public final void vy() {
        this.afL.d((byte) 6);
        c((byte) 6);
        this.afG.be(this.afL.getId());
    }

    public final void vz() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.agy = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.agy.getLooper(), this);
    }

    public final void a(Exception exc, int i, long j) {
        this.agA.set(0L);
        this.afL.P(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    public final void a(boolean z, long j, String str, String str2) {
        String wc = this.afL.wc();
        if (wc != null && !wc.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, wc));
        }
        this.agt.bd(z);
        this.afL.d((byte) 2);
        this.afL.Q(j);
        this.afL.bg(str);
        this.afL.bi(str2);
        this.afG.a(this.afL.getId(), j, str, str2);
        c((byte) 2);
        this.agx = h(j, this.agw);
        this.agB = true;
    }

    public final void c(Exception exc) {
        e(exc);
    }
}
