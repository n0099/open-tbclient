package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nmm;
    private float nmn;
    private boolean nmq;
    private float nmo = 1.0f;
    private float nmp = 1.0f;
    private float fEc = 1.0f;

    public final float dFE() {
        return this.nmm;
    }

    public final float dFF() {
        return this.nmn;
    }

    public final float dFG() {
        return this.nmo;
    }

    public final float dFH() {
        return this.nmp;
    }

    public final boolean dFI() {
        return this.nmq;
    }

    private final void dFJ() {
        this.nmm = 0.0f;
        this.nmn = 0.0f;
        this.nmo = 1.0f;
        this.nmp = 1.0f;
        this.fEc = 1.0f;
        this.nmq = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dFJ();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nmh[scaleType.ordinal()]) {
                case 1:
                    this.nmm = f5;
                    this.nmn = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fEc = f9;
                        this.nmq = false;
                        this.nmo = f9;
                        this.nmp = f9;
                        this.nmm = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fEc = f10;
                    this.nmq = true;
                    this.nmo = f10;
                    this.nmp = f10;
                    this.nmn = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nmm = f5;
                        this.nmn = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fEc = f10;
                        this.nmq = true;
                        this.nmo = f10;
                        this.nmp = f10;
                        this.nmn = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fEc = f9;
                        this.nmq = false;
                        this.nmo = f9;
                        this.nmp = f9;
                        this.nmm = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fEc = f10;
                        this.nmq = true;
                        this.nmo = f10;
                        this.nmp = f10;
                        this.nmn = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fEc = f9;
                    this.nmq = false;
                    this.nmo = f9;
                    this.nmp = f9;
                    this.nmm = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fEc = f10;
                        this.nmq = true;
                        this.nmo = f10;
                        this.nmp = f10;
                        return;
                    }
                    this.fEc = f9;
                    this.nmq = false;
                    this.nmo = f9;
                    this.nmp = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fEc = f10;
                        this.nmq = true;
                        this.nmo = f10;
                        this.nmp = f10;
                        this.nmn = f2 - (f4 * f10);
                        return;
                    }
                    this.fEc = f9;
                    this.nmq = false;
                    this.nmo = f9;
                    this.nmp = f9;
                    this.nmm = f - (f3 * f9);
                    return;
                case 7:
                    this.fEc = Math.max(f10, f9);
                    this.nmq = f10 > f9;
                    this.nmo = f10;
                    this.nmp = f9;
                    return;
                default:
                    this.fEc = f10;
                    this.nmq = true;
                    this.nmo = f10;
                    this.nmp = f10;
                    return;
            }
        }
    }
}
