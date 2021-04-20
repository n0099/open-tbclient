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
    public Handler f37155c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f37159g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f37157e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f37158f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f37153a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f37154b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f37156d = com.kwai.filedownloader.f.e.a().f37303b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f37155c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.f37159g != null) {
                        LockSupport.unpark(c.this.f37159g);
                        c.this.f37159g = null;
                    }
                    return false;
                }
                try {
                    c.this.f37158f.set(i);
                    c.this.g(i);
                    c.this.f37157e.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.f37158f.set(0);
                    if (c.this.f37159g != null) {
                        LockSupport.unpark(c.this.f37159g);
                        c.this.f37159g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        this.f37154b.a(this.f37153a.b(i));
        List<com.kwai.filedownloader.d.a> c2 = this.f37153a.c(i);
        this.f37154b.d(i);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f37154b.a(aVar);
        }
    }

    private boolean h(int i) {
        return !this.f37157e.contains(Integer.valueOf(i));
    }

    private void i(int i) {
        this.f37155c.removeMessages(i);
        if (this.f37158f.get() != i) {
            g(i);
            return;
        }
        this.f37159g = Thread.currentThread();
        this.f37155c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f37153a.a();
        this.f37154b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i) {
        this.f37155c.sendEmptyMessageDelayed(i, this.f37156d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2) {
        this.f37153a.a(i, i2);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, int i2, long j) {
        this.f37153a.a(i, i2, j);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j) {
        this.f37153a.a(i, j);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, long j, String str, String str2) {
        this.f37153a.a(i, j, str, str2);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, String str, long j, long j2, int i2) {
        this.f37153a.a(i, str, j, j2, i2);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, str, j, j2, i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th) {
        this.f37153a.a(i, th);
        if (h(i)) {
            return;
        }
        this.f37154b.a(i, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i, Throwable th, long j) {
        this.f37153a.a(i, th, j);
        if (h(i)) {
            i(i);
        }
        this.f37154b.a(i, th, j);
        this.f37157e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f37153a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f37154b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f37153a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f37154b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0455a b() {
        d dVar = this.f37154b;
        b bVar = this.f37153a;
        return dVar.a(bVar.f37149a, bVar.f37150b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i) {
        return this.f37153a.b(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i, long j) {
        this.f37153a.b(i, j);
        if (h(i)) {
            this.f37155c.removeMessages(i);
            if (this.f37158f.get() == i) {
                this.f37159g = Thread.currentThread();
                this.f37155c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f37157e.remove(Integer.valueOf(i));
        }
        this.f37154b.b(i, j);
        this.f37157e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i) {
        return this.f37153a.c(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i, long j) {
        this.f37153a.c(i, j);
        if (h(i)) {
            i(i);
        }
        this.f37154b.c(i, j);
        this.f37157e.remove(Integer.valueOf(i));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i) {
        this.f37153a.d(i);
        if (h(i)) {
            return;
        }
        this.f37154b.d(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i) {
        this.f37154b.e(i);
        return this.f37153a.e(i);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i) {
        this.f37153a.f(i);
        if (h(i)) {
            return;
        }
        this.f37154b.f(i);
    }
}
