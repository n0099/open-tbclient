package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b oLd = ejW().eke();
    public final int oLe;
    public final boolean oLf;
    public final boolean oLg;
    public final boolean oLh;
    public final boolean oLi;
    public final Bitmap.Config oLj;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b oLk;

    public b(c cVar) {
        this.oLe = cVar.ejX();
        this.oLf = cVar.ejY();
        this.oLg = cVar.ejZ();
        this.oLh = cVar.eka();
        this.oLi = cVar.ekc();
        this.oLj = cVar.ekd();
        this.oLk = cVar.ekb();
    }

    public static b ejV() {
        return oLd;
    }

    public static c ejW() {
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
        return this.oLf == bVar.oLf && this.oLg == bVar.oLg && this.oLh == bVar.oLh && this.oLi == bVar.oLi && this.oLj == bVar.oLj && this.oLk == bVar.oLk;
    }

    public int hashCode() {
        return (((((((this.oLh ? 1 : 0) + (((this.oLg ? 1 : 0) + (((this.oLf ? 1 : 0) + (this.oLe * 31)) * 31)) * 31)) * 31) + (this.oLi ? 1 : 0)) * 31) + this.oLj.ordinal()) * 31) + (this.oLk != null ? this.oLk.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.oLe), Boolean.valueOf(this.oLf), Boolean.valueOf(this.oLg), Boolean.valueOf(this.oLh), Boolean.valueOf(this.oLi), this.oLj.name(), this.oLk);
    }
}
