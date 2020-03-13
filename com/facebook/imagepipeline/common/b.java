package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b lRF = doo().dow();
    public final Bitmap.Config bitmapConfig;
    public final int lRG;
    public final boolean lRH;
    public final boolean lRI;
    public final boolean lRJ;
    public final boolean lRK;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lRL;

    public b(c cVar) {
        this.lRG = cVar.dop();
        this.lRH = cVar.doq();
        this.lRI = cVar.dor();
        this.lRJ = cVar.dos();
        this.lRK = cVar.dou();
        this.bitmapConfig = cVar.dov();
        this.lRL = cVar.dot();
    }

    public static b don() {
        return lRF;
    }

    public static c doo() {
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
        return this.lRH == bVar.lRH && this.lRI == bVar.lRI && this.lRJ == bVar.lRJ && this.lRK == bVar.lRK && this.bitmapConfig == bVar.bitmapConfig && this.lRL == bVar.lRL;
    }

    public int hashCode() {
        return (((((((this.lRJ ? 1 : 0) + (((this.lRI ? 1 : 0) + (((this.lRH ? 1 : 0) + (this.lRG * 31)) * 31)) * 31)) * 31) + (this.lRK ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lRL != null ? this.lRL.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lRG), Boolean.valueOf(this.lRH), Boolean.valueOf(this.lRI), Boolean.valueOf(this.lRJ), Boolean.valueOf(this.lRK), this.bitmapConfig.name(), this.lRL);
    }
}
