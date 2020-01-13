package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.HashMap;
import kotlin.jvm.a.m;
import kotlin.jvm.a.r;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public final class c {
    private HashMap<String, Boolean> njW = new HashMap<>();
    private HashMap<String, Bitmap> njX = new HashMap<>();
    private HashMap<String, String> njY = new HashMap<>();
    private HashMap<String, TextPaint> njZ = new HashMap<>();
    private HashMap<String, StaticLayout> nka = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nkb = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nkc = new HashMap<>();
    private boolean nkd;

    public final HashMap<String, Boolean> dDw() {
        return this.njW;
    }

    public final HashMap<String, Bitmap> dDx() {
        return this.njX;
    }

    public final HashMap<String, String> dDy() {
        return this.njY;
    }

    public final HashMap<String, TextPaint> dDz() {
        return this.njZ;
    }

    public final HashMap<String, StaticLayout> dDA() {
        return this.nka;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dDB() {
        return this.nkb;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dDC() {
        return this.nkc;
    }

    public final boolean dDD() {
        return this.nkd;
    }

    public final void wr(boolean z) {
        this.nkd = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nkd = true;
        this.njY.put(str2, str);
        this.njZ.put(str2, textPaint);
    }
}
