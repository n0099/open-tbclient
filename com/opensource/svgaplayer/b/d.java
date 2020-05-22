package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nfc;
    private float nfd;
    private boolean nfg;
    private float nfe = 1.0f;
    private float nff = 1.0f;
    private float gyy = 1.0f;

    public final float dHy() {
        return this.nfc;
    }

    public final float dHz() {
        return this.nfd;
    }

    public final float dHA() {
        return this.nfe;
    }

    public final float dHB() {
        return this.nff;
    }

    public final boolean dHC() {
        return this.nfg;
    }

    private final void dHD() {
        this.nfc = 0.0f;
        this.nfd = 0.0f;
        this.nfe = 1.0f;
        this.nff = 1.0f;
        this.gyy = 1.0f;
        this.nfg = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.m(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dHD();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.neX[scaleType.ordinal()]) {
                case 1:
                    this.nfc = f5;
                    this.nfd = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.gyy = f9;
                        this.nfg = false;
                        this.nfe = f9;
                        this.nff = f9;
                        this.nfc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.gyy = f10;
                    this.nfg = true;
                    this.nfe = f10;
                    this.nff = f10;
                    this.nfd = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nfc = f5;
                        this.nfd = f6;
                        return;
                    } else if (f7 > f8) {
                        this.gyy = f10;
                        this.nfg = true;
                        this.nfe = f10;
                        this.nff = f10;
                        this.nfd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.gyy = f9;
                        this.nfg = false;
                        this.nfe = f9;
                        this.nff = f9;
                        this.nfc = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.gyy = f10;
                        this.nfg = true;
                        this.nfe = f10;
                        this.nff = f10;
                        this.nfd = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.gyy = f9;
                    this.nfg = false;
                    this.nfe = f9;
                    this.nff = f9;
                    this.nfc = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.gyy = f10;
                        this.nfg = true;
                        this.nfe = f10;
                        this.nff = f10;
                        return;
                    }
                    this.gyy = f9;
                    this.nfg = false;
                    this.nfe = f9;
                    this.nff = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.gyy = f10;
                        this.nfg = true;
                        this.nfe = f10;
                        this.nff = f10;
                        this.nfd = f2 - (f4 * f10);
                        return;
                    }
                    this.gyy = f9;
                    this.nfg = false;
                    this.nfe = f9;
                    this.nff = f9;
                    this.nfc = f - (f3 * f9);
                    return;
                case 7:
                    this.gyy = Math.max(f10, f9);
                    this.nfg = f10 > f9;
                    this.nfe = f10;
                    this.nff = f9;
                    return;
                default:
                    this.gyy = f10;
                    this.nfg = true;
                    this.nfe = f10;
                    this.nff = f10;
                    return;
            }
        }
    }
}
