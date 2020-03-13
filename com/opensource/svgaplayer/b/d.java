package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private boolean nmB;
    private float nmx;
    private float nmy;
    private float nmz = 1.0f;
    private float nmA = 1.0f;
    private float fEp = 1.0f;

    public final float dFF() {
        return this.nmx;
    }

    public final float dFG() {
        return this.nmy;
    }

    public final float dFH() {
        return this.nmz;
    }

    public final float dFI() {
        return this.nmA;
    }

    public final boolean dFJ() {
        return this.nmB;
    }

    private final void dFK() {
        this.nmx = 0.0f;
        this.nmy = 0.0f;
        this.nmz = 1.0f;
        this.nmA = 1.0f;
        this.fEp = 1.0f;
        this.nmB = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dFK();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nms[scaleType.ordinal()]) {
                case 1:
                    this.nmx = f5;
                    this.nmy = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fEp = f9;
                        this.nmB = false;
                        this.nmz = f9;
                        this.nmA = f9;
                        this.nmx = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fEp = f10;
                    this.nmB = true;
                    this.nmz = f10;
                    this.nmA = f10;
                    this.nmy = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nmx = f5;
                        this.nmy = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fEp = f10;
                        this.nmB = true;
                        this.nmz = f10;
                        this.nmA = f10;
                        this.nmy = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fEp = f9;
                        this.nmB = false;
                        this.nmz = f9;
                        this.nmA = f9;
                        this.nmx = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fEp = f10;
                        this.nmB = true;
                        this.nmz = f10;
                        this.nmA = f10;
                        this.nmy = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fEp = f9;
                    this.nmB = false;
                    this.nmz = f9;
                    this.nmA = f9;
                    this.nmx = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fEp = f10;
                        this.nmB = true;
                        this.nmz = f10;
                        this.nmA = f10;
                        return;
                    }
                    this.fEp = f9;
                    this.nmB = false;
                    this.nmz = f9;
                    this.nmA = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fEp = f10;
                        this.nmB = true;
                        this.nmz = f10;
                        this.nmA = f10;
                        this.nmy = f2 - (f4 * f10);
                        return;
                    }
                    this.fEp = f9;
                    this.nmB = false;
                    this.nmz = f9;
                    this.nmA = f9;
                    this.nmx = f - (f3 * f9);
                    return;
                case 7:
                    this.fEp = Math.max(f10, f9);
                    this.nmB = f10 > f9;
                    this.nmz = f10;
                    this.nmA = f9;
                    return;
                default:
                    this.fEp = f10;
                    this.nmB = true;
                    this.nmz = f10;
                    this.nmA = f10;
                    return;
            }
        }
    }
}
