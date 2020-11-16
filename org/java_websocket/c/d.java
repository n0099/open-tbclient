package org.java_websocket.c;
/* loaded from: classes18.dex */
public class d extends g implements b {
    private String qdZ = "*";

    @Override // org.java_websocket.c.b
    public void ZO(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.qdZ = str;
    }

    @Override // org.java_websocket.c.a
    public String getResourceDescriptor() {
        return this.qdZ;
    }
}
