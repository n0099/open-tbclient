package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes7.dex */
public class b {
    private static final b pkO = etr().etz();
    public final int pkP;
    public final boolean pkQ;
    public final boolean pkR;
    public final boolean pkS;
    public final boolean pkT;
    public final Bitmap.Config pkU;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pkV;

    public b(c cVar) {
        this.pkP = cVar.ets();
        this.pkQ = cVar.ett();
        this.pkR = cVar.etu();
        this.pkS = cVar.etv();
        this.pkT = cVar.etx();
        this.pkU = cVar.ety();
        this.pkV = cVar.etw();
    }

    public static b etq() {
        return pkO;
    }

    public static c etr() {
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
        return this.pkQ == bVar.pkQ && this.pkR == bVar.pkR && this.pkS == bVar.pkS && this.pkT == bVar.pkT && this.pkU == bVar.pkU && this.pkV == bVar.pkV;
    }

    public int hashCode() {
        return (((((((this.pkS ? 1 : 0) + (((this.pkR ? 1 : 0) + (((this.pkQ ? 1 : 0) + (this.pkP * 31)) * 31)) * 31)) * 31) + (this.pkT ? 1 : 0)) * 31) + this.pkU.ordinal()) * 31) + (this.pkV != null ? this.pkV.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pkP), Boolean.valueOf(this.pkQ), Boolean.valueOf(this.pkR), Boolean.valueOf(this.pkS), Boolean.valueOf(this.pkT), this.pkU.name(), this.pkV);
    }
}
