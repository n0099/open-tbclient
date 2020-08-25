package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short oCV;
    private String oCW;

    @Override // org.java_websocket.c.h
    public String ejw() {
        return this.oCW;
    }

    @Override // org.java_websocket.c.i
    public void Wx(String str) {
        this.oCW = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.oCV = s;
    }
}
