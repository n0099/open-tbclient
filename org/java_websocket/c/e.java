package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short nDp;
    private String nDq;

    @Override // org.java_websocket.c.h
    public String dOX() {
        return this.nDq;
    }

    @Override // org.java_websocket.c.i
    public void RU(String str) {
        this.nDq = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.nDp = s;
    }
}
