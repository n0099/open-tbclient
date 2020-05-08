package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lXV = -1;
    @Nullable
    private b.a lXW;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lXX;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GB(int i) {
        return this.lXV == i ? com.facebook.common.references.a.b(this.lXX) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GC(int i) {
        return com.facebook.common.references.a.b(this.lXX);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.lXX);
        dpK();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean GD(int i) {
        boolean z;
        if (i == this.lXV) {
            z = com.facebook.common.references.a.a(this.lXX);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dpK();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lXX.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lXX != null) {
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXX);
        if (this.lXW != null && this.lXV != -1) {
            this.lXW.b(this, this.lXV);
        }
        this.lXX = com.facebook.common.references.a.b(aVar);
        if (this.lXW != null) {
            this.lXW.a(this, i);
        }
        this.lXV = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dpK() {
        if (this.lXW != null && this.lXV != -1) {
            this.lXW.b(this, this.lXV);
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXX);
        this.lXX = null;
        this.lXV = -1;
    }
}
