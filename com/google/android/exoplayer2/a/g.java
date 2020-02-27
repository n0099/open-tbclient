package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private final Thread mdD;
    private final I[] mdG;
    private final O[] mdH;
    private int mdI;
    private int mdJ;
    private I mdK;
    private boolean mdL;
    private int mdw;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mdE = new LinkedList<>();
    private final LinkedList<O> mdF = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I duJ();

    protected abstract O duK();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bx(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mdG = iArr;
        this.mdI = iArr.length;
        for (int i = 0; i < this.mdI; i++) {
            this.mdG[i] = duJ();
        }
        this.mdH = oArr;
        this.mdJ = oArr.length;
        for (int i2 = 0; i2 < this.mdJ; i2++) {
            this.mdH[i2] = duK();
        }
        this.mdD = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mdD.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jq(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mdI == this.mdG.length);
        for (I i2 : this.mdG) {
            i2.Jo(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duE */
    public final I dux() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            duG();
            com.google.android.exoplayer2.util.a.checkState(this.mdK == null);
            if (this.mdI == 0) {
                i = null;
            } else {
                I[] iArr = this.mdG;
                int i3 = this.mdI - 1;
                this.mdI = i3;
                i = iArr[i3];
            }
            this.mdK = i;
            i2 = this.mdK;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            duG();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mdK);
            this.mdE.addLast(i);
            duH();
            this.mdK = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: duF */
    public final O duy() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            duG();
            removeFirst = this.mdF.isEmpty() ? null : this.mdF.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            duH();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mdL = true;
            this.mdw = 0;
            if (this.mdK != null) {
                b((g<I, O, E>) this.mdK);
                this.mdK = null;
            }
            while (!this.mdE.isEmpty()) {
                b((g<I, O, E>) this.mdE.removeFirst());
            }
            while (!this.mdF.isEmpty()) {
                b((g<I, O, E>) this.mdF.removeFirst());
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
            this.mdD.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void duG() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void duH() {
        if (duI()) {
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
        } while (awI());
    }

    private boolean awI() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !duI()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mdE.removeFirst();
            O[] oArr = this.mdH;
            int i = this.mdJ - 1;
            this.mdJ = i;
            O o = oArr[i];
            boolean z = this.mdL;
            this.mdL = false;
            if (removeFirst.dus()) {
                o.aK(4);
            } else {
                if (removeFirst.dur()) {
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
                if (this.mdL) {
                    b((g<I, O, E>) o);
                } else if (o.dur()) {
                    this.mdw++;
                    b((g<I, O, E>) o);
                } else {
                    o.mdw = this.mdw;
                    this.mdw = 0;
                    this.mdF.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean duI() {
        return !this.mdE.isEmpty() && this.mdJ > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mdG;
        int i2 = this.mdI;
        this.mdI = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mdH;
        int i = this.mdJ;
        this.mdJ = i + 1;
        oArr[i] = o;
    }
}
