package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes16.dex */
public final class d {
    private float ooJ;
    private float ooK;
    private boolean ooN;
    private float ooL = 1.0f;
    private float ooM = 1.0f;
    private float hkZ = 1.0f;

    public final float ega() {
        return this.ooJ;
    }

    public final float egb() {
        return this.ooK;
    }

    public final float egc() {
        return this.ooL;
    }

    public final float egd() {
        return this.ooM;
    }

    public final boolean ege() {
        return this.ooN;
    }

    private final void egf() {
        this.ooJ = 0.0f;
        this.ooK = 0.0f;
        this.ooL = 1.0f;
        this.ooM = 1.0f;
        this.hkZ = 1.0f;
        this.ooN = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            egf();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.ooE[scaleType.ordinal()]) {
                case 1:
                    this.ooJ = f5;
                    this.ooK = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hkZ = f9;
                        this.ooN = false;
                        this.ooL = f9;
                        this.ooM = f9;
                        this.ooJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hkZ = f10;
                    this.ooN = true;
                    this.ooL = f10;
                    this.ooM = f10;
                    this.ooK = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.ooJ = f5;
                        this.ooK = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hkZ = f10;
                        this.ooN = true;
                        this.ooL = f10;
                        this.ooM = f10;
                        this.ooK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hkZ = f9;
                        this.ooN = false;
                        this.ooL = f9;
                        this.ooM = f9;
                        this.ooJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hkZ = f10;
                        this.ooN = true;
                        this.ooL = f10;
                        this.ooM = f10;
                        this.ooK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hkZ = f9;
                    this.ooN = false;
                    this.ooL = f9;
                    this.ooM = f9;
                    this.ooJ = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hkZ = f10;
                        this.ooN = true;
                        this.ooL = f10;
                        this.ooM = f10;
                        return;
                    }
                    this.hkZ = f9;
                    this.ooN = false;
                    this.ooL = f9;
                    this.ooM = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hkZ = f10;
                        this.ooN = true;
                        this.ooL = f10;
                        this.ooM = f10;
                        this.ooK = f2 - (f4 * f10);
                        return;
                    }
                    this.hkZ = f9;
                    this.ooN = false;
                    this.ooL = f9;
                    this.ooM = f9;
                    this.ooJ = f - (f3 * f9);
                    return;
                case 7:
                    this.hkZ = Math.max(f10, f9);
                    this.ooN = f10 > f9;
                    this.ooL = f10;
                    this.ooM = f9;
                    return;
                default:
                    this.hkZ = f10;
                    this.ooN = true;
                    this.ooL = f10;
                    this.ooM = f10;
                    return;
            }
        }
    }
}
