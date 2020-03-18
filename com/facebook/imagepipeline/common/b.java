package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b lTl = doL().doT();
    public final Bitmap.Config bitmapConfig;
    public final int lTm;
    public final boolean lTn;
    public final boolean lTo;
    public final boolean lTp;
    public final boolean lTq;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lTr;

    public b(c cVar) {
        this.lTm = cVar.doM();
        this.lTn = cVar.doN();
        this.lTo = cVar.doO();
        this.lTp = cVar.doP();
        this.lTq = cVar.doR();
        this.bitmapConfig = cVar.doS();
        this.lTr = cVar.doQ();
    }

    public static b doK() {
        return lTl;
    }

    public static c doL() {
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
        return this.lTn == bVar.lTn && this.lTo == bVar.lTo && this.lTp == bVar.lTp && this.lTq == bVar.lTq && this.bitmapConfig == bVar.bitmapConfig && this.lTr == bVar.lTr;
    }

    public int hashCode() {
        return (((((((this.lTp ? 1 : 0) + (((this.lTo ? 1 : 0) + (((this.lTn ? 1 : 0) + (this.lTm * 31)) * 31)) * 31)) * 31) + (this.lTq ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lTr != null ? this.lTr.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lTm), Boolean.valueOf(this.lTn), Boolean.valueOf(this.lTo), Boolean.valueOf(this.lTp), Boolean.valueOf(this.lTq), this.bitmapConfig.name(), this.lTr);
    }
}
