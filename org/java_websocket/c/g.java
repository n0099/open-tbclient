package org.java_websocket.c;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class g implements c {
    private byte[] content;
    private TreeMap<String, String> qqg = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // org.java_websocket.c.f
    public Iterator<String> eNl() {
        return Collections.unmodifiableSet(this.qqg.keySet()).iterator();
    }

    @Override // org.java_websocket.c.f
    public String acx(String str) {
        String str2 = this.qqg.get(str);
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
        this.qqg.put(str, str2);
    }

    @Override // org.java_websocket.c.f
    public boolean acy(String str) {
        return this.qqg.containsKey(str);
    }
}
