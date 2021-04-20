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
    public b f39470a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f39471b;

    /* renamed from: c  reason: collision with root package name */
    public File f39472c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f39473d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f39474e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f39475f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f39476g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f39477h;
    public volatile boolean i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f39490b, true, h.f39507a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.i) {
            this.i = true;
            i();
            try {
                this.f39477h.a(g(), this.f39473d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f39477h.b();
                throw th;
            }
            this.f39477h.b();
            this.i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f39472c)) || (this.f39471b == null && a2 != null)) {
            this.f39472c = a2;
            h();
            try {
                this.f39471b = new FileWriter(this.f39472c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f39471b;
    }

    private void h() {
        try {
            if (this.f39471b != null) {
                this.f39471b.flush();
                this.f39471b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f39476g == this.f39474e) {
                this.f39476g = this.f39475f;
                this.f39477h = this.f39474e;
            } else {
                this.f39476g = this.f39474e;
                this.f39477h = this.f39475f;
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
        return this.f39470a;
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
        this.f39474e = new g();
        this.f39475f = new g();
        this.f39476g = this.f39474e;
        this.f39477h = this.f39475f;
        this.f39473d = new char[bVar.d()];
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
        this.f39476g.a(str);
        if (this.f39476g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f39470a = bVar;
    }
}
