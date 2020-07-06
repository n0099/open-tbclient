package org.java_websocket.c;
/* loaded from: classes7.dex */
public class d extends g implements b {
    private String nZO = "*";

    @Override // org.java_websocket.c.b
    public void SH(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.nZO = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.nZO;
    }
}
