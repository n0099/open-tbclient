package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes10.dex */
public final class c implements a {
    public volatile Thread afg;
    public Handler handler;
    public volatile List<Integer> afe = new CopyOnWriteArrayList();
    public AtomicInteger aff = new AtomicInteger();
    public final b afb = new b();
    public final d afc = new d();
    public final long afd = com.kwad.framework.filedownloader.f.e.wD().ahY;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bq("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.afg != null) {
                        LockSupport.unpark(c.this.afg);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.aff.set(i);
                    c.this.bk(i);
                    c.this.afe.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.aff.set(0);
                    if (c.this.afg != null) {
                        LockSupport.unpark(c.this.afg);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(int i) {
        this.afc.b(this.afb.bf(i));
        List<com.kwad.framework.filedownloader.d.a> bg = this.afb.bg(i);
        this.afc.bh(i);
        for (com.kwad.framework.filedownloader.d.a aVar : bg) {
            this.afc.a(aVar);
        }
    }

    private boolean bl(int i) {
        if (!this.afe.contains(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    private void bm(int i) {
        this.handler.removeMessages(i);
        if (this.aff.get() == i) {
            this.afg = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        bk(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void be(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.afd);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bf(int i) {
        return this.afb.bf(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bg(int i) {
        return this.afb.bg(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bh(int i) {
        this.afb.bh(i);
        if (bl(i)) {
            return;
        }
        this.afc.bh(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bi(int i) {
        this.afc.bi(i);
        return this.afb.bi(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
        this.afb.bj(i);
        if (bl(i)) {
            return;
        }
        this.afc.bj(i);
    }

    public static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.afg = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        this.afb.c(i, j);
        if (bl(i)) {
            return;
        }
        this.afc.c(i, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void e(int i, long j) {
        this.afb.e(i, j);
        if (bl(i)) {
            bm(i);
        }
        this.afc.e(i, j);
        this.afe.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void u(int i, int i2) {
        this.afb.u(i, i2);
        if (bl(i)) {
            return;
        }
        this.afc.u(i, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        this.afb.a(i, i2, j);
        if (bl(i)) {
            return;
        }
        this.afc.a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        this.afb.a(i, j, str, str2);
        if (bl(i)) {
            return;
        }
        this.afc.a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        this.afb.a(i, str, j, j2, i2);
        if (bl(i)) {
            return;
        }
        this.afc.a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        this.afb.a(i, th);
        if (bl(i)) {
            return;
        }
        this.afc.a(i, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        this.afb.a(i, th, j);
        if (bl(i)) {
            bm(i);
        }
        this.afc.a(i, th, j);
        this.afe.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.afb.a(aVar);
        if (bl(aVar.getId())) {
            return;
        }
        this.afc.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.afb.b(cVar);
        if (bl(cVar.getId())) {
            return;
        }
        this.afc.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.afb.clear();
        this.afc.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0678a uV() {
        d dVar = this.afc;
        b bVar = this.afb;
        return dVar.a(bVar.aeY, bVar.aeZ);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        this.afb.d(i, j);
        if (bl(i)) {
            this.handler.removeMessages(i);
            if (this.aff.get() == i) {
                this.afg = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.afe.remove(Integer.valueOf(i));
        }
        this.afc.d(i, j);
        this.afe.remove(Integer.valueOf(i));
    }
}
