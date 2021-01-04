package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class d {
    private float pSJ;
    private float pSK;
    private boolean pSN;
    private float pSL = 1.0f;
    private float pSM = 1.0f;
    private float iqg = 1.0f;

    public final float eEr() {
        return this.pSJ;
    }

    public final float eEs() {
        return this.pSK;
    }

    public final float eEt() {
        return this.pSL;
    }

    public final float eEu() {
        return this.pSM;
    }

    public final boolean eEv() {
        return this.pSN;
    }

    private final void eEw() {
        this.pSJ = 0.0f;
        this.pSK = 0.0f;
        this.pSL = 1.0f;
        this.pSM = 1.0f;
        this.iqg = 1.0f;
        this.pSN = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eEw();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pSE[scaleType.ordinal()]) {
                case 1:
                    this.pSJ = f5;
                    this.pSK = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.iqg = f9;
                        this.pSN = false;
                        this.pSL = f9;
                        this.pSM = f9;
                        this.pSJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.iqg = f10;
                    this.pSN = true;
                    this.pSL = f10;
                    this.pSM = f10;
                    this.pSK = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pSJ = f5;
                        this.pSK = f6;
                        return;
                    } else if (f7 > f8) {
                        this.iqg = f10;
                        this.pSN = true;
                        this.pSL = f10;
                        this.pSM = f10;
                        this.pSK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.iqg = f9;
                        this.pSN = false;
                        this.pSL = f9;
                        this.pSM = f9;
                        this.pSJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pSN = true;
                        this.pSL = f10;
                        this.pSM = f10;
                        this.pSK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.iqg = f9;
                    this.pSN = false;
                    this.pSL = f9;
                    this.pSM = f9;
                    this.pSJ = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pSN = true;
                        this.pSL = f10;
                        this.pSM = f10;
                        return;
                    }
                    this.iqg = f9;
                    this.pSN = false;
                    this.pSL = f9;
                    this.pSM = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pSN = true;
                        this.pSL = f10;
                        this.pSM = f10;
                        this.pSK = f2 - (f4 * f10);
                        return;
                    }
                    this.iqg = f9;
                    this.pSN = false;
                    this.pSL = f9;
                    this.pSM = f9;
                    this.pSJ = f - (f3 * f9);
                    return;
                case 7:
                    this.iqg = Math.max(f10, f9);
                    this.pSN = f10 > f9;
                    this.pSL = f10;
                    this.pSM = f9;
                    return;
                default:
                    this.iqg = f10;
                    this.pSN = true;
                    this.pSL = f10;
                    this.pSM = f10;
                    return;
            }
        }
    }
}
