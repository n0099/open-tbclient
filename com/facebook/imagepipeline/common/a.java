package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    private static final a ims = bWe().bWm();
    public final int imt;
    public final boolean imu;
    public final boolean imv;
    public final boolean imw;
    public final boolean imx;
    public final Bitmap.Config imy;
    @Nullable
    public final com.facebook.imagepipeline.decoder.b imz;

    public a(b bVar) {
        this.imt = bVar.bWf();
        this.imu = bVar.bWg();
        this.imv = bVar.bWh();
        this.imw = bVar.bWi();
        this.imx = bVar.bWk();
        this.imy = bVar.bWl();
        this.imz = bVar.bWj();
    }

    public static a bWd() {
        return ims;
    }

    public static b bWe() {
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
        return this.imu == aVar.imu && this.imv == aVar.imv && this.imw == aVar.imw && this.imx == aVar.imx && this.imy == aVar.imy && this.imz == aVar.imz;
    }

    public int hashCode() {
        return (((((((this.imw ? 1 : 0) + (((this.imv ? 1 : 0) + (((this.imu ? 1 : 0) + (this.imt * 31)) * 31)) * 31)) * 31) + (this.imx ? 1 : 0)) * 31) + this.imy.ordinal()) * 31) + (this.imz != null ? this.imz.hashCode() : 0);
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%s-%s", Integer.valueOf(this.imt), Boolean.valueOf(this.imu), Boolean.valueOf(this.imv), Boolean.valueOf(this.imw), Boolean.valueOf(this.imx), this.imy.name(), this.imz);
    }
}
