package org.java_websocket.c;
/* loaded from: classes2.dex */
public class d extends g implements b {
    private String ktw = "*";

    @Override // org.java_websocket.c.b
    public void Is(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.ktw = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.ktw;
    }
}
