package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes17.dex */
public class b {
    private static final b oVZ = enK().enS();
    public final int oWa;
    public final boolean oWb;
    public final boolean oWc;
    public final boolean oWd;
    public final boolean oWe;
    public final Bitmap.Config oWf;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b oWg;

    public b(c cVar) {
        this.oWa = cVar.enL();
        this.oWb = cVar.enM();
        this.oWc = cVar.enN();
        this.oWd = cVar.enO();
        this.oWe = cVar.enQ();
        this.oWf = cVar.enR();
        this.oWg = cVar.enP();
    }

    public static b enJ() {
        return oVZ;
    }

    public static c enK() {
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
        return this.oWb == bVar.oWb && this.oWc == bVar.oWc && this.oWd == bVar.oWd && this.oWe == bVar.oWe && this.oWf == bVar.oWf && this.oWg == bVar.oWg;
    }

    public int hashCode() {
        return (((((((this.oWd ? 1 : 0) + (((this.oWc ? 1 : 0) + (((this.oWb ? 1 : 0) + (this.oWa * 31)) * 31)) * 31)) * 31) + (this.oWe ? 1 : 0)) * 31) + this.oWf.ordinal()) * 31) + (this.oWg != null ? this.oWg.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.oWa), Boolean.valueOf(this.oWb), Boolean.valueOf(this.oWc), Boolean.valueOf(this.oWd), Boolean.valueOf(this.oWe), this.oWf.name(), this.oWg);
    }
}
