package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kvb;
    private String kvc;

    @Override // org.java_websocket.c.h
    public String cPb() {
        return this.kvc;
    }

    @Override // org.java_websocket.c.i
    public void Iu(String str) {
        this.kvc = str;
    }

    @Override // org.java_websocket.c.i
    public void i(short s) {
        this.kvb = s;
    }
}
