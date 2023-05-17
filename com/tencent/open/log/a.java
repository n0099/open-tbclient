package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes10.dex */
public class a extends Tracer implements Handler.Callback {
    public b a;
    public FileWriter b;
    public FileWriter c;
    public File d;
    public File e;
    public char[] f;
    public volatile f g;
    public volatile f h;
    public volatile f i;
    public volatile f j;
    public volatile boolean k;
    public HandlerThread l;
    public Handler m;

    public a(int i, boolean z, g gVar, b bVar) {
        super(i, z, gVar);
        this.k = false;
        a(bVar);
        this.g = new f();
        this.h = new f();
        this.i = this.g;
        this.j = this.h;
        this.f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.l = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (this.l.isAlive() && this.l.getLooper() != null) {
            this.m = new Handler(this.l.getLooper(), this);
        }
    }

    public a(b bVar) {
        this(c.b, true, g.a, bVar);
    }

    private void a(String str) {
        this.i.a(str);
        if (this.i.a() >= c().d()) {
            a();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            f();
            return true;
        }
        return true;
    }

    private void f() {
        if (Thread.currentThread() != this.l || this.k) {
            return;
        }
        this.k = true;
        j();
        try {
            try {
                this.j.a(g(), this.f);
            } catch (IOException e) {
                SLog.e("FileTracer", "flushBuffer exception", e);
            }
            this.k = false;
        } finally {
            this.j.b();
        }
    }

    private Writer[] g() {
        File[] a = c().a();
        if (a != null && a.length >= 2) {
            File file = a[0];
            if ((file != null && !file.equals(this.d)) || (this.b == null && file != null)) {
                this.d = file;
                h();
                try {
                    this.b = new FileWriter(this.d, true);
                } catch (IOException unused) {
                    this.b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.c = new FileWriter(this.e, true);
                } catch (IOException unused2) {
                    this.c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.b, this.c};
    }

    private void h() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            if (this.c != null) {
                this.c.flush();
                this.c.close();
            }
        } catch (IOException e) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.i == this.g) {
                this.i = this.h;
                this.j = this.g;
            } else {
                this.i = this.g;
                this.j = this.h;
            }
        }
    }

    public void a() {
        if (this.m.hasMessages(1024)) {
            this.m.removeMessages(1024);
        }
        this.m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.l.quit();
    }

    public b c() {
        return this.a;
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }
}
