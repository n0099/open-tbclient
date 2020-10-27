package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> pTD = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eBn() {
        return Collections.unmodifiableSet(this.pTD.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String ZB(String str) {
        String str2 = this.pTD.get(str);
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
        this.pTD.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean ZC(String str) {
        return this.pTD.containsKey(str);
    }
}
