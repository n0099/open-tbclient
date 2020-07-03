package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b mSb = dCQ().dCY();
    public final int mSc;
    public final boolean mSd;
    public final boolean mSe;
    public final boolean mSf;
    public final boolean mSg;
    public final Bitmap.Config mSh;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b mSi;

    public b(c cVar) {
        this.mSc = cVar.dCR();
        this.mSd = cVar.dCS();
        this.mSe = cVar.dCT();
        this.mSf = cVar.dCU();
        this.mSg = cVar.dCW();
        this.mSh = cVar.dCX();
        this.mSi = cVar.dCV();
    }

    public static b dCP() {
        return mSb;
    }

    public static c dCQ() {
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
        return this.mSd == bVar.mSd && this.mSe == bVar.mSe && this.mSf == bVar.mSf && this.mSg == bVar.mSg && this.mSh == bVar.mSh && this.mSi == bVar.mSi;
    }

    public int hashCode() {
        return (((((((this.mSf ? 1 : 0) + (((this.mSe ? 1 : 0) + (((this.mSd ? 1 : 0) + (this.mSc * 31)) * 31)) * 31)) * 31) + (this.mSg ? 1 : 0)) * 31) + this.mSh.ordinal()) * 31) + (this.mSi != null ? this.mSi.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.mSc), Boolean.valueOf(this.mSd), Boolean.valueOf(this.mSe), Boolean.valueOf(this.mSf), Boolean.valueOf(this.mSg), this.mSh.name(), this.mSi);
    }
}
