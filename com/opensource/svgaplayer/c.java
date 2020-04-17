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
    private HashMap<String, Boolean> mJm = new HashMap<>();
    private HashMap<String, Bitmap> mJn = new HashMap<>();
    private HashMap<String, String> mJo = new HashMap<>();
    private HashMap<String, TextPaint> mJp = new HashMap<>();
    private HashMap<String, StaticLayout> mJq = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> mJr = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> mJs = new HashMap<>();
    private boolean mJt;

    public final HashMap<String, Boolean> dzk() {
        return this.mJm;
    }

    public final HashMap<String, Bitmap> dzl() {
        return this.mJn;
    }

    public final HashMap<String, String> dzm() {
        return this.mJo;
    }

    public final HashMap<String, TextPaint> dzn() {
        return this.mJp;
    }

    public final HashMap<String, StaticLayout> dzo() {
        return this.mJq;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dzp() {
        return this.mJr;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dzq() {
        return this.mJs;
    }

    public final boolean dzr() {
        return this.mJt;
    }

    public final void wl(boolean z) {
        this.mJt = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.mJt = true;
        this.mJo.put(str2, str);
        this.mJp.put(str2, textPaint);
    }
}
