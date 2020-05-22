package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b muS = dya().dyi();
    public final int muT;
    public final boolean muU;
    public final boolean muV;
    public final boolean muW;
    public final boolean muX;
    public final Bitmap.Config muY;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b muZ;

    public b(c cVar) {
        this.muT = cVar.dyb();
        this.muU = cVar.dyc();
        this.muV = cVar.dyd();
        this.muW = cVar.dye();
        this.muX = cVar.dyg();
        this.muY = cVar.dyh();
        this.muZ = cVar.dyf();
    }

    public static b dxZ() {
        return muS;
    }

    public static c dya() {
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
        return this.muU == bVar.muU && this.muV == bVar.muV && this.muW == bVar.muW && this.muX == bVar.muX && this.muY == bVar.muY && this.muZ == bVar.muZ;
    }

    public int hashCode() {
        return (((((((this.muW ? 1 : 0) + (((this.muV ? 1 : 0) + (((this.muU ? 1 : 0) + (this.muT * 31)) * 31)) * 31)) * 31) + (this.muX ? 1 : 0)) * 31) + this.muY.ordinal()) * 31) + (this.muZ != null ? this.muZ.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.muT), Boolean.valueOf(this.muU), Boolean.valueOf(this.muV), Boolean.valueOf(this.muW), Boolean.valueOf(this.muX), this.muY.name(), this.muZ);
    }
}
