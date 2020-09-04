package org.java_websocket.c;
/* loaded from: classes7.dex */
public class e extends g implements i {
    private short oDn;
    private String oDo;

    @Override // org.java_websocket.c.h
    public String ejF() {
        return this.oDo;
    }

    @Override // org.java_websocket.c.i
    public void Wx(String str) {
        this.oDo = str;
    }

    @Override // org.java_websocket.c.i
    public void l(short s) {
        this.oDn = s;
    }
}
