package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pCb = exD().exL();
    public final Bitmap.Config bitmapConfig;
    public final int pCc;
    public final boolean pCd;
    public final boolean pCe;
    public final boolean pCf;
    public final boolean pCg;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pCh;

    public b(c cVar) {
        this.pCc = cVar.exE();
        this.pCd = cVar.exF();
        this.pCe = cVar.exG();
        this.pCf = cVar.exH();
        this.pCg = cVar.exJ();
        this.bitmapConfig = cVar.exK();
        this.pCh = cVar.exI();
    }

    public static b exC() {
        return pCb;
    }

    public static c exD() {
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
        return this.pCd == bVar.pCd && this.pCe == bVar.pCe && this.pCf == bVar.pCf && this.pCg == bVar.pCg && this.bitmapConfig == bVar.bitmapConfig && this.pCh == bVar.pCh;
    }

    public int hashCode() {
        return (((((((this.pCf ? 1 : 0) + (((this.pCe ? 1 : 0) + (((this.pCd ? 1 : 0) + (this.pCc * 31)) * 31)) * 31)) * 31) + (this.pCg ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pCh != null ? this.pCh.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pCc), Boolean.valueOf(this.pCd), Boolean.valueOf(this.pCe), Boolean.valueOf(this.pCf), Boolean.valueOf(this.pCg), this.bitmapConfig.name(), this.pCh);
    }
}
