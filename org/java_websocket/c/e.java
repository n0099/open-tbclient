package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kmw;
    private String kmx;

    @Override // org.java_websocket.c.h
    public String cKS() {
        return this.kmx;
    }

    @Override // org.java_websocket.c.i
    public void Hr(String str) {
        this.kmx = str;
    }

    @Override // org.java_websocket.c.i
    public void i(short s) {
        this.kmw = s;
    }
}
