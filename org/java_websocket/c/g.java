package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes17.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> oMU = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> enD() {
        return Collections.unmodifiableSet(this.oMU.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Xa(String str) {
        String str2 = this.oMU.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // org.java_websocket.c.f
    public byte[] getContent() {
        return this.content;
    }

    @Override // org.java_websocket.c.c
    public void put(String str, String str2) {
        this.oMU.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Xb(String str) {
        return this.oMU.containsKey(str);
    }
}
