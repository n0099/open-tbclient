package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class d {
    private float pUr;
    private float pUs;
    private boolean pUv;
    private float pUt = 1.0f;
    private float pUu = 1.0f;
    private float iqg = 1.0f;

    public final float eEV() {
        return this.pUr;
    }

    public final float eEW() {
        return this.pUs;
    }

    public final float eEX() {
        return this.pUt;
    }

    public final float eEY() {
        return this.pUu;
    }

    public final boolean eEZ() {
        return this.pUv;
    }

    private final void eFa() {
        this.pUr = 0.0f;
        this.pUs = 0.0f;
        this.pUt = 1.0f;
        this.pUu = 1.0f;
        this.iqg = 1.0f;
        this.pUv = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eFa();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pUm[scaleType.ordinal()]) {
                case 1:
                    this.pUr = f5;
                    this.pUs = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.iqg = f9;
                        this.pUv = false;
                        this.pUt = f9;
                        this.pUu = f9;
                        this.pUr = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.iqg = f10;
                    this.pUv = true;
                    this.pUt = f10;
                    this.pUu = f10;
                    this.pUs = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pUr = f5;
                        this.pUs = f6;
                        return;
                    } else if (f7 > f8) {
                        this.iqg = f10;
                        this.pUv = true;
                        this.pUt = f10;
                        this.pUu = f10;
                        this.pUs = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.iqg = f9;
                        this.pUv = false;
                        this.pUt = f9;
                        this.pUu = f9;
                        this.pUr = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pUv = true;
                        this.pUt = f10;
                        this.pUu = f10;
                        this.pUs = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.iqg = f9;
                    this.pUv = false;
                    this.pUt = f9;
                    this.pUu = f9;
                    this.pUr = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pUv = true;
                        this.pUt = f10;
                        this.pUu = f10;
                        return;
                    }
                    this.iqg = f9;
                    this.pUv = false;
                    this.pUt = f9;
                    this.pUu = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.iqg = f10;
                        this.pUv = true;
                        this.pUt = f10;
                        this.pUu = f10;
                        this.pUs = f2 - (f4 * f10);
                        return;
                    }
                    this.iqg = f9;
                    this.pUv = false;
                    this.pUt = f9;
                    this.pUu = f9;
                    this.pUr = f - (f3 * f9);
                    return;
                case 7:
                    this.iqg = Math.max(f10, f9);
                    this.pUv = f10 > f9;
                    this.pUt = f10;
                    this.pUu = f9;
                    return;
                default:
                    this.iqg = f10;
                    this.pUv = true;
                    this.pUt = f10;
                    this.pUu = f10;
                    return;
            }
        }
    }
}
