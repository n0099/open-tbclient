package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mta = -1;
    @Nullable
    private b.a mtb;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mtc;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hp(int i) {
        return this.mta == i ? com.facebook.common.references.a.b(this.mtc) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Hq(int i) {
        return com.facebook.common.references.a.b(this.mtc);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mtc);
        dxr();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Hr(int i) {
        boolean z;
        if (i == this.mta) {
            z = com.facebook.common.references.a.a(this.mtc);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dxr();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mtc.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mtc != null) {
            }
        }
        com.facebook.common.references.a.c(this.mtc);
        if (this.mtb != null && this.mta != -1) {
            this.mtb.b(this, this.mta);
        }
        this.mtc = com.facebook.common.references.a.b(aVar);
        if (this.mtb != null) {
            this.mtb.a(this, i);
        }
        this.mta = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dxr() {
        if (this.mtb != null && this.mta != -1) {
            this.mtb.b(this, this.mta);
        }
        com.facebook.common.references.a.c(this.mtc);
        this.mtc = null;
        this.mta = -1;
    }
}
