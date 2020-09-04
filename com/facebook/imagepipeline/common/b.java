package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class b {
    private static final b nuv = dSp().dSx();
    public final boolean nuA;
    public final Bitmap.Config nuB;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b nuC;
    public final int nuw;
    public final boolean nux;
    public final boolean nuy;
    public final boolean nuz;

    public b(c cVar) {
        this.nuw = cVar.dSq();
        this.nux = cVar.dSr();
        this.nuy = cVar.dSs();
        this.nuz = cVar.dSt();
        this.nuA = cVar.dSv();
        this.nuB = cVar.dSw();
        this.nuC = cVar.dSu();
    }

    public static b dSo() {
        return nuv;
    }

    public static c dSp() {
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
        return this.nux == bVar.nux && this.nuy == bVar.nuy && this.nuz == bVar.nuz && this.nuA == bVar.nuA && this.nuB == bVar.nuB && this.nuC == bVar.nuC;
    }

    public int hashCode() {
        return (((((((this.nuz ? 1 : 0) + (((this.nuy ? 1 : 0) + (((this.nux ? 1 : 0) + (this.nuw * 31)) * 31)) * 31)) * 31) + (this.nuA ? 1 : 0)) * 31) + this.nuB.ordinal()) * 31) + (this.nuC != null ? this.nuC.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.nuw), Boolean.valueOf(this.nux), Boolean.valueOf(this.nuy), Boolean.valueOf(this.nuz), Boolean.valueOf(this.nuA), this.nuB.name(), this.nuC);
    }
}
