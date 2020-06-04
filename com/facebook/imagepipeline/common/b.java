package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b mwc = dyo().dyw();
    public final int mwd;
    public final boolean mwe;
    public final boolean mwf;
    public final boolean mwg;
    public final boolean mwh;
    public final Bitmap.Config mwi;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b mwj;

    public b(c cVar) {
        this.mwd = cVar.dyp();
        this.mwe = cVar.dyq();
        this.mwf = cVar.dyr();
        this.mwg = cVar.dys();
        this.mwh = cVar.dyu();
        this.mwi = cVar.dyv();
        this.mwj = cVar.dyt();
    }

    public static b dyn() {
        return mwc;
    }

    public static c dyo() {
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
        return this.mwe == bVar.mwe && this.mwf == bVar.mwf && this.mwg == bVar.mwg && this.mwh == bVar.mwh && this.mwi == bVar.mwi && this.mwj == bVar.mwj;
    }

    public int hashCode() {
        return (((((((this.mwg ? 1 : 0) + (((this.mwf ? 1 : 0) + (((this.mwe ? 1 : 0) + (this.mwd * 31)) * 31)) * 31)) * 31) + (this.mwh ? 1 : 0)) * 31) + this.mwi.ordinal()) * 31) + (this.mwj != null ? this.mwj.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.mwd), Boolean.valueOf(this.mwe), Boolean.valueOf(this.mwf), Boolean.valueOf(this.mwg), Boolean.valueOf(this.mwh), this.mwi.name(), this.mwj);
    }
}
