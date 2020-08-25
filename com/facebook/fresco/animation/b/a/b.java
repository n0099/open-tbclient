package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int nrb = -1;
    @Nullable
    private b.a nrc;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> nrd;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lv(int i) {
        return this.nrb == i ? com.facebook.common.references.a.b(this.nrd) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Lw(int i) {
        return com.facebook.common.references.a.b(this.nrd);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ab(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.nrd);
        dRj();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Lx(int i) {
        boolean z;
        if (i == this.nrb) {
            z = com.facebook.common.references.a.a(this.nrd);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dRj();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.nrd.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.nrd != null) {
            }
        }
        com.facebook.common.references.a.c(this.nrd);
        if (this.nrc != null && this.nrb != -1) {
            this.nrc.b(this, this.nrb);
        }
        this.nrd = com.facebook.common.references.a.b(aVar);
        if (this.nrc != null) {
            this.nrc.a(this, i);
        }
        this.nrb = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dRj() {
        if (this.nrc != null && this.nrb != -1) {
            this.nrc.b(this, this.nrb);
        }
        com.facebook.common.references.a.c(this.nrd);
        this.nrd = null;
        this.nrb = -1;
    }
}
