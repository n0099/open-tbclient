package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short iEM;
    private String iEN;

    @Override // org.java_websocket.c.h
    public String cee() {
        return this.iEN;
    }

    @Override // org.java_websocket.c.i
    public void Ae(String str) {
        this.iEN = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.iEM = s;
    }
}
