package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes18.dex */
public final class d {
    private float pAa;
    private float pAb;
    private boolean pAe;
    private float pAc = 1.0f;
    private float pAd = 1.0f;
    private float idJ = 1.0f;

    public final float eAy() {
        return this.pAa;
    }

    public final float eAz() {
        return this.pAb;
    }

    public final float eAA() {
        return this.pAc;
    }

    public final float eAB() {
        return this.pAd;
    }

    public final boolean eAC() {
        return this.pAe;
    }

    private final void eAD() {
        this.pAa = 0.0f;
        this.pAb = 0.0f;
        this.pAc = 1.0f;
        this.pAd = 1.0f;
        this.idJ = 1.0f;
        this.pAe = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eAD();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pzV[scaleType.ordinal()]) {
                case 1:
                    this.pAa = f5;
                    this.pAb = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.idJ = f9;
                        this.pAe = false;
                        this.pAc = f9;
                        this.pAd = f9;
                        this.pAa = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.idJ = f10;
                    this.pAe = true;
                    this.pAc = f10;
                    this.pAd = f10;
                    this.pAb = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pAa = f5;
                        this.pAb = f6;
                        return;
                    } else if (f7 > f8) {
                        this.idJ = f10;
                        this.pAe = true;
                        this.pAc = f10;
                        this.pAd = f10;
                        this.pAb = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.idJ = f9;
                        this.pAe = false;
                        this.pAc = f9;
                        this.pAd = f9;
                        this.pAa = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.idJ = f10;
                        this.pAe = true;
                        this.pAc = f10;
                        this.pAd = f10;
                        this.pAb = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.idJ = f9;
                    this.pAe = false;
                    this.pAc = f9;
                    this.pAd = f9;
                    this.pAa = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.idJ = f10;
                        this.pAe = true;
                        this.pAc = f10;
                        this.pAd = f10;
                        return;
                    }
                    this.idJ = f9;
                    this.pAe = false;
                    this.pAc = f9;
                    this.pAd = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.idJ = f10;
                        this.pAe = true;
                        this.pAc = f10;
                        this.pAd = f10;
                        this.pAb = f2 - (f4 * f10);
                        return;
                    }
                    this.idJ = f9;
                    this.pAe = false;
                    this.pAc = f9;
                    this.pAd = f9;
                    this.pAa = f - (f3 * f9);
                    return;
                case 7:
                    this.idJ = Math.max(f10, f9);
                    this.pAe = f10 > f9;
                    this.pAc = f10;
                    this.pAd = f9;
                    return;
                default:
                    this.idJ = f10;
                    this.pAe = true;
                    this.pAc = f10;
                    this.pAd = f10;
                    return;
            }
        }
    }
}
