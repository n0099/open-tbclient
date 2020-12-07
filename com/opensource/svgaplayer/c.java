package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes18.dex */
public final class c {
    private boolean pyB;
    private HashMap<String, Boolean> pyu = new HashMap<>();
    private HashMap<String, Bitmap> pyv = new HashMap<>();
    private HashMap<String, String> pyw = new HashMap<>();
    private HashMap<String, TextPaint> pyx = new HashMap<>();
    private HashMap<String, StaticLayout> pyy = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pyz = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pyA = new HashMap<>();

    public final HashMap<String, Boolean> ezB() {
        return this.pyu;
    }

    public final HashMap<String, Bitmap> ezC() {
        return this.pyv;
    }

    public final HashMap<String, String> ezD() {
        return this.pyw;
    }

    public final HashMap<String, TextPaint> ezE() {
        return this.pyx;
    }

    public final HashMap<String, StaticLayout> ezF() {
        return this.pyy;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> ezG() {
        return this.pyz;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> ezH() {
        return this.pyA;
    }

    public final void Bi(boolean z) {
        this.pyB = z;
    }

    public final boolean ezI() {
        return this.pyB;
    }
}
