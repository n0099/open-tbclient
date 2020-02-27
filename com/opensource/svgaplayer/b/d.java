package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nmk;
    private float nml;
    private boolean nmo;
    private float nmm = 1.0f;
    private float nmn = 1.0f;
    private float fEa = 1.0f;

    public final float dFC() {
        return this.nmk;
    }

    public final float dFD() {
        return this.nml;
    }

    public final float dFE() {
        return this.nmm;
    }

    public final float dFF() {
        return this.nmn;
    }

    public final boolean dFG() {
        return this.nmo;
    }

    private final void dFH() {
        this.nmk = 0.0f;
        this.nml = 0.0f;
        this.nmm = 1.0f;
        this.nmn = 1.0f;
        this.fEa = 1.0f;
        this.nmo = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dFH();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nmf[scaleType.ordinal()]) {
                case 1:
                    this.nmk = f5;
                    this.nml = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fEa = f9;
                        this.nmo = false;
                        this.nmm = f9;
                        this.nmn = f9;
                        this.nmk = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fEa = f10;
                    this.nmo = true;
                    this.nmm = f10;
                    this.nmn = f10;
                    this.nml = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nmk = f5;
                        this.nml = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fEa = f10;
                        this.nmo = true;
                        this.nmm = f10;
                        this.nmn = f10;
                        this.nml = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fEa = f9;
                        this.nmo = false;
                        this.nmm = f9;
                        this.nmn = f9;
                        this.nmk = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fEa = f10;
                        this.nmo = true;
                        this.nmm = f10;
                        this.nmn = f10;
                        this.nml = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fEa = f9;
                    this.nmo = false;
                    this.nmm = f9;
                    this.nmn = f9;
                    this.nmk = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fEa = f10;
                        this.nmo = true;
                        this.nmm = f10;
                        this.nmn = f10;
                        return;
                    }
                    this.fEa = f9;
                    this.nmo = false;
                    this.nmm = f9;
                    this.nmn = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fEa = f10;
                        this.nmo = true;
                        this.nmm = f10;
                        this.nmn = f10;
                        this.nml = f2 - (f4 * f10);
                        return;
                    }
                    this.fEa = f9;
                    this.nmo = false;
                    this.nmm = f9;
                    this.nmn = f9;
                    this.nmk = f - (f3 * f9);
                    return;
                case 7:
                    this.fEa = Math.max(f10, f9);
                    this.nmo = f10 > f9;
                    this.nmm = f10;
                    this.nmn = f9;
                    return;
                default:
                    this.fEa = f10;
                    this.nmo = true;
                    this.nmm = f10;
                    this.nmn = f10;
                    return;
            }
        }
    }
}
