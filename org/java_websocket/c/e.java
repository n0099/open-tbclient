package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short nim;
    private String nin;

    @Override // org.java_websocket.c.h
    public String dHg() {
        return this.nin;
    }

    @Override // org.java_websocket.c.i
    public void PL(String str) {
        this.nin = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.nim = s;
    }
}
