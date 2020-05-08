package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b mbb = dqH().dqP();
    public final int mbc;
    public final boolean mbd;
    public final boolean mbe;
    public final boolean mbf;
    public final boolean mbg;
    public final Bitmap.Config mbh;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b mbi;

    public b(c cVar) {
        this.mbc = cVar.dqI();
        this.mbd = cVar.dqJ();
        this.mbe = cVar.dqK();
        this.mbf = cVar.dqL();
        this.mbg = cVar.dqN();
        this.mbh = cVar.dqO();
        this.mbi = cVar.dqM();
    }

    public static b dqG() {
        return mbb;
    }

    public static c dqH() {
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
        return this.mbd == bVar.mbd && this.mbe == bVar.mbe && this.mbf == bVar.mbf && this.mbg == bVar.mbg && this.mbh == bVar.mbh && this.mbi == bVar.mbi;
    }

    public int hashCode() {
        return (((((((this.mbf ? 1 : 0) + (((this.mbe ? 1 : 0) + (((this.mbd ? 1 : 0) + (this.mbc * 31)) * 31)) * 31)) * 31) + (this.mbg ? 1 : 0)) * 31) + this.mbh.ordinal()) * 31) + (this.mbi != null ? this.mbi.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.mbc), Boolean.valueOf(this.mbd), Boolean.valueOf(this.mbe), Boolean.valueOf(this.mbf), Boolean.valueOf(this.mbg), this.mbh.name(), this.mbi);
    }
}
