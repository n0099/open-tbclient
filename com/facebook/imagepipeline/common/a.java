package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jGr = cwD().cwL();
    public final int jGs;
    public final boolean jGt;
    public final boolean jGu;
    public final boolean jGv;
    public final boolean jGw;
    public final Bitmap.Config jGx;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jGy;

    public a(b bVar) {
        this.jGs = bVar.cwE();
        this.jGt = bVar.cwF();
        this.jGu = bVar.cwG();
        this.jGv = bVar.cwH();
        this.jGw = bVar.cwJ();
        this.jGx = bVar.cwK();
        this.jGy = bVar.cwI();
    }

    public static a cwC() {
        return jGr;
    }

    public static b cwD() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.jGt == aVar.jGt && this.jGu == aVar.jGu && this.jGv == aVar.jGv && this.jGw == aVar.jGw && this.jGx == aVar.jGx && this.jGy == aVar.jGy;
    }

    public int hashCode() {
        return (((((((this.jGv ? 1 : 0) + (((this.jGu ? 1 : 0) + (((this.jGt ? 1 : 0) + (this.jGs * 31)) * 31)) * 31)) * 31) + (this.jGw ? 1 : 0)) * 31) + this.jGx.ordinal()) * 31) + (this.jGy != null ? this.jGy.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jGs), Boolean.valueOf(this.jGt), Boolean.valueOf(this.jGu), Boolean.valueOf(this.jGv), Boolean.valueOf(this.jGw), this.jGx.name(), this.jGy);
    }
}
