package org.java_websocket.c;
/* loaded from: classes4.dex */
public class e extends g implements i {
    private short qnk;
    private String qnl;

    @Override // org.java_websocket.c.h
    public String eJY() {
        return this.qnl;
    }

    @Override // org.java_websocket.c.i
    public void abp(String str) {
        this.qnl = str;
    }

    @Override // org.java_websocket.c.i
    public void n(short s) {
        this.qnk = s;
    }
}
