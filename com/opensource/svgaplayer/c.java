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
    private HashMap<String, Boolean> nJg = new HashMap<>();
    private HashMap<String, Bitmap> nJh = new HashMap<>();
    private HashMap<String, String> nJi = new HashMap<>();
    private HashMap<String, TextPaint> nJj = new HashMap<>();
    private HashMap<String, StaticLayout> nJk = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nJl = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nJm = new HashMap<>();
    private boolean nJn;

    public final HashMap<String, Boolean> dOU() {
        return this.nJg;
    }

    public final HashMap<String, Bitmap> dOV() {
        return this.nJh;
    }

    public final HashMap<String, String> dOW() {
        return this.nJi;
    }

    public final HashMap<String, TextPaint> dOX() {
        return this.nJj;
    }

    public final HashMap<String, StaticLayout> dOY() {
        return this.nJk;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dOZ() {
        return this.nJl;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dPa() {
        return this.nJm;
    }

    public final boolean dPb() {
        return this.nJn;
    }

    public final void xL(boolean z) {
        this.nJn = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.nJn = true;
        this.nJi.put(str2, str);
        this.nJj.put(str2, textPaint);
    }
}
