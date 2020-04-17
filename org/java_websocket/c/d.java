package org.java_websocket.c;
/* loaded from: classes7.dex */
public class d extends g implements b {
    private String nhM = "*";

    @Override // org.java_websocket.c.b
    public void PK(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.nhM = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.nhM;
    }
}
