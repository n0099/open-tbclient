package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes17.dex */
public final class d {
    private float pGu;
    private float pGv;
    private boolean pGy;
    private float pGw = 1.0f;
    private float pGx = 1.0f;
    private float hSM = 1.0f;

    public final float exB() {
        return this.pGu;
    }

    public final float exC() {
        return this.pGv;
    }

    public final float exD() {
        return this.pGw;
    }

    public final float exE() {
        return this.pGx;
    }

    public final boolean exF() {
        return this.pGy;
    }

    private final void exG() {
        this.pGu = 0.0f;
        this.pGv = 0.0f;
        this.pGw = 1.0f;
        this.pGx = 1.0f;
        this.hSM = 1.0f;
        this.pGy = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.n(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            exG();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pGp[scaleType.ordinal()]) {
                case 1:
                    this.pGu = f5;
                    this.pGv = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hSM = f9;
                        this.pGy = false;
                        this.pGw = f9;
                        this.pGx = f9;
                        this.pGu = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hSM = f10;
                    this.pGy = true;
                    this.pGw = f10;
                    this.pGx = f10;
                    this.pGv = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pGu = f5;
                        this.pGv = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hSM = f10;
                        this.pGy = true;
                        this.pGw = f10;
                        this.pGx = f10;
                        this.pGv = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hSM = f9;
                        this.pGy = false;
                        this.pGw = f9;
                        this.pGx = f9;
                        this.pGu = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hSM = f10;
                        this.pGy = true;
                        this.pGw = f10;
                        this.pGx = f10;
                        this.pGv = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hSM = f9;
                    this.pGy = false;
                    this.pGw = f9;
                    this.pGx = f9;
                    this.pGu = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hSM = f10;
                        this.pGy = true;
                        this.pGw = f10;
                        this.pGx = f10;
                        return;
                    }
                    this.hSM = f9;
                    this.pGy = false;
                    this.pGw = f9;
                    this.pGx = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hSM = f10;
                        this.pGy = true;
                        this.pGw = f10;
                        this.pGx = f10;
                        this.pGv = f2 - (f4 * f10);
                        return;
                    }
                    this.hSM = f9;
                    this.pGy = false;
                    this.pGw = f9;
                    this.pGx = f9;
                    this.pGu = f - (f3 * f9);
                    return;
                case 7:
                    this.hSM = Math.max(f10, f9);
                    this.pGy = f10 > f9;
                    this.pGw = f10;
                    this.pGx = f9;
                    return;
                default:
                    this.hSM = f10;
                    this.pGy = true;
                    this.pGw = f10;
                    this.pGx = f10;
                    return;
            }
        }
    }
}
