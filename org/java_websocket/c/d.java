package org.java_websocket.c;
/* loaded from: classes2.dex */
public class d extends g implements b {
    private String jTC = "*";

    @Override // org.java_websocket.c.b
    public void FW(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.jTC = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.jTC;
    }
}
