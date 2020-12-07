package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> pOC = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eFc() {
        return Collections.unmodifiableSet(this.pOC.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String aaD(String str) {
        String str2 = this.pOC.get(str);
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
        this.pOC.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean aaE(String str) {
        return this.pOC.containsKey(str);
    }
}
