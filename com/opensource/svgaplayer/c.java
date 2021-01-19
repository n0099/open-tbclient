package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes5.dex */
public final class c {
    private HashMap<String, Boolean> pOk = new HashMap<>();
    private HashMap<String, Bitmap> pOl = new HashMap<>();
    private HashMap<String, String> pOm = new HashMap<>();
    private HashMap<String, TextPaint> pOn = new HashMap<>();
    private HashMap<String, StaticLayout> pOo = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pOp = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pOq = new HashMap<>();
    private boolean pOr;

    public final HashMap<String, Boolean> eAg() {
        return this.pOk;
    }

    public final HashMap<String, Bitmap> eAh() {
        return this.pOl;
    }

    public final HashMap<String, String> eAi() {
        return this.pOm;
    }

    public final HashMap<String, TextPaint> eAj() {
        return this.pOn;
    }

    public final HashMap<String, StaticLayout> eAk() {
        return this.pOo;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eAl() {
        return this.pOp;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eAm() {
        return this.pOq;
    }

    public final void Bo(boolean z) {
        this.pOr = z;
    }

    public final boolean eAn() {
        return this.pOr;
    }
}
