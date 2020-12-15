package org.java_websocket.c;
/* loaded from: classes5.dex */
public class e extends g implements i {
    private short pOC;
    private String pOD;

    @Override // org.java_websocket.c.h
    public String eFc() {
        return this.pOD;
    }

    @Override // org.java_websocket.c.i
    public void aaC(String str) {
        this.pOD = str;
    }

    @Override // org.java_websocket.c.i
    public void m(short s) {
        this.pOC = s;
    }
}
