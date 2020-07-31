package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class d {
    private float nKN;
    private float nKO;
    private boolean nKR;
    private float nKP = 1.0f;
    private float nKQ = 1.0f;
    private float gRb = 1.0f;

    public final float dPR() {
        return this.nKN;
    }

    public final float dPS() {
        return this.nKO;
    }

    public final float dPT() {
        return this.nKP;
    }

    public final float dPU() {
        return this.nKQ;
    }

    public final boolean dPV() {
        return this.nKR;
    }

    private final void dPW() {
        this.nKN = 0.0f;
        this.nKO = 0.0f;
        this.nKP = 1.0f;
        this.nKQ = 1.0f;
        this.gRb = 1.0f;
        this.nKR = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dPW();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nKI[scaleType.ordinal()]) {
                case 1:
                    this.nKN = f5;
                    this.nKO = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gRb = f9;
                        this.nKR = false;
                        this.nKP = f9;
                        this.nKQ = f9;
                        this.nKN = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gRb = f10;
                    this.nKR = true;
                    this.nKP = f10;
                    this.nKQ = f10;
                    this.nKO = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nKN = f5;
                        this.nKO = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gRb = f10;
                        this.nKR = true;
                        this.nKP = f10;
                        this.nKQ = f10;
                        this.nKO = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gRb = f9;
                        this.nKR = false;
                        this.nKP = f9;
                        this.nKQ = f9;
                        this.nKN = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKR = true;
                        this.nKP = f10;
                        this.nKQ = f10;
                        this.nKO = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gRb = f9;
                    this.nKR = false;
                    this.nKP = f9;
                    this.nKQ = f9;
                    this.nKN = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKR = true;
                        this.nKP = f10;
                        this.nKQ = f10;
                        return;
                    }
                    this.gRb = f9;
                    this.nKR = false;
                    this.nKP = f9;
                    this.nKQ = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gRb = f10;
                        this.nKR = true;
                        this.nKP = f10;
                        this.nKQ = f10;
                        this.nKO = f2 - (f4 * f10);
                        return;
                    }
                    this.gRb = f9;
                    this.nKR = false;
                    this.nKP = f9;
                    this.nKQ = f9;
                    this.nKN = f - (f3 * f9);
                    return;
                case 7:
                    this.gRb = Math.max(f10, f9);
                    this.nKR = f10 > f9;
                    this.nKP = f10;
                    this.nKQ = f9;
                    return;
                default:
                    this.gRb = f10;
                    this.nKR = true;
                    this.nKP = f10;
                    this.nKQ = f10;
                    return;
            }
        }
    }
}
