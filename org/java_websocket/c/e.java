package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short iEN;
    private String iEO;

    @Override // org.java_websocket.c.h
    public String cee() {
        return this.iEO;
    }

    @Override // org.java_websocket.c.i
    public void Ae(String str) {
        this.iEO = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.iEN = s;
    }
}
