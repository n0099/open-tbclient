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
/* loaded from: classes11.dex */
public final class c {
    private HashMap<String, Boolean> odr = new HashMap<>();
    private HashMap<String, Bitmap> ods = new HashMap<>();
    private HashMap<String, String> odt = new HashMap<>();
    private HashMap<String, TextPaint> odu = new HashMap<>();
    private HashMap<String, StaticLayout> odv = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> odw = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> odx = new HashMap<>();
    private boolean ody;

    public final HashMap<String, Boolean> ebf() {
        return this.odr;
    }

    public final HashMap<String, Bitmap> ebg() {
        return this.ods;
    }

    public final HashMap<String, String> ebh() {
        return this.odt;
    }

    public final HashMap<String, TextPaint> ebi() {
        return this.odu;
    }

    public final HashMap<String, StaticLayout> ebj() {
        return this.odv;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> ebk() {
        return this.odw;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ebl() {
        return this.odx;
    }

    public final boolean ebm() {
        return this.ody;
    }

    public final void yF(boolean z) {
        this.ody = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.ody = true;
        this.odt.put(str2, str);
        this.odu.put(str2, textPaint);
    }
}
