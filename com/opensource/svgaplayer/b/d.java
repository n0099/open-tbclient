package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class d {
    private float ofa;
    private float ofb;
    private boolean ofe;
    private float ofc = 1.0f;
    private float ofd = 1.0f;
    private float hdX = 1.0f;

    public final float ecd() {
        return this.ofa;
    }

    public final float ece() {
        return this.ofb;
    }

    public final float ecf() {
        return this.ofc;
    }

    public final float ecg() {
        return this.ofd;
    }

    public final boolean ech() {
        return this.ofe;
    }

    private final void eci() {
        this.ofa = 0.0f;
        this.ofb = 0.0f;
        this.ofc = 1.0f;
        this.ofd = 1.0f;
        this.hdX = 1.0f;
        this.ofe = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            eci();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.oeV[scaleType.ordinal()]) {
                case 1:
                    this.ofa = f5;
                    this.ofb = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hdX = f9;
                        this.ofe = false;
                        this.ofc = f9;
                        this.ofd = f9;
                        this.ofa = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hdX = f10;
                    this.ofe = true;
                    this.ofc = f10;
                    this.ofd = f10;
                    this.ofb = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.ofa = f5;
                        this.ofb = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hdX = f10;
                        this.ofe = true;
                        this.ofc = f10;
                        this.ofd = f10;
                        this.ofb = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hdX = f9;
                        this.ofe = false;
                        this.ofc = f9;
                        this.ofd = f9;
                        this.ofa = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hdX = f10;
                        this.ofe = true;
                        this.ofc = f10;
                        this.ofd = f10;
                        this.ofb = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hdX = f9;
                    this.ofe = false;
                    this.ofc = f9;
                    this.ofd = f9;
                    this.ofa = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hdX = f10;
                        this.ofe = true;
                        this.ofc = f10;
                        this.ofd = f10;
                        return;
                    }
                    this.hdX = f9;
                    this.ofe = false;
                    this.ofc = f9;
                    this.ofd = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hdX = f10;
                        this.ofe = true;
                        this.ofc = f10;
                        this.ofd = f10;
                        this.ofb = f2 - (f4 * f10);
                        return;
                    }
                    this.hdX = f9;
                    this.ofe = false;
                    this.ofc = f9;
                    this.ofd = f9;
                    this.ofa = f - (f3 * f9);
                    return;
                case 7:
                    this.hdX = Math.max(f10, f9);
                    this.ofe = f10 > f9;
                    this.ofc = f10;
                    this.ofd = f9;
                    return;
                default:
                    this.hdX = f10;
                    this.ofe = true;
                    this.ofc = f10;
                    this.ofd = f10;
                    return;
            }
        }
    }
}
