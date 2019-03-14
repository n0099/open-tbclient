package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jGC = cwQ().cwY();
    public final int jGD;
    public final boolean jGE;
    public final boolean jGF;
    public final boolean jGG;
    public final boolean jGH;
    public final Bitmap.Config jGI;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jGJ;

    public a(b bVar) {
        this.jGD = bVar.cwR();
        this.jGE = bVar.cwS();
        this.jGF = bVar.cwT();
        this.jGG = bVar.cwU();
        this.jGH = bVar.cwW();
        this.jGI = bVar.cwX();
        this.jGJ = bVar.cwV();
    }

    public static a cwP() {
        return jGC;
    }

    public static b cwQ() {
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
        return this.jGE == aVar.jGE && this.jGF == aVar.jGF && this.jGG == aVar.jGG && this.jGH == aVar.jGH && this.jGI == aVar.jGI && this.jGJ == aVar.jGJ;
    }

    public int hashCode() {
        return (((((((this.jGG ? 1 : 0) + (((this.jGF ? 1 : 0) + (((this.jGE ? 1 : 0) + (this.jGD * 31)) * 31)) * 31)) * 31) + (this.jGH ? 1 : 0)) * 31) + this.jGI.ordinal()) * 31) + (this.jGJ != null ? this.jGJ.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jGD), Boolean.valueOf(this.jGE), Boolean.valueOf(this.jGF), Boolean.valueOf(this.jGG), Boolean.valueOf(this.jGH), this.jGI.name(), this.jGJ);
    }
}
