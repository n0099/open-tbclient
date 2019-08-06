package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> kvd = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cPc() {
        return Collections.unmodifiableSet(this.kvd.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Iv(String str) {
        String str2 = this.kvd.get(str);
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
        this.kvd.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Iw(String str) {
        return this.kvd.containsKey(str);
    }
}
