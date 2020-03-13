package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nMV = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dNH() {
        return Collections.unmodifiableSet(this.nMV.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Sx(String str) {
        String str2 = this.nMV.get(str);
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
        this.nMV.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Sy(String str) {
        return this.nMV.containsKey(str);
    }
}
