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
    public b f37163a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f37164b;

    /* renamed from: c  reason: collision with root package name */
    public File f37165c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f37166d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f37167e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f37168f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f37169g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f37170h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f37171i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f37185b, true, h.f37203a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.f37171i) {
            this.f37171i = true;
            i();
            try {
                this.f37170h.a(g(), this.f37166d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f37170h.b();
                throw th;
            }
            this.f37170h.b();
            this.f37171i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f37165c)) || (this.f37164b == null && a2 != null)) {
            this.f37165c = a2;
            h();
            try {
                this.f37164b = new FileWriter(this.f37165c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f37164b;
    }

    private void h() {
        try {
            if (this.f37164b != null) {
                this.f37164b.flush();
                this.f37164b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f37169g == this.f37167e) {
                this.f37169g = this.f37168f;
                this.f37170h = this.f37167e;
            } else {
                this.f37169g = this.f37167e;
                this.f37170h = this.f37168f;
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
        return this.f37163a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, h hVar, b bVar) {
        super(i2, z, hVar);
        this.f37171i = false;
        a(bVar);
        this.f37167e = new g();
        this.f37168f = new g();
        this.f37169g = this.f37167e;
        this.f37170h = this.f37168f;
        this.f37166d = new char[bVar.d()];
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
    public void a(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j, str, str2, th));
    }

    public void a(String str) {
        this.f37169g.a(str);
        if (this.f37169g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f37163a = bVar;
    }
}
