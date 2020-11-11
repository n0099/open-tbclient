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
    private HashMap<String, Boolean> pDl = new HashMap<>();
    private HashMap<String, Bitmap> pDm = new HashMap<>();
    private HashMap<String, String> pDn = new HashMap<>();
    private HashMap<String, TextPaint> pDo = new HashMap<>();
    private HashMap<String, StaticLayout> pDp = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> pDq = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> pDr = new HashMap<>();
    private boolean pDs;

    public final HashMap<String, Boolean> ewD() {
        return this.pDl;
    }

    public final HashMap<String, Bitmap> ewE() {
        return this.pDm;
    }

    public final HashMap<String, String> ewF() {
        return this.pDn;
    }

    public final HashMap<String, TextPaint> ewG() {
        return this.pDo;
    }

    public final HashMap<String, StaticLayout> ewH() {
        return this.pDp;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> ewI() {
        return this.pDq;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ewJ() {
        return this.pDr;
    }

    public final void AN(boolean z) {
        this.pDs = z;
    }

    public final boolean ewK() {
        return this.pDs;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.n(str, "text");
        q.n(textPaint, "textPaint");
        q.n(str2, "forKey");
        this.pDs = true;
        this.pDn.put(str2, str);
        this.pDo.put(str2, textPaint);
    }
}
