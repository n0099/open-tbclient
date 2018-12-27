package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a ipD = bWU().bXc();
    public final int ipE;
    public final boolean ipF;
    public final boolean ipG;
    public final boolean ipH;
    public final boolean ipI;
    public final Bitmap.Config ipJ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b ipK;

    public a(b bVar) {
        this.ipE = bVar.bWV();
        this.ipF = bVar.bWW();
        this.ipG = bVar.bWX();
        this.ipH = bVar.bWY();
        this.ipI = bVar.bXa();
        this.ipJ = bVar.bXb();
        this.ipK = bVar.bWZ();
    }

    public static a bWT() {
        return ipD;
    }

    public static b bWU() {
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
        return this.ipF == aVar.ipF && this.ipG == aVar.ipG && this.ipH == aVar.ipH && this.ipI == aVar.ipI && this.ipJ == aVar.ipJ && this.ipK == aVar.ipK;
    }

    public int hashCode() {
        return (((((((this.ipH ? 1 : 0) + (((this.ipG ? 1 : 0) + (((this.ipF ? 1 : 0) + (this.ipE * 31)) * 31)) * 31)) * 31) + (this.ipI ? 1 : 0)) * 31) + this.ipJ.ordinal()) * 31) + (this.ipK != null ? this.ipK.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.ipE), Boolean.valueOf(this.ipF), Boolean.valueOf(this.ipG), Boolean.valueOf(this.ipH), Boolean.valueOf(this.ipI), this.ipJ.name(), this.ipK);
    }
}
