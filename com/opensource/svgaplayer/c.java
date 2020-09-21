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
/* loaded from: classes16.dex */
public final class c {
    private HashMap<String, Boolean> onc = new HashMap<>();
    private HashMap<String, Bitmap> ond = new HashMap<>();
    private HashMap<String, String> onf = new HashMap<>();
    private HashMap<String, TextPaint> ong = new HashMap<>();
    private HashMap<String, StaticLayout> onh = new HashMap<>();
    private HashMap<String, m<Canvas, Integer, Boolean>> oni = new HashMap<>();
    private HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> onj = new HashMap<>();
    private boolean onk;

    public final HashMap<String, Boolean> efd() {
        return this.onc;
    }

    public final HashMap<String, Bitmap> efe() {
        return this.ond;
    }

    public final HashMap<String, String> eff() {
        return this.onf;
    }

    public final HashMap<String, TextPaint> efg() {
        return this.ong;
    }

    public final HashMap<String, StaticLayout> efh() {
        return this.onh;
    }

    public final HashMap<String, m<Canvas, Integer, Boolean>> efi() {
        return this.oni;
    }

    public final HashMap<String, r<Canvas, Integer, Integer, Integer, Boolean>> efj() {
        return this.onj;
    }

    public final boolean efk() {
        return this.onk;
    }

    public final void yN(boolean z) {
        this.onk = z;
    }

    public final void a(String str, TextPaint textPaint, String str2) {
        q.m(str, "text");
        q.m(textPaint, "textPaint");
        q.m(str2, "forKey");
        this.onk = true;
        this.onf.put(str2, str);
        this.ong.put(str2, textPaint);
    }
}
