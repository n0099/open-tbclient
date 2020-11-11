package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes12.dex */
public class b {
    private static final b oUw = enM().enU();
    public final boolean oUA;
    public final boolean oUB;
    public final Bitmap.Config oUC;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b oUD;
    public final int oUx;
    public final boolean oUy;
    public final boolean oUz;

    public b(c cVar) {
        this.oUx = cVar.enN();
        this.oUy = cVar.enO();
        this.oUz = cVar.enP();
        this.oUA = cVar.enQ();
        this.oUB = cVar.enS();
        this.oUC = cVar.enT();
        this.oUD = cVar.enR();
    }

    public static b enL() {
        return oUw;
    }

    public static c enM() {
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
        return this.oUy == bVar.oUy && this.oUz == bVar.oUz && this.oUA == bVar.oUA && this.oUB == bVar.oUB && this.oUC == bVar.oUC && this.oUD == bVar.oUD;
    }

    public int hashCode() {
        return (((((((this.oUA ? 1 : 0) + (((this.oUz ? 1 : 0) + (((this.oUy ? 1 : 0) + (this.oUx * 31)) * 31)) * 31)) * 31) + (this.oUB ? 1 : 0)) * 31) + this.oUC.ordinal()) * 31) + (this.oUD != null ? this.oUD.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.oUx), Boolean.valueOf(this.oUy), Boolean.valueOf(this.oUz), Boolean.valueOf(this.oUA), Boolean.valueOf(this.oUB), this.oUC.name(), this.oUD);
    }
}
