package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jYK = cEF().cEN();
    public final int jYL;
    public final boolean jYM;
    public final boolean jYN;
    public final boolean jYO;
    public final boolean jYP;
    public final Bitmap.Config jYQ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jYR;

    public a(b bVar) {
        this.jYL = bVar.cEG();
        this.jYM = bVar.cEH();
        this.jYN = bVar.cEI();
        this.jYO = bVar.cEJ();
        this.jYP = bVar.cEL();
        this.jYQ = bVar.cEM();
        this.jYR = bVar.cEK();
    }

    public static a cEE() {
        return jYK;
    }

    public static b cEF() {
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
        return this.jYM == aVar.jYM && this.jYN == aVar.jYN && this.jYO == aVar.jYO && this.jYP == aVar.jYP && this.jYQ == aVar.jYQ && this.jYR == aVar.jYR;
    }

    public int hashCode() {
        return (((((((this.jYO ? 1 : 0) + (((this.jYN ? 1 : 0) + (((this.jYM ? 1 : 0) + (this.jYL * 31)) * 31)) * 31)) * 31) + (this.jYP ? 1 : 0)) * 31) + this.jYQ.ordinal()) * 31) + (this.jYR != null ? this.jYR.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jYL), Boolean.valueOf(this.jYM), Boolean.valueOf(this.jYN), Boolean.valueOf(this.jYO), Boolean.valueOf(this.jYP), this.jYQ.name(), this.jYR);
    }
}
