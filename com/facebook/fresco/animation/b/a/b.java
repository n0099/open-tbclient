package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int mXk = -1;
    @Nullable
    private b.a mXl;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> mXm;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IR(int i) {
        return this.mXk == i ? com.facebook.common.references.a.b(this.mXm) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> IS(int i) {
        return com.facebook.common.references.a.b(this.mXm);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.mXm);
        dFj();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean IT(int i) {
        boolean z;
        if (i == this.mXk) {
            z = com.facebook.common.references.a.a(this.mXm);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dFj();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.mXm.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.mXm != null) {
            }
        }
        com.facebook.common.references.a.c(this.mXm);
        if (this.mXl != null && this.mXk != -1) {
            this.mXl.b(this, this.mXk);
        }
        this.mXm = com.facebook.common.references.a.b(aVar);
        if (this.mXl != null) {
            this.mXl.a(this, i);
        }
        this.mXk = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dFj() {
        if (this.mXl != null && this.mXk != -1) {
            this.mXl.b(this, this.mXk);
        }
        com.facebook.common.references.a.c(this.mXm);
        this.mXm = null;
        this.mXk = -1;
    }
}
