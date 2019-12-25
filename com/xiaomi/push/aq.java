package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class aq {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f131a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f132a = new HashMap();

    public String a() {
        return this.f131a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f132a.toString(), this.f131a);
    }
}
