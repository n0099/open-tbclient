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
    private HashMap<String, Boolean> nkC = new HashMap<>();
    private HashMap<String, Bitmap> nkD = new HashMap<>();
    private HashMap<String, String> nkE = new HashMap<>();
    private HashMap<String, TextPaint> nkF = new HashMap<>();
    private HashMap<String, StaticLayout> nkG = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nkH = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nkI = new HashMap<>();
    private boolean nkJ;

    public final HashMap<String, Boolean> dEF() {
        return this.nkC;
    }

    public final HashMap<String, Bitmap> dEG() {
        return this.nkD;
    }

    public final HashMap<String, String> dEH() {
        return this.nkE;
    }

    public final HashMap<String, TextPaint> dEI() {
        return this.nkF;
    }

    public final HashMap<String, StaticLayout> dEJ() {
        return this.nkG;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dEK() {
        return this.nkH;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dEL() {
        return this.nkI;
    }

    public final boolean dEM() {
        return this.nkJ;
    }

    public final void wv(boolean z) {
        this.nkJ = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nkJ = true;
        this.nkE.put(str2, str);
        this.nkF.put(str2, textPaint);
    }
}
