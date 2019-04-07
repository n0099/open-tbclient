package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jFW = cwJ().cwR();
    public final int jFX;
    public final boolean jFY;
    public final boolean jFZ;
    public final boolean jGa;
    public final boolean jGb;
    public final Bitmap.Config jGc;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jGd;

    public a(b bVar) {
        this.jFX = bVar.cwK();
        this.jFY = bVar.cwL();
        this.jFZ = bVar.cwM();
        this.jGa = bVar.cwN();
        this.jGb = bVar.cwP();
        this.jGc = bVar.cwQ();
        this.jGd = bVar.cwO();
    }

    public static a cwI() {
        return jFW;
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
        return this.jFY == aVar.jFY && this.jFZ == aVar.jFZ && this.jGa == aVar.jGa && this.jGb == aVar.jGb && this.jGc == aVar.jGc && this.jGd == aVar.jGd;
    }

    public int hashCode() {
        return (((((((this.jGa ? 1 : 0) + (((this.jFZ ? 1 : 0) + (((this.jFY ? 1 : 0) + (this.jFX * 31)) * 31)) * 31)) * 31) + (this.jGb ? 1 : 0)) * 31) + this.jGc.ordinal()) * 31) + (this.jGd != null ? this.jGd.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jFX), Boolean.valueOf(this.jFY), Boolean.valueOf(this.jFZ), Boolean.valueOf(this.jGa), Boolean.valueOf(this.jGb), this.jGc.name(), this.jGd);
    }
}
