package org.java_websocket.c;
/* loaded from: classes9.dex */
public class d extends g implements b {
    private String oiA = "*";

    @Override // org.java_websocket.c.b
    public void Ts(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.oiA = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.oiA;
    }
}
