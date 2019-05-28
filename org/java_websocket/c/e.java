package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kmt;
    private String kmu;

    @Override // org.java_websocket.c.h
    public String cKT() {
        return this.kmu;
    }

    @Override // org.java_websocket.c.i
    public void Hp(String str) {
        this.kmu = str;
    }

    @Override // org.java_websocket.c.i
    public void i(short s) {
        this.kmt = s;
    }
}
