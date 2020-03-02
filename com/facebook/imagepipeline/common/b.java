package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b lRu = don().dov();
    public final Bitmap.Config bitmapConfig;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lRA;
    public final int lRv;
    public final boolean lRw;
    public final boolean lRx;
    public final boolean lRy;
    public final boolean lRz;

    public b(c cVar) {
        this.lRv = cVar.doo();
        this.lRw = cVar.dop();
        this.lRx = cVar.doq();
        this.lRy = cVar.dor();
        this.lRz = cVar.dot();
        this.bitmapConfig = cVar.dou();
        this.lRA = cVar.dos();
    }

    public static b dom() {
        return lRu;
    }

    public static c don() {
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
        return this.lRw == bVar.lRw && this.lRx == bVar.lRx && this.lRy == bVar.lRy && this.lRz == bVar.lRz && this.bitmapConfig == bVar.bitmapConfig && this.lRA == bVar.lRA;
    }

    public int hashCode() {
        return (((((((this.lRy ? 1 : 0) + (((this.lRx ? 1 : 0) + (((this.lRw ? 1 : 0) + (this.lRv * 31)) * 31)) * 31)) * 31) + (this.lRz ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lRA != null ? this.lRA.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lRv), Boolean.valueOf(this.lRw), Boolean.valueOf(this.lRx), Boolean.valueOf(this.lRy), Boolean.valueOf(this.lRz), this.bitmapConfig.name(), this.lRA);
    }
}
