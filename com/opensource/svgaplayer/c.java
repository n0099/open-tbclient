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
    private HashMap<String, Boolean> mJp = new HashMap<>();
    private HashMap<String, Bitmap> mJq = new HashMap<>();
    private HashMap<String, String> mJr = new HashMap<>();
    private HashMap<String, TextPaint> mJs = new HashMap<>();
    private HashMap<String, StaticLayout> mJt = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> mJu = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> mJv = new HashMap<>();
    private boolean mJw;

    public final HashMap<String, Boolean> dzh() {
        return this.mJp;
    }

    public final HashMap<String, Bitmap> dzi() {
        return this.mJq;
    }

    public final HashMap<String, String> dzj() {
        return this.mJr;
    }

    public final HashMap<String, TextPaint> dzk() {
        return this.mJs;
    }

    public final HashMap<String, StaticLayout> dzl() {
        return this.mJt;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> dzm() {
        return this.mJu;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> dzn() {
        return this.mJv;
    }

    public final boolean dzo() {
        return this.mJw;
    }

    public final void wl(boolean z) {
        this.mJw = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.j(str, "text");
        q.j(textPaint, "textPaint");
        q.j(str2, "forKey");
        this.mJw = true;
        this.mJr.put(str2, str);
        this.mJs.put(str2, textPaint);
    }
}
