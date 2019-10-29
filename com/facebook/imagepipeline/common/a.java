package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a khJ = cFP().cFX();
    public final int khK;
    public final boolean khL;
    public final boolean khM;
    public final boolean khN;
    public final boolean khO;
    public final Bitmap.Config khP;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b khQ;

    public a(b bVar) {
        this.khK = bVar.cFQ();
        this.khL = bVar.cFR();
        this.khM = bVar.cFS();
        this.khN = bVar.cFT();
        this.khO = bVar.cFV();
        this.khP = bVar.cFW();
        this.khQ = bVar.cFU();
    }

    public static a cFO() {
        return khJ;
    }

    public static b cFP() {
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
        return this.khL == aVar.khL && this.khM == aVar.khM && this.khN == aVar.khN && this.khO == aVar.khO && this.khP == aVar.khP && this.khQ == aVar.khQ;
    }

    public int hashCode() {
        return (((((((this.khN ? 1 : 0) + (((this.khM ? 1 : 0) + (((this.khL ? 1 : 0) + (this.khK * 31)) * 31)) * 31)) * 31) + (this.khO ? 1 : 0)) * 31) + this.khP.ordinal()) * 31) + (this.khQ != null ? this.khQ.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.khK), Boolean.valueOf(this.khL), Boolean.valueOf(this.khM), Boolean.valueOf(this.khN), Boolean.valueOf(this.khO), this.khP.name(), this.khQ);
    }
}
