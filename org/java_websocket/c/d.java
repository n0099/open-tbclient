package org.java_websocket.c;
/* loaded from: classes7.dex */
public class d extends g implements b {
    private String oCO = "*";

    @Override // org.java_websocket.c.b
    public void Ww(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.oCO = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.oCO;
    }
}
