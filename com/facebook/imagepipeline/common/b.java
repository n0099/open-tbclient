package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes7.dex */
public class b {
    private static final b pkQ = ets().etA();
    public final int pkR;
    public final boolean pkS;
    public final boolean pkT;
    public final boolean pkU;
    public final boolean pkV;
    public final Bitmap.Config pkW;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pkX;

    public b(c cVar) {
        this.pkR = cVar.ett();
        this.pkS = cVar.etu();
        this.pkT = cVar.etv();
        this.pkU = cVar.etw();
        this.pkV = cVar.ety();
        this.pkW = cVar.etz();
        this.pkX = cVar.etx();
    }

    public static b etr() {
        return pkQ;
    }

    public static c ets() {
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
        return this.pkS == bVar.pkS && this.pkT == bVar.pkT && this.pkU == bVar.pkU && this.pkV == bVar.pkV && this.pkW == bVar.pkW && this.pkX == bVar.pkX;
    }

    public int hashCode() {
        return (((((((this.pkU ? 1 : 0) + (((this.pkT ? 1 : 0) + (((this.pkS ? 1 : 0) + (this.pkR * 31)) * 31)) * 31)) * 31) + (this.pkV ? 1 : 0)) * 31) + this.pkW.ordinal()) * 31) + (this.pkX != null ? this.pkX.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pkR), Boolean.valueOf(this.pkS), Boolean.valueOf(this.pkT), Boolean.valueOf(this.pkU), Boolean.valueOf(this.pkV), this.pkW.name(), this.pkX);
    }
}
