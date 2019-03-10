package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> jUT = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> cDu() {
        return Collections.unmodifiableSet(this.jUT.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String Gl(String str) {
        String str2 = this.jUT.get(str);
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
        this.jUT.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean Gm(String str) {
        return this.jUT.containsKey(str);
    }
}
