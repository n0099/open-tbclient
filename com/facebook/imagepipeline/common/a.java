package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a jGK = cwN().cwV();
    public final int jGL;
    public final boolean jGM;
    public final boolean jGN;
    public final boolean jGO;
    public final boolean jGP;
    public final Bitmap.Config jGQ;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b jGR;

    public a(b bVar) {
        this.jGL = bVar.cwO();
        this.jGM = bVar.cwP();
        this.jGN = bVar.cwQ();
        this.jGO = bVar.cwR();
        this.jGP = bVar.cwT();
        this.jGQ = bVar.cwU();
        this.jGR = bVar.cwS();
    }

    public static a cwM() {
        return jGK;
    }

    public static b cwN() {
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
        return this.jGM == aVar.jGM && this.jGN == aVar.jGN && this.jGO == aVar.jGO && this.jGP == aVar.jGP && this.jGQ == aVar.jGQ && this.jGR == aVar.jGR;
    }

    public int hashCode() {
        return (((((((this.jGO ? 1 : 0) + (((this.jGN ? 1 : 0) + (((this.jGM ? 1 : 0) + (this.jGL * 31)) * 31)) * 31)) * 31) + (this.jGP ? 1 : 0)) * 31) + this.jGQ.ordinal()) * 31) + (this.jGR != null ? this.jGR.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.jGL), Boolean.valueOf(this.jGM), Boolean.valueOf(this.jGN), Boolean.valueOf(this.jGO), Boolean.valueOf(this.jGP), this.jGQ.name(), this.jGR);
    }
}
