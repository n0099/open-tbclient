package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a kfU = cHJ().cHR();
    public final int kfV;
    public final boolean kfW;
    public final boolean kfX;
    public final boolean kfY;
    public final boolean kfZ;
    public final Bitmap.Config kga;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b kgb;

    public a(b bVar) {
        this.kfV = bVar.cHK();
        this.kfW = bVar.cHL();
        this.kfX = bVar.cHM();
        this.kfY = bVar.cHN();
        this.kfZ = bVar.cHP();
        this.kga = bVar.cHQ();
        this.kgb = bVar.cHO();
    }

    public static a cHI() {
        return kfU;
    }

    public static b cHJ() {
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
        return this.kfW == aVar.kfW && this.kfX == aVar.kfX && this.kfY == aVar.kfY && this.kfZ == aVar.kfZ && this.kga == aVar.kga && this.kgb == aVar.kgb;
    }

    public int hashCode() {
        return (((((((this.kfY ? 1 : 0) + (((this.kfX ? 1 : 0) + (((this.kfW ? 1 : 0) + (this.kfV * 31)) * 31)) * 31)) * 31) + (this.kfZ ? 1 : 0)) * 31) + this.kga.ordinal()) * 31) + (this.kgb != null ? this.kgb.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.kfV), Boolean.valueOf(this.kfW), Boolean.valueOf(this.kfX), Boolean.valueOf(this.kfY), Boolean.valueOf(this.kfZ), this.kga.name(), this.kgb);
    }
}
