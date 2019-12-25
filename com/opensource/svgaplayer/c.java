package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class c {
    private boolean mKB;
    private HashMap<String, Boolean> mKu = new HashMap<>();
    private HashMap<String, Bitmap> mKv = new HashMap<>();
    private HashMap<String, String> mKw = new HashMap<>();
    private HashMap<String, TextPaint> mKx = new HashMap<>();
    private HashMap<String, StaticLayout> mKy = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> mKz = new HashMap<>();
    private HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> mKA = new HashMap<>();

    public final HashMap<String, Boolean> dzD() {
        return this.mKu;
    }

    public final HashMap<String, Bitmap> dzE() {
        return this.mKv;
    }

    public final HashMap<String, String> dzF() {
        return this.mKw;
    }

    public final HashMap<String, TextPaint> dzG() {
        return this.mKx;
    }

    public final HashMap<String, StaticLayout> dzH() {
        return this.mKy;
    }

    public final HashMap<String, kotlin.jvm.a.c<Canvas, Integer, Boolean>> dzI() {
        return this.mKz;
    }

    public final HashMap<String, kotlin.jvm.a.d<Canvas, Integer, Integer, Integer, Boolean>> dzJ() {
        return this.mKA;
    }

    public final boolean dzK() {
        return this.mKB;
    }

    public final void vS(boolean z) {
        this.mKB = z;
    }
}
