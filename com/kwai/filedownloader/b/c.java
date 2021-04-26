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
    public Handler f34965c;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f34969g;

    /* renamed from: e  reason: collision with root package name */
    public volatile List<Integer> f34967e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f34968f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final b f34963a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final d f34964b = new d();

    /* renamed from: d  reason: collision with root package name */
    public final long f34966d = com.kwai.filedownloader.f.e.a().f35120b;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.i("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.f34965c = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.f34969g != null) {
                        LockSupport.unpark(c.this.f34969g);
                        c.this.f34969g = null;
                    }
                    return false;
                }
                try {
                    c.this.f34968f.set(i2);
                    c.this.g(i2);
                    c.this.f34967e.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.f34968f.set(0);
                    if (c.this.f34969g != null) {
                        LockSupport.unpark(c.this.f34969g);
                        c.this.f34969g = null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        this.f34964b.a(this.f34963a.b(i2));
        List<com.kwai.filedownloader.d.a> c2 = this.f34963a.c(i2);
        this.f34964b.d(i2);
        for (com.kwai.filedownloader.d.a aVar : c2) {
            this.f34964b.a(aVar);
        }
    }

    private boolean h(int i2) {
        return !this.f34967e.contains(Integer.valueOf(i2));
    }

    private void i(int i2) {
        this.f34965c.removeMessages(i2);
        if (this.f34968f.get() != i2) {
            g(i2);
            return;
        }
        this.f34969g = Thread.currentThread();
        this.f34965c.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        this.f34963a.a();
        this.f34964b.a();
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
        this.f34965c.sendEmptyMessageDelayed(i2, this.f34966d);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        this.f34963a.a(i2, i3);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j) {
        this.f34963a.a(i2, i3, j);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, i3, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j) {
        this.f34963a.a(i2, j);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, j);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j, String str, String str2) {
        this.f34963a.a(i2, j, str, str2);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, j, str, str2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j, long j2, int i3) {
        this.f34963a.a(i2, str, j, j2, i3);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, str, j, j2, i3);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        this.f34963a.a(i2, th);
        if (h(i2)) {
            return;
        }
        this.f34964b.a(i2, th);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j) {
        this.f34963a.a(i2, th, j);
        if (h(i2)) {
            i(i2);
        }
        this.f34964b.a(i2, th, j);
        this.f34967e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        this.f34963a.a(aVar);
        if (h(aVar.a())) {
            return;
        }
        this.f34964b.a(aVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        this.f34963a.a(cVar);
        if (h(cVar.a())) {
            return;
        }
        this.f34964b.a(cVar);
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC0403a b() {
        d dVar = this.f34964b;
        b bVar = this.f34963a;
        return dVar.a(bVar.f34959a, bVar.f34960b);
    }

    @Override // com.kwai.filedownloader.b.a
    public com.kwai.filedownloader.d.c b(int i2) {
        return this.f34963a.b(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j) {
        this.f34963a.b(i2, j);
        if (h(i2)) {
            this.f34965c.removeMessages(i2);
            if (this.f34968f.get() == i2) {
                this.f34969g = Thread.currentThread();
                this.f34965c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f34967e.remove(Integer.valueOf(i2));
        }
        this.f34964b.b(i2, j);
        this.f34967e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        return this.f34963a.c(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j) {
        this.f34963a.c(i2, j);
        if (h(i2)) {
            i(i2);
        }
        this.f34964b.c(i2, j);
        this.f34967e.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        this.f34963a.d(i2);
        if (h(i2)) {
            return;
        }
        this.f34964b.d(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        this.f34964b.e(i2);
        return this.f34963a.e(i2);
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
        this.f34963a.f(i2);
        if (h(i2)) {
            return;
        }
        this.f34964b.f(i2);
    }
}
