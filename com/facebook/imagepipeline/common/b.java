package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pxA = etL().etT();
    public final Bitmap.Config bitmapConfig;
    public final int pxB;
    public final boolean pxC;
    public final boolean pxD;
    public final boolean pxE;
    public final boolean pxF;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pxG;

    public b(c cVar) {
        this.pxB = cVar.etM();
        this.pxC = cVar.etN();
        this.pxD = cVar.etO();
        this.pxE = cVar.etP();
        this.pxF = cVar.etR();
        this.bitmapConfig = cVar.etS();
        this.pxG = cVar.etQ();
    }

    public static b etK() {
        return pxA;
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
        return this.pxC == bVar.pxC && this.pxD == bVar.pxD && this.pxE == bVar.pxE && this.pxF == bVar.pxF && this.bitmapConfig == bVar.bitmapConfig && this.pxG == bVar.pxG;
    }

    public int hashCode() {
        return (((((((this.pxE ? 1 : 0) + (((this.pxD ? 1 : 0) + (((this.pxC ? 1 : 0) + (this.pxB * 31)) * 31)) * 31)) * 31) + (this.pxF ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pxG != null ? this.pxG.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pxB), Boolean.valueOf(this.pxC), Boolean.valueOf(this.pxD), Boolean.valueOf(this.pxE), Boolean.valueOf(this.pxF), this.bitmapConfig.name(), this.pxG);
    }
}
