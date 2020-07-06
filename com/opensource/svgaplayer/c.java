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
/* loaded from: classes.dex */
public final class c {
    private boolean nAD;
    private HashMap<String, Boolean> nAw = new HashMap<>();
    private HashMap<String, Bitmap> nAx = new HashMap<>();
    private HashMap<String, String> nAy = new HashMap<>();
    private HashMap<String, TextPaint> nAz = new HashMap<>();
    private HashMap<String, StaticLayout> nAA = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nAB = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nAC = new HashMap<>();

    public final HashMap<String, Boolean> dLy() {
        return this.nAw;
    }

    public final HashMap<String, Bitmap> dLz() {
        return this.nAx;
    }

    public final HashMap<String, String> dLA() {
        return this.nAy;
    }

    public final HashMap<String, TextPaint> dLB() {
        return this.nAz;
    }

    public final HashMap<String, StaticLayout> dLC() {
        return this.nAA;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dLD() {
        return this.nAB;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dLE() {
        return this.nAC;
    }

    public final boolean dLF() {
        return this.nAD;
    }

    public final void xg(boolean z) {
        this.nAD = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.nAD = true;
        this.nAy.put(str2, str);
        this.nAz.put(str2, textPaint);
    }
}
