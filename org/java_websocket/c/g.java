package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> nir = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dHe() {
        return Collections.unmodifiableSet(this.nir.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String PP(String str) {
        String str2 = this.nir.get(str);
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
        this.nir.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean PQ(String str) {
        return this.nir.containsKey(str);
    }
}
