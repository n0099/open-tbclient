package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> kye = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cNV() {
        return Collections.unmodifiableSet(this.kye.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Hk(String str) {
        String str2 = this.kye.get(str);
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
        this.kye.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Hl(String str) {
        return this.kye.containsKey(str);
    }
}
