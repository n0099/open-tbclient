package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private int lYT;
    private final Thread lZa;
    private final I[] lZd;
    private final O[] lZe;
    private int lZf;
    private int lZg;
    private I lZh;
    private boolean lZi;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> lZb = new LinkedList<>();
    private final LinkedList<O> lZc = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I dsk();

    protected abstract O dsl();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bu(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.lZd = iArr;
        this.lZf = iArr.length;
        for (int i = 0; i < this.lZf; i++) {
            this.lZd[i] = dsk();
        }
        this.lZe = oArr;
        this.lZg = oArr.length;
        for (int i2 = 0; i2 < this.lZg; i2++) {
            this.lZe[i2] = dsl();
        }
        this.lZa = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.lZa.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jc(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.lZf == this.lZd.length);
        for (I i2 : this.lZd) {
            i2.Ja(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dsf */
    public final I drY() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            dsh();
            com.google.android.exoplayer2.util.a.checkState(this.lZh == null);
            if (this.lZf == 0) {
                i = null;
            } else {
                I[] iArr = this.lZd;
                int i3 = this.lZf - 1;
                this.lZf = i3;
                i = iArr[i3];
            }
            this.lZh = i;
            i2 = this.lZh;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            dsh();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.lZh);
            this.lZb.addLast(i);
            dsi();
            this.lZh = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dsg */
    public final O drZ() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            dsh();
            removeFirst = this.lZc.isEmpty() ? null : this.lZc.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            dsi();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.lZi = true;
            this.lYT = 0;
            if (this.lZh != null) {
                b((g<I, O, E>) this.lZh);
                this.lZh = null;
            }
            while (!this.lZb.isEmpty()) {
                b((g<I, O, E>) this.lZb.removeFirst());
            }
            while (!this.lZc.isEmpty()) {
                b((g<I, O, E>) this.lZc.removeFirst());
            }
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.lZa.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void dsh() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void dsi() {
        if (dsj()) {
            this.lock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (aub());
    }

    private boolean aub() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !dsj()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.lZb.removeFirst();
            O[] oArr = this.lZe;
            int i = this.lZg - 1;
            this.lZg = i;
            O o = oArr[i];
            boolean z = this.lZi;
            this.lZi = false;
            if (removeFirst.drT()) {
                o.aH(4);
            } else {
                if (removeFirst.drS()) {
                    o.aH(Integer.MIN_VALUE);
                }
                this.exception = a(removeFirst, o, z);
                if (this.exception != null) {
                    synchronized (this.lock) {
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                if (this.lZi) {
                    b((g<I, O, E>) o);
                } else if (o.drS()) {
                    this.lYT++;
                    b((g<I, O, E>) o);
                } else {
                    o.lYT = this.lYT;
                    this.lYT = 0;
                    this.lZc.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean dsj() {
        return !this.lZb.isEmpty() && this.lZg > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.lZd;
        int i2 = this.lZf;
        this.lZf = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.lZe;
        int i = this.lZg;
        this.lZg = i + 1;
        oArr[i] = o;
    }
}
