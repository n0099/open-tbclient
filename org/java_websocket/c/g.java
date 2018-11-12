package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> itn = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> caB() {
        return Collections.unmodifiableSet(this.itn.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String zj(String str) {
        String str2 = this.itn.get(str);
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
        this.itn.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean zk(String str) {
        return this.itn.containsKey(str);
    }
}
