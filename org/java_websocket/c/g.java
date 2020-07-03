package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> oam = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dTS() {
        return Collections.unmodifiableSet(this.oam.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String SI(String str) {
        String str2 = this.oam.get(str);
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
        this.oam.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean SJ(String str) {
        return this.oam.containsKey(str);
    }
}
