package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short qyq;
    private String qyr;

    @Override // org.java_websocket.c.h
    public String eMe() {
        return this.qyr;
    }

    @Override // org.java_websocket.c.i
    public void acC(String str) {
        this.qyr = str;
    }

    @Override // org.java_websocket.c.i
    public void n(short s) {
        this.qyq = s;
    }
}
