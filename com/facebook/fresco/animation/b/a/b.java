package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mXm = -1;
    @Nullable
    private b.a mXn;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mXo;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IR(int i) {
        return this.mXm == i ? com.facebook.common.references.a.b(this.mXo) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IS(int i) {
        return com.facebook.common.references.a.b(this.mXo);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mXo);
        dFk();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean IT(int i) {
        boolean z;
        if (i == this.mXm) {
            z = com.facebook.common.references.a.a(this.mXo);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dFk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mXo.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mXo != null) {
            }
        }
        com.facebook.common.references.a.c(this.mXo);
        if (this.mXn != null && this.mXm != -1) {
            this.mXn.b(this, this.mXm);
        }
        this.mXo = com.facebook.common.references.a.b(aVar);
        if (this.mXn != null) {
            this.mXn.a(this, i);
        }
        this.mXm = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dFk() {
        if (this.mXn != null && this.mXm != -1) {
            this.mXn.b(this, this.mXm);
        }
        com.facebook.common.references.a.c(this.mXo);
        this.mXo = null;
        this.mXm = -1;
    }
}
