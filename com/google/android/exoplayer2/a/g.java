package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private int mcL;
    private final Thread mcS;
    private final I[] mcV;
    private final O[] mcW;
    private int mcX;
    private int mcY;
    private I mcZ;
    private boolean mda;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mcT = new LinkedList<>();
    private final LinkedList<O> mcU = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I dtw();

    protected abstract O dtx();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bv(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mcV = iArr;
        this.mcX = iArr.length;
        for (int i = 0; i < this.mcX; i++) {
            this.mcV[i] = dtw();
        }
        this.mcW = oArr;
        this.mcY = oArr.length;
        for (int i2 = 0; i2 < this.mcY; i2++) {
            this.mcW[i2] = dtx();
        }
        this.mcS = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mcS.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jl(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mcX == this.mcV.length);
        for (I i2 : this.mcV) {
            i2.Jj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dtr */
    public final I dtk() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            dtt();
            com.google.android.exoplayer2.util.a.checkState(this.mcZ == null);
            if (this.mcX == 0) {
                i = null;
            } else {
                I[] iArr = this.mcV;
                int i3 = this.mcX - 1;
                this.mcX = i3;
                i = iArr[i3];
            }
            this.mcZ = i;
            i2 = this.mcZ;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            dtt();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mcZ);
            this.mcT.addLast(i);
            dtu();
            this.mcZ = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dts */
    public final O dtl() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            dtt();
            removeFirst = this.mcU.isEmpty() ? null : this.mcU.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            dtu();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mda = true;
            this.mcL = 0;
            if (this.mcZ != null) {
                b((g<I, O, E>) this.mcZ);
                this.mcZ = null;
            }
            while (!this.mcT.isEmpty()) {
                b((g<I, O, E>) this.mcT.removeFirst());
            }
            while (!this.mcU.isEmpty()) {
                b((g<I, O, E>) this.mcU.removeFirst());
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
            this.mcS.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void dtt() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void dtu() {
        if (dtv()) {
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
            while (!this.released && !dtv()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mcT.removeFirst();
            O[] oArr = this.mcW;
            int i = this.mcY - 1;
            this.mcY = i;
            O o = oArr[i];
            boolean z = this.mda;
            this.mda = false;
            if (removeFirst.dtf()) {
                o.aH(4);
            } else {
                if (removeFirst.dte()) {
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
                if (this.mda) {
                    b((g<I, O, E>) o);
                } else if (o.dte()) {
                    this.mcL++;
                    b((g<I, O, E>) o);
                } else {
                    o.mcL = this.mcL;
                    this.mcL = 0;
                    this.mcU.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean dtv() {
        return !this.mcT.isEmpty() && this.mcY > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mcV;
        int i2 = this.mcX;
        this.mcX = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mcW;
        int i = this.mcY;
        this.mcY = i + 1;
        oArr[i] = o;
    }
}
