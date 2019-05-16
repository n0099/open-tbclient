package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kms;
    private String kmt;

    @Override // org.java_websocket.c.h
    public String cKR() {
        return this.kmt;
    }

    @Override // org.java_websocket.c.i
    public void Hp(String str) {
        this.kmt = str;
    }

    @Override // org.java_websocket.c.i
    public void i(short s) {
        this.kms = s;
    }
}
