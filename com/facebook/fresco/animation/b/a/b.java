package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lOt = -1;
    @Nullable
    private b.a lOu;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lOv;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HU(int i) {
        return this.lOt == i ? com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOv) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> HV(int i) {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOv);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ad(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOv);
        dnp();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean HW(int i) {
        boolean z;
        if (i == this.lOt) {
            z = com.facebook.common.references.a.a(this.lOv);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dnp();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lOv.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lOv != null) {
            }
        }
        com.facebook.common.references.a.c(this.lOv);
        if (this.lOu != null && this.lOt != -1) {
            this.lOu.b(this, this.lOt);
        }
        this.lOv = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        if (this.lOu != null) {
            this.lOu.a(this, i);
        }
        this.lOt = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dnp() {
        if (this.lOu != null && this.lOt != -1) {
            this.lOu.b(this, this.lOt);
        }
        com.facebook.common.references.a.c(this.lOv);
        this.lOv = null;
        this.lOt = -1;
    }
}
