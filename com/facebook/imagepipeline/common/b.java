package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b lQG = dmW().dne();
    public final Bitmap.Config bitmapConfig;
    public final int lQH;
    public final boolean lQI;
    public final boolean lQJ;
    public final boolean lQK;
    public final boolean lQL;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lQM;

    public b(c cVar) {
        this.lQH = cVar.dmX();
        this.lQI = cVar.dmY();
        this.lQJ = cVar.dmZ();
        this.lQK = cVar.dna();
        this.lQL = cVar.dnc();
        this.bitmapConfig = cVar.dnd();
        this.lQM = cVar.dnb();
    }

    public static b dmV() {
        return lQG;
    }

    public static c dmW() {
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
        return this.lQI == bVar.lQI && this.lQJ == bVar.lQJ && this.lQK == bVar.lQK && this.lQL == bVar.lQL && this.bitmapConfig == bVar.bitmapConfig && this.lQM == bVar.lQM;
    }

    public int hashCode() {
        return (((((((this.lQK ? 1 : 0) + (((this.lQJ ? 1 : 0) + (((this.lQI ? 1 : 0) + (this.lQH * 31)) * 31)) * 31)) * 31) + (this.lQL ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lQM != null ? this.lQM.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lQH), Boolean.valueOf(this.lQI), Boolean.valueOf(this.lQJ), Boolean.valueOf(this.lQK), Boolean.valueOf(this.lQL), this.bitmapConfig.name(), this.lQM);
    }
}
