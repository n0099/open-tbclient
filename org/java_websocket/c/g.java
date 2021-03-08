package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qys = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eMf() {
        return Collections.unmodifiableSet(this.qys.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String acD(String str) {
        String str2 = this.qys.get(str);
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
        this.qys.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean acE(String str) {
        return this.qys.containsKey(str);
    }
}
