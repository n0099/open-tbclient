package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes6.dex */
public final class c {
    private HashMap<String, Boolean> pSJ = new HashMap<>();
    private HashMap<String, Bitmap> pSK = new HashMap<>();
    private HashMap<String, String> pSL = new HashMap<>();
    private HashMap<String, TextPaint> pSM = new HashMap<>();
    private HashMap<String, StaticLayout> pSN = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pSO = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pSP = new HashMap<>();
    private boolean pSQ;

    public final HashMap<String, Boolean> eDY() {
        return this.pSJ;
    }

    public final HashMap<String, Bitmap> eDZ() {
        return this.pSK;
    }

    public final HashMap<String, String> eEa() {
        return this.pSL;
    }

    public final HashMap<String, TextPaint> eEb() {
        return this.pSM;
    }

    public final HashMap<String, StaticLayout> eEc() {
        return this.pSN;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eEd() {
        return this.pSO;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eEe() {
        return this.pSP;
    }

    public final void Bs(boolean z) {
        this.pSQ = z;
    }

    public final boolean eEf() {
        return this.pSQ;
    }
}
