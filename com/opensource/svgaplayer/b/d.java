package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nCc;
    private float nCd;
    private boolean nCg;
    private float nCe = 1.0f;
    private float nCf = 1.0f;
    private float gLv = 1.0f;

    public final float dMs() {
        return this.nCc;
    }

    public final float dMt() {
        return this.nCd;
    }

    public final float dMu() {
        return this.nCe;
    }

    public final float dMv() {
        return this.nCf;
    }

    public final boolean dMw() {
        return this.nCg;
    }

    private final void dMx() {
        this.nCc = 0.0f;
        this.nCd = 0.0f;
        this.nCe = 1.0f;
        this.nCf = 1.0f;
        this.gLv = 1.0f;
        this.nCg = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dMx();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nBX[scaleType.ordinal()]) {
                case 1:
                    this.nCc = f5;
                    this.nCd = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gLv = f9;
                        this.nCg = false;
                        this.nCe = f9;
                        this.nCf = f9;
                        this.nCc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gLv = f10;
                    this.nCg = true;
                    this.nCe = f10;
                    this.nCf = f10;
                    this.nCd = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nCc = f5;
                        this.nCd = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gLv = f10;
                        this.nCg = true;
                        this.nCe = f10;
                        this.nCf = f10;
                        this.nCd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gLv = f9;
                        this.nCg = false;
                        this.nCe = f9;
                        this.nCf = f9;
                        this.nCc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCg = true;
                        this.nCe = f10;
                        this.nCf = f10;
                        this.nCd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gLv = f9;
                    this.nCg = false;
                    this.nCe = f9;
                    this.nCf = f9;
                    this.nCc = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCg = true;
                        this.nCe = f10;
                        this.nCf = f10;
                        return;
                    }
                    this.gLv = f9;
                    this.nCg = false;
                    this.nCe = f9;
                    this.nCf = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCg = true;
                        this.nCe = f10;
                        this.nCf = f10;
                        this.nCd = f2 - (f4 * f10);
                        return;
                    }
                    this.gLv = f9;
                    this.nCg = false;
                    this.nCe = f9;
                    this.nCf = f9;
                    this.nCc = f - (f3 * f9);
                    return;
                case 7:
                    this.gLv = Math.max(f10, f9);
                    this.nCg = f10 > f9;
                    this.nCe = f10;
                    this.nCf = f9;
                    return;
                default:
                    this.gLv = f10;
                    this.nCg = true;
                    this.nCe = f10;
                    this.nCf = f10;
                    return;
            }
        }
    }
}
