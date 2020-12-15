package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class d {
    private float pAc;
    private float pAd;
    private boolean pAg;
    private float pAe = 1.0f;
    private float pAf = 1.0f;
    private float idL = 1.0f;

    public final float eAz() {
        return this.pAc;
    }

    public final float eAA() {
        return this.pAd;
    }

    public final float eAB() {
        return this.pAe;
    }

    public final float eAC() {
        return this.pAf;
    }

    public final boolean eAD() {
        return this.pAg;
    }

    private final void eAE() {
        this.pAc = 0.0f;
        this.pAd = 0.0f;
        this.pAe = 1.0f;
        this.pAf = 1.0f;
        this.idL = 1.0f;
        this.pAg = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eAE();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pzX[scaleType.ordinal()]) {
                case 1:
                    this.pAc = f5;
                    this.pAd = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.idL = f9;
                        this.pAg = false;
                        this.pAe = f9;
                        this.pAf = f9;
                        this.pAc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.idL = f10;
                    this.pAg = true;
                    this.pAe = f10;
                    this.pAf = f10;
                    this.pAd = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pAc = f5;
                        this.pAd = f6;
                        return;
                    } else if (f7 > f8) {
                        this.idL = f10;
                        this.pAg = true;
                        this.pAe = f10;
                        this.pAf = f10;
                        this.pAd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.idL = f9;
                        this.pAg = false;
                        this.pAe = f9;
                        this.pAf = f9;
                        this.pAc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.idL = f10;
                        this.pAg = true;
                        this.pAe = f10;
                        this.pAf = f10;
                        this.pAd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.idL = f9;
                    this.pAg = false;
                    this.pAe = f9;
                    this.pAf = f9;
                    this.pAc = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.idL = f10;
                        this.pAg = true;
                        this.pAe = f10;
                        this.pAf = f10;
                        return;
                    }
                    this.idL = f9;
                    this.pAg = false;
                    this.pAe = f9;
                    this.pAf = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.idL = f10;
                        this.pAg = true;
                        this.pAe = f10;
                        this.pAf = f10;
                        this.pAd = f2 - (f4 * f10);
                        return;
                    }
                    this.idL = f9;
                    this.pAg = false;
                    this.pAe = f9;
                    this.pAf = f9;
                    this.pAc = f - (f3 * f9);
                    return;
                case 7:
                    this.idL = Math.max(f10, f9);
                    this.pAg = f10 > f9;
                    this.pAe = f10;
                    this.pAf = f9;
                    return;
                default:
                    this.idL = f10;
                    this.pAg = true;
                    this.pAe = f10;
                    this.pAf = f10;
                    return;
            }
        }
    }
}
