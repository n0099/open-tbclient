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
/* loaded from: classes5.dex */
public class c implements a {
    private Handler c;
    private volatile Thread g;
    private volatile List<Integer> e = new CopyOnWriteArrayList();
    private AtomicInteger f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final b f11170a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final d f11171b = new d();
    private final long d = com.kwai.filedownloader.f.e.a().f11230b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i != 0) {
                    try {
                        c.this.f.set(i);
                        c.this.g(i);
                        c.this.e.add(Integer.valueOf(i));
                        c.this.f.set(0);
                        if (c.this.g != null) {
                            LockSupport.unpark(c.this.g);
                            c.this.g = null;
                        }
                    } catch (Throwable th) {
                        c.this.f.set(0);
                        if (c.this.g != null) {
                            LockSupport.unpark(c.this.g);
                            c.this.g = null;
                        }
                        throw th;
                    }
                } else if (c.this.g != null) {
                    LockSupport.unpark(c.this.g);
                    c.this.g = null;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        this.f11171b.a(this.f11170a.b(i));
        List<com.kwai.filedownloader.d.a> c = this.f11170a.c(i);
        this.f11171b.d(i);
        for (com.kwai.filedownloader.d.a aVar : c) {
            this.f11171b.a(aVar);
        }
    }

    private boolean h(int i) {
        return !this.e.contains(Integer.valueOf(i));
    }

    private void i(int i) {
        this.c.removeMessages(i);
        if (this.f.get() != i) {
            g(i);
            return;
        }
        this.g = Thread.currentThread();
        this.c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f11170a.a();
        this.f11171b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
        this.c.sendEmptyMessageDelayed(i, this.d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        this.f11170a.a(i, i2);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        this.f11170a.a(i, i2, j);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
        this.f11170a.a(i, j);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
        this.f11170a.a(i, j, str, str2);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
        this.f11170a.a(i, str, j, j2, i2);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, str, j, j2, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
        this.f11170a.a(i, th);
        if (h(i)) {
            return;
        }
        this.f11171b.a(i, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
        this.f11170a.a(i, th, j);
        if (h(i)) {
            i(i);
        }
        this.f11171b.a(i, th, j);
        this.e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f11170a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f11171b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f11170a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f11171b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC1167a b() {
        return this.f11171b.a(this.f11170a.f11166a, this.f11170a.f11167b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        return this.f11170a.b(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        this.f11170a.b(i, j);
        if (h(i)) {
            this.c.removeMessages(i);
            if (this.f.get() == i) {
                this.g = Thread.currentThread();
                this.c.sendEmptyMessage(0);
                LockSupport.park();
                this.f11171b.b(i, j);
            }
        } else {
            this.f11171b.b(i, j);
        }
        this.e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        return this.f11170a.c(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
        this.f11170a.c(i, j);
        if (h(i)) {
            i(i);
        }
        this.f11171b.c(i, j);
        this.e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        this.f11170a.d(i);
        if (h(i)) {
            return;
        }
        this.f11171b.d(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        this.f11171b.e(i);
        return this.f11170a.e(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
        this.f11170a.f(i);
        if (h(i)) {
            return;
        }
        this.f11171b.f(i);
    }
}
