package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short qxO;
    private String qxP;

    @Override // org.java_websocket.c.h
    public String eMw() {
        return this.qxP;
    }

    @Override // org.java_websocket.c.i
    public void acD(String str) {
        this.qxP = str;
    }

    @Override // org.java_websocket.c.i
    public void n(short s) {
        this.qxO = s;
    }
}
