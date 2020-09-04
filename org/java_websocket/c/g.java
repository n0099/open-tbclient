package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> oDp = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> ejG() {
        return Collections.unmodifiableSet(this.oDp.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Wy(String str) {
        String str2 = this.oDp.get(str);
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
        this.oDp.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Wz(String str) {
        return this.oDp.containsKey(str);
    }
}
