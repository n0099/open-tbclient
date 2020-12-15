package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int phW = -1;
    @Nullable
    private b.a phX;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> phY;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qr(int i) {
        return this.phW == i ? com.facebook.common.references.a.b(this.phY) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Qs(int i) {
        return com.facebook.common.references.a.b(this.phY);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ah(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.phY);
        esy();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Qt(int i) {
        boolean z;
        if (i == this.phW) {
            z = com.facebook.common.references.a.a(this.phY);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        esy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.phY.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.phY != null) {
            }
        }
        com.facebook.common.references.a.c(this.phY);
        if (this.phX != null && this.phW != -1) {
            this.phX.b(this, this.phW);
        }
        this.phY = com.facebook.common.references.a.b(aVar);
        if (this.phX != null) {
            this.phX.a(this, i);
        }
        this.phW = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void esy() {
        if (this.phX != null && this.phW != -1) {
            this.phX.b(this, this.phW);
        }
        com.facebook.common.references.a.c(this.phY);
        this.phY = null;
        this.phW = -1;
    }
}
