package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a kha = cIe().cIm();
    public final int khb;
    public final boolean khc;
    public final boolean khd;
    public final boolean khe;
    public final boolean khf;
    public final Bitmap.Config khg;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b khh;

    public a(b bVar) {
        this.khb = bVar.cIf();
        this.khc = bVar.cIg();
        this.khd = bVar.cIh();
        this.khe = bVar.cIi();
        this.khf = bVar.cIk();
        this.khg = bVar.cIl();
        this.khh = bVar.cIj();
    }

    public static a cId() {
        return kha;
    }

    public static b cIe() {
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
        return this.khc == aVar.khc && this.khd == aVar.khd && this.khe == aVar.khe && this.khf == aVar.khf && this.khg == aVar.khg && this.khh == aVar.khh;
    }

    public int hashCode() {
        return (((((((this.khe ? 1 : 0) + (((this.khd ? 1 : 0) + (((this.khc ? 1 : 0) + (this.khb * 31)) * 31)) * 31)) * 31) + (this.khf ? 1 : 0)) * 31) + this.khg.ordinal()) * 31) + (this.khh != null ? this.khh.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.khb), Boolean.valueOf(this.khc), Boolean.valueOf(this.khd), Boolean.valueOf(this.khe), Boolean.valueOf(this.khf), this.khg.name(), this.khh);
    }
}
