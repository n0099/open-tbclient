package com.kascend.chushou.player.ui.h5.c;

import com.kascend.chushou.constants.H5Positon;
/* loaded from: classes6.dex */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f4176a;
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

    public e Rm(int i) {
        this.b = i;
        return this;
    }

    public String d() {
        return this.f4176a;
    }

    public e Yu(String str) {
        this.f4176a = str;
        return this;
    }

    public H5Positon evU() {
        return this.pwL;
    }

    public H5Positon evV() {
        return this.pwM;
    }
}
