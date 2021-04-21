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
    public Handler f37250c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f37254g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f37252e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37253f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f37248a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f37249b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f37251d = com.kwai.filedownloader.f.e.a().f37398b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f37250c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.f37254g != null) {
                        LockSupport.unpark(c.this.f37254g);
                        c.this.f37254g = null;
                    }
                    return false;
                }
                try {
                    c.this.f37253f.set(i);
                    c.this.g(i);
                    c.this.f37252e.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.f37253f.set(0);
                    if (c.this.f37254g != null) {
                        LockSupport.unpark(c.this.f37254g);
                        c.this.f37254g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        this.f37249b.a(this.f37248a.b(i));
        List<com.kwai.filedownloader.d.a> c2 = this.f37248a.c(i);
        this.f37249b.d(i);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f37249b.a(aVar);
        }
    }

    private boolean h(int i) {
        return !this.f37252e.contains(Integer.valueOf(i));
    }

    private void i(int i) {
        this.f37250c.removeMessages(i);
        if (this.f37253f.get() != i) {
            g(i);
            return;
        }
        this.f37254g = Thread.currentThread();
        this.f37250c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f37248a.a();
        this.f37249b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
        this.f37250c.sendEmptyMessageDelayed(i, this.f37251d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        this.f37248a.a(i, i2);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        this.f37248a.a(i, i2, j);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
        this.f37248a.a(i, j);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
        this.f37248a.a(i, j, str, str2);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
        this.f37248a.a(i, str, j, j2, i2);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, str, j, j2, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
        this.f37248a.a(i, th);
        if (h(i)) {
            return;
        }
        this.f37249b.a(i, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
        this.f37248a.a(i, th, j);
        if (h(i)) {
            i(i);
        }
        this.f37249b.a(i, th, j);
        this.f37252e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f37248a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f37249b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f37248a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f37249b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0458a b() {
        d dVar = this.f37249b;
        b bVar = this.f37248a;
        return dVar.a(bVar.f37244a, bVar.f37245b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        return this.f37248a.b(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        this.f37248a.b(i, j);
        if (h(i)) {
            this.f37250c.removeMessages(i);
            if (this.f37253f.get() == i) {
                this.f37254g = Thread.currentThread();
                this.f37250c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f37252e.remove(Integer.valueOf(i));
        }
        this.f37249b.b(i, j);
        this.f37252e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        return this.f37248a.c(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
        this.f37248a.c(i, j);
        if (h(i)) {
            i(i);
        }
        this.f37249b.c(i, j);
        this.f37252e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        this.f37248a.d(i);
        if (h(i)) {
            return;
        }
        this.f37249b.d(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        this.f37249b.e(i);
        return this.f37248a.e(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
        this.f37248a.f(i);
        if (h(i)) {
            return;
        }
        this.f37249b.f(i);
    }
}
