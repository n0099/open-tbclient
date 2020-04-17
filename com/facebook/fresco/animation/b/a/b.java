package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int lXR = -1;
    @Nullable
    private b.a lXS;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> lXT;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GB(int i) {
        return this.lXR == i ? com.facebook.common.references.a.b(this.lXT) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> GC(int i) {
        return com.facebook.common.references.a.b(this.lXT);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> ae(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.lXT);
        dpN();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean GD(int i) {
        boolean z;
        if (i == this.lXR) {
            z = com.facebook.common.references.a.a(this.lXT);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        dpN();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.lXT.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.lXT != null) {
            }
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXT);
        if (this.lXS != null && this.lXR != -1) {
            this.lXS.b(this, this.lXR);
        }
        this.lXT = com.facebook.common.references.a.b(aVar);
        if (this.lXS != null) {
            this.lXS.a(this, i);
        }
        this.lXR = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void dpN() {
        if (this.lXS != null && this.lXR != -1) {
            this.lXS.b(this, this.lXR);
        }
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lXT);
        this.lXT = null;
        this.lXR = -1;
    }
}
