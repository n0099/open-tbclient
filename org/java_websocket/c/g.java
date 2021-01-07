package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qrO = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eNP() {
        return Collections.unmodifiableSet(this.qrO.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String acy(String str) {
        String str2 = this.qrO.get(str);
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
        this.qrO.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean acz(String str) {
        return this.qrO.containsKey(str);
    }
}
