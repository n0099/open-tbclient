package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int puL = -1;
    @Nullable
    private b.a puM;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> puN;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OY(int i) {
        return this.puL == i ? com.facebook.common.references.a.b(this.puN) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OZ(int i) {
        return com.facebook.common.references.a.b(this.puN);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ak(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b2;
        b2 = com.facebook.common.references.a.b(this.puN);
        esQ();
        return b2;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Pa(int i) {
        boolean z;
        if (i == this.puL) {
            z = com.facebook.common.references.a.a(this.puN);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        esQ();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.puN.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.puN != null) {
            }
        }
        com.facebook.common.references.a.c(this.puN);
        if (this.puM != null && this.puL != -1) {
            this.puM.b(this, this.puL);
        }
        this.puN = com.facebook.common.references.a.b(aVar);
        if (this.puM != null) {
            this.puM.a(this, i);
        }
        this.puL = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void esQ() {
        if (this.puM != null && this.puL != -1) {
            this.puM.b(this, this.puL);
        }
        com.facebook.common.references.a.c(this.puN);
        this.puN = null;
        this.puL = -1;
    }
}
