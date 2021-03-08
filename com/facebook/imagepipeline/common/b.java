package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pKo = ewu().ewC();
    public final Bitmap.Config bitmapConfig;
    public final int pKp;
    public final boolean pKq;
    public final boolean pKr;
    public final boolean pKs;
    public final boolean pKt;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pKu;

    public b(c cVar) {
        this.pKp = cVar.ewv();
        this.pKq = cVar.eww();
        this.pKr = cVar.ewx();
        this.pKs = cVar.ewy();
        this.pKt = cVar.ewA();
        this.bitmapConfig = cVar.ewB();
        this.pKu = cVar.ewz();
    }

    public static b ewt() {
        return pKo;
    }

    public static c ewu() {
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
        return this.pKq == bVar.pKq && this.pKr == bVar.pKr && this.pKs == bVar.pKs && this.pKt == bVar.pKt && this.bitmapConfig == bVar.bitmapConfig && this.pKu == bVar.pKu;
    }

    public int hashCode() {
        return (((((((this.pKs ? 1 : 0) + (((this.pKr ? 1 : 0) + (((this.pKq ? 1 : 0) + (this.pKp * 31)) * 31)) * 31)) * 31) + (this.pKt ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pKu != null ? this.pKu.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pKp), Boolean.valueOf(this.pKq), Boolean.valueOf(this.pKr), Boolean.valueOf(this.pKs), Boolean.valueOf(this.pKt), this.bitmapConfig.name(), this.pKu);
    }
}
