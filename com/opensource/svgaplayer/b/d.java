package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nCf;
    private float nCg;
    private boolean nCj;
    private float nCh = 1.0f;
    private float nCi = 1.0f;
    private float gLv = 1.0f;

    public final float dMw() {
        return this.nCf;
    }

    public final float dMx() {
        return this.nCg;
    }

    public final float dMy() {
        return this.nCh;
    }

    public final float dMz() {
        return this.nCi;
    }

    public final boolean dMA() {
        return this.nCj;
    }

    private final void dMB() {
        this.nCf = 0.0f;
        this.nCg = 0.0f;
        this.nCh = 1.0f;
        this.nCi = 1.0f;
        this.gLv = 1.0f;
        this.nCj = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dMB();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nCa[scaleType.ordinal()]) {
                case 1:
                    this.nCf = f5;
                    this.nCg = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gLv = f9;
                        this.nCj = false;
                        this.nCh = f9;
                        this.nCi = f9;
                        this.nCf = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gLv = f10;
                    this.nCj = true;
                    this.nCh = f10;
                    this.nCi = f10;
                    this.nCg = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nCf = f5;
                        this.nCg = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gLv = f10;
                        this.nCj = true;
                        this.nCh = f10;
                        this.nCi = f10;
                        this.nCg = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gLv = f9;
                        this.nCj = false;
                        this.nCh = f9;
                        this.nCi = f9;
                        this.nCf = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCj = true;
                        this.nCh = f10;
                        this.nCi = f10;
                        this.nCg = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gLv = f9;
                    this.nCj = false;
                    this.nCh = f9;
                    this.nCi = f9;
                    this.nCf = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCj = true;
                        this.nCh = f10;
                        this.nCi = f10;
                        return;
                    }
                    this.gLv = f9;
                    this.nCj = false;
                    this.nCh = f9;
                    this.nCi = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gLv = f10;
                        this.nCj = true;
                        this.nCh = f10;
                        this.nCi = f10;
                        this.nCg = f2 - (f4 * f10);
                        return;
                    }
                    this.gLv = f9;
                    this.nCj = false;
                    this.nCh = f9;
                    this.nCi = f9;
                    this.nCf = f - (f3 * f9);
                    return;
                case 7:
                    this.gLv = Math.max(f10, f9);
                    this.nCj = f10 > f9;
                    this.nCh = f10;
                    this.nCi = f9;
                    return;
                default:
                    this.gLv = f10;
                    this.nCj = true;
                    this.nCh = f10;
                    this.nCi = f10;
                    return;
            }
        }
    }
}
