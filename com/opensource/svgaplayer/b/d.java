package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class d {
    private float nlE;
    private float nlF;
    private boolean nlI;
    private float nlG = 1.0f;
    private float nlH = 1.0f;
    private float fBD = 1.0f;

    public final float dEt() {
        return this.nlE;
    }

    public final float dEu() {
        return this.nlF;
    }

    public final float dEv() {
        return this.nlG;
    }

    public final float dEw() {
        return this.nlH;
    }

    public final boolean dEx() {
        return this.nlI;
    }

    private final void dEy() {
        this.nlE = 0.0f;
        this.nlF = 0.0f;
        this.nlG = 1.0f;
        this.nlH = 1.0f;
        this.fBD = 1.0f;
        this.nlI = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dEy();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nlz[scaleType.ordinal()]) {
                case 1:
                    this.nlE = f5;
                    this.nlF = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fBD = f9;
                        this.nlI = false;
                        this.nlG = f9;
                        this.nlH = f9;
                        this.nlE = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fBD = f10;
                    this.nlI = true;
                    this.nlG = f10;
                    this.nlH = f10;
                    this.nlF = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nlE = f5;
                        this.nlF = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fBD = f10;
                        this.nlI = true;
                        this.nlG = f10;
                        this.nlH = f10;
                        this.nlF = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fBD = f9;
                        this.nlI = false;
                        this.nlG = f9;
                        this.nlH = f9;
                        this.nlE = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlI = true;
                        this.nlG = f10;
                        this.nlH = f10;
                        this.nlF = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fBD = f9;
                    this.nlI = false;
                    this.nlG = f9;
                    this.nlH = f9;
                    this.nlE = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlI = true;
                        this.nlG = f10;
                        this.nlH = f10;
                        return;
                    }
                    this.fBD = f9;
                    this.nlI = false;
                    this.nlG = f9;
                    this.nlH = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlI = true;
                        this.nlG = f10;
                        this.nlH = f10;
                        this.nlF = f2 - (f4 * f10);
                        return;
                    }
                    this.fBD = f9;
                    this.nlI = false;
                    this.nlG = f9;
                    this.nlH = f9;
                    this.nlE = f - (f3 * f9);
                    return;
                case 7:
                    this.fBD = Math.max(f10, f9);
                    this.nlI = f10 > f9;
                    this.nlG = f10;
                    this.nlH = f9;
                    return;
                default:
                    this.fBD = f10;
                    this.nlI = true;
                    this.nlG = f10;
                    this.nlH = f10;
                    return;
            }
        }
    }
}
