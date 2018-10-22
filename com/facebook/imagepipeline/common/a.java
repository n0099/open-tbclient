package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a idx = bUD().bUL();
    public final boolean idA;
    public final boolean idB;
    public final boolean idC;
    public final Bitmap.Config idD;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b idE;
    public final int idy;
    public final boolean idz;

    public a(b bVar) {
        this.idy = bVar.bUE();
        this.idz = bVar.bUF();
        this.idA = bVar.bUG();
        this.idB = bVar.bUH();
        this.idC = bVar.bUJ();
        this.idD = bVar.bUK();
        this.idE = bVar.bUI();
    }

    public static a bUC() {
        return idx;
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
        return this.idz == aVar.idz && this.idA == aVar.idA && this.idB == aVar.idB && this.idC == aVar.idC && this.idD == aVar.idD && this.idE == aVar.idE;
    }

    public int hashCode() {
        return (((((((this.idB ? 1 : 0) + (((this.idA ? 1 : 0) + (((this.idz ? 1 : 0) + (this.idy * 31)) * 31)) * 31)) * 31) + (this.idC ? 1 : 0)) * 31) + this.idD.ordinal()) * 31) + (this.idE != null ? this.idE.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.idy), Boolean.valueOf(this.idz), Boolean.valueOf(this.idA), Boolean.valueOf(this.idB), Boolean.valueOf(this.idC), this.idD.name(), this.idE);
    }
}
