package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes6.dex */
public final class c {
    private HashMap<String, Boolean> pYO = new HashMap<>();
    private HashMap<String, Bitmap> pYP = new HashMap<>();
    private HashMap<String, String> pYQ = new HashMap<>();
    private HashMap<String, TextPaint> pYR = new HashMap<>();
    private HashMap<String, StaticLayout> pYS = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pYT = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pYU = new HashMap<>();
    private boolean pYV;

    public final HashMap<String, Boolean> eCF() {
        return this.pYO;
    }

    public final HashMap<String, Bitmap> eCG() {
        return this.pYP;
    }

    public final HashMap<String, String> eCH() {
        return this.pYQ;
    }

    public final HashMap<String, TextPaint> eCI() {
        return this.pYR;
    }

    public final HashMap<String, StaticLayout> eCJ() {
        return this.pYS;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eCK() {
        return this.pYT;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eCL() {
        return this.pYU;
    }

    public final void BH(boolean z) {
        this.pYV = z;
    }

    public final boolean eCM() {
        return this.pYV;
    }
}
