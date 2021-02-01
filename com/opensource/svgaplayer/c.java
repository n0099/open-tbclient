package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes6.dex */
public final class c {
    private HashMap<String, Boolean> pYo = new HashMap<>();
    private HashMap<String, Bitmap> pYp = new HashMap<>();
    private HashMap<String, String> pYq = new HashMap<>();
    private HashMap<String, TextPaint> pYr = new HashMap<>();
    private HashMap<String, StaticLayout> pYs = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pYt = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pYu = new HashMap<>();
    private boolean pYv;

    public final HashMap<String, Boolean> eCx() {
        return this.pYo;
    }

    public final HashMap<String, Bitmap> eCy() {
        return this.pYp;
    }

    public final HashMap<String, String> eCz() {
        return this.pYq;
    }

    public final HashMap<String, TextPaint> eCA() {
        return this.pYr;
    }

    public final HashMap<String, StaticLayout> eCB() {
        return this.pYs;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eCC() {
        return this.pYt;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eCD() {
        return this.pYu;
    }

    public final void BH(boolean z) {
        this.pYv = z;
    }

    public final boolean eCE() {
        return this.pYv;
    }
}
