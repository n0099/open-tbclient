package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int oRv = -1;
    @Nullable
    private b.a oRw;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> oRx;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OS(int i) {
        return this.oRv == i ? com.facebook.common.references.a.b(this.oRx) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> OT(int i) {
        return com.facebook.common.references.a.b(this.oRx);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> af(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.oRx);
        emO();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean OU(int i) {
        boolean z;
        if (i == this.oRv) {
            z = com.facebook.common.references.a.a(this.oRx);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        emO();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.oRx.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.oRx != null) {
            }
        }
        com.facebook.common.references.a.c(this.oRx);
        if (this.oRw != null && this.oRv != -1) {
            this.oRw.b(this, this.oRv);
        }
        this.oRx = com.facebook.common.references.a.b(aVar);
        if (this.oRw != null) {
            this.oRw.a(this, i);
        }
        this.oRv = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void emO() {
        if (this.oRw != null && this.oRv != -1) {
            this.oRw.b(this, this.oRv);
        }
        com.facebook.common.references.a.c(this.oRx);
        this.oRx = null;
        this.oRv = -1;
    }
}
