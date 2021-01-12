package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes5.dex */
public final class c {
    private HashMap<String, Boolean> pOj = new HashMap<>();
    private HashMap<String, Bitmap> pOk = new HashMap<>();
    private HashMap<String, String> pOl = new HashMap<>();
    private HashMap<String, TextPaint> pOm = new HashMap<>();
    private HashMap<String, StaticLayout> pOn = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pOo = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pOp = new HashMap<>();
    private boolean pOq;

    public final HashMap<String, Boolean> eAg() {
        return this.pOj;
    }

    public final HashMap<String, Bitmap> eAh() {
        return this.pOk;
    }

    public final HashMap<String, String> eAi() {
        return this.pOl;
    }

    public final HashMap<String, TextPaint> eAj() {
        return this.pOm;
    }

    public final HashMap<String, StaticLayout> eAk() {
        return this.pOn;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eAl() {
        return this.pOo;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eAm() {
        return this.pOp;
    }

    public final void Bo(boolean z) {
        this.pOq = z;
    }

    public final boolean eAn() {
        return this.pOq;
    }
}
