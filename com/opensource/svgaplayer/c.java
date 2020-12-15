package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
@kotlin.e
/* loaded from: classes18.dex */
public final class c {
    private boolean pyD;
    private HashMap<String, Boolean> pyw = new HashMap<>();
    private HashMap<String, Bitmap> pyx = new HashMap<>();
    private HashMap<String, String> pyy = new HashMap<>();
    private HashMap<String, TextPaint> pyz = new HashMap<>();
    private HashMap<String, StaticLayout> pyA = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> pyB = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> pyC = new HashMap<>();

    public final HashMap<String, Boolean> ezC() {
        return this.pyw;
    }

    public final HashMap<String, Bitmap> ezD() {
        return this.pyx;
    }

    public final HashMap<String, String> ezE() {
        return this.pyy;
    }

    public final HashMap<String, TextPaint> ezF() {
        return this.pyz;
    }

    public final HashMap<String, StaticLayout> ezG() {
        return this.pyA;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> ezH() {
        return this.pyB;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> ezI() {
        return this.pyC;
    }

    public final void Bi(boolean z) {
        this.pyD = z;
    }

    public final boolean ezJ() {
        return this.pyD;
    }
}
