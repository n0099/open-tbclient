package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private int mcQ;
    private final Thread mcX;
    private final I[] mda;
    private final O[] mdb;
    private int mdc;
    private int mdd;
    private I mde;
    private boolean mdf;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mcY = new LinkedList<>();
    private final LinkedList<O> mcZ = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I dty();

    protected abstract O dtz();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bv(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mda = iArr;
        this.mdc = iArr.length;
        for (int i = 0; i < this.mdc; i++) {
            this.mda[i] = dty();
        }
        this.mdb = oArr;
        this.mdd = oArr.length;
        for (int i2 = 0; i2 < this.mdd; i2++) {
            this.mdb[i2] = dtz();
        }
        this.mcX = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mcX.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jl(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mdc == this.mda.length);
        for (I i2 : this.mda) {
            i2.Jj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dtt */
    public final I dtm() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            dtv();
            com.google.android.exoplayer2.util.a.checkState(this.mde == null);
            if (this.mdc == 0) {
                i = null;
            } else {
                I[] iArr = this.mda;
                int i3 = this.mdc - 1;
                this.mdc = i3;
                i = iArr[i3];
            }
            this.mde = i;
            i2 = this.mde;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            dtv();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mde);
            this.mcY.addLast(i);
            dtw();
            this.mde = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dtu */
    public final O dtn() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            dtv();
            removeFirst = this.mcZ.isEmpty() ? null : this.mcZ.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            dtw();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mdf = true;
            this.mcQ = 0;
            if (this.mde != null) {
                b((g<I, O, E>) this.mde);
                this.mde = null;
            }
            while (!this.mcY.isEmpty()) {
                b((g<I, O, E>) this.mcY.removeFirst());
            }
            while (!this.mcZ.isEmpty()) {
                b((g<I, O, E>) this.mcZ.removeFirst());
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
            this.mcX.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void dtv() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void dtw() {
        if (dtx()) {
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
        } while (auu());
    }

    private boolean auu() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !dtx()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mcY.removeFirst();
            O[] oArr = this.mdb;
            int i = this.mdd - 1;
            this.mdd = i;
            O o = oArr[i];
            boolean z = this.mdf;
            this.mdf = false;
            if (removeFirst.dth()) {
                o.aH(4);
            } else {
                if (removeFirst.dtg()) {
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
                if (this.mdf) {
                    b((g<I, O, E>) o);
                } else if (o.dtg()) {
                    this.mcQ++;
                    b((g<I, O, E>) o);
                } else {
                    o.mcQ = this.mcQ;
                    this.mcQ = 0;
                    this.mcZ.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean dtx() {
        return !this.mcY.isEmpty() && this.mdd > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mda;
        int i2 = this.mdc;
        this.mdc = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mdb;
        int i = this.mdd;
        this.mdd = i + 1;
        oArr[i] = o;
    }
}
