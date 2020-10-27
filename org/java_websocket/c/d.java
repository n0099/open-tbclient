package org.java_websocket.c;
/* loaded from: classes11.dex */
public class d extends g implements b {
    private String pTc = "*";

    @Override // org.java_websocket.c.b
    public void Zz(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.pTc = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.pTc;
    }
}
