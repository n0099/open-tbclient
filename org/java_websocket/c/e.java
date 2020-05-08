package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short nip;
    private String niq;

    @Override // org.java_websocket.c.h
    public String dHc() {
        return this.niq;
    }

    @Override // org.java_websocket.c.i
    public void PO(String str) {
        this.niq = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.nip = s;
    }
}
