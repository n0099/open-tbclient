package org.java_websocket.c;
/* loaded from: classes2.dex */
public class d extends g implements b {
    private String iEn = "*";

    @Override // org.java_websocket.c.b
    public void Ad(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.iEn = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.iEn;
    }
}
