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
    private HashMap<String, Boolean> nds = new HashMap<>();
    private HashMap<String, Bitmap> ndt = new HashMap<>();
    private HashMap<String, String> ndu = new HashMap<>();
    private HashMap<String, TextPaint> ndv = new HashMap<>();
    private HashMap<String, StaticLayout> ndw = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> ndx = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ndy = new HashMap<>();
    private boolean ndz;

    public final HashMap<String, Boolean> dGA() {
        return this.nds;
    }

    public final HashMap<String, Bitmap> dGB() {
        return this.ndt;
    }

    public final HashMap<String, String> dGC() {
        return this.ndu;
    }

    public final HashMap<String, TextPaint> dGD() {
        return this.ndv;
    }

    public final HashMap<String, StaticLayout> dGE() {
        return this.ndw;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dGF() {
        return this.ndx;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dGG() {
        return this.ndy;
    }

    public final boolean dGH() {
        return this.ndz;
    }

    public final void wJ(boolean z) {
        this.ndz = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.ndz = true;
        this.ndu.put(str2, str);
        this.ndv.put(str2, textPaint);
    }
}
