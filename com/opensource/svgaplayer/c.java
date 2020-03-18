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
    private HashMap<String, Boolean> nmC = new HashMap<>();
    private HashMap<String, Bitmap> nmD = new HashMap<>();
    private HashMap<String, String> nmE = new HashMap<>();
    private HashMap<String, TextPaint> nmF = new HashMap<>();
    private HashMap<String, StaticLayout> nmG = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> nmH = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> nmI = new HashMap<>();
    private boolean nmJ;

    public final HashMap<String, Boolean> dFi() {
        return this.nmC;
    }

    public final HashMap<String, Bitmap> dFj() {
        return this.nmD;
    }

    public final HashMap<String, String> dFk() {
        return this.nmE;
    }

    public final HashMap<String, TextPaint> dFl() {
        return this.nmF;
    }

    public final HashMap<String, StaticLayout> dFm() {
        return this.nmG;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dFn() {
        return this.nmH;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dFo() {
        return this.nmI;
    }

    public final boolean dFp() {
        return this.nmJ;
    }

    public final void wD(boolean z) {
        this.nmJ = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.nmJ = true;
        this.nmE.put(str2, str);
        this.nmF.put(str2, textPaint);
    }
}
