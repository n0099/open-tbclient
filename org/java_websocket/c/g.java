package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nio = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dHh() {
        return Collections.unmodifiableSet(this.nio.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String PM(String str) {
        String str2 = this.nio.get(str);
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
        this.nio.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean PN(String str) {
        return this.nio.containsKey(str);
    }
}
