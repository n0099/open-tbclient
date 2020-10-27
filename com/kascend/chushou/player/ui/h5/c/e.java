package com.kascend.chushou.player.ui.h5.c;

import com.kascend.chushou.constants.H5Positon;
/* loaded from: classes6.dex */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f4174a;
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

    public e Qo(int i) {
        this.b = i;
        return this;
    }

    public String d() {
        return this.f4174a;
    }

    public e Yf(String str) {
        this.f4174a = str;
        return this;
    }

    public H5Positon esf() {
        return this.plJ;
    }

    public H5Positon esg() {
        return this.plK;
    }
}
