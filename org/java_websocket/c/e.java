package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short qnl;
    private String qnm;

    @Override // org.java_websocket.c.h
    public String eJY() {
        return this.qnm;
    }

    @Override // org.java_websocket.c.i
    public void abq(String str) {
        this.qnm = str;
    }

    @Override // org.java_websocket.c.i
    public void n(short s) {
        this.qnl = s;
    }
}
