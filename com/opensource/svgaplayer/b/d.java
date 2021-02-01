package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class d {
    private float pZW;
    private float pZX;
    private boolean qaa;
    private float pZY = 1.0f;
    private float pZZ = 1.0f;
    private float ratio = 1.0f;

    public final float eDv() {
        return this.pZW;
    }

    public final float eDw() {
        return this.pZX;
    }

    public final float eDx() {
        return this.pZY;
    }

    public final float eDy() {
        return this.pZZ;
    }

    public final boolean eDz() {
        return this.qaa;
    }

    private final void eDA() {
        this.pZW = 0.0f;
        this.pZX = 0.0f;
        this.pZY = 1.0f;
        this.pZZ = 1.0f;
        this.ratio = 1.0f;
        this.qaa = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eDA();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pZR[scaleType.ordinal()]) {
                case 1:
                    this.pZW = f5;
                    this.pZX = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.ratio = f9;
                        this.qaa = false;
                        this.pZY = f9;
                        this.pZZ = f9;
                        this.pZW = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.ratio = f10;
                    this.qaa = true;
                    this.pZY = f10;
                    this.pZZ = f10;
                    this.pZX = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pZW = f5;
                        this.pZX = f6;
                        return;
                    } else if (f7 > f8) {
                        this.ratio = f10;
                        this.qaa = true;
                        this.pZY = f10;
                        this.pZZ = f10;
                        this.pZX = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.ratio = f9;
                        this.qaa = false;
                        this.pZY = f9;
                        this.pZZ = f9;
                        this.pZW = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaa = true;
                        this.pZY = f10;
                        this.pZZ = f10;
                        this.pZX = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.ratio = f9;
                    this.qaa = false;
                    this.pZY = f9;
                    this.pZZ = f9;
                    this.pZW = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaa = true;
                        this.pZY = f10;
                        this.pZZ = f10;
                        return;
                    }
                    this.ratio = f9;
                    this.qaa = false;
                    this.pZY = f9;
                    this.pZZ = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.ratio = f10;
                        this.qaa = true;
                        this.pZY = f10;
                        this.pZZ = f10;
                        this.pZX = f2 - (f4 * f10);
                        return;
                    }
                    this.ratio = f9;
                    this.qaa = false;
                    this.pZY = f9;
                    this.pZZ = f9;
                    this.pZW = f - (f3 * f9);
                    return;
                case 7:
                    this.ratio = Math.max(f10, f9);
                    this.qaa = f10 > f9;
                    this.pZY = f10;
                    this.pZZ = f9;
                    return;
                default:
                    this.ratio = f10;
                    this.qaa = true;
                    this.pZY = f10;
                    this.pZZ = f10;
                    return;
            }
        }
    }
}
