package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b mSe = dCU().dDc();
    public final int mSf;
    public final boolean mSg;
    public final boolean mSh;
    public final boolean mSi;
    public final boolean mSj;
    public final Bitmap.Config mSk;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b mSl;

    public b(c cVar) {
        this.mSf = cVar.dCV();
        this.mSg = cVar.dCW();
        this.mSh = cVar.dCX();
        this.mSi = cVar.dCY();
        this.mSj = cVar.dDa();
        this.mSk = cVar.dDb();
        this.mSl = cVar.dCZ();
    }

    public static b dCT() {
        return mSe;
    }

    public static c dCU() {
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
        return this.mSg == bVar.mSg && this.mSh == bVar.mSh && this.mSi == bVar.mSi && this.mSj == bVar.mSj && this.mSk == bVar.mSk && this.mSl == bVar.mSl;
    }

    public int hashCode() {
        return (((((((this.mSi ? 1 : 0) + (((this.mSh ? 1 : 0) + (((this.mSg ? 1 : 0) + (this.mSf * 31)) * 31)) * 31)) * 31) + (this.mSj ? 1 : 0)) * 31) + this.mSk.ordinal()) * 31) + (this.mSl != null ? this.mSl.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.mSf), Boolean.valueOf(this.mSg), Boolean.valueOf(this.mSh), Boolean.valueOf(this.mSi), Boolean.valueOf(this.mSj), this.mSk.name(), this.mSl);
    }
}
