package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> iEO = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cef() {
        return Collections.unmodifiableSet(this.iEO.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Af(String str) {
        String str2 = this.iEO.get(str);
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
        this.iEO.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Ag(String str) {
        return this.iEO.containsKey(str);
    }
}
