package org.java_websocket.c;
/* loaded from: classes4.dex */
public class d extends g implements b {
    private String qxR = "*";

    @Override // org.java_websocket.c.b
    public void acB(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.qxR = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.qxR;
    }
}
