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
    public b f36408a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f36409b;

    /* renamed from: c  reason: collision with root package name */
    public File f36410c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f36411d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f36412e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f36413f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f36414g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f36415h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f36416i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f36430b, true, h.f36448a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.f36416i) {
            this.f36416i = true;
            i();
            try {
                this.f36415h.a(g(), this.f36411d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f36415h.b();
                throw th;
            }
            this.f36415h.b();
            this.f36416i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f36410c)) || (this.f36409b == null && a2 != null)) {
            this.f36410c = a2;
            h();
            try {
                this.f36409b = new FileWriter(this.f36410c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f36409b;
    }

    private void h() {
        try {
            if (this.f36409b != null) {
                this.f36409b.flush();
                this.f36409b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f36414g == this.f36412e) {
                this.f36414g = this.f36413f;
                this.f36415h = this.f36412e;
            } else {
                this.f36414g = this.f36412e;
                this.f36415h = this.f36413f;
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
        return this.f36408a;
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
        this.f36416i = false;
        a(bVar);
        this.f36412e = new g();
        this.f36413f = new g();
        this.f36414g = this.f36412e;
        this.f36415h = this.f36413f;
        this.f36411d = new char[bVar.d()];
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
        this.f36414g.a(str);
        if (this.f36414g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f36408a = bVar;
    }
}
