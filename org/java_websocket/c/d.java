package org.java_websocket.c;
/* loaded from: classes7.dex */
public class d extends g implements b {
    private String nEa = "*";

    @Override // org.java_websocket.c.b
    public void RU(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.nEa = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.nEa;
    }
}
