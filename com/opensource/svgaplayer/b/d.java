package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class d {
    private boolean qaA;
    private float qaw;
    private float qax;
    private float qay = 1.0f;
    private float qaz = 1.0f;
    private float ratio = 1.0f;

    public final float eDD() {
        return this.qaw;
    }

    public final float eDE() {
        return this.qax;
    }

    public final float eDF() {
        return this.qay;
    }

    public final float eDG() {
        return this.qaz;
    }

    public final boolean eDH() {
        return this.qaA;
    }

    private final void eDI() {
        this.qaw = 0.0f;
        this.qax = 0.0f;
        this.qay = 1.0f;
        this.qaz = 1.0f;
        this.ratio = 1.0f;
        this.qaA = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eDI();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.qar[scaleType.ordinal()]) {
                case 1:
                    this.qaw = f5;
                    this.qax = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.ratio = f9;
                        this.qaA = false;
                        this.qay = f9;
                        this.qaz = f9;
                        this.qaw = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.ratio = f10;
                    this.qaA = true;
                    this.qay = f10;
                    this.qaz = f10;
                    this.qax = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.qaw = f5;
                        this.qax = f6;
                        return;
                    } else if (f7 > f8) {
                        this.ratio = f10;
                        this.qaA = true;
                        this.qay = f10;
                        this.qaz = f10;
                        this.qax = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.ratio = f9;
                        this.qaA = false;
                        this.qay = f9;
                        this.qaz = f9;
                        this.qaw = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaA = true;
                        this.qay = f10;
                        this.qaz = f10;
                        this.qax = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.ratio = f9;
                    this.qaA = false;
                    this.qay = f9;
                    this.qaz = f9;
                    this.qaw = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaA = true;
                        this.qay = f10;
                        this.qaz = f10;
                        return;
                    }
                    this.ratio = f9;
                    this.qaA = false;
                    this.qay = f9;
                    this.qaz = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaA = true;
                        this.qay = f10;
                        this.qaz = f10;
                        this.qax = f2 - (f4 * f10);
                        return;
                    }
                    this.ratio = f9;
                    this.qaA = false;
                    this.qay = f9;
                    this.qaz = f9;
                    this.qaw = f - (f3 * f9);
                    return;
                case 7:
                    this.ratio = Math.max(f10, f9);
                    this.qaA = f10 > f9;
                    this.qay = f10;
                    this.qaz = f9;
                    return;
                default:
                    this.ratio = f10;
                    this.qaA = true;
                    this.qay = f10;
                    this.qaz = f10;
                    return;
            }
        }
    }
}
