package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class d {
    private float nok;
    private float nol;
    private boolean noo;
    private float nom = 1.0f;
    private float non = 1.0f;
    private float fEX = 1.0f;

    public final float dGf() {
        return this.nok;
    }

    public final float dGg() {
        return this.nol;
    }

    public final float dGh() {
        return this.nom;
    }

    public final float dGi() {
        return this.non;
    }

    public final boolean dGj() {
        return this.noo;
    }

    private final void dGk() {
        this.nok = 0.0f;
        this.nol = 0.0f;
        this.nom = 1.0f;
        this.non = 1.0f;
        this.fEX = 1.0f;
        this.noo = false;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        q.j(scaleType, "scaleType");
        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f && f4 != 0.0f) {
            dGk();
            float f5 = (f - f3) / 2.0f;
            float f6 = (f2 - f4) / 2.0f;
            float f7 = f3 / f4;
            float f8 = f / f2;
            float f9 = f2 / f4;
            float f10 = f / f3;
            switch (e.nof[scaleType.ordinal()]) {
                case 1:
                    this.nok = f5;
                    this.nol = f6;
                    return;
                case 2:
                    if (f7 > f8) {
                        this.fEX = f9;
                        this.noo = false;
                        this.nom = f9;
                        this.non = f9;
                        this.nok = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                    this.fEX = f10;
                    this.noo = true;
                    this.nom = f10;
                    this.non = f10;
                    this.nol = (f2 - (f4 * f10)) / 2.0f;
                    return;
                case 3:
                    if (f3 < f && f4 < f2) {
                        this.nok = f5;
                        this.nol = f6;
                        return;
                    } else if (f7 > f8) {
                        this.fEX = f10;
                        this.noo = true;
                        this.nom = f10;
                        this.non = f10;
                        this.nol = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    } else {
                        this.fEX = f9;
                        this.noo = false;
                        this.nom = f9;
                        this.non = f9;
                        this.nok = (f - (f3 * f9)) / 2.0f;
                        return;
                    }
                case 4:
                    if (f7 > f8) {
                        this.fEX = f10;
                        this.noo = true;
                        this.nom = f10;
                        this.non = f10;
                        this.nol = (f2 - (f4 * f10)) / 2.0f;
                        return;
                    }
                    this.fEX = f9;
                    this.noo = false;
                    this.nom = f9;
                    this.non = f9;
                    this.nok = (f - (f3 * f9)) / 2.0f;
                    return;
                case 5:
                    if (f7 > f8) {
                        this.fEX = f10;
                        this.noo = true;
                        this.nom = f10;
                        this.non = f10;
                        return;
                    }
                    this.fEX = f9;
                    this.noo = false;
                    this.nom = f9;
                    this.non = f9;
                    return;
                case 6:
                    if (f7 > f8) {
                        this.fEX = f10;
                        this.noo = true;
                        this.nom = f10;
                        this.non = f10;
                        this.nol = f2 - (f4 * f10);
                        return;
                    }
                    this.fEX = f9;
                    this.noo = false;
                    this.nom = f9;
                    this.non = f9;
                    this.nok = f - (f3 * f9);
                    return;
                case 7:
                    this.fEX = Math.max(f10, f9);
                    this.noo = f10 > f9;
                    this.nom = f10;
                    this.non = f9;
                    return;
                default:
                    this.fEX = f10;
                    this.noo = true;
                    this.nom = f10;
                    this.non = f10;
                    return;
            }
        }
    }
}
