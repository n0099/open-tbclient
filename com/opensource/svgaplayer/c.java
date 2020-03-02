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
    private HashMap<String, Boolean> nkE = new HashMap<>();
    private HashMap<String, Bitmap> nkF = new HashMap<>();
    private HashMap<String, String> nkG = new HashMap<>();
    private HashMap<String, TextPaint> nkH = new HashMap<>();
    private HashMap<String, StaticLayout> nkI = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nkJ = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nkK = new HashMap<>();
    private boolean nkL;

    public final HashMap<String, Boolean> dEH() {
        return this.nkE;
    }

    public final HashMap<String, Bitmap> dEI() {
        return this.nkF;
    }

    public final HashMap<String, String> dEJ() {
        return this.nkG;
    }

    public final HashMap<String, TextPaint> dEK() {
        return this.nkH;
    }

    public final HashMap<String, StaticLayout> dEL() {
        return this.nkI;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dEM() {
        return this.nkJ;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dEN() {
        return this.nkK;
    }

    public final boolean dEO() {
        return this.nkL;
    }

    public final void wv(boolean z) {
        this.nkL = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nkL = true;
        this.nkG.put(str2, str);
        this.nkH.put(str2, textPaint);
    }
}
