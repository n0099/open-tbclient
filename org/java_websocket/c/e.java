package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kxu;
    private String kxv;

    @Override // org.java_websocket.c.h
    public String cPN() {
        return this.kxv;
    }

    @Override // org.java_websocket.c.i
    public void IS(String str) {
        this.kxv = str;
    }

    @Override // org.java_websocket.c.i
    public void i(short s) {
        this.kxu = s;
    }
}
