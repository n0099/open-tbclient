package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private int mdJ;
    private final Thread mdQ;
    private final I[] mdT;
    private final O[] mdU;
    private int mdV;
    private int mdW;
    private I mdX;
    private boolean mdY;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mdR = new LinkedList<>();
    private final LinkedList<O> mdS = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I duM();

    protected abstract O duN();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bx(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mdT = iArr;
        this.mdV = iArr.length;
        for (int i = 0; i < this.mdV; i++) {
            this.mdT[i] = duM();
        }
        this.mdU = oArr;
        this.mdW = oArr.length;
        for (int i2 = 0; i2 < this.mdW; i2++) {
            this.mdU[i2] = duN();
        }
        this.mdQ = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mdQ.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jq(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mdV == this.mdT.length);
        for (I i2 : this.mdT) {
            i2.Jo(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duH */
    public final I duA() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            duJ();
            com.google.android.exoplayer2.util.a.checkState(this.mdX == null);
            if (this.mdV == 0) {
                i = null;
            } else {
                I[] iArr = this.mdT;
                int i3 = this.mdV - 1;
                this.mdV = i3;
                i = iArr[i3];
            }
            this.mdX = i;
            i2 = this.mdX;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            duJ();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mdX);
            this.mdR.addLast(i);
            duK();
            this.mdX = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duI */
    public final O duB() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            duJ();
            removeFirst = this.mdS.isEmpty() ? null : this.mdS.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            duK();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mdY = true;
            this.mdJ = 0;
            if (this.mdX != null) {
                b((g<I, O, E>) this.mdX);
                this.mdX = null;
            }
            while (!this.mdR.isEmpty()) {
                b((g<I, O, E>) this.mdR.removeFirst());
            }
            while (!this.mdS.isEmpty()) {
                b((g<I, O, E>) this.mdS.removeFirst());
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
            this.mdQ.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void duJ() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void duK() {
        if (duL()) {
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
        } while (awK());
    }

    private boolean awK() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !duL()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mdR.removeFirst();
            O[] oArr = this.mdU;
            int i = this.mdW - 1;
            this.mdW = i;
            O o = oArr[i];
            boolean z = this.mdY;
            this.mdY = false;
            if (removeFirst.duv()) {
                o.aK(4);
            } else {
                if (removeFirst.duu()) {
                    o.aK(Integer.MIN_VALUE);
                }
                this.exception = a(removeFirst, o, z);
                if (this.exception != null) {
                    synchronized (this.lock) {
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                if (this.mdY) {
                    b((g<I, O, E>) o);
                } else if (o.duu()) {
                    this.mdJ++;
                    b((g<I, O, E>) o);
                } else {
                    o.mdJ = this.mdJ;
                    this.mdJ = 0;
                    this.mdS.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean duL() {
        return !this.mdR.isEmpty() && this.mdW > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mdT;
        int i2 = this.mdV;
        this.mdV = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mdU;
        int i = this.mdW;
        this.mdW = i + 1;
        oArr[i] = o;
    }
}
