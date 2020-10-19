package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b nTL = dZY().eag();
    public final int nTM;
    public final boolean nTN;
    public final boolean nTO;
    public final boolean nTP;
    public final boolean nTQ;
    public final Bitmap.Config nTR;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nTS;

    public b(c cVar) {
        this.nTM = cVar.dZZ();
        this.nTN = cVar.eaa();
        this.nTO = cVar.eab();
        this.nTP = cVar.eac();
        this.nTQ = cVar.eae();
        this.nTR = cVar.eaf();
        this.nTS = cVar.ead();
    }

    public static b dZX() {
        return nTL;
    }

    public static c dZY() {
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
        return this.nTN == bVar.nTN && this.nTO == bVar.nTO && this.nTP == bVar.nTP && this.nTQ == bVar.nTQ && this.nTR == bVar.nTR && this.nTS == bVar.nTS;
    }

    public int hashCode() {
        return (((((((this.nTP ? 1 : 0) + (((this.nTO ? 1 : 0) + (((this.nTN ? 1 : 0) + (this.nTM * 31)) * 31)) * 31)) * 31) + (this.nTQ ? 1 : 0)) * 31) + this.nTR.ordinal()) * 31) + (this.nTS != null ? this.nTS.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nTM), Boolean.valueOf(this.nTN), Boolean.valueOf(this.nTO), Boolean.valueOf(this.nTP), Boolean.valueOf(this.nTQ), this.nTR.name(), this.nTS);
    }
}
