package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short nMG;
    private String nMH;

    @Override // org.java_websocket.c.h
    public String dND() {
        return this.nMH;
    }

    @Override // org.java_websocket.c.i
    public void Sv(String str) {
        this.nMH = str;
    }

    @Override // org.java_websocket.c.i
    public void m(short s) {
        this.nMG = s;
    }
}
