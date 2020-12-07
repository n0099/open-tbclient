package org.java_websocket.c;
/* loaded from: classes5.dex */
public class e extends g implements i {
    private short pOA;
    private String pOB;

    @Override // org.java_websocket.c.h
    public String eFb() {
        return this.pOB;
    }

    @Override // org.java_websocket.c.i
    public void aaC(String str) {
        this.pOB = str;
    }

    @Override // org.java_websocket.c.i
    public void m(short s) {
        this.pOA = s;
    }
}
