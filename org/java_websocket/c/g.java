package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> ojb = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> dXt() {
        return Collections.unmodifiableSet(this.ojb.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Tu(String str) {
        String str2 = this.ojb.get(str);
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
        this.ojb.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Tv(String str) {
        return this.ojb.containsKey(str);
    }
}
