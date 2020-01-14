package org.java_websocket.c;
/* loaded from: classes5.dex */
public class d extends g implements b {
    private String nLs = "*";

    @Override // org.java_websocket.c.b
    public void Sj(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.nLs = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.nLs;
    }
}
