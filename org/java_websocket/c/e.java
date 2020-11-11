package org.java_websocket.c;
/* loaded from: classes11.dex */
public class e extends g implements i {
    private short qcV;
    private String qcW;

    @Override // org.java_websocket.c.h
    public String eFb() {
        return this.qcW;
    }

    @Override // org.java_websocket.c.i
    public void aae(String str) {
        this.qcW = str;
    }

    @Override // org.java_websocket.c.i
    public void m(short s) {
        this.qcV = s;
    }
}
