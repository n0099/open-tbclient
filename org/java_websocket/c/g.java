package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qcX = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eFc() {
        return Collections.unmodifiableSet(this.qcX.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String aaf(String str) {
        String str2 = this.qcX.get(str);
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
        this.qcX.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean aag(String str) {
        return this.qcX.containsKey(str);
    }
}
