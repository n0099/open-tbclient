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
    public b f39181a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f39182b;

    /* renamed from: c  reason: collision with root package name */
    public File f39183c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f39184d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f39185e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f39186f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f39187g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f39188h;
    public volatile boolean i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f39201b, true, h.f39218a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.f39188h.a(g(), this.f39184d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f39188h.b();
                throw th;
            }
            this.f39188h.b();
            this.i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f39183c)) || (this.f39182b == null && a2 != null)) {
            this.f39183c = a2;
            h();
            try {
                this.f39182b = new FileWriter(this.f39183c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f39182b;
    }

    private void h() {
        try {
            if (this.f39182b != null) {
                this.f39182b.flush();
                this.f39182b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f39187g == this.f39185e) {
                this.f39187g = this.f39186f;
                this.f39188h = this.f39185e;
            } else {
                this.f39187g = this.f39185e;
                this.f39188h = this.f39186f;
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
        return this.f39181a;
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
        this.f39185e = new g();
        this.f39186f = new g();
        this.f39187g = this.f39185e;
        this.f39188h = this.f39186f;
        this.f39184d = new char[bVar.d()];
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
        this.f39187g.a(str);
        if (this.f39187g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f39181a = bVar;
    }
}
