package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class d {
    private float qbk;
    private float qbl;
    private boolean qbo;
    private float qbm = 1.0f;
    private float qbn = 1.0f;
    private float ratio = 1.0f;

    public final float eDJ() {
        return this.qbk;
    }

    public final float eDK() {
        return this.qbl;
    }

    public final float eDL() {
        return this.qbm;
    }

    public final float eDM() {
        return this.qbn;
    }

    public final boolean eDN() {
        return this.qbo;
    }

    private final void eDO() {
        this.qbk = 0.0f;
        this.qbl = 0.0f;
        this.qbm = 1.0f;
        this.qbn = 1.0f;
        this.ratio = 1.0f;
        this.qbo = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.p(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eDO();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.qbf[scaleType.ordinal()]) {
                case 1:
                    this.qbk = f5;
                    this.qbl = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.ratio = f9;
                        this.qbo = false;
                        this.qbm = f9;
                        this.qbn = f9;
                        this.qbk = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.ratio = f10;
                    this.qbo = true;
                    this.qbm = f10;
                    this.qbn = f10;
                    this.qbl = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.qbk = f5;
                        this.qbl = f6;
                        return;
                    } else if (f7 > f8) {
                        this.ratio = f10;
                        this.qbo = true;
                        this.qbm = f10;
                        this.qbn = f10;
                        this.qbl = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.ratio = f9;
                        this.qbo = false;
                        this.qbm = f9;
                        this.qbn = f9;
                        this.qbk = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qbo = true;
                        this.qbm = f10;
                        this.qbn = f10;
                        this.qbl = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.ratio = f9;
                    this.qbo = false;
                    this.qbm = f9;
                    this.qbn = f9;
                    this.qbk = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qbo = true;
                        this.qbm = f10;
                        this.qbn = f10;
                        return;
                    }
                    this.ratio = f9;
                    this.qbo = false;
                    this.qbm = f9;
                    this.qbn = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qbo = true;
                        this.qbm = f10;
                        this.qbn = f10;
                        this.qbl = f2 - (f4 * f10);
                        return;
                    }
                    this.ratio = f9;
                    this.qbo = false;
                    this.qbm = f9;
                    this.qbn = f9;
                    this.qbk = f - (f3 * f9);
                    return;
                case 7:
                    this.ratio = Math.max(f10, f9);
                    this.qbo = f10 > f9;
                    this.qbm = f10;
                    this.qbn = f9;
                    return;
                default:
                    this.ratio = f10;
                    this.qbo = true;
                    this.qbm = f10;
                    this.qbn = f10;
                    return;
            }
        }
    }
}
