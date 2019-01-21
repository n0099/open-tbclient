package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a iqL = bXC().bXK();
    public final int iqM;
    public final boolean iqN;
    public final boolean iqO;
    public final boolean iqP;
    public final boolean iqQ;
    public final Bitmap.Config iqR;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b iqS;

    public a(b bVar) {
        this.iqM = bVar.bXD();
        this.iqN = bVar.bXE();
        this.iqO = bVar.bXF();
        this.iqP = bVar.bXG();
        this.iqQ = bVar.bXI();
        this.iqR = bVar.bXJ();
        this.iqS = bVar.bXH();
    }

    public static a bXB() {
        return iqL;
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
        return this.iqN == aVar.iqN && this.iqO == aVar.iqO && this.iqP == aVar.iqP && this.iqQ == aVar.iqQ && this.iqR == aVar.iqR && this.iqS == aVar.iqS;
    }

    public int hashCode() {
        return (((((((this.iqP ? 1 : 0) + (((this.iqO ? 1 : 0) + (((this.iqN ? 1 : 0) + (this.iqM * 31)) * 31)) * 31)) * 31) + (this.iqQ ? 1 : 0)) * 31) + this.iqR.ordinal()) * 31) + (this.iqS != null ? this.iqS.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.iqM), Boolean.valueOf(this.iqN), Boolean.valueOf(this.iqO), Boolean.valueOf(this.iqP), Boolean.valueOf(this.iqQ), this.iqR.name(), this.iqS);
    }
}
