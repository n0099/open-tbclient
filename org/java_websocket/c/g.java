package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes18.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qeA = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eFd() {
        return Collections.unmodifiableSet(this.qeA.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String ZQ(String str) {
        String str2 = this.qeA.get(str);
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
        this.qeA.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean ZR(String str) {
        return this.qeA.containsKey(str);
    }
}
