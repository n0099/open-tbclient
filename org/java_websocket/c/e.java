package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short irA;
    private String irB;

    @Override // org.java_websocket.c.h
    public String cbd() {
        return this.irB;
    }

    @Override // org.java_websocket.c.i
    public void zd(String str) {
        this.irB = str;
    }

    @Override // org.java_websocket.c.i
    public void j(short s) {
        this.irA = s;
    }
}
