package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float mKV;
    private float mKW;
    private boolean mKZ;
    private float mKX = 1.0f;
    private float mKY = 1.0f;
    private float gjC = 1.0f;

    public final float dAi() {
        return this.mKV;
    }

    public final float dAj() {
        return this.mKW;
    }

    public final float dAk() {
        return this.mKX;
    }

    public final float dAl() {
        return this.mKY;
    }

    public final boolean dAm() {
        return this.mKZ;
    }

    private final void dAn() {
        this.mKV = 0.0f;
        this.mKW = 0.0f;
        this.mKX = 1.0f;
        this.mKY = 1.0f;
        this.gjC = 1.0f;
        this.mKZ = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dAn();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.mKQ[scaleType.ordinal()]) {
                case 1:
                    this.mKV = f5;
                    this.mKW = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gjC = f9;
                        this.mKZ = false;
                        this.mKX = f9;
                        this.mKY = f9;
                        this.mKV = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gjC = f10;
                    this.mKZ = true;
                    this.mKX = f10;
                    this.mKY = f10;
                    this.mKW = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.mKV = f5;
                        this.mKW = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gjC = f10;
                        this.mKZ = true;
                        this.mKX = f10;
                        this.mKY = f10;
                        this.mKW = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gjC = f9;
                        this.mKZ = false;
                        this.mKX = f9;
                        this.mKY = f9;
                        this.mKV = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gjC = f10;
                        this.mKZ = true;
                        this.mKX = f10;
                        this.mKY = f10;
                        this.mKW = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gjC = f9;
                    this.mKZ = false;
                    this.mKX = f9;
                    this.mKY = f9;
                    this.mKV = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gjC = f10;
                        this.mKZ = true;
                        this.mKX = f10;
                        this.mKY = f10;
                        return;
                    }
                    this.gjC = f9;
                    this.mKZ = false;
                    this.mKX = f9;
                    this.mKY = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gjC = f10;
                        this.mKZ = true;
                        this.mKX = f10;
                        this.mKY = f10;
                        this.mKW = f2 - (f4 * f10);
                        return;
                    }
                    this.gjC = f9;
                    this.mKZ = false;
                    this.mKX = f9;
                    this.mKY = f9;
                    this.mKV = f - (f3 * f9);
                    return;
                case 7:
                    this.gjC = Math.max(f10, f9);
                    this.mKZ = f10 > f9;
                    this.mKX = f10;
                    this.mKY = f9;
                    return;
                default:
                    this.gjC = f10;
                    this.mKZ = true;
                    this.mKX = f10;
                    this.mKY = f10;
                    return;
            }
        }
    }
}
