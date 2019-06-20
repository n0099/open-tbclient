package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> kmy = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cKT() {
        return Collections.unmodifiableSet(this.kmy.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Hs(String str) {
        String str2 = this.kmy.get(str);
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
        this.kmy.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Ht(String str) {
        return this.kmy.containsKey(str);
    }
}
