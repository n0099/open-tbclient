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
    private HashMap<String, Boolean> ptR = new HashMap<>();
    private HashMap<String, Bitmap> ptS = new HashMap<>();
    private HashMap<String, String> ptT = new HashMap<>();
    private HashMap<String, TextPaint> ptU = new HashMap<>();
    private HashMap<String, StaticLayout> ptV = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> ptW = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ptX = new HashMap<>();
    private boolean ptY;

    public final HashMap<String, Boolean> esO() {
        return this.ptR;
    }

    public final HashMap<String, Bitmap> esP() {
        return this.ptS;
    }

    public final HashMap<String, String> esQ() {
        return this.ptT;
    }

    public final HashMap<String, TextPaint> esR() {
        return this.ptU;
    }

    public final HashMap<String, StaticLayout> esS() {
        return this.ptV;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> esT() {
        return this.ptW;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> esU() {
        return this.ptX;
    }

    public final void AC(boolean z) {
        this.ptY = z;
    }

    public final boolean esV() {
        return this.ptY;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.n(str, "text");
        q.n(textPaint, "textPaint");
        q.n(str2, "forKey");
        this.ptY = true;
        this.ptT.put(str2, str);
        this.ptU.put(str2, textPaint);
    }
}
