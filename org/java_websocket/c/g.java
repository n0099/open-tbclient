package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qnn = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eJZ() {
        return Collections.unmodifiableSet(this.qnn.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String abr(String str) {
        String str2 = this.qnn.get(str);
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
        this.qnn.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean abs(String str) {
        return this.qnn.containsKey(str);
    }
}
