package org.java_websocket.c;
/* loaded from: classes2.dex */
public class e extends g implements i {
    private short kxl;
    private String kxm;

    @Override // org.java_websocket.c.h
    public String cNS() {
        return this.kxm;
    }

    @Override // org.java_websocket.c.i
    public void Hj(String str) {
        this.kxm = str;
    }

    @Override // org.java_websocket.c.i
    public void h(short s) {
        this.kxl = s;
    }
}
