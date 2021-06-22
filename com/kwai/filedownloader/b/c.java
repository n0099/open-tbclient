package com.kwai.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes7.dex */
public class c implements a {

    /* renamed from: c  reason: collision with root package name */
    public Handler f37722c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f37726g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f37724e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37725f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f37720a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f37721b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f37723d = com.kwai.filedownloader.f.e.a().f37876b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f37722c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.f37726g != null) {
                        LockSupport.unpark(c.this.f37726g);
                        c.this.f37726g = null;
                    }
                    return false;
                }
                try {
                    c.this.f37725f.set(i2);
                    c.this.g(i2);
                    c.this.f37724e.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.f37725f.set(0);
                    if (c.this.f37726g != null) {
                        LockSupport.unpark(c.this.f37726g);
                        c.this.f37726g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        this.f37721b.a(this.f37720a.b(i2));
        List<com.kwai.filedownloader.d.a> c2 = this.f37720a.c(i2);
        this.f37721b.d(i2);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f37721b.a(aVar);
        }
    }

    private boolean h(int i2) {
        return !this.f37724e.contains(Integer.valueOf(i2));
    }

    private void i(int i2) {
        this.f37722c.removeMessages(i2);
        if (this.f37725f.get() != i2) {
            g(i2);
            return;
        }
        this.f37726g = Thread.currentThread();
        this.f37722c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f37720a.a();
        this.f37721b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
        this.f37722c.sendEmptyMessageDelayed(i2, this.f37723d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        this.f37720a.a(i2, i3);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        this.f37720a.a(i2, i3, j);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, i3, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
        this.f37720a.a(i2, j);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
        this.f37720a.a(i2, j, str, str2);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
        this.f37720a.a(i2, str, j, j2, i3);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, str, j, j2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        this.f37720a.a(i2, th);
        if (h(i2)) {
            return;
        }
        this.f37721b.a(i2, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
        this.f37720a.a(i2, th, j);
        if (h(i2)) {
            i(i2);
        }
        this.f37721b.a(i2, th, j);
        this.f37724e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f37720a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f37721b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f37720a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f37721b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0444a b() {
        d dVar = this.f37721b;
        b bVar = this.f37720a;
        return dVar.a(bVar.f37716a, bVar.f37717b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i2) {
        return this.f37720a.b(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        this.f37720a.b(i2, j);
        if (h(i2)) {
            this.f37722c.removeMessages(i2);
            if (this.f37725f.get() == i2) {
                this.f37726g = Thread.currentThread();
                this.f37722c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f37724e.remove(Integer.valueOf(i2));
        }
        this.f37721b.b(i2, j);
        this.f37724e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        return this.f37720a.c(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j) {
        this.f37720a.c(i2, j);
        if (h(i2)) {
            i(i2);
        }
        this.f37721b.c(i2, j);
        this.f37724e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        this.f37720a.d(i2);
        if (h(i2)) {
            return;
        }
        this.f37721b.d(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        this.f37721b.e(i2);
        return this.f37720a.e(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
        this.f37720a.f(i2);
        if (h(i2)) {
            return;
        }
        this.f37721b.f(i2);
    }
}
