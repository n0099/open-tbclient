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
    private HashMap<String, Boolean> nkP = new HashMap<>();
    private HashMap<String, Bitmap> nkQ = new HashMap<>();
    private HashMap<String, String> nkR = new HashMap<>();
    private HashMap<String, TextPaint> nkS = new HashMap<>();
    private HashMap<String, StaticLayout> nkT = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nkU = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nkV = new HashMap<>();
    private boolean nkW;

    public final HashMap<String, Boolean> dEI() {
        return this.nkP;
    }

    public final HashMap<String, Bitmap> dEJ() {
        return this.nkQ;
    }

    public final HashMap<String, String> dEK() {
        return this.nkR;
    }

    public final HashMap<String, TextPaint> dEL() {
        return this.nkS;
    }

    public final HashMap<String, StaticLayout> dEM() {
        return this.nkT;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dEN() {
        return this.nkU;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dEO() {
        return this.nkV;
    }

    public final boolean dEP() {
        return this.nkW;
    }

    public final void wv(boolean z) {
        this.nkW = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nkW = true;
        this.nkR.put(str2, str);
        this.nkS.put(str2, textPaint);
    }
}
