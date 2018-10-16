package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> irC = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cbe() {
        return Collections.unmodifiableSet(this.irC.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String ze(String str) {
        String str2 = this.irC.get(str);
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
        this.irC.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean zf(String str) {
        return this.irC.containsKey(str);
    }
}
