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
    public Handler f37624c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f37628g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f37626e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37627f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f37622a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f37623b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f37625d = com.kwai.filedownloader.f.e.a().f37778b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f37624c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.f37628g != null) {
                        LockSupport.unpark(c.this.f37628g);
                        c.this.f37628g = null;
                    }
                    return false;
                }
                try {
                    c.this.f37627f.set(i2);
                    c.this.g(i2);
                    c.this.f37626e.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.f37627f.set(0);
                    if (c.this.f37628g != null) {
                        LockSupport.unpark(c.this.f37628g);
                        c.this.f37628g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        this.f37623b.a(this.f37622a.b(i2));
        List<com.kwai.filedownloader.d.a> c2 = this.f37622a.c(i2);
        this.f37623b.d(i2);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f37623b.a(aVar);
        }
    }

    private boolean h(int i2) {
        return !this.f37626e.contains(Integer.valueOf(i2));
    }

    private void i(int i2) {
        this.f37624c.removeMessages(i2);
        if (this.f37627f.get() != i2) {
            g(i2);
            return;
        }
        this.f37628g = Thread.currentThread();
        this.f37624c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f37622a.a();
        this.f37623b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
        this.f37624c.sendEmptyMessageDelayed(i2, this.f37625d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        this.f37622a.a(i2, i3);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        this.f37622a.a(i2, i3, j);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, i3, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
        this.f37622a.a(i2, j);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
        this.f37622a.a(i2, j, str, str2);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
        this.f37622a.a(i2, str, j, j2, i3);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, str, j, j2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        this.f37622a.a(i2, th);
        if (h(i2)) {
            return;
        }
        this.f37623b.a(i2, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
        this.f37622a.a(i2, th, j);
        if (h(i2)) {
            i(i2);
        }
        this.f37623b.a(i2, th, j);
        this.f37626e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f37622a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f37623b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f37622a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f37623b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0441a b() {
        d dVar = this.f37623b;
        b bVar = this.f37622a;
        return dVar.a(bVar.f37618a, bVar.f37619b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i2) {
        return this.f37622a.b(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        this.f37622a.b(i2, j);
        if (h(i2)) {
            this.f37624c.removeMessages(i2);
            if (this.f37627f.get() == i2) {
                this.f37628g = Thread.currentThread();
                this.f37624c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f37626e.remove(Integer.valueOf(i2));
        }
        this.f37623b.b(i2, j);
        this.f37626e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        return this.f37622a.c(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j) {
        this.f37622a.c(i2, j);
        if (h(i2)) {
            i(i2);
        }
        this.f37623b.c(i2, j);
        this.f37626e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        this.f37622a.d(i2);
        if (h(i2)) {
            return;
        }
        this.f37623b.d(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        this.f37623b.e(i2);
        return this.f37622a.e(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
        this.f37622a.f(i2);
        if (h(i2)) {
            return;
        }
        this.f37623b.f(i2);
    }
}
