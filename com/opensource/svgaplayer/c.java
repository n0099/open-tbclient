package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes6.dex */
public final class c {
    private HashMap<String, Boolean> pRb = new HashMap<>();
    private HashMap<String, Bitmap> pRc = new HashMap<>();
    private HashMap<String, String> pRd = new HashMap<>();
    private HashMap<String, TextPaint> pRe = new HashMap<>();
    private HashMap<String, StaticLayout> pRf = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pRg = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pRh = new HashMap<>();
    private boolean pRi;

    public final HashMap<String, Boolean> eDu() {
        return this.pRb;
    }

    public final HashMap<String, Bitmap> eDv() {
        return this.pRc;
    }

    public final HashMap<String, String> eDw() {
        return this.pRd;
    }

    public final HashMap<String, TextPaint> eDx() {
        return this.pRe;
    }

    public final HashMap<String, StaticLayout> eDy() {
        return this.pRf;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> eDz() {
        return this.pRg;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> eDA() {
        return this.pRh;
    }

    public final void Bs(boolean z) {
        this.pRi = z;
    }

    public final boolean eDB() {
        return this.pRi;
    }
}
