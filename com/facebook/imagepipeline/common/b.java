package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b lQL = dmY().dng();
    public final Bitmap.Config bitmapConfig;
    public final int lQM;
    public final boolean lQN;
    public final boolean lQO;
    public final boolean lQP;
    public final boolean lQQ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lQR;

    public b(c cVar) {
        this.lQM = cVar.dmZ();
        this.lQN = cVar.dna();
        this.lQO = cVar.dnb();
        this.lQP = cVar.dnc();
        this.lQQ = cVar.dne();
        this.bitmapConfig = cVar.dnf();
        this.lQR = cVar.dnd();
    }

    public static b dmX() {
        return lQL;
    }

    public static c dmY() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.lQN == bVar.lQN && this.lQO == bVar.lQO && this.lQP == bVar.lQP && this.lQQ == bVar.lQQ && this.bitmapConfig == bVar.bitmapConfig && this.lQR == bVar.lQR;
    }

    public int hashCode() {
        return (((((((this.lQP ? 1 : 0) + (((this.lQO ? 1 : 0) + (((this.lQN ? 1 : 0) + (this.lQM * 31)) * 31)) * 31)) * 31) + (this.lQQ ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lQR != null ? this.lQR.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lQM), Boolean.valueOf(this.lQN), Boolean.valueOf(this.lQO), Boolean.valueOf(this.lQP), Boolean.valueOf(this.lQQ), this.bitmapConfig.name(), this.lQR);
    }
}
