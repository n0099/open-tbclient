package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes13.dex */
public class b {
    private static final b lRs = dol().dot();
    public final Bitmap.Config bitmapConfig;
    public final int lRt;
    public final boolean lRu;
    public final boolean lRv;
    public final boolean lRw;
    public final boolean lRx;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b lRy;

    public b(c cVar) {
        this.lRt = cVar.dom();
        this.lRu = cVar.don();
        this.lRv = cVar.doo();
        this.lRw = cVar.dop();
        this.lRx = cVar.dor();
        this.bitmapConfig = cVar.dos();
        this.lRy = cVar.doq();
    }

    public static b dok() {
        return lRs;
    }

    public static c dol() {
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
        return this.lRu == bVar.lRu && this.lRv == bVar.lRv && this.lRw == bVar.lRw && this.lRx == bVar.lRx && this.bitmapConfig == bVar.bitmapConfig && this.lRy == bVar.lRy;
    }

    public int hashCode() {
        return (((((((this.lRw ? 1 : 0) + (((this.lRv ? 1 : 0) + (((this.lRu ? 1 : 0) + (this.lRt * 31)) * 31)) * 31)) * 31) + (this.lRx ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.lRy != null ? this.lRy.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.lRt), Boolean.valueOf(this.lRu), Boolean.valueOf(this.lRv), Boolean.valueOf(this.lRw), Boolean.valueOf(this.lRx), this.bitmapConfig.name(), this.lRy);
    }
}
