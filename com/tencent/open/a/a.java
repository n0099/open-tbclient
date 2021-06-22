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
    public b f40119a;

    /* renamed from: b  reason: collision with root package name */
    public FileWriter f40120b;

    /* renamed from: c  reason: collision with root package name */
    public File f40121c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f40122d;

    /* renamed from: e  reason: collision with root package name */
    public volatile g f40123e;

    /* renamed from: f  reason: collision with root package name */
    public volatile g f40124f;

    /* renamed from: g  reason: collision with root package name */
    public volatile g f40125g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f40126h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f40127i;
    public HandlerThread j;
    public Handler k;

    public a(b bVar) {
        this(c.f40141b, true, h.f40159a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.j && !this.f40127i) {
            this.f40127i = true;
            i();
            try {
                this.f40126h.a(g(), this.f40122d);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f40126h.b();
                throw th;
            }
            this.f40126h.b();
            this.f40127i = false;
        }
    }

    private Writer g() {
        File a2 = c().a();
        if ((a2 != null && !a2.equals(this.f40121c)) || (this.f40120b == null && a2 != null)) {
            this.f40121c = a2;
            h();
            try {
                this.f40120b = new FileWriter(this.f40121c, true);
            } catch (IOException unused) {
                return null;
            }
        }
        return this.f40120b;
    }

    private void h() {
        try {
            if (this.f40120b != null) {
                this.f40120b.flush();
                this.f40120b.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        synchronized (this) {
            if (this.f40125g == this.f40123e) {
                this.f40125g = this.f40124f;
                this.f40126h = this.f40123e;
            } else {
                this.f40125g = this.f40123e;
                this.f40126h = this.f40124f;
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
        return this.f40119a;
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
        this.f40127i = false;
        a(bVar);
        this.f40123e = new g();
        this.f40124f = new g();
        this.f40125g = this.f40123e;
        this.f40126h = this.f40124f;
        this.f40122d = new char[bVar.d()];
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
        this.f40125g.a(str);
        if (this.f40125g.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.f40119a = bVar;
    }
}
