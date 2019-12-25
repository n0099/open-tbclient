package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class d {
    private float mMc;
    private float mMd;
    private boolean mMg;
    private float mMe = 1.0f;
    private float mMf = 1.0f;
    private float fys = 1.0f;

    public final float dAA() {
        return this.mMc;
    }

    public final float dAB() {
        return this.mMd;
    }

    public final float dAC() {
        return this.mMe;
    }

    public final float dAD() {
        return this.mMf;
    }

    public final boolean dAE() {
        return this.mMg;
    }

    private final void dAF() {
        this.mMc = 0.0f;
        this.mMd = 0.0f;
        this.mMe = 1.0f;
        this.mMf = 1.0f;
        this.fys = 1.0f;
        this.mMg = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        p.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dAF();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.mLX[scaleType.ordinal()]) {
                case 1:
                    this.mMc = f5;
                    this.mMd = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fys = f9;
                        this.mMg = false;
                        this.mMe = f9;
                        this.mMf = f9;
                        this.mMc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fys = f10;
                    this.mMg = true;
                    this.mMe = f10;
                    this.mMf = f10;
                    this.mMd = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.mMc = f5;
                        this.mMd = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fys = f10;
                        this.mMg = true;
                        this.mMe = f10;
                        this.mMf = f10;
                        this.mMd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fys = f9;
                        this.mMg = false;
                        this.mMe = f9;
                        this.mMf = f9;
                        this.mMc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fys = f10;
                        this.mMg = true;
                        this.mMe = f10;
                        this.mMf = f10;
                        this.mMd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fys = f9;
                    this.mMg = false;
                    this.mMe = f9;
                    this.mMf = f9;
                    this.mMc = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fys = f10;
                        this.mMg = true;
                        this.mMe = f10;
                        this.mMf = f10;
                        return;
                    }
                    this.fys = f9;
                    this.mMg = false;
                    this.mMe = f9;
                    this.mMf = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fys = f10;
                        this.mMg = true;
                        this.mMe = f10;
                        this.mMf = f10;
                        this.mMd = f2 - (f4 * f10);
                        return;
                    }
                    this.fys = f9;
                    this.mMg = false;
                    this.mMe = f9;
                    this.mMf = f9;
                    this.mMc = f - (f3 * f9);
                    return;
                case 7:
                    this.fys = Math.max(f10, f9);
                    this.mMg = f10 > f9;
                    this.mMe = f10;
                    this.mMf = f9;
                    return;
                default:
                    this.fys = f10;
                    this.mMg = true;
                    this.mMe = f10;
                    this.mMf = f10;
                    return;
            }
        }
    }
}
