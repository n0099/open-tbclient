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
    private HashMap<String, Boolean> ocZ = new HashMap<>();
    private HashMap<String, Bitmap> oda = new HashMap<>();
    private HashMap<String, String> odb = new HashMap<>();
    private HashMap<String, TextPaint> odc = new HashMap<>();
    private HashMap<String, StaticLayout> odd = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> ode = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> odf = new HashMap<>();
    private boolean odg;

    public final HashMap<String, Boolean> eaW() {
        return this.ocZ;
    }

    public final HashMap<String, Bitmap> eaX() {
        return this.oda;
    }

    public final HashMap<String, String> eaY() {
        return this.odb;
    }

    public final HashMap<String, TextPaint> eaZ() {
        return this.odc;
    }

    public final HashMap<String, StaticLayout> eba() {
        return this.odd;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> ebb() {
        return this.ode;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> ebc() {
        return this.odf;
    }

    public final boolean ebd() {
        return this.odg;
    }

    public final void yD(boolean z) {
        this.odg = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.odg = true;
        this.odb.put(str2, str);
        this.odc.put(str2, textPaint);
    }
}
