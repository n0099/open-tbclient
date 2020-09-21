package org.java_websocket.c;
/* loaded from: classes17.dex */
public class e extends g implements i {
    private short oMS;
    private String oMT;

    @Override // org.java_websocket.c.h
    public String enC() {
        return this.oMT;
    }

    @Override // org.java_websocket.c.i
    public void WZ(String str) {
        this.oMT = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.oMS = s;
    }
}
