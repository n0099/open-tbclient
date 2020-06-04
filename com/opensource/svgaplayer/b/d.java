package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float ngm;
    private float ngn;
    private boolean ngq;
    private float ngo = 1.0f;
    private float ngp = 1.0f;
    private float gyJ = 1.0f;

    public final float dHM() {
        return this.ngm;
    }

    public final float dHN() {
        return this.ngn;
    }

    public final float dHO() {
        return this.ngo;
    }

    public final float dHP() {
        return this.ngp;
    }

    public final boolean dHQ() {
        return this.ngq;
    }

    private final void dHR() {
        this.ngm = 0.0f;
        this.ngn = 0.0f;
        this.ngo = 1.0f;
        this.ngp = 1.0f;
        this.gyJ = 1.0f;
        this.ngq = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dHR();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.ngh[scaleType.ordinal()]) {
                case 1:
                    this.ngm = f5;
                    this.ngn = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gyJ = f9;
                        this.ngq = false;
                        this.ngo = f9;
                        this.ngp = f9;
                        this.ngm = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gyJ = f10;
                    this.ngq = true;
                    this.ngo = f10;
                    this.ngp = f10;
                    this.ngn = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.ngm = f5;
                        this.ngn = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gyJ = f10;
                        this.ngq = true;
                        this.ngo = f10;
                        this.ngp = f10;
                        this.ngn = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gyJ = f9;
                        this.ngq = false;
                        this.ngo = f9;
                        this.ngp = f9;
                        this.ngm = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gyJ = f10;
                        this.ngq = true;
                        this.ngo = f10;
                        this.ngp = f10;
                        this.ngn = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gyJ = f9;
                    this.ngq = false;
                    this.ngo = f9;
                    this.ngp = f9;
                    this.ngm = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gyJ = f10;
                        this.ngq = true;
                        this.ngo = f10;
                        this.ngp = f10;
                        return;
                    }
                    this.gyJ = f9;
                    this.ngq = false;
                    this.ngo = f9;
                    this.ngp = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gyJ = f10;
                        this.ngq = true;
                        this.ngo = f10;
                        this.ngp = f10;
                        this.ngn = f2 - (f4 * f10);
                        return;
                    }
                    this.gyJ = f9;
                    this.ngq = false;
                    this.ngo = f9;
                    this.ngp = f9;
                    this.ngm = f - (f3 * f9);
                    return;
                case 7:
                    this.gyJ = Math.max(f10, f9);
                    this.ngq = f10 > f9;
                    this.ngo = f10;
                    this.ngp = f9;
                    return;
                default:
                    this.gyJ = f10;
                    this.ngq = true;
                    this.ngo = f10;
                    this.ngp = f10;
                    return;
            }
        }
    }
}
