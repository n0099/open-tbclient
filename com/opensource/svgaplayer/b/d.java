package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class d {
    private float nlJ;
    private float nlK;
    private boolean nlN;
    private float nlL = 1.0f;
    private float nlM = 1.0f;
    private float fBD = 1.0f;

    public final float dEv() {
        return this.nlJ;
    }

    public final float dEw() {
        return this.nlK;
    }

    public final float dEx() {
        return this.nlL;
    }

    public final float dEy() {
        return this.nlM;
    }

    public final boolean dEz() {
        return this.nlN;
    }

    private final void dEA() {
        this.nlJ = 0.0f;
        this.nlK = 0.0f;
        this.nlL = 1.0f;
        this.nlM = 1.0f;
        this.fBD = 1.0f;
        this.nlN = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dEA();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nlE[scaleType.ordinal()]) {
                case 1:
                    this.nlJ = f5;
                    this.nlK = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fBD = f9;
                        this.nlN = false;
                        this.nlL = f9;
                        this.nlM = f9;
                        this.nlJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fBD = f10;
                    this.nlN = true;
                    this.nlL = f10;
                    this.nlM = f10;
                    this.nlK = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nlJ = f5;
                        this.nlK = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fBD = f10;
                        this.nlN = true;
                        this.nlL = f10;
                        this.nlM = f10;
                        this.nlK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fBD = f9;
                        this.nlN = false;
                        this.nlL = f9;
                        this.nlM = f9;
                        this.nlJ = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlN = true;
                        this.nlL = f10;
                        this.nlM = f10;
                        this.nlK = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fBD = f9;
                    this.nlN = false;
                    this.nlL = f9;
                    this.nlM = f9;
                    this.nlJ = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlN = true;
                        this.nlL = f10;
                        this.nlM = f10;
                        return;
                    }
                    this.fBD = f9;
                    this.nlN = false;
                    this.nlL = f9;
                    this.nlM = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fBD = f10;
                        this.nlN = true;
                        this.nlL = f10;
                        this.nlM = f10;
                        this.nlK = f2 - (f4 * f10);
                        return;
                    }
                    this.fBD = f9;
                    this.nlN = false;
                    this.nlL = f9;
                    this.nlM = f9;
                    this.nlJ = f - (f3 * f9);
                    return;
                case 7:
                    this.fBD = Math.max(f10, f9);
                    this.nlN = f10 > f9;
                    this.nlL = f10;
                    this.nlM = f9;
                    return;
                default:
                    this.fBD = f10;
                    this.nlN = true;
                    this.nlL = f10;
                    this.nlM = f10;
                    return;
            }
        }
    }
}
