package org.java_websocket.c;
/* loaded from: classes4.dex */
public class d extends g implements b {
    private String qpF = "*";

    @Override // org.java_websocket.c.b
    public void acv(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.qpF = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.qpF;
    }
}
