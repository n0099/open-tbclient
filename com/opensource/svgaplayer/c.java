package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes5.dex */
public final class c {
    private HashMap<String, Boolean> pZC = new HashMap<>();
    private HashMap<String, Bitmap> pZD = new HashMap<>();
    private HashMap<String, String> pZE = new HashMap<>();
    private HashMap<String, TextPaint> pZF = new HashMap<>();
    private HashMap<String, StaticLayout> pZG = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pZH = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pZI = new HashMap<>();
    private boolean pZJ;

    public final HashMap<String, Boolean> eCL() {
        return this.pZC;
    }

    public final HashMap<String, Bitmap> eCM() {
        return this.pZD;
    }

    public final HashMap<String, String> eCN() {
        return this.pZE;
    }

    public final HashMap<String, TextPaint> eCO() {
        return this.pZF;
    }

    public final HashMap<String, StaticLayout> eCP() {
        return this.pZG;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eCQ() {
        return this.pZH;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eCR() {
        return this.pZI;
    }

    public final void BF(boolean z) {
        this.pZJ = z;
    }

    public final boolean eCS() {
        return this.pZJ;
    }
}
