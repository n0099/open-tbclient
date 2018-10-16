package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a idw = bUD().bUL();
    public final boolean idA;
    public final boolean idB;
    public final Bitmap.Config idC;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b idD;
    public final int idx;
    public final boolean idy;
    public final boolean idz;

    public a(b bVar) {
        this.idx = bVar.bUE();
        this.idy = bVar.bUF();
        this.idz = bVar.bUG();
        this.idA = bVar.bUH();
        this.idB = bVar.bUJ();
        this.idC = bVar.bUK();
        this.idD = bVar.bUI();
    }

    public static a bUC() {
        return idw;
    }

    public static b bUD() {
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
        return this.idy == aVar.idy && this.idz == aVar.idz && this.idA == aVar.idA && this.idB == aVar.idB && this.idC == aVar.idC && this.idD == aVar.idD;
    }

    public int hashCode() {
        return (((((((this.idA ? 1 : 0) + (((this.idz ? 1 : 0) + (((this.idy ? 1 : 0) + (this.idx * 31)) * 31)) * 31)) * 31) + (this.idB ? 1 : 0)) * 31) + this.idC.ordinal()) * 31) + (this.idD != null ? this.idD.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.idx), Boolean.valueOf(this.idy), Boolean.valueOf(this.idz), Boolean.valueOf(this.idA), Boolean.valueOf(this.idB), this.idC.name(), this.idD);
    }
}
