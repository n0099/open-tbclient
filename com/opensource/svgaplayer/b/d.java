package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes15.dex */
public final class d {
    private boolean pvB;
    private float pvx;
    private float pvy;
    private float pvz = 1.0f;
    private float pvA = 1.0f;
    private float hMp = 1.0f;

    public final float etL() {
        return this.pvx;
    }

    public final float etM() {
        return this.pvy;
    }

    public final float etN() {
        return this.pvz;
    }

    public final float etO() {
        return this.pvA;
    }

    public final boolean etP() {
        return this.pvB;
    }

    private final void etQ() {
        this.pvx = 0.0f;
        this.pvy = 0.0f;
        this.pvz = 1.0f;
        this.pvA = 1.0f;
        this.hMp = 1.0f;
        this.pvB = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.n(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            etQ();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.pvs[scaleType.ordinal()]) {
                case 1:
                    this.pvx = f5;
                    this.pvy = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.hMp = f9;
                        this.pvB = false;
                        this.pvz = f9;
                        this.pvA = f9;
                        this.pvx = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.hMp = f10;
                    this.pvB = true;
                    this.pvz = f10;
                    this.pvA = f10;
                    this.pvy = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.pvx = f5;
                        this.pvy = f6;
                        return;
                    } else if (f7 > f8) {
                        this.hMp = f10;
                        this.pvB = true;
                        this.pvz = f10;
                        this.pvA = f10;
                        this.pvy = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.hMp = f9;
                        this.pvB = false;
                        this.pvz = f9;
                        this.pvA = f9;
                        this.pvx = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.hMp = f10;
                        this.pvB = true;
                        this.pvz = f10;
                        this.pvA = f10;
                        this.pvy = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.hMp = f9;
                    this.pvB = false;
                    this.pvz = f9;
                    this.pvA = f9;
                    this.pvx = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.hMp = f10;
                        this.pvB = true;
                        this.pvz = f10;
                        this.pvA = f10;
                        return;
                    }
                    this.hMp = f9;
                    this.pvB = false;
                    this.pvz = f9;
                    this.pvA = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.hMp = f10;
                        this.pvB = true;
                        this.pvz = f10;
                        this.pvA = f10;
                        this.pvy = f2 - (f4 * f10);
                        return;
                    }
                    this.hMp = f9;
                    this.pvB = false;
                    this.pvz = f9;
                    this.pvA = f9;
                    this.pvx = f - (f3 * f9);
                    return;
                case 7:
                    this.hMp = Math.max(f10, f9);
                    this.pvB = f10 > f9;
                    this.pvz = f10;
                    this.pvA = f9;
                    return;
                default:
                    this.hMp = f10;
                    this.pvB = true;
                    this.pvz = f10;
                    this.pvA = f10;
                    return;
            }
        }
    }
}
