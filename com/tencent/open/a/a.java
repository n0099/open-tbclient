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
    public b f40016a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f40017b;

    /* renamed from: c  reason: collision with root package name */
    public File f40018c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f40019d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f40020e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f40021f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f40022g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f40023h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f40024i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f40038b, true, h.f40056a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.f40024i) {
            this.f40024i = true;
            i();
            try {
                this.f40023h.a(g(), this.f40019d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f40023h.b();
                throw th;
            }
            this.f40023h.b();
            this.f40024i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f40018c)) || (this.f40017b == null && a2 != null)) {
            this.f40018c = a2;
            h();
            try {
                this.f40017b = new FileWriter(this.f40018c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f40017b;
    }

    private void h() {
        try {
            if (this.f40017b != null) {
                this.f40017b.flush();
                this.f40017b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f40022g == this.f40020e) {
                this.f40022g = this.f40021f;
                this.f40023h = this.f40020e;
            } else {
                this.f40022g = this.f40020e;
                this.f40023h = this.f40021f;
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
        return this.f40016a;
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
        this.f40024i = false;
        a(bVar);
        this.f40020e = new g();
        this.f40021f = new g();
        this.f40022g = this.f40020e;
        this.f40023h = this.f40021f;
        this.f40019d = new char[bVar.d()];
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
        this.f40022g.a(str);
        if (this.f40022g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f40016a = bVar;
    }
}
