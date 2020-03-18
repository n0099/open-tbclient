package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private E exception;
    private final O[] mfA;
    private int mfB;
    private int mfC;
    private I mfD;
    private boolean mfE;
    private int mfp;
    private final Thread mfw;
    private final I[] mfz;
    private boolean released;
    private final Object lock = new Object();
    private final LinkedList<I> mfx = new LinkedList<>();
    private final LinkedList<O> mfy = new LinkedList<>();

    protected abstract E a(I i, O o, boolean z);

    protected abstract I dvj();

    protected abstract O dvk();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.a.g<I extends com.google.android.exoplayer2.a.e, O extends com.google.android.exoplayer2.a.f, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.a.c
    public /* synthetic */ void bx(Object obj) throws Exception {
        a((g<I, O, E>) ((e) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(I[] iArr, O[] oArr) {
        this.mfz = iArr;
        this.mfB = iArr.length;
        for (int i = 0; i < this.mfB; i++) {
            this.mfz[i] = dvj();
        }
        this.mfA = oArr;
        this.mfC = oArr.length;
        for (int i2 = 0; i2 < this.mfC; i2++) {
            this.mfA[i2] = dvk();
        }
        this.mfw = new Thread() { // from class: com.google.android.exoplayer2.a.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                g.this.run();
            }
        };
        this.mfw.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Jw(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mfB == this.mfz.length);
        for (I i2 : this.mfz) {
            i2.Ju(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dve */
    public final I duX() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            dvg();
            com.google.android.exoplayer2.util.a.checkState(this.mfD == null);
            if (this.mfB == 0) {
                i = null;
            } else {
                I[] iArr = this.mfz;
                int i3 = this.mfB - 1;
                this.mfB = i3;
                i = iArr[i3];
            }
            this.mfD = i;
            i2 = this.mfD;
        }
        return i2;
    }

    public final void a(I i) throws Exception {
        synchronized (this.lock) {
            dvg();
            com.google.android.exoplayer2.util.a.checkArgument(i == this.mfD);
            this.mfx.addLast(i);
            dvh();
            this.mfD = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.a.c
    /* renamed from: dvf */
    public final O duY() throws Exception {
        O removeFirst;
        synchronized (this.lock) {
            dvg();
            removeFirst = this.mfy.isEmpty() ? null : this.mfy.removeFirst();
        }
        return removeFirst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b((g<I, O, E>) o);
            dvh();
        }
    }

    @Override // com.google.android.exoplayer2.a.c
    public final void flush() {
        synchronized (this.lock) {
            this.mfE = true;
            this.mfp = 0;
            if (this.mfD != null) {
                b((g<I, O, E>) this.mfD);
                this.mfD = null;
            }
            while (!this.mfx.isEmpty()) {
                b((g<I, O, E>) this.mfx.removeFirst());
            }
            while (!this.mfy.isEmpty()) {
                b((g<I, O, E>) this.mfy.removeFirst());
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
            this.mfw.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void dvg() throws Exception {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void dvh() {
        if (dvi()) {
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
        } while (awN());
    }

    private boolean awN() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !dvi()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.mfx.removeFirst();
            O[] oArr = this.mfA;
            int i = this.mfC - 1;
            this.mfC = i;
            O o = oArr[i];
            boolean z = this.mfE;
            this.mfE = false;
            if (removeFirst.duS()) {
                o.aK(4);
            } else {
                if (removeFirst.duR()) {
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
                if (this.mfE) {
                    b((g<I, O, E>) o);
                } else if (o.duR()) {
                    this.mfp++;
                    b((g<I, O, E>) o);
                } else {
                    o.mfp = this.mfp;
                    this.mfp = 0;
                    this.mfy.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean dvi() {
        return !this.mfx.isEmpty() && this.mfC > 0;
    }

    private void b(I i) {
        i.clear();
        I[] iArr = this.mfz;
        int i2 = this.mfB;
        this.mfB = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.mfA;
        int i = this.mfC;
        this.mfC = i + 1;
        oArr[i] = o;
    }
}
