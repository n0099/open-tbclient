package org.java_websocket.c;
/* loaded from: classes11.dex */
public class d extends g implements b {
    private String qcw = "*";

    @Override // org.java_websocket.c.b
    public void aad(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.qcw = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.qcw;
    }
}
