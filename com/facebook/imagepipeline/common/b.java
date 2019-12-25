package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes11.dex */
public class b {
    private static final b lMU = dlR().dlZ();
    public final Bitmap.Config bitmapConfig;
    public final int lMV;
    public final boolean lMW;
    public final boolean lMX;
    public final boolean lMY;
    public final boolean lMZ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lNa;

    public b(c cVar) {
        this.lMV = cVar.dlS();
        this.lMW = cVar.dlT();
        this.lMX = cVar.dlU();
        this.lMY = cVar.dlV();
        this.lMZ = cVar.dlX();
        this.bitmapConfig = cVar.dlY();
        this.lNa = cVar.dlW();
    }

    public static b dlQ() {
        return lMU;
    }

    public static c dlR() {
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
        return this.lMW == bVar.lMW && this.lMX == bVar.lMX && this.lMY == bVar.lMY && this.lMZ == bVar.lMZ && this.bitmapConfig == bVar.bitmapConfig && this.lNa == bVar.lNa;
    }

    public int hashCode() {
        return (((((((this.lMY ? 1 : 0) + (((this.lMX ? 1 : 0) + (((this.lMW ? 1 : 0) + (this.lMV * 31)) * 31)) * 31)) * 31) + (this.lMZ ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lNa != null ? this.lNa.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lMV), Boolean.valueOf(this.lMW), Boolean.valueOf(this.lMX), Boolean.valueOf(this.lMY), Boolean.valueOf(this.lMZ), this.bitmapConfig.name(), this.lNa);
    }
}
