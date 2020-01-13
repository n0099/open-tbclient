package org.java_websocket.c;
/* loaded from: classes5.dex */
public class e extends g implements i {
    private short nLM;
    private String nLN;

    @Override // org.java_websocket.c.h
    public String dMo() {
        return this.nLN;
    }

    @Override // org.java_websocket.c.i
    public void Sk(String str) {
        this.nLN = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.nLM = s;
    }
}
