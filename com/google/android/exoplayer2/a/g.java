package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private final Thread mdF;
    private final I[] mdI;
    private final O[] mdJ;
    private int mdK;
    private int mdL;
    private I mdM;
    private boolean mdN;
    private int mdy;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mdG = new LinkedList<>();
    private final LinkedList<O> mdH = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I duL();

    protected abstract O duM();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bx(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mdI = iArr;
        this.mdK = iArr.length;
        for (int i = 0; i < this.mdK; i++) {
            this.mdI[i] = duL();
        }
        this.mdJ = oArr;
        this.mdL = oArr.length;
        for (int i2 = 0; i2 < this.mdL; i2++) {
            this.mdJ[i2] = duM();
        }
        this.mdF = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mdF.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jq(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mdK == this.mdI.length);
        for (I i2 : this.mdI) {
            i2.Jo(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duG */
    public final I duz() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            duI();
            com.google.android.exoplayer2.util.a.checkState(this.mdM == null);
            if (this.mdK == 0) {
                i = null;
            } else {
                I[] iArr = this.mdI;
                int i3 = this.mdK - 1;
                this.mdK = i3;
                i = iArr[i3];
            }
            this.mdM = i;
            i2 = this.mdM;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            duI();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mdM);
            this.mdG.addLast(i);
            duJ();
            this.mdM = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duH */
    public final O duA() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            duI();
            removeFirst = this.mdH.isEmpty() ? null : this.mdH.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            duJ();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mdN = true;
            this.mdy = 0;
            if (this.mdM != null) {
                b((g<I, O, E>) this.mdM);
                this.mdM = null;
            }
            while (!this.mdG.isEmpty()) {
                b((g<I, O, E>) this.mdG.removeFirst());
            }
            while (!this.mdH.isEmpty()) {
                b((g<I, O, E>) this.mdH.removeFirst());
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
            this.mdF.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void duI() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void duJ() {
        if (duK()) {
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
            while (!this.released && !duK()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mdG.removeFirst();
            O[] oArr = this.mdJ;
            int i = this.mdL - 1;
            this.mdL = i;
            O o = oArr[i];
            boolean z = this.mdN;
            this.mdN = false;
            if (removeFirst.duu()) {
                o.aK(4);
            } else {
                if (removeFirst.dut()) {
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
                if (this.mdN) {
                    b((g<I, O, E>) o);
                } else if (o.dut()) {
                    this.mdy++;
                    b((g<I, O, E>) o);
                } else {
                    o.mdy = this.mdy;
                    this.mdy = 0;
                    this.mdH.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean duK() {
        return !this.mdG.isEmpty() && this.mdL > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mdI;
        int i2 = this.mdK;
        this.mdK = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mdJ;
        int i = this.mdL;
        this.mdL = i + 1;
        oArr[i] = o;
    }
}
