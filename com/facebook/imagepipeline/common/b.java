package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pHJ = ewd().ewl();
    public final Bitmap.Config bitmapConfig;
    public final int pHK;
    public final boolean pHL;
    public final boolean pHM;
    public final boolean pHN;
    public final boolean pHO;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pHP;

    public b(c cVar) {
        this.pHK = cVar.ewe();
        this.pHL = cVar.ewf();
        this.pHM = cVar.ewg();
        this.pHN = cVar.ewh();
        this.pHO = cVar.ewj();
        this.bitmapConfig = cVar.ewk();
        this.pHP = cVar.ewi();
    }

    public static b ewc() {
        return pHJ;
    }

    public static c ewd() {
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
        return this.pHL == bVar.pHL && this.pHM == bVar.pHM && this.pHN == bVar.pHN && this.pHO == bVar.pHO && this.bitmapConfig == bVar.bitmapConfig && this.pHP == bVar.pHP;
    }

    public int hashCode() {
        return (((((((this.pHN ? 1 : 0) + (((this.pHM ? 1 : 0) + (((this.pHL ? 1 : 0) + (this.pHK * 31)) * 31)) * 31)) * 31) + (this.pHO ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pHP != null ? this.pHP.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pHK), Boolean.valueOf(this.pHL), Boolean.valueOf(this.pHM), Boolean.valueOf(this.pHN), Boolean.valueOf(this.pHO), this.bitmapConfig.name(), this.pHP);
    }
}
