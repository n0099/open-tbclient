package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jYL = cEH().cEP();
    public final int jYM;
    public final boolean jYN;
    public final boolean jYO;
    public final boolean jYP;
    public final boolean jYQ;
    public final Bitmap.Config jYR;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jYS;

    public a(b bVar) {
        this.jYM = bVar.cEI();
        this.jYN = bVar.cEJ();
        this.jYO = bVar.cEK();
        this.jYP = bVar.cEL();
        this.jYQ = bVar.cEN();
        this.jYR = bVar.cEO();
        this.jYS = bVar.cEM();
    }

    public static a cEG() {
        return jYL;
    }

    public static b cEH() {
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
        return this.jYN == aVar.jYN && this.jYO == aVar.jYO && this.jYP == aVar.jYP && this.jYQ == aVar.jYQ && this.jYR == aVar.jYR && this.jYS == aVar.jYS;
    }

    public int hashCode() {
        return (((((((this.jYP ? 1 : 0) + (((this.jYO ? 1 : 0) + (((this.jYN ? 1 : 0) + (this.jYM * 31)) * 31)) * 31)) * 31) + (this.jYQ ? 1 : 0)) * 31) + this.jYR.ordinal()) * 31) + (this.jYS != null ? this.jYS.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jYM), Boolean.valueOf(this.jYN), Boolean.valueOf(this.jYO), Boolean.valueOf(this.jYP), Boolean.valueOf(this.jYQ), this.jYR.name(), this.jYS);
    }
}
