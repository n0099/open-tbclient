package com.tencent.open.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public class a extends i implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private b f4572a;
    private FileWriter b;
    private File c;
    private char[] d;
    private volatile g e;
    private volatile g f;
    private volatile g g;
    private volatile g h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(b bVar) {
        this(c.b, true, h.f4580a, bVar);
    }

    public a(int i, boolean z, h hVar, b bVar) {
        super(i, z, hVar);
        this.i = false;
        a(bVar);
        this.e = new g();
        this.f = new g();
        this.g = this.e;
        this.h = this.f;
        this.d = new char[bVar.d()];
        g();
        this.j = new HandlerThread(bVar.c(), bVar.f());
        if (this.j != null) {
            this.j.start();
        }
        if (this.j.isAlive() && this.j.getLooper() != null) {
            this.k = new Handler(this.j.getLooper(), this);
        }
    }

    public void a() {
        if (this.k.hasMessages(1024)) {
            this.k.removeMessages(1024);
        }
        this.k.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        this.j.quit();
    }

    @Override // com.tencent.open.a.i
    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    protected void a(String str) {
        this.g.a(str);
        if (this.g.a() >= c().d()) {
            a();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1024:
                f();
                return true;
            default:
                return true;
        }
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.h.a(g(), this.d);
            } catch (IOException e) {
            } finally {
                this.h.b();
            }
            this.i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.c)) || (this.b == null && a2 != null)) {
            this.c = a2;
            h();
            try {
                this.b = new FileWriter(this.c, true);
            } catch (IOException e) {
                return null;
            }
        }
        return this.b;
    }

    private void h() {
        try {
            if (this.b != null) {
                this.b.flush();
                this.b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.g == this.e) {
                this.g = this.f;
                this.h = this.e;
            } else {
                this.g = this.e;
                this.h = this.f;
            }
        }
    }

    public b c() {
        return this.f4572a;
    }

    public void a(b bVar) {
        this.f4572a = bVar;
    }
}
