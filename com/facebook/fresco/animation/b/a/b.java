package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lOv = -1;
    @Nullable
    private b.a lOw;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lOx;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return this.lOv == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOx) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOx);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOx);
        dnr();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        boolean z;
        if (i == this.lOv) {
            z = com.facebook.common.references.a.a(this.lOx);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dnr();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lOx.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lOx != null) {
            }
        }
        com.facebook.common.references.a.c(this.lOx);
        if (this.lOw != null && this.lOv != -1) {
            this.lOw.b(this, this.lOv);
        }
        this.lOx = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lOw != null) {
            this.lOw.a(this, i);
        }
        this.lOv = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dnr() {
        if (this.lOw != null && this.lOv != -1) {
            this.lOw.b(this, this.lOv);
        }
        com.facebook.common.references.a.c(this.lOx);
        this.lOx = null;
        this.lOv = -1;
    }
}
