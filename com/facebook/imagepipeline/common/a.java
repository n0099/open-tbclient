package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jYO = cEG().cEO();
    public final int jYP;
    public final boolean jYQ;
    public final boolean jYR;
    public final boolean jYS;
    public final boolean jYT;
    public final Bitmap.Config jYU;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jYV;

    public a(b bVar) {
        this.jYP = bVar.cEH();
        this.jYQ = bVar.cEI();
        this.jYR = bVar.cEJ();
        this.jYS = bVar.cEK();
        this.jYT = bVar.cEM();
        this.jYU = bVar.cEN();
        this.jYV = bVar.cEL();
    }

    public static a cEF() {
        return jYO;
    }

    public static b cEG() {
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
        return this.jYQ == aVar.jYQ && this.jYR == aVar.jYR && this.jYS == aVar.jYS && this.jYT == aVar.jYT && this.jYU == aVar.jYU && this.jYV == aVar.jYV;
    }

    public int hashCode() {
        return (((((((this.jYS ? 1 : 0) + (((this.jYR ? 1 : 0) + (((this.jYQ ? 1 : 0) + (this.jYP * 31)) * 31)) * 31)) * 31) + (this.jYT ? 1 : 0)) * 31) + this.jYU.ordinal()) * 31) + (this.jYV != null ? this.jYV.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jYP), Boolean.valueOf(this.jYQ), Boolean.valueOf(this.jYR), Boolean.valueOf(this.jYS), Boolean.valueOf(this.jYT), this.jYU.name(), this.jYV);
    }
}
