package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class d {
    private float oeI;
    private float oeJ;
    private boolean oeM;
    private float oeK = 1.0f;
    private float oeL = 1.0f;
    private float hdT = 1.0f;

    public final float ebU() {
        return this.oeI;
    }

    public final float ebV() {
        return this.oeJ;
    }

    public final float ebW() {
        return this.oeK;
    }

    public final float ebX() {
        return this.oeL;
    }

    public final boolean ebY() {
        return this.oeM;
    }

    private final void ebZ() {
        this.oeI = 0.0f;
        this.oeJ = 0.0f;
        this.oeK = 1.0f;
        this.oeL = 1.0f;
        this.hdT = 1.0f;
        this.oeM = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            ebZ();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.oeD[scaleType.ordinal()]) {
                case 1:
                    this.oeI = f5;
                    this.oeJ = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hdT = f9;
                        this.oeM = false;
                        this.oeK = f9;
                        this.oeL = f9;
                        this.oeI = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hdT = f10;
                    this.oeM = true;
                    this.oeK = f10;
                    this.oeL = f10;
                    this.oeJ = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.oeI = f5;
                        this.oeJ = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hdT = f10;
                        this.oeM = true;
                        this.oeK = f10;
                        this.oeL = f10;
                        this.oeJ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hdT = f9;
                        this.oeM = false;
                        this.oeK = f9;
                        this.oeL = f9;
                        this.oeI = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hdT = f10;
                        this.oeM = true;
                        this.oeK = f10;
                        this.oeL = f10;
                        this.oeJ = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hdT = f9;
                    this.oeM = false;
                    this.oeK = f9;
                    this.oeL = f9;
                    this.oeI = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hdT = f10;
                        this.oeM = true;
                        this.oeK = f10;
                        this.oeL = f10;
                        return;
                    }
                    this.hdT = f9;
                    this.oeM = false;
                    this.oeK = f9;
                    this.oeL = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hdT = f10;
                        this.oeM = true;
                        this.oeK = f10;
                        this.oeL = f10;
                        this.oeJ = f2 - (f4 * f10);
                        return;
                    }
                    this.hdT = f9;
                    this.oeM = false;
                    this.oeK = f9;
                    this.oeL = f9;
                    this.oeI = f - (f3 * f9);
                    return;
                case 7:
                    this.hdT = Math.max(f10, f9);
                    this.oeM = f10 > f9;
                    this.oeK = f10;
                    this.oeL = f9;
                    return;
                default:
                    this.hdT = f10;
                    this.oeM = true;
                    this.oeK = f10;
                    this.oeL = f10;
                    return;
            }
        }
    }
}
