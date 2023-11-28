package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class bg {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f137a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f138a = new HashMap();

    public String a() {
        return this.f137a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f138a.toString(), this.f137a);
    }
}
