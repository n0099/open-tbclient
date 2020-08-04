package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class d {
    private float nKP;
    private float nKQ;
    private boolean nKT;
    private float nKR = 1.0f;
    private float nKS = 1.0f;
    private float gRb = 1.0f;

    public final float dPS() {
        return this.nKP;
    }

    public final float dPT() {
        return this.nKQ;
    }

    public final float dPU() {
        return this.nKR;
    }

    public final float dPV() {
        return this.nKS;
    }

    public final boolean dPW() {
        return this.nKT;
    }

    private final void dPX() {
        this.nKP = 0.0f;
        this.nKQ = 0.0f;
        this.nKR = 1.0f;
        this.nKS = 1.0f;
        this.gRb = 1.0f;
        this.nKT = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dPX();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nKK[scaleType.ordinal()]) {
                case 1:
                    this.nKP = f5;
                    this.nKQ = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gRb = f9;
                        this.nKT = false;
                        this.nKR = f9;
                        this.nKS = f9;
                        this.nKP = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gRb = f10;
                    this.nKT = true;
                    this.nKR = f10;
                    this.nKS = f10;
                    this.nKQ = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nKP = f5;
                        this.nKQ = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gRb = f10;
                        this.nKT = true;
                        this.nKR = f10;
                        this.nKS = f10;
                        this.nKQ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gRb = f9;
                        this.nKT = false;
                        this.nKR = f9;
                        this.nKS = f9;
                        this.nKP = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKT = true;
                        this.nKR = f10;
                        this.nKS = f10;
                        this.nKQ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gRb = f9;
                    this.nKT = false;
                    this.nKR = f9;
                    this.nKS = f9;
                    this.nKP = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKT = true;
                        this.nKR = f10;
                        this.nKS = f10;
                        return;
                    }
                    this.gRb = f9;
                    this.nKT = false;
                    this.nKR = f9;
                    this.nKS = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKT = true;
                        this.nKR = f10;
                        this.nKS = f10;
                        this.nKQ = f2 - (f4 * f10);
                        return;
                    }
                    this.gRb = f9;
                    this.nKT = false;
                    this.nKR = f9;
                    this.nKS = f9;
                    this.nKP = f - (f3 * f9);
                    return;
                case 7:
                    this.gRb = Math.max(f10, f9);
                    this.nKT = f10 > f9;
                    this.nKR = f10;
                    this.nKS = f9;
                    return;
                default:
                    this.gRb = f10;
                    this.nKT = true;
                    this.nKR = f10;
                    this.nKS = f10;
                    return;
            }
        }
    }
}
