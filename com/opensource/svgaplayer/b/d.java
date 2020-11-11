package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class d {
    private float pER;
    private float pES;
    private boolean pEV;
    private float pET = 1.0f;
    private float pEU = 1.0f;
    private float hSm = 1.0f;

    public final float exA() {
        return this.pER;
    }

    public final float exB() {
        return this.pES;
    }

    public final float exC() {
        return this.pET;
    }

    public final float exD() {
        return this.pEU;
    }

    public final boolean exE() {
        return this.pEV;
    }

    private final void exF() {
        this.pER = 0.0f;
        this.pES = 0.0f;
        this.pET = 1.0f;
        this.pEU = 1.0f;
        this.hSm = 1.0f;
        this.pEV = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.n(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            exF();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pEM[scaleType.ordinal()]) {
                case 1:
                    this.pER = f5;
                    this.pES = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hSm = f9;
                        this.pEV = false;
                        this.pET = f9;
                        this.pEU = f9;
                        this.pER = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hSm = f10;
                    this.pEV = true;
                    this.pET = f10;
                    this.pEU = f10;
                    this.pES = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pER = f5;
                        this.pES = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hSm = f10;
                        this.pEV = true;
                        this.pET = f10;
                        this.pEU = f10;
                        this.pES = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hSm = f9;
                        this.pEV = false;
                        this.pET = f9;
                        this.pEU = f9;
                        this.pER = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hSm = f10;
                        this.pEV = true;
                        this.pET = f10;
                        this.pEU = f10;
                        this.pES = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hSm = f9;
                    this.pEV = false;
                    this.pET = f9;
                    this.pEU = f9;
                    this.pER = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hSm = f10;
                        this.pEV = true;
                        this.pET = f10;
                        this.pEU = f10;
                        return;
                    }
                    this.hSm = f9;
                    this.pEV = false;
                    this.pET = f9;
                    this.pEU = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hSm = f10;
                        this.pEV = true;
                        this.pET = f10;
                        this.pEU = f10;
                        this.pES = f2 - (f4 * f10);
                        return;
                    }
                    this.hSm = f9;
                    this.pEV = false;
                    this.pET = f9;
                    this.pEU = f9;
                    this.pER = f - (f3 * f9);
                    return;
                case 7:
                    this.hSm = Math.max(f10, f9);
                    this.pEV = f10 > f9;
                    this.pET = f10;
                    this.pEU = f9;
                    return;
                default:
                    this.hSm = f10;
                    this.pEV = true;
                    this.pET = f10;
                    this.pEU = f10;
                    return;
            }
        }
    }
}
