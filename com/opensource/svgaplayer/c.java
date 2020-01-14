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
    private HashMap<String, Boolean> nkb = new HashMap<>();
    private HashMap<String, Bitmap> nkc = new HashMap<>();
    private HashMap<String, String> nkd = new HashMap<>();
    private HashMap<String, TextPaint> nke = new HashMap<>();
    private HashMap<String, StaticLayout> nkf = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nkg = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nkh = new HashMap<>();
    private boolean nki;

    public final HashMap<String, Boolean> dDy() {
        return this.nkb;
    }

    public final HashMap<String, Bitmap> dDz() {
        return this.nkc;
    }

    public final HashMap<String, String> dDA() {
        return this.nkd;
    }

    public final HashMap<String, TextPaint> dDB() {
        return this.nke;
    }

    public final HashMap<String, StaticLayout> dDC() {
        return this.nkf;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dDD() {
        return this.nkg;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dDE() {
        return this.nkh;
    }

    public final boolean dDF() {
        return this.nki;
    }

    public final void wr(boolean z) {
        this.nki = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nki = true;
        this.nkd.put(str2, str);
        this.nke.put(str2, textPaint);
    }
}
