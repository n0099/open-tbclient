package org.java_websocket.c;
/* loaded from: classes2.dex */
public class d extends g implements b {
    private String iDg = "*";

    @Override // org.java_websocket.c.b
    public void zN(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.iDg = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.iDg;
    }
}
