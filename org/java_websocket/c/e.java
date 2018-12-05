package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short iAv;
    private String iAw;

    @Override // org.java_websocket.c.h
    public String ccG() {
        return this.iAw;
    }

    @Override // org.java_websocket.c.i
    public void zL(String str) {
        this.iAw = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.iAv = s;
    }
}
