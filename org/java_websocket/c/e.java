package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short ncN;
    private String ncO;

    @Override // org.java_websocket.c.h
    public String dFN() {
        return this.ncO;
    }

    @Override // org.java_websocket.c.i
    public void Rp(String str) {
        this.ncO = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.ncN = s;
    }
}
