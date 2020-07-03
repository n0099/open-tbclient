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
    private boolean nAA;
    private HashMap<String, Boolean> nAt = new HashMap<>();
    private HashMap<String, Bitmap> nAu = new HashMap<>();
    private HashMap<String, String> nAv = new HashMap<>();
    private HashMap<String, TextPaint> nAw = new HashMap<>();
    private HashMap<String, StaticLayout> nAx = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nAy = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nAz = new HashMap<>();

    public final HashMap<String, Boolean> dLu() {
        return this.nAt;
    }

    public final HashMap<String, Bitmap> dLv() {
        return this.nAu;
    }

    public final HashMap<String, String> dLw() {
        return this.nAv;
    }

    public final HashMap<String, TextPaint> dLx() {
        return this.nAw;
    }

    public final HashMap<String, StaticLayout> dLy() {
        return this.nAx;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dLz() {
        return this.nAy;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dLA() {
        return this.nAz;
    }

    public final boolean dLB() {
        return this.nAA;
    }

    public final void xg(boolean z) {
        this.nAA = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.nAA = true;
        this.nAv.put(str2, str);
        this.nAw.put(str2, textPaint);
    }
}
