package org.java_websocket.c;
/* loaded from: classes5.dex */
public class e extends g implements i {
    private short nLR;
    private String nLS;

    @Override // org.java_websocket.c.h
    public String dMq() {
        return this.nLS;
    }

    @Override // org.java_websocket.c.i
    public void Sk(String str) {
        this.nLS = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.nLR = s;
    }
}
