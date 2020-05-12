package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float mKY;
    private float mKZ;
    private boolean mLc;
    private float mLa = 1.0f;
    private float mLb = 1.0f;
    private float gjI = 1.0f;

    public final float dAf() {
        return this.mKY;
    }

    public final float dAg() {
        return this.mKZ;
    }

    public final float dAh() {
        return this.mLa;
    }

    public final float dAi() {
        return this.mLb;
    }

    public final boolean dAj() {
        return this.mLc;
    }

    private final void dAk() {
        this.mKY = 0.0f;
        this.mKZ = 0.0f;
        this.mLa = 1.0f;
        this.mLb = 1.0f;
        this.gjI = 1.0f;
        this.mLc = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dAk();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.mKT[scaleType.ordinal()]) {
                case 1:
                    this.mKY = f5;
                    this.mKZ = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gjI = f9;
                        this.mLc = false;
                        this.mLa = f9;
                        this.mLb = f9;
                        this.mKY = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gjI = f10;
                    this.mLc = true;
                    this.mLa = f10;
                    this.mLb = f10;
                    this.mKZ = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.mKY = f5;
                        this.mKZ = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gjI = f10;
                        this.mLc = true;
                        this.mLa = f10;
                        this.mLb = f10;
                        this.mKZ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gjI = f9;
                        this.mLc = false;
                        this.mLa = f9;
                        this.mLb = f9;
                        this.mKY = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gjI = f10;
                        this.mLc = true;
                        this.mLa = f10;
                        this.mLb = f10;
                        this.mKZ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gjI = f9;
                    this.mLc = false;
                    this.mLa = f9;
                    this.mLb = f9;
                    this.mKY = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gjI = f10;
                        this.mLc = true;
                        this.mLa = f10;
                        this.mLb = f10;
                        return;
                    }
                    this.gjI = f9;
                    this.mLc = false;
                    this.mLa = f9;
                    this.mLb = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gjI = f10;
                        this.mLc = true;
                        this.mLa = f10;
                        this.mLb = f10;
                        this.mKZ = f2 - (f4 * f10);
                        return;
                    }
                    this.gjI = f9;
                    this.mLc = false;
                    this.mLa = f9;
                    this.mLb = f9;
                    this.mKY = f - (f3 * f9);
                    return;
                case 7:
                    this.gjI = Math.max(f10, f9);
                    this.mLc = f10 > f9;
                    this.mLa = f10;
                    this.mLb = f9;
                    return;
                default:
                    this.gjI = f10;
                    this.mLc = true;
                    this.mLa = f10;
                    this.mLb = f10;
                    return;
            }
        }
    }
}
