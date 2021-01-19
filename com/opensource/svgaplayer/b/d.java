package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class d {
    private float pPS;
    private float pPT;
    private boolean pPW;
    private float pPU = 1.0f;
    private float pPV = 1.0f;
    private float ilx = 1.0f;

    public final float eBe() {
        return this.pPS;
    }

    public final float eBf() {
        return this.pPT;
    }

    public final float eBg() {
        return this.pPU;
    }

    public final float eBh() {
        return this.pPV;
    }

    public final boolean eBi() {
        return this.pPW;
    }

    private final void eBj() {
        this.pPS = 0.0f;
        this.pPT = 0.0f;
        this.pPU = 1.0f;
        this.pPV = 1.0f;
        this.ilx = 1.0f;
        this.pPW = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.o(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eBj();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pPN[scaleType.ordinal()]) {
                case 1:
                    this.pPS = f5;
                    this.pPT = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.ilx = f9;
                        this.pPW = false;
                        this.pPU = f9;
                        this.pPV = f9;
                        this.pPS = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.ilx = f10;
                    this.pPW = true;
                    this.pPU = f10;
                    this.pPV = f10;
                    this.pPT = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pPS = f5;
                        this.pPT = f6;
                        return;
                    } else if (f7 > f8) {
                        this.ilx = f10;
                        this.pPW = true;
                        this.pPU = f10;
                        this.pPV = f10;
                        this.pPT = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.ilx = f9;
                        this.pPW = false;
                        this.pPU = f9;
                        this.pPV = f9;
                        this.pPS = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.ilx = f10;
                        this.pPW = true;
                        this.pPU = f10;
                        this.pPV = f10;
                        this.pPT = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.ilx = f9;
                    this.pPW = false;
                    this.pPU = f9;
                    this.pPV = f9;
                    this.pPS = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.ilx = f10;
                        this.pPW = true;
                        this.pPU = f10;
                        this.pPV = f10;
                        return;
                    }
                    this.ilx = f9;
                    this.pPW = false;
                    this.pPU = f9;
                    this.pPV = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.ilx = f10;
                        this.pPW = true;
                        this.pPU = f10;
                        this.pPV = f10;
                        this.pPT = f2 - (f4 * f10);
                        return;
                    }
                    this.ilx = f9;
                    this.pPW = false;
                    this.pPU = f9;
                    this.pPV = f9;
                    this.pPS = f - (f3 * f9);
                    return;
                case 7:
                    this.ilx = Math.max(f10, f9);
                    this.pPW = f10 > f9;
                    this.pPU = f10;
                    this.pPV = f9;
                    return;
                default:
                    this.ilx = f10;
                    this.pPW = true;
                    this.pPU = f10;
                    this.pPV = f10;
                    return;
            }
        }
    }
}
