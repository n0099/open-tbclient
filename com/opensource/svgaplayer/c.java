package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.a.r;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes17.dex */
public final class c {
    private HashMap<String, Boolean> pEO = new HashMap<>();
    private HashMap<String, Bitmap> pEP = new HashMap<>();
    private HashMap<String, String> pEQ = new HashMap<>();
    private HashMap<String, TextPaint> pER = new HashMap<>();
    private HashMap<String, StaticLayout> pES = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> pET = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> pEU = new HashMap<>();
    private boolean pEV;

    public final HashMap<String, Boolean> ewE() {
        return this.pEO;
    }

    public final HashMap<String, Bitmap> ewF() {
        return this.pEP;
    }

    public final HashMap<String, String> ewG() {
        return this.pEQ;
    }

    public final HashMap<String, TextPaint> ewH() {
        return this.pER;
    }

    public final HashMap<String, StaticLayout> ewI() {
        return this.pES;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> ewJ() {
        return this.pET;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ewK() {
        return this.pEU;
    }

    public final void AU(boolean z) {
        this.pEV = z;
    }

    public final boolean ewL() {
        return this.pEV;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.n(str, "text");
        q.n(textPaint, "textPaint");
        q.n(str2, "forKey");
        this.pEV = true;
        this.pEQ.put(str2, str);
        this.pER.put(str2, textPaint);
    }
}
