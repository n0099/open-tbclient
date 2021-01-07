package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short qrM;
    private String qrN;

    @Override // org.java_websocket.c.h
    public String eNO() {
        return this.qrN;
    }

    @Override // org.java_websocket.c.i
    public void acx(String str) {
        this.qrN = str;
    }

    @Override // org.java_websocket.c.i
    public void n(short s) {
        this.qrM = s;
    }
}
