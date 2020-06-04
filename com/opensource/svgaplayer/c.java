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
    private HashMap<String, Boolean> neD = new HashMap<>();
    private HashMap<String, Bitmap> neE = new HashMap<>();
    private HashMap<String, String> neF = new HashMap<>();
    private HashMap<String, TextPaint> neG = new HashMap<>();
    private HashMap<String, StaticLayout> neH = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> neI = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> neJ = new HashMap<>();
    private boolean neK;

    public final HashMap<String, Boolean> dGO() {
        return this.neD;
    }

    public final HashMap<String, Bitmap> dGP() {
        return this.neE;
    }

    public final HashMap<String, String> dGQ() {
        return this.neF;
    }

    public final HashMap<String, TextPaint> dGR() {
        return this.neG;
    }

    public final HashMap<String, StaticLayout> dGS() {
        return this.neH;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dGT() {
        return this.neI;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dGU() {
        return this.neJ;
    }

    public final boolean dGV() {
        return this.neK;
    }

    public final void wL(boolean z) {
        this.neK = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.neK = true;
        this.neF.put(str2, str);
        this.neG.put(str2, textPaint);
    }
}
