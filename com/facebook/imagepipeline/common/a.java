package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a kjy = cIS().cJa();
    public final boolean kjA;
    public final boolean kjB;
    public final boolean kjC;
    public final boolean kjD;
    public final Bitmap.Config kjE;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b kjF;
    public final int kjz;

    public a(b bVar) {
        this.kjz = bVar.cIT();
        this.kjA = bVar.cIU();
        this.kjB = bVar.cIV();
        this.kjC = bVar.cIW();
        this.kjD = bVar.cIY();
        this.kjE = bVar.cIZ();
        this.kjF = bVar.cIX();
    }

    public static a cIR() {
        return kjy;
    }

    public static b cIS() {
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
        return this.kjA == aVar.kjA && this.kjB == aVar.kjB && this.kjC == aVar.kjC && this.kjD == aVar.kjD && this.kjE == aVar.kjE && this.kjF == aVar.kjF;
    }

    public int hashCode() {
        return (((((((this.kjC ? 1 : 0) + (((this.kjB ? 1 : 0) + (((this.kjA ? 1 : 0) + (this.kjz * 31)) * 31)) * 31)) * 31) + (this.kjD ? 1 : 0)) * 31) + this.kjE.ordinal()) * 31) + (this.kjF != null ? this.kjF.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.kjz), Boolean.valueOf(this.kjA), Boolean.valueOf(this.kjB), Boolean.valueOf(this.kjC), Boolean.valueOf(this.kjD), this.kjE.name(), this.kjF);
    }
}
