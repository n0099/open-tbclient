package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> iAx = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> ccG() {
        return Collections.unmodifiableSet(this.iAx.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String zM(String str) {
        String str2 = this.iAx.get(str);
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
        this.iAx.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean zN(String str) {
        return this.iAx.containsKey(str);
    }
}
