package com.facebook.fresco.animation.b.a;

import android.graphics.Bitmap;
import com.facebook.fresco.animation.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes14.dex */
public class b implements com.facebook.fresco.animation.b.b {
    private int oIc = -1;
    @Nullable
    private b.a oId;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> oIe;

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Ox(int i) {
        return this.oIc == i ? com.facebook.common.references.a.b(this.oIe) : null;
    }

    @Override // com.facebook.fresco.animation.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> Oy(int i) {
        return com.facebook.common.references.a.b(this.oIe);
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized com.facebook.common.references.a<Bitmap> af(int i, int i2, int i3) {
        com.facebook.common.references.a<Bitmap> b;
        b = com.facebook.common.references.a.b(this.oIe);
        eiZ();
        return b;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized boolean Oz(int i) {
        boolean z;
        if (i == this.oIc) {
            z = com.facebook.common.references.a.a(this.oIe);
        }
        return z;
    }

    @Override // com.facebook.fresco.animation.b.b
    public synchronized void clear() {
        eiZ();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4.get().equals(r2.oIe.get()) != false) goto L12;
     */
    @Override // com.facebook.fresco.animation.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
        if (aVar != null) {
            if (this.oIe != null) {
            }
        }
        com.facebook.common.references.a.c(this.oIe);
        if (this.oId != null && this.oIc != -1) {
            this.oId.b(this, this.oIc);
        }
        this.oIe = com.facebook.common.references.a.b(aVar);
        if (this.oId != null) {
            this.oId.a(this, i);
        }
        this.oIc = i;
    }

    @Override // com.facebook.fresco.animation.b.b
    public void b(int i, com.facebook.common.references.a<Bitmap> aVar, int i2) {
    }

    private synchronized void eiZ() {
        if (this.oId != null && this.oIc != -1) {
            this.oId.b(this, this.oIc);
        }
        com.facebook.common.references.a.c(this.oIe);
        this.oIe = null;
        this.oIc = -1;
    }
}
