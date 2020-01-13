package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nLO = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dMp() {
        return Collections.unmodifiableSet(this.nLO.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Sl(String str) {
        String str2 = this.nLO.get(str);
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
        this.nLO.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Sm(String str) {
        return this.nLO.containsKey(str);
    }
}
