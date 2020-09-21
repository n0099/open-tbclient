package com.kascend.chushou.player.ui.h5.c;

import com.kascend.chushou.constants.H5Positon;
/* loaded from: classes6.dex */
public class e extends d {
    private String a;
    private int b = 1;

    public e() {
        this.h = 2;
        this.i = 1;
        this.j = 0;
        this.k = "#99000000";
    }

    public String a() {
        return this.p;
    }

    public String b() {
        return this.o;
    }

    public int c() {
        return this.b;
    }

    public e NR(int i) {
        this.b = i;
        return this;
    }

    public String d() {
        return this.a;
    }

    public e VE(String str) {
        this.a = str;
        return this;
    }

    public H5Positon eeu() {
        return this.oeY;
    }

    public H5Positon eev() {
        return this.oeZ;
    }
}
