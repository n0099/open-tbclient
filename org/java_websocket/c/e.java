package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short jUc;
    private String jUd;

    @Override // org.java_websocket.c.h
    public String cDl() {
        return this.jUd;
    }

    @Override // org.java_websocket.c.i
    public void FX(String str) {
        this.jUd = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.jUc = s;
    }
}
