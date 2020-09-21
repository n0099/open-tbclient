package org.java_websocket.c;
/* loaded from: classes17.dex */
public class d extends g implements b {
    private String oMt = "*";

    @Override // org.java_websocket.c.b
    public void WY(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.oMt = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.oMt;
    }
}
