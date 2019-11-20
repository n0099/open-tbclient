package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a kgS = cFN().cFV();
    public final int kgT;
    public final boolean kgU;
    public final boolean kgV;
    public final boolean kgW;
    public final boolean kgX;
    public final Bitmap.Config kgY;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b kgZ;

    public a(b bVar) {
        this.kgT = bVar.cFO();
        this.kgU = bVar.cFP();
        this.kgV = bVar.cFQ();
        this.kgW = bVar.cFR();
        this.kgX = bVar.cFT();
        this.kgY = bVar.cFU();
        this.kgZ = bVar.cFS();
    }

    public static a cFM() {
        return kgS;
    }

    public static b cFN() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.kgU == aVar.kgU && this.kgV == aVar.kgV && this.kgW == aVar.kgW && this.kgX == aVar.kgX && this.kgY == aVar.kgY && this.kgZ == aVar.kgZ;
    }

    public int hashCode() {
        return (((((((this.kgW ? 1 : 0) + (((this.kgV ? 1 : 0) + (((this.kgU ? 1 : 0) + (this.kgT * 31)) * 31)) * 31)) * 31) + (this.kgX ? 1 : 0)) * 31) + this.kgY.ordinal()) * 31) + (this.kgZ != null ? this.kgZ.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.kgT), Boolean.valueOf(this.kgU), Boolean.valueOf(this.kgV), Boolean.valueOf(this.kgW), Boolean.valueOf(this.kgX), this.kgY.name(), this.kgZ);
    }
}
