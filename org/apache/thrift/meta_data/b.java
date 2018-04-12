package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements Serializable {
    private static Map<Class<? extends org.apache.thrift.a>, Map<?, b>> d = new HashMap();
    public final String a;
    public final byte b;
    public final c c;

    public b(String str, byte b, c cVar) {
        this.a = str;
        this.b = b;
        this.c = cVar;
    }

    public static void a(Class<? extends org.apache.thrift.a> cls, Map<?, b> map) {
        d.put(cls, map);
    }
}
