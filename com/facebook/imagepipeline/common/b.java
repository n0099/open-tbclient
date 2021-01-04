package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes6.dex */
public class b {
    private static final b pAu = exb().exj();
    public final Bitmap.Config bitmapConfig;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pAA;
    public final int pAv;
    public final boolean pAw;
    public final boolean pAx;
    public final boolean pAy;
    public final boolean pAz;

    public b(c cVar) {
        this.pAv = cVar.exc();
        this.pAw = cVar.exd();
        this.pAx = cVar.exe();
        this.pAy = cVar.exf();
        this.pAz = cVar.exh();
        this.bitmapConfig = cVar.exi();
        this.pAA = cVar.exg();
    }

    public static b exa() {
        return pAu;
    }

    public static c exb() {
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
        return this.pAw == bVar.pAw && this.pAx == bVar.pAx && this.pAy == bVar.pAy && this.pAz == bVar.pAz && this.bitmapConfig == bVar.bitmapConfig && this.pAA == bVar.pAA;
    }

    public int hashCode() {
        return (((((((this.pAy ? 1 : 0) + (((this.pAx ? 1 : 0) + (((this.pAw ? 1 : 0) + (this.pAv * 31)) * 31)) * 31)) * 31) + (this.pAz ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pAA != null ? this.pAA.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pAv), Boolean.valueOf(this.pAw), Boolean.valueOf(this.pAx), Boolean.valueOf(this.pAy), Boolean.valueOf(this.pAz), this.bitmapConfig.name(), this.pAA);
    }
}
