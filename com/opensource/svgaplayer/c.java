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
/* loaded from: classes8.dex */
public final class c {
    private HashMap<String, Boolean> nJe = new HashMap<>();
    private HashMap<String, Bitmap> nJf = new HashMap<>();
    private HashMap<String, String> nJg = new HashMap<>();
    private HashMap<String, TextPaint> nJh = new HashMap<>();
    private HashMap<String, StaticLayout> nJi = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nJj = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nJk = new HashMap<>();
    private boolean nJl;

    public final HashMap<String, Boolean> dOT() {
        return this.nJe;
    }

    public final HashMap<String, Bitmap> dOU() {
        return this.nJf;
    }

    public final HashMap<String, String> dOV() {
        return this.nJg;
    }

    public final HashMap<String, TextPaint> dOW() {
        return this.nJh;
    }

    public final HashMap<String, StaticLayout> dOX() {
        return this.nJi;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dOY() {
        return this.nJj;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dOZ() {
        return this.nJk;
    }

    public final boolean dPa() {
        return this.nJl;
    }

    public final void xL(boolean z) {
        this.nJl = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.nJl = true;
        this.nJg.put(str2, str);
        this.nJh.put(str2, textPaint);
    }
}
