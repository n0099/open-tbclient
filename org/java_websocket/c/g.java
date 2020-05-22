package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nDr = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dOY() {
        return Collections.unmodifiableSet(this.nDr.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String RV(String str) {
        String str2 = this.nDr.get(str);
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
        this.nDr.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean RW(String str) {
        return this.nDr.containsKey(str);
    }
}
