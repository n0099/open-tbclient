package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b maX = dqK().dqS();
    public final int maY;
    public final boolean maZ;
    public final boolean mba;
    public final boolean mbb;
    public final boolean mbc;
    public final Bitmap.Config mbd;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b mbe;

    public b(c cVar) {
        this.maY = cVar.dqL();
        this.maZ = cVar.dqM();
        this.mba = cVar.dqN();
        this.mbb = cVar.dqO();
        this.mbc = cVar.dqQ();
        this.mbd = cVar.dqR();
        this.mbe = cVar.dqP();
    }

    public static b dqJ() {
        return maX;
    }

    public static c dqK() {
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
        return this.maZ == bVar.maZ && this.mba == bVar.mba && this.mbb == bVar.mbb && this.mbc == bVar.mbc && this.mbd == bVar.mbd && this.mbe == bVar.mbe;
    }

    public int hashCode() {
        return (((((((this.mbb ? 1 : 0) + (((this.mba ? 1 : 0) + (((this.maZ ? 1 : 0) + (this.maY * 31)) * 31)) * 31)) * 31) + (this.mbc ? 1 : 0)) * 31) + this.mbd.ordinal()) * 31) + (this.mbe != null ? this.mbe.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.maY), Boolean.valueOf(this.maZ), Boolean.valueOf(this.mba), Boolean.valueOf(this.mbb), Boolean.valueOf(this.mbc), this.mbd.name(), this.mbe);
    }
}
