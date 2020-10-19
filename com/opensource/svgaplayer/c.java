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
/* loaded from: classes15.dex */
public final class c {
    private boolean oCC;
    private HashMap<String, Boolean> oCv = new HashMap<>();
    private HashMap<String, Bitmap> oCw = new HashMap<>();
    private HashMap<String, String> oCx = new HashMap<>();
    private HashMap<String, TextPaint> oCy = new HashMap<>();
    private HashMap<String, StaticLayout> oCz = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> oCA = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> oCB = new HashMap<>();

    public final HashMap<String, Boolean> eiO() {
        return this.oCv;
    }

    public final HashMap<String, Bitmap> eiP() {
        return this.oCw;
    }

    public final HashMap<String, String> eiQ() {
        return this.oCx;
    }

    public final HashMap<String, TextPaint> eiR() {
        return this.oCy;
    }

    public final HashMap<String, StaticLayout> eiS() {
        return this.oCz;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> eiT() {
        return this.oCA;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> eiU() {
        return this.oCB;
    }

    public final boolean eiV() {
        return this.oCC;
    }

    public final void zu(boolean z) {
        this.oCC = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.n(str, "text");
        q.n(textPaint, "textPaint");
        q.n(str2, "forKey");
        this.oCC = true;
        this.oCx.put(str2, str);
        this.oCy.put(str2, textPaint);
    }
}
