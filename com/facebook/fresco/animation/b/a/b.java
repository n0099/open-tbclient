package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes7.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int oSY = -1;
    @Nullable
    private b.a oSZ;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> oTa;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pv(int i) {
        return this.oSY == i ? com.facebook.common.references.a.b(this.oTa) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Pw(int i) {
        return com.facebook.common.references.a.b(this.oTa);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ai(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.oTa);
        emM();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Px(int i) {
        boolean z;
        if (i == this.oSY) {
            z = com.facebook.common.references.a.a(this.oTa);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        emM();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.oTa.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.oTa != null) {
            }
        }
        com.facebook.common.references.a.c(this.oTa);
        if (this.oSZ != null && this.oSY != -1) {
            this.oSZ.b(this, this.oSY);
        }
        this.oTa = com.facebook.common.references.a.b(aVar);
        if (this.oSZ != null) {
            this.oSZ.a(this, i);
        }
        this.oSY = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void emM() {
        if (this.oSZ != null && this.oSY != -1) {
            this.oSZ.b(this, this.oSY);
        }
        com.facebook.common.references.a.c(this.oTa);
        this.oTa = null;
        this.oSY = -1;
    }
}
