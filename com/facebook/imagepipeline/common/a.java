package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jFX = cwJ().cwR();
    public final int jFY;
    public final boolean jFZ;
    public final boolean jGa;
    public final boolean jGb;
    public final boolean jGc;
    public final Bitmap.Config jGd;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jGe;

    public a(b bVar) {
        this.jFY = bVar.cwK();
        this.jFZ = bVar.cwL();
        this.jGa = bVar.cwM();
        this.jGb = bVar.cwN();
        this.jGc = bVar.cwP();
        this.jGd = bVar.cwQ();
        this.jGe = bVar.cwO();
    }

    public static a cwI() {
        return jFX;
    }

    public static b cwJ() {
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
        return this.jFZ == aVar.jFZ && this.jGa == aVar.jGa && this.jGb == aVar.jGb && this.jGc == aVar.jGc && this.jGd == aVar.jGd && this.jGe == aVar.jGe;
    }

    public int hashCode() {
        return (((((((this.jGb ? 1 : 0) + (((this.jGa ? 1 : 0) + (((this.jFZ ? 1 : 0) + (this.jFY * 31)) * 31)) * 31)) * 31) + (this.jGc ? 1 : 0)) * 31) + this.jGd.ordinal()) * 31) + (this.jGe != null ? this.jGe.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jFY), Boolean.valueOf(this.jFZ), Boolean.valueOf(this.jGa), Boolean.valueOf(this.jGb), Boolean.valueOf(this.jGc), this.jGd.name(), this.jGe);
    }
}
