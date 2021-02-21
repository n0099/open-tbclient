package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class b {
    private static final b pIj = ewl().ewt();
    public final Bitmap.Config bitmapConfig;
    public final int pIk;
    public final boolean pIl;
    public final boolean pIm;
    public final boolean pIn;
    public final boolean pIo;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b pIp;

    public b(c cVar) {
        this.pIk = cVar.ewm();
        this.pIl = cVar.ewn();
        this.pIm = cVar.ewo();
        this.pIn = cVar.ewp();
        this.pIo = cVar.ewr();
        this.bitmapConfig = cVar.ews();
        this.pIp = cVar.ewq();
    }

    public static b ewk() {
        return pIj;
    }

    public static c ewl() {
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
        return this.pIl == bVar.pIl && this.pIm == bVar.pIm && this.pIn == bVar.pIn && this.pIo == bVar.pIo && this.bitmapConfig == bVar.bitmapConfig && this.pIp == bVar.pIp;
    }

    public int hashCode() {
        return (((((((this.pIn ? 1 : 0) + (((this.pIm ? 1 : 0) + (((this.pIl ? 1 : 0) + (this.pIk * 31)) * 31)) * 31)) * 31) + (this.pIo ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.pIp != null ? this.pIp.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.pIk), Boolean.valueOf(this.pIl), Boolean.valueOf(this.pIm), Boolean.valueOf(this.pIn), Boolean.valueOf(this.pIo), this.bitmapConfig.name(), this.pIp);
    }
}
