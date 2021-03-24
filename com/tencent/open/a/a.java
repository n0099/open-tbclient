package com.tencent.open.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class a extends i implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public b f39180a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f39181b;

    /* renamed from: c  reason: collision with root package name */
    public File f39182c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f39183d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f39184e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f39185f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f39186g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f39187h;
    public volatile boolean i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f39200b, true, h.f39217a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.f39187h.a(g(), this.f39183d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f39187h.b();
                throw th;
            }
            this.f39187h.b();
            this.i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f39182c)) || (this.f39181b == null && a2 != null)) {
            this.f39182c = a2;
            h();
            try {
                this.f39181b = new FileWriter(this.f39182c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f39181b;
    }

    private void h() {
        try {
            if (this.f39181b != null) {
                this.f39181b.flush();
                this.f39181b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f39186g == this.f39184e) {
                this.f39186g = this.f39185f;
                this.f39187h = this.f39184e;
            } else {
                this.f39186g = this.f39184e;
                this.f39187h = this.f39185f;
            }
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

    public b c() {
        return this.f39180a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i, boolean z, h hVar, b bVar) {
        super(i, z, hVar);
        this.i = false;
        a(bVar);
        this.f39184e = new g();
        this.f39185f = new g();
        this.f39186g = this.f39184e;
        this.f39187h = this.f39185f;
        this.f39183d = new char[bVar.d()];
        g();
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.j = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.j.isAlive() || this.j.getLooper() == null) {
            return;
        }
        this.k = new Handler(this.j.getLooper(), this);
    }

    @Override // com.tencent.open.a.i
    public void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    public void a(String str) {
        this.f39186g.a(str);
        if (this.f39186g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f39180a = bVar;
    }
}
