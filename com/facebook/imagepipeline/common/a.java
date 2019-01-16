package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a iqK = bXC().bXK();
    public final int iqL;
    public final boolean iqM;
    public final boolean iqN;
    public final boolean iqO;
    public final boolean iqP;
    public final Bitmap.Config iqQ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b iqR;

    public a(b bVar) {
        this.iqL = bVar.bXD();
        this.iqM = bVar.bXE();
        this.iqN = bVar.bXF();
        this.iqO = bVar.bXG();
        this.iqP = bVar.bXI();
        this.iqQ = bVar.bXJ();
        this.iqR = bVar.bXH();
    }

    public static a bXB() {
        return iqK;
    }

    public static b bXC() {
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
        return this.iqM == aVar.iqM && this.iqN == aVar.iqN && this.iqO == aVar.iqO && this.iqP == aVar.iqP && this.iqQ == aVar.iqQ && this.iqR == aVar.iqR;
    }

    public int hashCode() {
        return (((((((this.iqO ? 1 : 0) + (((this.iqN ? 1 : 0) + (((this.iqM ? 1 : 0) + (this.iqL * 31)) * 31)) * 31)) * 31) + (this.iqP ? 1 : 0)) * 31) + this.iqQ.ordinal()) * 31) + (this.iqR != null ? this.iqR.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.iqL), Boolean.valueOf(this.iqM), Boolean.valueOf(this.iqN), Boolean.valueOf(this.iqO), Boolean.valueOf(this.iqP), this.iqQ.name(), this.iqR);
    }
}
