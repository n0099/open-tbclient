package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pxB = etL().etT();
    public final Bitmap.Config bitmapConfig;
    public final int pxC;
    public final boolean pxD;
    public final boolean pxE;
    public final boolean pxF;
    public final boolean pxG;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pxH;

    public b(c cVar) {
        this.pxC = cVar.etM();
        this.pxD = cVar.etN();
        this.pxE = cVar.etO();
        this.pxF = cVar.etP();
        this.pxG = cVar.etR();
        this.bitmapConfig = cVar.etS();
        this.pxH = cVar.etQ();
    }

    public static b etK() {
        return pxB;
    }

    public static c etL() {
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
        return this.pxD == bVar.pxD && this.pxE == bVar.pxE && this.pxF == bVar.pxF && this.pxG == bVar.pxG && this.bitmapConfig == bVar.bitmapConfig && this.pxH == bVar.pxH;
    }

    public int hashCode() {
        return (((((((this.pxF ? 1 : 0) + (((this.pxE ? 1 : 0) + (((this.pxD ? 1 : 0) + (this.pxC * 31)) * 31)) * 31)) * 31) + (this.pxG ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pxH != null ? this.pxH.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pxC), Boolean.valueOf(this.pxD), Boolean.valueOf(this.pxE), Boolean.valueOf(this.pxF), Boolean.valueOf(this.pxG), this.bitmapConfig.name(), this.pxH);
    }
}
