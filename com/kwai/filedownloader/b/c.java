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
/* loaded from: classes6.dex */
public class c implements a {

    /* renamed from: c  reason: collision with root package name */
    public Handler f36866c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f36870g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f36868e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f36869f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f36864a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f36865b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f36867d = com.kwai.filedownloader.f.e.a().f37014b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f36866c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.f36870g != null) {
                        LockSupport.unpark(c.this.f36870g);
                        c.this.f36870g = null;
                    }
                    return false;
                }
                try {
                    c.this.f36869f.set(i);
                    c.this.g(i);
                    c.this.f36868e.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.f36869f.set(0);
                    if (c.this.f36870g != null) {
                        LockSupport.unpark(c.this.f36870g);
                        c.this.f36870g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        this.f36865b.a(this.f36864a.b(i));
        List<com.kwai.filedownloader.d.a> c2 = this.f36864a.c(i);
        this.f36865b.d(i);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f36865b.a(aVar);
        }
    }

    private boolean h(int i) {
        return !this.f36868e.contains(Integer.valueOf(i));
    }

    private void i(int i) {
        this.f36866c.removeMessages(i);
        if (this.f36869f.get() != i) {
            g(i);
            return;
        }
        this.f36870g = Thread.currentThread();
        this.f36866c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f36864a.a();
        this.f36865b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
        this.f36866c.sendEmptyMessageDelayed(i, this.f36867d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        this.f36864a.a(i, i2);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        this.f36864a.a(i, i2, j);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
        this.f36864a.a(i, j);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
        this.f36864a.a(i, j, str, str2);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
        this.f36864a.a(i, str, j, j2, i2);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, str, j, j2, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
        this.f36864a.a(i, th);
        if (h(i)) {
            return;
        }
        this.f36865b.a(i, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
        this.f36864a.a(i, th, j);
        if (h(i)) {
            i(i);
        }
        this.f36865b.a(i, th, j);
        this.f36868e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f36864a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f36865b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f36864a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f36865b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0441a b() {
        d dVar = this.f36865b;
        b bVar = this.f36864a;
        return dVar.a(bVar.f36860a, bVar.f36861b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        return this.f36864a.b(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        this.f36864a.b(i, j);
        if (h(i)) {
            this.f36866c.removeMessages(i);
            if (this.f36869f.get() == i) {
                this.f36870g = Thread.currentThread();
                this.f36866c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f36868e.remove(Integer.valueOf(i));
        }
        this.f36865b.b(i, j);
        this.f36868e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        return this.f36864a.c(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
        this.f36864a.c(i, j);
        if (h(i)) {
            i(i);
        }
        this.f36865b.c(i, j);
        this.f36868e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        this.f36864a.d(i);
        if (h(i)) {
            return;
        }
        this.f36865b.d(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        this.f36865b.e(i);
        return this.f36864a.e(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
        this.f36864a.f(i);
        if (h(i)) {
            return;
        }
        this.f36865b.f(i);
    }
}
