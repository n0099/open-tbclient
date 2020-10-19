package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class d {
    private float oEb;
    private float oEc;
    private boolean oEf;
    private float oEd = 1.0f;
    private float oEe = 1.0f;
    private float hzT = 1.0f;

    public final float ejL() {
        return this.oEb;
    }

    public final float ejM() {
        return this.oEc;
    }

    public final float ejN() {
        return this.oEd;
    }

    public final float ejO() {
        return this.oEe;
    }

    public final boolean ejP() {
        return this.oEf;
    }

    private final void ejQ() {
        this.oEb = 0.0f;
        this.oEc = 0.0f;
        this.oEd = 1.0f;
        this.oEe = 1.0f;
        this.hzT = 1.0f;
        this.oEf = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.n(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            ejQ();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.oDW[scaleType.ordinal()]) {
                case 1:
                    this.oEb = f5;
                    this.oEc = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hzT = f9;
                        this.oEf = false;
                        this.oEd = f9;
                        this.oEe = f9;
                        this.oEb = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hzT = f10;
                    this.oEf = true;
                    this.oEd = f10;
                    this.oEe = f10;
                    this.oEc = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.oEb = f5;
                        this.oEc = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hzT = f10;
                        this.oEf = true;
                        this.oEd = f10;
                        this.oEe = f10;
                        this.oEc = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hzT = f9;
                        this.oEf = false;
                        this.oEd = f9;
                        this.oEe = f9;
                        this.oEb = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hzT = f10;
                        this.oEf = true;
                        this.oEd = f10;
                        this.oEe = f10;
                        this.oEc = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hzT = f9;
                    this.oEf = false;
                    this.oEd = f9;
                    this.oEe = f9;
                    this.oEb = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hzT = f10;
                        this.oEf = true;
                        this.oEd = f10;
                        this.oEe = f10;
                        return;
                    }
                    this.hzT = f9;
                    this.oEf = false;
                    this.oEd = f9;
                    this.oEe = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hzT = f10;
                        this.oEf = true;
                        this.oEd = f10;
                        this.oEe = f10;
                        this.oEc = f2 - (f4 * f10);
                        return;
                    }
                    this.hzT = f9;
                    this.oEf = false;
                    this.oEd = f9;
                    this.oEe = f9;
                    this.oEb = f - (f3 * f9);
                    return;
                case 7:
                    this.hzT = Math.max(f10, f9);
                    this.oEf = f10 > f9;
                    this.oEd = f10;
                    this.oEe = f9;
                    return;
                default:
                    this.hzT = f10;
                    this.oEf = true;
                    this.oEd = f10;
                    this.oEe = f10;
                    return;
            }
        }
    }
}
