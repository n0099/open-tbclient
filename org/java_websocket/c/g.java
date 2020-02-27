package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nMI = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dNE() {
        return Collections.unmodifiableSet(this.nMI.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Sw(String str) {
        String str2 = this.nMI.get(str);
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
        this.nMI.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Sx(String str) {
        return this.nMI.containsKey(str);
    }
}
